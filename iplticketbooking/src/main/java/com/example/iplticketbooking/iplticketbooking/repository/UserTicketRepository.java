package com.example.iplticketbooking.iplticketbooking.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.iplticketbooking.iplticketbooking.entity.UserTicket;

public interface UserTicketRepository extends CrudRepository<UserTicket, Integer> {
  Iterable<UserTicket> findAllByTicketNumber(String ticketNumber);
}
