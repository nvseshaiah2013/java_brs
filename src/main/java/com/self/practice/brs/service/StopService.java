package com.self.practice.brs.service;

import com.self.practice.brs.dto.model.bus.StopDto;

import java.util.Set;

public interface StopService {

    /**
     * Fetch all the stops from the DB
     *
     * @return {@link Set} of {@link StopDto}
     */
    Set<StopDto> getAllStops();

    /**
     * Finds the Stop using the stopCode
     *
     * @param stopCode {@link String} code
     * @return {@link StopDto} based on the code
     */
    StopDto getStopByCode(String stopCode);
}
