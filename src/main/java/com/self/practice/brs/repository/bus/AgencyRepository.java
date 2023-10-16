package com.self.practice.brs.repository.bus;

import com.self.practice.brs.model.bus.Agency;
import com.self.practice.brs.model.user.User;
import org.springframework.data.repository.CrudRepository;

public interface AgencyRepository extends CrudRepository<Agency, Long> {

    Agency findByCode(String agencyCode);

    Agency findByOwner(User owner);

    Agency findByName(String name);
}
