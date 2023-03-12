package com.ev.evproject.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;



import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "Transaction_List")
public class Transaction {

	@Id
	@Column(name = "transaction_id")
	private String transactionId;
	@Column(name = "date_of_payment")
	private LocalDate dateOfPayment;

	@Column(name = "time_of_payment")
	private LocalTime timeOfPayment;

	@Column(name = "booking_amount")
	private Double bookingAmount;

	@Column(name = "total_units")
	private Integer totalUnits;

	@Column(name = "total_price")
	private Double total_price;

	@NotNull(message = "Slot booking id is required")
	@OneToOne
	@JoinColumn(name = "slot_booking_id")
	private SlotBooking slot_booking;

}