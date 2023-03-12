package com.ev.evproject.controller;

import com.ev.evproject.dto.ChargingStationDto;
import com.ev.evproject.dto.OrderDto;
import com.ev.evproject.entity.ChargingSlot;
import com.ev.evproject.entity.ChargingStation;
import com.ev.evproject.requestObject.OrderRequest;
import com.ev.evproject.service.SlotService;
import com.ev.evproject.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    StationService stationService;

    @Autowired
    SlotService slotService;

//    public List<ChargingStationDto> getAvailableStation(OrderRequest orderRequest){
//        List<ChargingStation> chargingStationList = stationService.getChargingStationByVehicleAndLocationAndPort(orderRequest.getVehicle(),orderRequest.getLocation(),orderRequest.getPort());
//        for(ChargingStation station : chargingStationList){
//            slotService.
//        }
//        return null;
//    }


}
