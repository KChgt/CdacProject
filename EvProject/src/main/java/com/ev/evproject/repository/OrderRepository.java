package com.ev.evproject.repository;

import com.ev.evproject.entity.SlotBooking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends JpaRepository<SlotBooking,Long> {

    List<SlotBooking> findByBookingDateAndChargingSlot_ChargingSlotId(LocalDate date, Long id);

}
