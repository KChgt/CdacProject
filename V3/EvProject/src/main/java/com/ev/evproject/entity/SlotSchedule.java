package com.ev.evproject.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "SlotSchedule")
public class SlotSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long slotScheduleId;
    private LocalDate date;

    @Value("${my.booleanMember}")
    private boolean zero;
    @Value("${my.booleanMember}")
    private boolean one;
    @Value("${my.booleanMember}")
    private boolean two;
    @Value("${my.booleanMember}")
    private boolean three;
    @Value("${my.booleanMember}")
    private boolean four;
    @Value("${my.booleanMember}")
    private boolean five;
    @Value("${my.booleanMember}")
    private boolean six;
    @Value("${my.booleanMember}")
    private boolean seven;
    @Value("${my.booleanMember}")
    private boolean eight;
    @Value("${my.booleanMember}")
    private boolean nine;
    @Value("${my.booleanMember}")
    private boolean ten;
    @Value("${my.booleanMember}")
    private boolean eleven;
    @Value("${my.booleanMember}")
    private boolean twelve;
    @Value("${my.booleanMember}")
    private boolean thirteen;
    @Value("${my.booleanMember}")
    private boolean fourteen;
    @Value("${my.booleanMember}")
    private boolean fifteen;
    @Value("${my.booleanMember}")
    private boolean sixteen;
    @Value("${my.booleanMember}")
    private boolean seventeen;
    @Value("${my.booleanMember}")
    private boolean eighteen;
    @Value("${my.booleanMember}")
    private boolean nineteen;
    @Value("${my.booleanMember}")
    private boolean twenty;
    @Value("${my.booleanMember}")
    private boolean twentyOne;
    @Value("${my.booleanMember}")
    private boolean twentyTwo;
    @Value("${my.booleanMember}")
    private boolean twentyThree;



    @ManyToOne
    @JoinColumn(name = "fk_slotBooking")
    private SlotBooking slotBooking;

}


