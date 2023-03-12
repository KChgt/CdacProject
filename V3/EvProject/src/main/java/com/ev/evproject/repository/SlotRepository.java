package com.ev.evproject.repository;

import com.ev.evproject.entity.ChargingSlot;
import com.ev.evproject.entity.ChargingStation;
import com.ev.evproject.enums.Port;
import com.ev.evproject.enums.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface SlotRepository extends JpaRepository<ChargingSlot,Long> {
    Set<ChargingSlot> findByPort(String port);

    ChargingStation findByPortAndAndChargingStation_ChargingStationId(Port port, Long id);

    List<ChargingSlot> findByChargingStationChargingStationId(Long id);

    ChargingStation findByPortAndVehicalAndChargingStationChargingStationId(Port port, Vehicle vehicle, Long stationId);
    List<ChargingSlot> findByVehicalAndPortAndChargingStation_ChargingStationId(Vehicle vehicle, Port port, Long stationId);

    List<ChargingStation> findByPortAndChargingStation_Address_City(Port port, String city);


}
