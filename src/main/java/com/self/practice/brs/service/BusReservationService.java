package com.self.practice.brs.service;

import com.self.practice.brs.dto.model.bus.StopDto;

import java.util.Set;

public interface BusReservationService {

    Set<StopDto> getAllStops();
}
