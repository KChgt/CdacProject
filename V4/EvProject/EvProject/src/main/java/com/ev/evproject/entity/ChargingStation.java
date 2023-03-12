package com.ev.evproject.entity;

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
@Table(name = "charging_station")
public class ChargingStation {

	@Id
	@Column(name = "charging_station_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long chargingStationId;

	@NotNull(message = "Station name is required")
	@Column(name = "station_name")
	private String stationName;

	@NotNull(message = "Email is required")
	@Column(unique = true)
	private String email;
	
	private String password;

	@NotNull(message = "GST number is required")
	@Column(name = "gst_number")
	private String gstNumber;

	@NotNull(message = "Date of registration is required")
	@Column(name = "date_of_registration")
	private LocalDate dateOfRegistration;

	@Column(name = "shop_ratings")
	private float shopRatings;

	@Column(name ="contact_num")
	private BigInteger contactNumber;

	@OneToOne(mappedBy = "chargingStation", cascade = CascadeType.ALL, orphanRemoval = true)
	private Address address;

	@JsonIgnore
	@OneToMany(mappedBy = "chargingStation", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<ChargingSlot> chargingSlots = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "chargingStation",cascade = CascadeType.ALL)
	private List<SlotBooking> slotBookings = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "chargingStation",cascade = CascadeType.ALL)
	private List<ImageNames> image_names;

}
