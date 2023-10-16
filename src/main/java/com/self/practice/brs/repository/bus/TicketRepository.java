package com.self.practice.brs.repository.bus;

import com.self.practice.brs.model.bus.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
}
