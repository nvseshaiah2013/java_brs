package com.self.practice.brs.dto.mapper;

import com.self.practice.brs.dto.model.user.RoleDto;
import com.self.practice.brs.model.user.Role;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class RoleMapper {

    public static RoleDto toRoleDto(Role role) {
        return RoleDto
                .builder()
                .role(role.getRole().toString())
                .build();
    }

    public static Collection<RoleDto> toRoleDtos(Collection<Role> roles) {
        return roles
                .stream()
                .map(RoleMapper::toRoleDto)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
