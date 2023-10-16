package com.self.practice.brs.dto.mapper;

import com.self.practice.brs.dto.model.bus.TripScheduleDto;
import com.self.practice.brs.model.bus.Trip;
import com.self.practice.brs.model.bus.TripSchedule;

public class TripScheduleMapper {

    public static TripScheduleDto toTripScheduleDto(TripSchedule schedule) {
        Trip details = schedule.getTripDetail();
        return TripScheduleDto.builder()
                .id(schedule.getId())
                .tripId(details.getId())
                .busCode(details.getBus().getCode())
                .availableSeats(schedule.getAvailableSeats())
                .fare(details.getFare())
                .journeyTime(details.getJourneyTime())
                .sourceStop(details.getSourceStop().getName())
                .destinationStop(details.getDestinationStop().getName())
                .build();
    }
}
