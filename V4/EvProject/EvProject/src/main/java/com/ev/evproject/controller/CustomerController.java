package com.ev.evproject.controller;

import com.ev.evproject.dto.ApiResponse;
import com.ev.evproject.dto.CustomerDto;
import com.ev.evproject.entity.Customer;
import com.ev.evproject.requestObject.LogInClass;
import com.ev.evproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@CrossOrigin("http://localhost:3000")
public class CustomerController {


    @Autowired
    private CustomerService customerService;


    public CustomerController() {
        super();
    }

    //	@PostMapping
//	public Customer addCustomerDetails(@RequestBody  Customer customer) { //@Valid is of javax or jakarta?
//		System.out.println("in add emp dtls " + customer);
//	customer.getAddress().setCustomer(customer);
//		return services.saveCustomerDetails(customer);
//	}
    @PostMapping
    public CustomerDto addCustomer(@RequestBody Customer customer){
    	customer.getAddress().setCustomer(customer);
        return customerService.saveCustomerDetails(customer);
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomerList();
    }

    @PostMapping("/login")
    public ResponseEntity<?> CustomerLogin(@RequestBody LogInClass logInCred) {
        try {
            return ResponseEntity.ok(customerService.getCustomerByEmailAndPassword(logInCred.getEmail(), logInCred.getPassword()));
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new ApiResponse("Invalid Employee ID!!!!!!"),
                    HttpStatus.NOT_FOUND);
        }
    }

}

