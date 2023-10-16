package com.self.practice.brs.repository.bus;

import com.self.practice.brs.model.bus.Agency;
import com.self.practice.brs.model.bus.Bus;
import org.springframework.data.repository.CrudRepository;

public interface BusRepository extends CrudRepository<Bus, Long> {

    Bus findByCode(String busCode);

    Bus findByCodeAndAgency(String busCode, Agency agency);
}
