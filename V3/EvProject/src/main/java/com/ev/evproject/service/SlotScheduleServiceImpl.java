package com.ev.evproject.service;

import com.ev.evproject.entity.ChargingSlot;
import com.ev.evproject.entity.SlotSchedule;
import com.ev.evproject.enums.Port;
import com.ev.evproject.enums.Vehicle;
import com.ev.evproject.exceptions.NotAvailableException;
import com.ev.evproject.repository.SlotRepository;
import com.ev.evproject.repository.SlotScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SlotScheduleServiceImpl implements SlotScheduleService{

    @Autowired
    SlotScheduleRepository scheduleRepository;
    @Autowired
    SlotRepository slotRepository;

    @Override
    public SlotSchedule getScheduleByDateAndSlotId(LocalDate date, Long slotId) {
        return scheduleRepository.findByDateAndSlotBooking_SlotBookingId(date, slotId);
    }


}
