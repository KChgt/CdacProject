package com.ev.evproject.repository;

import com.ev.evproject.entity.Customer;
import com.ev.evproject.exceptions.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
   Customer findByEmailAndPassword(String email,String password) throws ResourceNotFoundException;
}
