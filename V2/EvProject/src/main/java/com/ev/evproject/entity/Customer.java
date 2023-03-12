package com.ev.evproject.entity;


import com.ev.evproject.enums.Gender;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private Long id;

    @NotNull(message = "First name is required")
    @Column(name = "first_name")
    private String firstName;

    @NotNull(message = "Last name is required")
    @Column(name = "last_name")
    private String lastName;

    @NotNull(message = "Date of birth is required")
    @Column(name = "date_of_birth")
    private LocalDate dataOfBirth;

    @NotNull(message = "Gender is required")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull(message = "Email is required")
    @Column(unique = true)
    private String email;

    @NotNull(message = "Password is required")
    private String password;

    @NotNull(message = "Contact number is required")
    @Column(name = "contact_number")
    private BigInteger contactNumber;

    @NotNull(message = "Registration date is required")
    @Column(name = "date_of_registration", nullable = false)
    private LocalDate dateOfRegistration;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Address address;

    @JsonIgnore
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SlotBooking> slotBookings = new ArrayList<>();

//    @JsonIgnore
//    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<CustomerComplaint> customerComplaints = new ArrayList<>();
//
//    @JsonIgnore
//    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval =true)
//    private List<Feedback> feedbacks = new ArrayList<>();

}
