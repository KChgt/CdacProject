package com.ev.evproject.repository;

import com.ev.evproject.entity.SlotSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SlotScheduleRepository extends JpaRepository<SlotSchedule,Long> {
//	changed from SlotSchedule to List<SlotSchedule>
	SlotSchedule findByDateAndChargingSlot_ChargingSlotId(LocalDate date, Long slotId);


}
