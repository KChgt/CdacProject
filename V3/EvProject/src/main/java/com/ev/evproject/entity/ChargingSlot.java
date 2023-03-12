package com.ev.evproject.entity;

import com.ev.evproject.enums.Port;
import com.ev.evproject.enums.Vehicle;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "Charging_slot")
public class ChargingSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "charging_slot_id")
    private Long chargingSlotId;
    @Enumerated(EnumType.STRING)
    private Vehicle vehical;
    @Enumerated(EnumType.STRING)
    private Port port;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "fk_charging_station")
    private ChargingStation chargingStation;

    @JsonIgnore
    @OneToMany(mappedBy = "chargingSlot", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SlotBooking> slotBookings = new ArrayList<>();

}
