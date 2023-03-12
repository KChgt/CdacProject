package com.ev.evproject.service;

import com.ev.evproject.dto.ChargingSlotDto;
import com.ev.evproject.entity.ChargingSlot;
import com.ev.evproject.entity.SlotSchedule;
import com.ev.evproject.enums.Port;
import com.ev.evproject.enums.Vehicle;
import com.ev.evproject.exceptions.NotAvailableException;
import com.ev.evproject.repository.SlotRepository;
import com.ev.evproject.repository.SlotScheduleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SlotServiceImpl implements SlotService{
    @Autowired
    SlotRepository slotRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    SlotScheduleRepository scheduleRepository;

    
    @Override
    public ChargingSlot saveSlot(ChargingSlot slot) {
        return slotRepository.save(slot);
    }

    @Override
    public ChargingSlotDto saveSlotDetails(ChargingSlot slot) {
        return modelMapper.map(slot,ChargingSlotDto.class);
    }

    @Override
    public ChargingSlot updateSlot(ChargingSlot slot) {
        return null;
    }

    @Override
    public ChargingSlotDto updateSlotDetails(ChargingSlot slot) {
        return null;
    }

    @Override
    public ChargingSlot getSlot(Long id) {
        return null;
    }

    @Override
    public ChargingSlotDto getSlotDetails(Long id) {
        return modelMapper.map(slotRepository.findById(id),ChargingSlotDto.class);
    }

    @Override
    public List<ChargingSlotDto> getSlotDetailsByStationId(Long id) {
        List<ChargingSlot> chargingSlotList = slotRepository.findByChargingStationChargingStationId(id);
        List<ChargingSlotDto> chargingSlotDtoList= chargingSlotList.stream()
                .map(slot -> modelMapper.map(slot,ChargingSlotDto.class))
                .collect(Collectors.toList());
        return chargingSlotDtoList;
    }

    @Override
    public List<ChargingSlot> getAllSlot() {
        return slotRepository.findAll();
    }

    @Override
    public List<ChargingSlotDto> getAllSlotDetails() {
        List<ChargingSlot> chargingSlotList = slotRepository.findAll();
        List<ChargingSlotDto> chargingSlotDtoList = chargingSlotList.stream()
                .map(slot -> modelMapper.map(slot,ChargingSlotDto.class))
                .collect(Collectors.toList());
        return chargingSlotDtoList;
    }

    @Override
    public ChargingSlot checkAvailableSlot(Long stationId, Vehicle vehicle, Port port, LocalDate date, String time) {
        System.out.println("checking avaliable slot");
        List<ChargingSlot> chargingSlotList = slotRepository.findByVehicalAndPortAndChargingStation_ChargingStationId(vehicle,port,stationId);
        for(ChargingSlot slot: chargingSlotList){
            SlotSchedule slotSchedule = scheduleRepository.findByDateAndChargingSlot_ChargingSlotId(date, slot.getChargingSlotId());
            switch (time){
                case "zero"->{
                    if(!slotSchedule.isZero()){
                        return slot;
                    }
                }
                case "one"->{
                    if(!slotSchedule.isOne()){
                        return slot;
                    }
                }
                case "two"->{
                    if(slotSchedule.isTwo()){
                        return slot;
                    }
                }
                case "three"->{
                    if(slotSchedule.isThree()){
                        return slot;
                    }
                }
                case "four"->{
                    if(slotSchedule.isFour()){
                        return slot;
                    }

                }
                case "five"->{
                    if(slotSchedule.isFive()){
                        return slot;
                    }
                }

                default -> throw new IllegalStateException("Unexpected value: " + time);
            }
        }
        throw new NotAvailableException("Slot Not available");
    }


    @Override
    public String deleteSlot(Long id) {
        return null;
    }
}
