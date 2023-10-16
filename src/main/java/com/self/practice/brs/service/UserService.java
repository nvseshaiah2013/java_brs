package com.self.practice.brs.service;

import com.self.practice.brs.dto.model.user.UserDto;

public interface UserService {

    /**
     * Registration of New User
     *
     * @param userDto {@link UserDto} request object
     * @return {@link UserDto} saved into the DB
     */
    UserDto signUp(UserDto userDto);

    /**
     * Search an existing user using the email id
     *
     * @param email {@link String} email id
     * @return {@link UserDto} object of the corresponding email id
     */
    UserDto findByUserByEmail(String email);

    /**
     * Update the profile of the user
     *
     * @param userDto updated {@link UserDto} object request
     * @return updated {@link UserDto} from the DB
     */
    UserDto updateProfile(UserDto userDto);

    /**
     * Update the user credentials with new password
     *
     * @param userDto {@link UserDto} for which password needs to be changed
     * @param newPassword The new password of the user
     * @return updated {@link UserDto} from the DB
     */
    UserDto changePassword(UserDto userDto, String newPassword);
}
