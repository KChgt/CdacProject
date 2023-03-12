package com.ev.evproject.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.beans.JavaBean;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

//@JavaBean
@Data
@Component
public class SlotLifeCycle {
    private Map<Long,Map<Long, Map<LocalDate, List<LocalTime>>>> slotLifeMap = new HashMap<>();

    public SlotLifeCycle(){
        super();
    }


    public void createLocalTimeList(Long stationId, Long slotId, LocalDate date){
        List<LocalTime> timeList = new ArrayList<>();
//         slotLife.computeIfAbsent(stationId, k -> new HashMap<>())
//                 .computeIfAbsent(slotId,k -> new HashMap<>())
//                 .put(date,timeList);
        slotLifeMap.get(stationId)
                .get(slotId)
                .put(date,timeList);
    }

    public List<LocalTime> insertLocalTimeByDate(Long stationId, Long slotId, LocalDate date, LocalTime time){
           List<LocalTime> timeList= slotLifeMap.get(stationId)
                    .get(slotId)
                    .get(date);
           timeList.add(time);
           return timeList;
    }
}
