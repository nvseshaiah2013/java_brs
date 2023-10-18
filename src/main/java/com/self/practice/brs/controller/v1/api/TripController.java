package com.self.practice.brs.controller.v1.api;

import com.self.practice.brs.controller.v1.request.GetTripSchedulesRequest;
import com.self.practice.brs.dto.model.bus.TripDto;
import com.self.practice.brs.dto.response.Response;
import com.self.practice.brs.service.TripService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/trips")
@Api(value = "brs-application-trip-controller")
public class TripController {

    @Autowired
    private TripService tripService;

    @GetMapping("/")
    public Response<List<TripDto>> getTripsByStops(@RequestBody @Valid GetTripSchedulesRequest tripSchedulesRequest) {
        List<TripDto> trips = tripService.getAvailableTripsBetweenStops(tripSchedulesRequest.getSourceStopCode(),
                tripSchedulesRequest.getDestinationStopCode());
        if (trips.isEmpty()) {
            var response = Response.<List<TripDto>>notFound();
            response
                    .setErrors(String.format("No trips between source stop - '%s' to '%s' are available at this time.",
                            tripSchedulesRequest.getSourceStopCode(),
                            tripSchedulesRequest.getDestinationStopCode()));
            return response.setPayload(List.of());
        }
        return Response.<List<TripDto>>ok().setPayload(trips);
    }
}
