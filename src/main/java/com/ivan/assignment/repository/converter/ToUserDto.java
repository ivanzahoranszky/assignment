package com.ivan.assignment.repository.converter;

import com.ivan.assignment.controller.dto.PhoneDto;
import com.ivan.assignment.controller.dto.UserDto;
import com.ivan.assignment.repository.model.Phone;
import com.ivan.assignment.repository.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ToUserDto implements Converter<User, UserDto> {

    @Override
    public UserDto convert(User source) {
        return UserDto.builder()
                .id(source.getId())
                .name(source.getName())
                .build();
    }

}
