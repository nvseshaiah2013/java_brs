package com.self.practice.brs.controller.v1.api;

import com.self.practice.brs.controller.v1.request.UserSignUpRequest;
import com.self.practice.brs.dto.model.user.UserDto;
import com.self.practice.brs.dto.response.Response;
import com.self.practice.brs.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/user")
@Api(value = "brs-application")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public Response<UserDto> signup(@Valid @RequestBody UserSignUpRequest signUpRequest) {
        return Response.<UserDto>ok().setPayload(registerUser(signUpRequest, false));
    }

    private UserDto registerUser(UserSignUpRequest signUpRequest, boolean isAdmin) {
        UserDto userDto = UserDto.builder()
                .email(signUpRequest.getEmail())
                .password(signUpRequest.getPassword())
                .firstName(signUpRequest.getFirstName())
                .lastName(signUpRequest.getLastName())
                .mobileNumber(signUpRequest.getMobileNumber())
                .isAdmin(isAdmin)
                .build();
        return userService.signUp(userDto);
    }
}
