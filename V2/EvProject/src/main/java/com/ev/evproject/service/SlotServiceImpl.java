package com.ev.evproject.service;

import com.ev.evproject.dto.ChargingSlotDto;
import com.ev.evproject.entity.ChargingSlot;
import com.ev.evproject.repository.SlotRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SlotServiceImpl implements SlotService{
    @Autowired
    SlotRepository slotRepository;
    @Autowired
    ModelMapper modelMapper;

    
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
    public String deleteSlot(Long id) {
        return null;
    }
}
