package com.ev.evproject.dto;

import com.ev.evproject.enums.Port;
import com.ev.evproject.enums.Vehicle;
import lombok.Data;

@Data
public class ChargingSlotDto {
    private String chargingSlotId;
    private Vehicle vehicle;
    private Port port;

}
