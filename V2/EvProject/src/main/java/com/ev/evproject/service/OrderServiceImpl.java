package com.ev.evproject.service;

import com.ev.evproject.entity.SlotBooking;
import com.ev.evproject.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;


    @Override
    public SlotBooking putOrder(SlotBooking slotBooking) {
        return orderRepository.save(slotBooking);
    }
}
