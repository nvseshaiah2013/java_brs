package com.self.practice.brs.dto.mapper;

import com.self.practice.brs.dto.model.user.UserDto;
import com.self.practice.brs.model.user.User;

public class UserMapper {

    public static UserDto toUserDto(User user) {
        return UserDto.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .mobileNumber(user.getMobileNumber())
                .roles(RoleMapper.toRoleDtos(user.getRoles()))
                .build();
    }
}
