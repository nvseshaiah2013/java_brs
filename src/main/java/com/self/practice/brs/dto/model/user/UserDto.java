package com.self.practice.brs.dto.model.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Collection;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@Builder
public class UserDto {

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private String mobileNumber;

    private boolean isAdmin;

    private Collection<RoleDto> roles;

    public String getFullName() {
        return Optional.ofNullable(firstName)
                .map(fName -> fName.concat(" ").concat(lastName))
                .orElse(lastName);
    }
}
