package com.self.practice.brs.dto.mapper;

import com.self.practice.brs.dto.model.bus.AgencyDto;
import com.self.practice.brs.model.bus.Agency;

import java.util.Set;

public class AgencyMapper {

    public static AgencyDto toAgencyDto(Agency agency) {
        return AgencyDto.builder()
                .name(agency.getName())
                .code(agency.getCode())
                .details(agency.getDetails())
                .owner(UserMapper.toUserDto(agency.getOwner()))
                .buses(Set.of())
                .build();
    }
}
