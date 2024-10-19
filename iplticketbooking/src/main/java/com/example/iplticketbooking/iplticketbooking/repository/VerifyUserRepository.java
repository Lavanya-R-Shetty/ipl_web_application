package com.example.iplticketbooking.iplticketbooking.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.iplticketbooking.iplticketbooking.entity.VerifyUser;

public interface VerifyUserRepository
  extends CrudRepository<VerifyUser, String> {
  public VerifyUser findByEmail(String email);

  public void deleteByEmail(String email);
}
