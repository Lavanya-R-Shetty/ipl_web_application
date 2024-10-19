package com.example.iplticketbooking.iplticketbooking.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.iplticketbooking.iplticketbooking.entity.IPLMatch;

public interface MatchRepository extends CrudRepository<IPLMatch, String> {
  Iterable<IPLMatch> findAllByLocationAndDate(
    String Location,
    String date 
  );
}
