package com.ev.evproject.service;

import com.ev.evproject.dto.CustomerDto;
import com.ev.evproject.entity.Customer;
import com.ev.evproject.exceptions.ResourceNotFoundException;
import com.ev.evproject.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ModelMapper mapper;

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public CustomerDto saveCustomerDetails(Customer customer) {
        return mapper.map(customerRepository.save(customer),CustomerDto.class);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        if(customerRepository.existsById(customer.getId())){
            return customerRepository.save(customer);
        }
        throw new ResourceNotFoundException("Customer invalid : update failed");
    }

    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("ID invalid : customer not found"));
    }

    @Override
    public List<Customer> getCustomerList() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerDto getCustomerByEmailAndPassword(String email, String password){
        Customer customer = customerRepository.findByEmailAndPassword(email, password);
        return mapper.map(customer,CustomerDto.class);
    }

    @Override
    public String deleteCustomer(Long id) {
        if(customerRepository.existsById(id)){
            customerRepository.deleteById(id);
            return "ID : " + id + " details deleted";
        }
        throw new ResourceNotFoundException("Invalid ID : delete unsuccessful");
    }

}
