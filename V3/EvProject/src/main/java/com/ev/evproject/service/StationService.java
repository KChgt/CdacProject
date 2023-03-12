package com.ev.evproject.service;

import com.ev.evproject.dto.AvailableStation;
import com.ev.evproject.dto.ChargingStationDto;
import com.ev.evproject.entity.ChargingStation;
import com.ev.evproject.enums.Port;
import com.ev.evproject.enums.Vehicle;
import com.ev.evproject.requestObject.StationRequest;

import java.util.List;

public interface StationService {
    ChargingStation saveChargingStation(ChargingStation chargingStation);
    ChargingStationDto saveChargingStationDetails(ChargingStation chargingStation);
    ChargingStation updateChargingStation(ChargingStation chargingStation);
    ChargingStationDto updateChargingStationDetails(ChargingStation chargingStation);
    ChargingStation getChargingStation(Long id);
    ChargingStation getChargingStationByEmail(String email);
    List<ChargingStation> getAllChargingStation();
    ChargingStationDto getChargingStationDetails(Long id);

    List<AvailableStation> getAvailableStation(StationRequest request);

    public List<ChargingStationDto> getChargingStationByLocation(String city);
    List<ChargingStationDto> getChargingStationByLocationAndPort(String city, Port port);
    public List<ChargingStation> getChargingStationByVehicleAndLocationAndPort(Vehicle vehicle, String city, Port port);
    String deleteChargingStation(Long id);

    ChargingStationDto logInChargingStation(String email, String password);
    public List<ChargingStationDto> getAvailableStationByTime(StationRequest request, String time);

}
