package com.ev.evproject.service;

import com.ev.evproject.dto.ChargingSlotDto;
import com.ev.evproject.dto.ChargingStationDto;
import com.ev.evproject.entity.ChargingSlot;
import com.ev.evproject.entity.ChargingStation;
import com.ev.evproject.enums.Port;
import com.ev.evproject.enums.Vehicle;

import java.time.LocalDate;
import java.util.List;

public interface SlotService {
    ChargingSlot saveSlot(ChargingSlot slot);
    ChargingSlotDto saveSlotDetails(ChargingSlot slot);
    ChargingSlot updateSlot(ChargingSlot slot);
    ChargingSlotDto updateSlotDetails(ChargingSlot slot);
    ChargingSlot getSlot(Long id);
    ChargingSlotDto getSlotDetails(Long id);
    List<ChargingSlotDto> getSlotDetailsByStationId(Long id);
    public ChargingSlot checkAvailableSlot(Long stationId, Vehicle vehicle, Port port, LocalDate date, String time);
    List<ChargingSlot> getAllSlot();
    List<ChargingSlotDto> getAllSlotDetails();
    String deleteSlot(Long id);


}
