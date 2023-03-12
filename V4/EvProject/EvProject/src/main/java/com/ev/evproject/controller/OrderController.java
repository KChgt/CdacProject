package com.ev.evproject.controller;


import com.ev.evproject.service.OrderService;
import com.ev.evproject.service.SlotService;
import com.ev.evproject.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

//    @Autowired
//    StationService stationService;
//    @Autowired
//    SlotService slotService;
//    @Autowired
//    OrderService orderService;
//    @Autowired
//    SlotLifeCycle slotLifeCycle;

//    public List<ChargingStationDto> getAvailableStation(OrderRequest orderRequest){
//        List<ChargingStation> chargingStationList = stationService.getChargingStationByVehicleAndLocationAndPort(orderRequest.getVehicle(),orderRequest.getLocation(),orderRequest.getPort());
//        for(ChargingStation station : chargingStationList){
//            slotService.
//        }
//        return null;
//    }

//    public OrderDto putOrder(@RequestBody SlotBooking slotBooking){
//        SlotBooking slotBooking1 = orderService.putOrder(slotBooking);
//        slotLifeCycle.getSlotLifeMap
//
//    }



}
