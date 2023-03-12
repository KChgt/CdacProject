package com.ev.evproject.dto;

import com.ev.evproject.entity.Address;
import lombok.Data;

import java.math.BigInteger;

@Data
public class ChargingStationDto {
    private Long chargingStationId;
    private String stationName;
    private String email;
    private BigInteger phoneNumber;
    private float shopRatings;
    private Address address;
}
