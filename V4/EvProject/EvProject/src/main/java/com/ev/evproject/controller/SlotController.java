package com.ev.evproject.controller;

import com.ev.evproject.dto.ChargingSlotDto;
import com.ev.evproject.entity.ChargingSlot;
import com.ev.evproject.entity.ChargingStation;

import com.ev.evproject.exceptions.ResourceNotFoundException;
import com.ev.evproject.repository.SlotScheduleRepository;
import com.ev.evproject.repository.StationRepository;
import com.ev.evproject.service.SlotService;
import com.ev.evproject.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/slot")
@CrossOrigin("http://localhost:3000")
public class SlotController {

	@Autowired
	private SlotService slotService;
	@Autowired
	private StationService stationService;
	
	@Autowired
	private SlotScheduleRepository repository;



	@PostMapping("/addSlot/{numberOfSlots}/{stationId}")
	public void addSlot(@PathVariable("numberOfSlots") int numberOfSlots, @PathVariable("stationId") Long stationId,@RequestBody ChargingSlot slotinfo) {

		System.out.println(numberOfSlots + " " + stationId);
		ChargingStation station = stationService.getChargingStation(stationId);

		for(int i = 0; i < numberOfSlots; i++) {
			System.out.println("inside addslot");
			System.out.println(i);
			 slotinfo.setChargingStation(station);
			ChargingSlot chargingSlot = slotService.saveSlot(slotinfo);

		}
	}

//	this method is for admin and station;
	@GetMapping("/{stationid}")
	public ResponseEntity<List<ChargingSlotDto>> getSlotByStation(@PathVariable("stationid") String id){
		return ResponseEntity.ok(slotService.getSlotDetailsByStationId(Long.parseLong(id)));
	}
	
//	@PostMapping('/add')
//	public String addDate(@RequestBody Long StationId) {
//		
//	}
	
	
}


