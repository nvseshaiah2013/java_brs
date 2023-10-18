package com.self.practice.brs.controller.v1.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class GetTripSchedulesRequest {

    private String sourceStopCode;

    private String destinationStopCode;

    private Date tripDate;
}
