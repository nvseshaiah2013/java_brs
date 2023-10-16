package com.self.practice.brs.repository.bus;

import com.self.practice.brs.model.bus.Bus;
import com.self.practice.brs.model.bus.Stop;
import com.self.practice.brs.model.bus.Trip;
import org.springframework.data.repository.CrudRepository;

public interface TripRepository extends CrudRepository<Trip, Long> {

    Trip findBySourceStopAndDestStopAndBus(Stop source, Stop destination, Bus bus);
}