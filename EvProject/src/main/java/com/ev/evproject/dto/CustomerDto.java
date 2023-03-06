package com.ev.evproject.dto;

import com.ev.evproject.entity.Address;
import com.ev.evproject.enums.Gender;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDate;

@Data
public class CustomerDto {
    private String customerId;
    private String firstName;
    private String lastName;
    private LocalDate dataOfBirth;
    private Gender gender;
    private String email;
    private BigInteger contactNumber;
    private LocalDate dateOfRegistration;
    private Address address;
}
