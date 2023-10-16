package com.self.practice.brs.dto.mapper;

import com.self.practice.brs.dto.model.bus.TicketDto;
import com.self.practice.brs.model.bus.Ticket;

import java.util.List;
import java.util.stream.Collectors;

public class TicketMapper {

    public static TicketDto toTicketDto(Ticket ticket) {
        return TicketDto
                .builder()
                .id(ticket.getId())
                .busCode(ticket.getTripSchedule().getTripDetail().getBus().getCode())
                .seatNumber(ticket.getSeatNumber())
                .sourceStop(ticket.getTripSchedule().getTripDetail().getSourceStop().getName())
                .destinationStop(ticket.getTripSchedule().getTripDetail().getDestinationStop().getName())
                .cancellable(false)
                .journeyDate(ticket.getJourneyDate())
                .passengerName(ticket.getPassenger().getFullName())
                .passengerMobileNumber(ticket.getPassenger().getMobileNumber())
                .build();
    }

    public static List<TicketDto> toTicketDtos(List<Ticket> tickets) {
        return tickets
                .stream()
                .map(TicketMapper::toTicketDto)
                .collect(Collectors.toList());
    }
}
