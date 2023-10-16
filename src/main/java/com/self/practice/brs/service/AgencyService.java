package com.self.practice.brs.service;

import com.self.practice.brs.dto.model.bus.AgencyDto;
import com.self.practice.brs.dto.model.bus.BusDto;
import com.self.practice.brs.dto.model.user.UserDto;

public interface AgencyService {

    /**
     * Details of the Agency owned by the {@link UserDto}
     *
     * @param userDto {@link UserDto} owner of the agency
     * @return {@link AgencyDto} of the owner
     */
    AgencyDto getAgency(UserDto userDto);

    /**
     * Adds the agency to the logged-in user
     *
     * @param agencyDto {@link AgencyDto} details
     * @return Updated {@link AgencyDto} from the DB
     */
    AgencyDto addAgency(AgencyDto agencyDto);

    /**
     * Updates the details of the agency with new bus
     *
     * @param agencyDto {@link AgencyDto}
     * @param busDto new {@link BusDto}
     * @return Update {@link AgencyDto} from the DB
     */
    AgencyDto updateAgency(AgencyDto agencyDto, BusDto busDto);
}
