package com.ev.evproject.requestObject;

import com.ev.evproject.enums.Port;
import com.ev.evproject.enums.Vehicle;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class BookingRequest {
    private Long stationId;
    private Vehicle vehicle;
    private Port port;
    private String time;
    private LocalDate date;


}
