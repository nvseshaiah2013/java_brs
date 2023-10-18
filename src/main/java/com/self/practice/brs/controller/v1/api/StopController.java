package com.self.practice.brs.controller.v1.api;

import com.self.practice.brs.dto.model.bus.StopDto;
import com.self.practice.brs.dto.response.Response;
import com.self.practice.brs.service.StopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/stops")
@Api(value = "brs-application-stop-controller")
public class StopController {

    @Autowired
    private StopService stopService;

    @GetMapping("/stops")
    @ApiOperation(value = "", authorizations = {@Authorization(value = "apiKey")})
    public Response<Set<StopDto>> getAllStops() {
        return Response.<Set<StopDto>>ok()
                .setPayload(stopService.getAllStops());
    }
}
