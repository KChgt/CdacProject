package com.ev.evproject.service;

import com.ev.evproject.dto.AvailableStation;
import com.ev.evproject.dto.ChargingStationDto;
import com.ev.evproject.entity.ChargingSlot;
import com.ev.evproject.entity.ChargingStation;
import com.ev.evproject.entity.SlotBooking;
import com.ev.evproject.enums.Port;
import com.ev.evproject.enums.Vehicle;
import com.ev.evproject.exceptions.ResourceNotFoundException;
import com.ev.evproject.repository.OrderRepository;
import com.ev.evproject.repository.SlotRepository;
import com.ev.evproject.repository.StationRepository;
import com.ev.evproject.requestObject.OrderRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class StationServiceImpl implements StationService{

    @Autowired
    StationRepository stationRepository;
    @Autowired
    SlotRepository slotRepository;

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ModelMapper mapper;

    @Override
    public ChargingStation saveChargingStation(ChargingStation chargingStation) {
        return stationRepository.save(chargingStation);
    }

    @Override
    public ChargingStationDto saveChargingStationDetails(ChargingStation chargingStation) {
        return mapper.map(stationRepository.save(chargingStation),ChargingStationDto.class);
    }

    @Override
    public ChargingStation updateChargingStation(ChargingStation chargingStation) {
        if(stationRepository.existsById(chargingStation.getChargingStationId())){
            return stationRepository.save(chargingStation);
        }
        throw new ResourceNotFoundException("Invalid Station : Update Failed");
    }
    @Override
    public ChargingStationDto updateChargingStationDetails(ChargingStation chargingStation) {
        if(stationRepository.existsById(chargingStation.getChargingStationId())){
            return mapper.map(stationRepository.save(chargingStation),ChargingStationDto.class);
        }
        throw new ResourceNotFoundException("Invalid Station : Update Failed");
    }

    @Override
    public ChargingStation getChargingStation(Long id) {
        return stationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Station not found"));
    }

    @Override
    public ChargingStation getChargingStationByEmail(String email) {
        return stationRepository.findByEmail(email);
    }

    @Override
    public List<ChargingStation> getAllChargingStation() {
        return stationRepository.findAll();
    }

    public List<ChargingStationDto> getChargingStationByLocation(String city){
        List<ChargingStation> chargingStationList = stationRepository.findByAddress_City(city);
        List<ChargingStationDto> chargingStationDtoList = chargingStationList.stream()
                .map(station -> mapper.map(station,ChargingStationDto.class))
                .collect(Collectors.toList());
        return chargingStationDtoList;
    }
//    @Override
//    public List<ChargingStationDto> getChargingStationByLocationAndPort(String city, String port) {
//        List<ChargingStationDto> chargingStationDtoList = new ArrayList<>();
//        List<ChargingStation> chargingStationList = stationRepository.findByAddressCity(city);
//        Set<ChargingSlot> slotList = slotRepository.findByPort(port);
//        for(ChargingStation station : chargingStationList){
//            for(ChargingSlot slot : slotList){
//                if(station.getChargingStationId().equals(slot.getChargingStation().getChargingStationId())){
//                    chargingStationDtoList.add(mapper.map(station,ChargingStationDto.class));
//                }
//            }
//        }
//        return chargingStationDtoList;
//    }
    @Override
    public List<ChargingStationDto> getChargingStationByLocationAndPort(String city, Port port){
        Set<ChargingStation> chargingStationsSet = new HashSet<>();
        List<Long> chargingStationList = stationRepository.findByAddressCity(city);
        for(Long id: chargingStationList){
                chargingStationsSet.add(slotRepository.findByPortAndAndChargingStation_ChargingStationId(port,id));
        }
        List<ChargingStationDto> chargingStationDtoList = chargingStationsSet
                .stream()
                .map(station-> mapper.map(station,ChargingStationDto.class))
                .collect(Collectors.toList());
        return chargingStationDtoList;
    }
    @Override
    public ChargingStationDto getChargingStationDetails(Long id) {
        ChargingStation chargingStation = stationRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Station Not found"));
        return mapper.map(chargingStation,ChargingStationDto.class);
    }

    public List<ChargingStation> getChargingStationByVehicleAndLocationAndPort(Vehicle vehicle, String city, Port port){
        Set<ChargingStation> chargingStationsSet = new HashSet<>();
        List<Long> chargingStationList = stationRepository.findByAddressCity(city);
        for(Long id: chargingStationList){
            chargingStationsSet.add(slotRepository.findByPortAndVehicleAndChargingStationChargingStationId(port,vehicle,id));
        }
        return chargingStationsSet.stream().toList();
    }


    @Override
    public String deleteChargingStation(Long id) {
        if(stationRepository.existsById(id)){
            stationRepository.deleteById(id);
        }
        throw new ResourceNotFoundException("Invalid Id : deletion failed");
    }


    @Override
    public ChargingStationDto logInChargingStation(String email, String password) {
        ChargingStation chargingStation = stationRepository.findByEmailAndPassword(email, password);
        return mapper.map(chargingStation, ChargingStationDto.class);
    }

//    public List<AvailableStation> getAvailableStation(OrderRequest orderRequest){
//        AvailableStation availableStation = new AvailableStation();
//        Set<AvailableStation> availableStationSet = new HashSet<>();
//        List<LocalTime> bookedTime = new ArrayList<>();
//        List<ChargingStation> chargingStationList = slotRepository.findByPortAndChargingStation_Address_City(orderRequest.getPort(),orderRequest.getLocation());
//        for (ChargingStation station: chargingStationList) {
//            // this is because if I code station.getChargingSlots I will get all slot and then filter it out according to port and vehicle which will be length;
//            List<ChargingSlot> chargingSlotList = slotRepository.findByVehicleAndPortAndChargingStation_ChargingStationId(orderRequest.getVehicle(),orderRequest.getPort(),station.getChargingStationId());
//            for(ChargingSlot slot : chargingSlotList){
//               List<SlotBooking> orderList = orderRepository.findByBookingDateAndChargingSlot_ChargingSlotId(orderRequest.getDate(), slot.getChargingSlotId());
//               for(SlotBooking order : orderList){
//                   bookedTime.add(order.getBookingTime());
//                   LocalTime timeAfterOneHour = order.getBookingTime().plusHours(1);
//                   bookedTime.add(timeAfterOneHour);
//               }
//            }
//        }
//    }




}
