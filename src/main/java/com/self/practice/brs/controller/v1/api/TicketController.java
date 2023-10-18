package com.self.practice.brs.controller.v1.api;

import com.self.practice.brs.controller.v1.request.BookTicketRequest;
import com.self.practice.brs.dto.model.bus.TicketDto;
import com.self.practice.brs.dto.response.Response;
import com.self.practice.brs.service.TicketService;
import com.self.practice.brs.service.TripScheduleService;
import com.self.practice.brs.service.TripService;
import com.self.practice.brs.service.UserService;
import com.self.practice.brs.util.DateUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private UserService userService;

    @Autowired
    private TripService tripService;

    @Autowired
    private TripScheduleService tripScheduleService;

    @PostMapping("/")
    @ApiOperation(value = "", authorizations = {@Authorization(value = "apiKey")})
    public Response<TicketDto> bookTicket(@RequestBody @Valid BookTicketRequest ticketRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = (String) authentication.getPrincipal();
        return Optional.ofNullable(userService.findByUserByEmail(email))
                .map(user -> {
                    var tripDto = Optional.ofNullable(tripService.getTripById(ticketRequest.getTripId()))
                            .orElseThrow();
                    var tripSchedule = Optional.ofNullable(tripScheduleService.getTripSchedule(tripDto,
                            DateUtil.formattedDate(ticketRequest.getTripDate()), true))
                            .orElseThrow();
                    return Optional
                            .ofNullable(ticketService.bookTicket(tripSchedule, user))
                            .map(ticket -> Response.<TicketDto>ok().setPayload(ticket))
                            .orElseThrow();

                })
                .orElseGet(() -> {
                    var response = Response.<TicketDto>badRequest();
                    response.setErrors("Unable to process ticket booking");
                    return response;
                });
    }
}
