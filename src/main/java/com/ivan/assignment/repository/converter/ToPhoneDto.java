package com.ivan.assignment.repository.converter;

import com.ivan.assignment.controller.dto.PhoneDto;
import com.ivan.assignment.repository.model.Phone;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ToPhoneDto implements Converter<Phone, PhoneDto> {

    @Override
    public PhoneDto convert(Phone source) {
        return PhoneDto.builder()
                ._2gBands(source.get_2gBands())
                ._3gBands(source.get_3gBands())
                ._4gBands(source.get_4gBands())
                .booked(source.getBooked())
                .bookedUser(source.getBookedUser())
                .deviceName(source.getDeviceName())
                .id(source.getId())
                .technology(source.getTechnology().toString().toLowerCase())
                .build();
    }

}
