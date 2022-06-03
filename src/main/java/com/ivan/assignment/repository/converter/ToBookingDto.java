package com.ivan.assignment.repository.converter;

import com.ivan.assignment.controller.dto.BookingDto;
import com.ivan.assignment.controller.dto.PhoneDto;
import com.ivan.assignment.repository.model.Booking;
import com.ivan.assignment.repository.model.Phone;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ToBookingDto implements Converter<Booking, BookingDto> {

    @Override
    public BookingDto convert(Booking source) {
        return BookingDto.builder()
                .id(source.getId())
                .phone(source.getPhone())
                .user(source.getUser())
                .start(source.getStart())
                .build();
    }

}
