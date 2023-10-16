package com.self.practice.brs.service;

import com.self.practice.brs.dto.model.bus.TicketDto;
import com.self.practice.brs.dto.model.bus.TripScheduleDto;
import com.self.practice.brs.dto.model.user.UserDto;

public interface TicketService {

    /**
     * Book a new ticket for passenger for the given schedule
     *
     * @param tripScheduleDto selected {@link TripScheduleDto}
     * @param passenger logged-in {@link UserDto}
     * @return booked {@link TicketDto}
     */
    TicketDto bookTicket(TripScheduleDto tripScheduleDto, UserDto passenger);
}
