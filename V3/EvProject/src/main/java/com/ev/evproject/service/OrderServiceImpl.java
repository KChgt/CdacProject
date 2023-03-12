package com.ev.evproject.service;

import com.ev.evproject.entity.ChargingSlot;
import com.ev.evproject.entity.ChargingStation;
import com.ev.evproject.entity.SlotBooking;
import com.ev.evproject.exceptions.ResourceNotFoundException;
import com.ev.evproject.repository.OrderRepository;
import com.ev.evproject.repository.SlotRepository;
import com.ev.evproject.repository.StationRepository;
import com.ev.evproject.requestObject.BookingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;
//    @Autowired
//    SlotRepository slotRepository;
//    @Autowired
//    SlotService slotService;
//    @Autowired
//    StationService stationService;


    @Override
    public SlotBooking putOrder(SlotBooking slotBooking) {
        return orderRepository.save(slotBooking);
    }

//    public SlotBooking checkSlot(BookingRequest request){
//        SlotBooking slotBooking = new SlotBooking();
//        List<ChargingSlot> chargingSlotList = slotRepository.findByVehicleAndPortAndChargingStation_ChargingStationId(request.getVehicle(),request.getPort(),request.getStationId());
//        for(ChargingSlot slot : chargingSlotList){
//            ChargingSlot chargingSlot = slotService.checkAvailableSlot(request.getStationId(),request.getVehicle(),request.getPort(),request.getDate(),request.getTime());
//           slotBooking.setChargingSlot(chargingSlot);
//        }
//        slotBooking.setBookingDate(LocalDate.now());
//        slotBooking.setBookingTime(LocalTime.now());
//        slotBooking.setChargingStation(stationService.getChargingStation(request.getStationId()));
//
//
//    }



}
