package com.example.iplticketbooking.iplticketbooking.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.iplticketbooking.iplticketbooking.entity.Admin;

public interface AdminRepository extends CrudRepository<Admin, String> {
  public Admin findByAadhar(String aadhar);
  public Admin findByEmail(String email);
}
