package com.self.practice.brs.service;

import com.self.practice.brs.dto.model.user.UserDto;
import com.self.practice.brs.exception.BRSException;
import com.self.practice.brs.exception.EntityType;
import com.self.practice.brs.exception.ExceptionType;
import com.self.practice.brs.model.user.Role;
import com.self.practice.brs.repository.user.RoleRepository;
import com.self.practice.brs.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto signUp(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto findByUserByEmail(String email) {
        return null;
    }

    @Override
    public UserDto updateProfile(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto changePassword(UserDto userDto, String newPassword) {
        return null;
    }

    private RuntimeException exception(EntityType entityType, ExceptionType exceptionType, String... args) {
        return BRSException.throwException(entityType, exceptionType, args);
    }
}
