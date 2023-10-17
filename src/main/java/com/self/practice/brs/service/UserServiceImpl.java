package com.self.practice.brs.service;

import com.self.practice.brs.dto.mapper.UserMapper;
import com.self.practice.brs.dto.model.user.UserDto;
import com.self.practice.brs.exception.EntityType;
import com.self.practice.brs.exception.ExceptionType;
import com.self.practice.brs.model.user.Role;
import com.self.practice.brs.model.user.User;
import com.self.practice.brs.model.user.UserRoles;
import com.self.practice.brs.repository.user.RoleRepository;
import com.self.practice.brs.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService, StandardExceptionMessage {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto signUp(UserDto userDto) {
        if (Optional.ofNullable(userRepository.findByEmail(userDto.getEmail()))
                .isEmpty()) {
            Role userRole;
            if (userDto.isAdmin()) {
                userRole = roleRepository.findByRole(UserRoles.ADMIN);
            } else {
                userRole = roleRepository.findByRole(UserRoles.PASSENGER);
            }
            var user = User.builder()
                    .setEmail(userDto.getEmail())
                    .setPassword(passwordEncoder.encode(userDto.getPassword()))
                    .setRoles(Set.of(userRole))
                    .setFirstName(userDto.getFirstName())
                    .setLastName(userDto.getLastName())
                    .setMobileNumber(userDto.getMobileNumber())
                    .build();
            return UserMapper.toUserDto(userRepository.save(user));
        }
        throw exception(EntityType.USER, ExceptionType.DUPLICATE_ENTITY, userDto.getEmail());
    }

    @Override
    public UserDto findByUserByEmail(String email) {
        return Optional
                .ofNullable(userRepository.findByEmail(email))
                .map(UserMapper::toUserDto)
                .orElseThrow(() -> exception(EntityType.USER, ExceptionType.ENTITY_NOT_FOUND, email));
    }

    @Override
    public UserDto updateProfile(UserDto userDto) {
        return Optional.ofNullable(userRepository.findByEmail(userDto.getEmail()))
                .map(user -> {
                    user.setFirstName(userDto.getFirstName());
                    user.setLastName(userDto.getLastName());
                    user.setMobileNumber(userDto.getMobileNumber());
                    return UserMapper.toUserDto(userRepository.save(user));
                })
                .orElseThrow(() -> exception(EntityType.USER, ExceptionType.ENTITY_NOT_FOUND, userDto.getEmail()));
    }

    @Override
    public UserDto changePassword(UserDto userDto, String newPassword) {
        return Optional.ofNullable(userRepository.findByEmail(userDto.getEmail()))
                .map(user -> {
                    user.setPassword(passwordEncoder.encode(newPassword));
                    return UserMapper.toUserDto(userRepository.save(user));
                })
                .orElseThrow(() -> exception(EntityType.USER, ExceptionType.ENTITY_NOT_FOUND, userDto.getEmail()));
    }
}
