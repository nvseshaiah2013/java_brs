package com.self.practice.brs.model.user;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Optional;

@Entity
@Table(name = "USER", indexes = @Index(
        name = "IDX_USER_EMAIL",
        unique = true,
        columnList = "email"
))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "set")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "MOBILE_NUMBER")
    private String mobileNumber;

    private String password;

    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "USER_ROLE",
        joinColumns = {@JoinColumn(name = "USER_ID")},
        inverseJoinColumns = {@JoinColumn(name = "ROLE_ID")})
    private Collection<Role> roles;

    public String getFullName() {
        return Optional
                .ofNullable(firstName)
                .map(fName -> fName.concat(" ").concat(lastName))
                .orElse(lastName);
    }
}
