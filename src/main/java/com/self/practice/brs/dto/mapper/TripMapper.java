package com.self.practice.brs.dto.mapper;

import com.self.practice.brs.dto.model.bus.TripDto;
import com.self.practice.brs.model.bus.Trip;

public class TripMapper {

    public static TripDto toTripDto(Trip trip) {
        return TripDto.builder()
                .id(trip.getId())
                .agencyCode(trip.getAgency().getCode())
                .sourceStopCode(trip.getSourceStop().getCode())
                .destinationStopCode(trip.getDestinationStop().getCode())
                .sourceStopName(trip.getSourceStop().getName())
                .destinationStopName(trip.getDestinationStop().getName())
                .busCode(trip.getBus().getCode())
                .journeyTime(trip.getJourneyTime())
                .fare(trip.getFare())
                .build();
    }
}
