package com.ev.evproject.controller;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


import com.ev.evproject.dto.ApiResponse;
import com.ev.evproject.dto.ChargingStationDto;
import com.ev.evproject.entity.ChargingStation;
import com.ev.evproject.entity.SlotLifeCycle;
import com.ev.evproject.enums.Port;
import com.ev.evproject.enums.Vehicle;
import com.ev.evproject.exceptions.ResourceAlreadyPresentException;
import com.ev.evproject.requestObject.LogInClass;
import com.ev.evproject.requestObject.OrderRequest;
import com.ev.evproject.service.SlotService;
import com.ev.evproject.service.StationService;
import org.apache.logging.log4j.util.PerformanceSensitive;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/station")
@CrossOrigin("http://localhost:3000")
public class StationController {

	public StationController() {
		super();
	}

	@Autowired
	private StationService stationService;
	@Autowired
	private SlotService slotService;
	@Autowired
	ModelMapper mapper;

	@Autowired
	SlotLifeCycle slotLifeCycle;




	public static String UploadDirectory = System.getProperty("user.dir") + "/src/main/webapp/imagedata";

	@PostMapping
	public ChargingStationDto addStation(@RequestBody ChargingStation station) {
		System.out.println("in add station dtls " + station);
//		station.getAddress().setChargingStation(station);
		if (stationService.getChargingStationByEmail(station.getEmail()).equals(station.getEmail())){
			ChargingStationDto chargingStationDto = stationService.saveChargingStationDetails(station);
			slotLifeCycle.getSlotLifeMap().put(chargingStationDto.getChargingStationId(),new HashMap<>());
		}
		throw new ResourceAlreadyPresentException("station is already present");
	}



	@PostMapping("/login")
	public ResponseEntity<?> ChargingStationLogin(@RequestBody LogInClass logInCred) {
		try {
			return ResponseEntity.ok(stationService.logInChargingStation(logInCred.getEmail(), logInCred.getPassword()));
		} catch (RuntimeException e) {
			return new ResponseEntity<>(new ApiResponse("Invalid Station ID!!!!!!"),
					HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/{city}")
	public List<ChargingStationDto> getChargingStationByLocation(@PathVariable("city") String city){
		return stationService.getChargingStationByLocation(city);
	}

	//	@GetMapping("/{city}&{port}")
	@GetMapping("/{city}/{port}")
	public List<ChargingStationDto> getChargingStationByLocationAndPort(@PathVariable("city") String city, @PathVariable("port") Port port){
		return stationService.getChargingStationByLocationAndPort(city,port);
	}

//	@GetMapping("/{city}/{port}")
//	public ResponseEntity<List<ChargingStationDto>> getChargingStationByLocationAndPort(@PathVariable("city") String city, @PathVariable("port") String port){
//		return ResponseEntity.ok(stationServices.getChargingStationByLocationAndPort(city,port));
//	}

	public List<ChargingStationDto> getAvailableStation(OrderRequest orderRequest){
		List<ChargingStation> chargingStationList = stationService.getChargingStationByVehicleAndLocationAndPort(orderRequest.getVehicle(),orderRequest.getLocation(),orderRequest.getPort());
		for(ChargingStation station : chargingStationList){

		}
		return null;
	}

	@GetMapping("/station/{city}/{vehicle}/{port}")
	public List<ChargingStationDto> getChargingStationByLocationAndVehicleAndPort(@PathVariable("city") String city,@PathVariable("vehicle") Vehicle vehicle,@PathVariable("port") Port port){
		List<ChargingStation> chargingStationDtoList = stationService.getChargingStationByVehicleAndLocationAndPort(vehicle,city,port);
		return chargingStationDtoList.stream().map(station -> mapper.map(station,ChargingStationDto.class)).collect(Collectors.toList());
	}
}
