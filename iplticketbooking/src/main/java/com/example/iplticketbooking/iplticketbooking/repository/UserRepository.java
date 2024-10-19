package com.example.iplticketbooking.iplticketbooking.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.iplticketbooking.iplticketbooking.entity.User;

public interface UserRepository extends CrudRepository<User, String> {
  public User findByAadhar(String aadhar);
  public User findByEmail(String email);
}
