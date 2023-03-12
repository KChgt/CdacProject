package com.ev.evproject.dto;

import com.ev.evproject.entity.ChargingStation;
import com.ev.evproject.entity.SlotSchedule;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class AvailableStation {

    private ChargingStation chargingStation;
    private SlotSchedule slotSchedule;
}