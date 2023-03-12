package com.ev.evproject.service;

import com.ev.evproject.dto.CustomerDto;
import com.ev.evproject.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer saveCustomer(Customer customer);
    CustomerDto saveCustomerDetails(Customer customer);
    Customer updateCustomer(Customer customer);
    Customer getCustomer(Long id);
    CustomerDto getCustomerByEmailAndPassword(String email, String password);
    List<Customer> getCustomerList();
    String deleteCustomer(Long id);
}
