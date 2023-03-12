package com.ev.evproject.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table
public class Order {
    @Id
    private Long id;
    private LocalDate bookingDate;
    private LocalTime bookingTime;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}


//    @OneToOne(mappedBy = "order",cascade = CascadeType.ALL, orphanRemoval = true)
//    private Transaction transaction;
//
//    @ManyToOne
//    @JoinColumn(name = "fk_charging_station")
//    private ChargingStation chargingStation;
//
//    @ManyToOne
//    @JoinColumn(name = "fk_customer")
//    private Customer customer;
//
//    @ManyToOne
//    @JoinColumn(name = "fk_charging_slot")
//    private ChargingSlot chargingSlot;


