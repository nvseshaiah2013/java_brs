package com.self.practice.brs.repository.bus;

import com.self.practice.brs.model.bus.Trip;
import com.self.practice.brs.model.bus.TripSchedule;
import org.springframework.data.repository.CrudRepository;

public interface TripScheduleRepository extends CrudRepository<TripSchedule, Long> {

    TripSchedule findByTripDetailAndTripDate(Trip tripDetail, String tripDate);
}
