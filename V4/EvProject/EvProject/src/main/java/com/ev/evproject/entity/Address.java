package com.ev.evproject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;


import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name="address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private long addressId;

    @Column(length = 30, name = "house_name")
    private String houseName;

    private String lane1;

    private String lane2;

    private String lane3;

    private String landmark;

    private String city;

    private String district;

    private String pincode;

    @NotNull(message = "country missing")
    private String country;

    @Column(name = "gps_longitude")
    private String gpsLnogitude;

    @Column(name = "gps_latitude")
    private String gpsLatitude;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name="fk_customer_id")
    private Customer customer;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "fk_charging_station")
    private ChargingStation chargingStation;

}
