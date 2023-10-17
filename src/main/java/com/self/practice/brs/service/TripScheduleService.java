package com.self.practice.brs.service;

import com.self.practice.brs.dto.model.bus.TripDto;
import com.self.practice.brs.dto.model.bus.TripScheduleDto;

import java.util.List;

public interface TripScheduleService {

    /**
     * Show the {@link List} of {@link TripScheduleDto} between the
     * source and destination selected by user
     *
     * @param sourceStopCode source station code
     * @param destinationStopCode destination station code
     * @return {@link List} of {@link TripScheduleDto}
     */
    List<TripScheduleDto> getAvailableTripSchedules(String sourceStopCode, String destinationStopCode);

    /**
     * {@link TripScheduleDto} details of the trip
     *
     * @param tripDto {@link TripDto}
     * @param tripDate date of the trip
     * @param createScheduleForTrip whether to create new schedule for the trip
     * @return details of the {@link TripScheduleDto}
     */
    TripScheduleDto getTripSchedule(TripDto tripDto, String tripDate, boolean createScheduleForTrip);
}
