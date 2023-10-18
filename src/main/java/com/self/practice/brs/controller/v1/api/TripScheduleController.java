package com.self.practice.brs.controller.v1.api;

import com.self.practice.brs.controller.v1.request.GetTripSchedulesRequest;
import com.self.practice.brs.dto.model.bus.TripScheduleDto;
import com.self.practice.brs.dto.response.Response;
import com.self.practice.brs.service.TripScheduleService;
import com.self.practice.brs.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/trip-schedules")
public class TripScheduleController {

    @Autowired
    private TripScheduleService tripScheduleService;

    @GetMapping("/")
    public Response<List<TripScheduleDto>> getTripSchedules(@RequestBody @Valid GetTripSchedulesRequest tripSchedulesRequest) {
        var tripSchedules  = tripScheduleService.getAvailableTripSchedules(tripSchedulesRequest.getSourceStopCode(),
                tripSchedulesRequest.getDestinationStopCode(),
                DateUtil.formattedDate(tripSchedulesRequest.getTripDate()));
        if (tripSchedules.isEmpty()) {
            var response = Response.<List<TripScheduleDto>>notFound();
            response.setErrors(String.format("No trips between source stop - '%s' and destination stop - '%s' on date '%s' are available at the moment",
                    tripSchedulesRequest.getSourceStopCode(), tripSchedulesRequest.getDestinationStopCode(), tripSchedulesRequest.getTripDate()));
            return response.setPayload(List.of());
        }
        return Response.<List<TripScheduleDto>>ok().setPayload(tripSchedules);
    }
}
