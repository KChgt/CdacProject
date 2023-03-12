package com.ev.evproject.dto;

import com.ev.evproject.entity.Address;
import com.ev.evproject.entity.ImageNames;

import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@Data
public class ChargingStationDto {
    private Long chargingStationId;
    private String stationName;
    private String email;
    private BigInteger contactNumber;
    private float shopRatings;
    private Address address;
    private List<ImageNames> image_names;
}
