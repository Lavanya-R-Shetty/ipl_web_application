package com.example.iplticketbooking.iplticketbooking.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.iplticketbooking.iplticketbooking.entity.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, String> {
  public Ticket findByTicketNumber(String ticket_number);

  public Iterable<Ticket> findAllByEmail(String email);
}
 