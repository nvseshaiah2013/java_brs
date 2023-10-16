package com.self.practice.brs.service;

import com.self.practice.brs.dto.model.bus.TripDto;

import java.util.List;

public interface TripService {

    /**
     * Find the tripDetails of the given id
     *
     * @param tripId id of the trip
     * @return {@link TripDto} details
     */
    TripDto getTripById(Long tripId);

    /**
     * Add a new Trip to the existing bus
     *
     * @param tripDto {@link TripDto} details
     * @return {@link List} of all the {@link TripDto}
     */
    List<TripDto> addTrip(TripDto tripDto);

    /**
     * Lists out the trips between given stops
     *
     * @param sourceStopCode code of source station
     * @param destinationStopCode code of destination station
     * @return {@link List} of {@link TripDto}
     */
    List<TripDto> getAvailableTripsBetweenStops(String sourceStopCode, String destinationStopCode);


}
