package com.ev.evproject.dto;

import com.ev.evproject.entity.ChargingStation;
import lombok.Data;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class AvailableStation {

    private ChargingStation chargingStation;
    private List<LocalTime> timeList = new ArrayList<>();
}