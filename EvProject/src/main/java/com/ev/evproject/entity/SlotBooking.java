package com.ev.evproject.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;
import java.time.LocalTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "slot_booking")
public class SlotBooking {

	@Id
	@Column(name = "slot_booking_id")
	private Long slotBookingId;
	@Column(name = "booking_date")
	private LocalDate bookingDate;

	@Column(name = "booking_time")
	private LocalTime bookingTime;

	@ManyToOne
	@JoinColumn(name = "charging_station_id")
	private ChargingStation chargingStation;
	@OneToOne(mappedBy = "slot_booking", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private Transaction transaction;
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "charging_slot_id")
	private ChargingSlot chargingSlot;
}