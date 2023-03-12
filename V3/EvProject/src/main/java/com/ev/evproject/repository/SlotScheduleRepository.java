package com.ev.evproject.repository;

import com.ev.evproject.entity.SlotSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface SlotScheduleRepository extends JpaRepository<SlotSchedule,Long> {
    SlotSchedule findByDateAndSlotBooking_SlotBookingId(LocalDate date, Long slotId);


}
