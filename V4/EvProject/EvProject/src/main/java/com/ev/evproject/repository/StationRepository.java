package com.ev.evproject.repository;

import com.ev.evproject.dto.ChargingStationDto;
import com.ev.evproject.entity.ChargingStation;
import com.ev.evproject.enums.Port;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StationRepository extends JpaRepository<ChargingStation,Long> {

//    @Query("select station.charging_station_id from charging_station station inner join address ad on station.charging_station_id=ad.fk_charging_station ")
//    List<Long> findByAddressCityAndPort(String city, Port port);

//    @Query("SELECT DISTINCT st.charging_station_id FROM charging_station st INNER JOIN address ad ON ad.charging_station_id = st.charging_station_id INNER JOIN charging_slot cs ON st.charging_station_id = cs.charging_station_id WHERE ad.city = ?1 AND cs.port = ?2")
//    List<Long> findByCityAndPort(String city, String port);

    List<ChargingStation> findByAddressCity(String city);

    List<ChargingStation> findByAddress_City(String city);

    ChargingStation findByEmailAndPassword(String email, String password);

    ChargingStation findByEmail(String email);






}
