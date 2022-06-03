package com.ivan.assignment.service;

import com.ivan.assignment.controller.dto.BookingDto;
import com.ivan.assignment.controller.dto.PhoneDto;
import com.ivan.assignment.repository.BookingRepository;
import com.ivan.assignment.repository.PhoneRepository;
import com.ivan.assignment.repository.UserRepository;
import com.ivan.assignment.repository.model.Booking;
import com.ivan.assignment.repository.model.Phone;
import com.ivan.assignment.service.enrich.Enricher;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class MobilePhoneService {

    private final PhoneRepository phoneRepository;
    private final UserRepository userRepository;
    private final BookingRepository bookingRepository;

    private final Enricher enricher;

    private final ConversionService conversionService;

    public Flux<PhoneDto> getPhones(boolean freeOnly) {
        Flux<Phone> phones;
        if (freeOnly) {
            phones = phoneRepository.findFreePhones();
        } else {
            phones = phoneRepository.findPhones();
        }
        return phones
                .flatMap(enricher::enrich)
                .map(phone -> conversionService.convert(phone, PhoneDto.class));
    }

    public Mono<BookingDto> bookPhone(int phoneId, String userName) {
        return phoneRepository.findById(phoneId)
                .flatMap(phone -> userRepository.findByName(userName))
                .flatMap(user -> {
                    var booking = Booking.builder()
                            .phone(phoneId)
                            .user(user.getId())
                            .start(Instant.now())
                            .build();
                    return bookingRepository
                            .save(booking)
                            .map(b -> conversionService.convert(b, BookingDto.class));
                });
    }

    public Mono<Void> returnPhone(int phoneId) {
        return bookingRepository.findByPhoneId(phoneId)
                .flatMap(bookingRepository::delete);
    }
}
