package com.self.practice.brs.repository.bus;

import org.springframework.data.repository.CrudRepository;
import com.self.practice.brs.model.bus.Stop;

public interface StopRepository extends CrudRepository<Stop, Long> {
    Stop findByCode(String code);

}
