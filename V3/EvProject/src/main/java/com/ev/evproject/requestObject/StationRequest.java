package com.ev.evproject.requestObject;

import com.ev.evproject.enums.Port;
import com.ev.evproject.enums.Vehicle;
import lombok.Data;

import java.time.LocalDate;

@Data
public class StationRequest {
    private String location;
    private LocalDate date;
    private Vehicle vehicle;
    private Port port;
}
