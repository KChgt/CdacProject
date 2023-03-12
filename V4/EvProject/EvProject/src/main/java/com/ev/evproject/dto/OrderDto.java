package com.ev.evproject.dto;

import com.ev.evproject.entity.ChargingSlot;
import com.ev.evproject.entity.ChargingStation;
import com.ev.evproject.entity.Customer;
import com.ev.evproject.entity.Transaction;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderDto {

    private String slotBookingId;
    private LocalDate bookingDate;
    private LocalDate bookingTime;
    private ChargingStation chargingStation;
    private Transaction transaction;
    private Customer customer;
    private ChargingSlot chargingSlot;
}

