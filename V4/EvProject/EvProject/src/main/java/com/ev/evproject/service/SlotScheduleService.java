package com.ev.evproject.service;

import com.ev.evproject.entity.ChargingSlot;
import com.ev.evproject.entity.SlotSchedule;
import com.ev.evproject.enums.Port;
import com.ev.evproject.enums.Vehicle;

import java.time.LocalDate;
import java.util.List;

public interface SlotScheduleService {

    SlotSchedule getScheduleByDateAndSlotId(LocalDate date, Long slotId);

}
