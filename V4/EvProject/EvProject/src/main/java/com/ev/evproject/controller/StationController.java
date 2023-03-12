package com.ev.evproject.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


import com.ev.evproject.dto.ApiResponse;
import com.ev.evproject.dto.ChargingStationDto;
import com.ev.evproject.entity.ChargingStation;

import com.ev.evproject.enums.Port;
import com.ev.evproject.enums.Vehicle;
import com.ev.evproject.requestObject.LogInClass;
import com.ev.evproject.requestObject.StationRequest;
import com.ev.evproject.service.SlotService;
import com.ev.evproject.service.StationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


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


	
	
	 @Value("${project.image}")
	private String path;




	public static String UploadDirectory = System.getProperty("user.dir") + "/src/main/webapp/imagedata";

	@PostMapping
	public ChargingStationDto addStation(@RequestBody ChargingStation station) {
		System.out.println("in add station dtls " + station);
	station.getAddress().setChargingStation(station);

			ChargingStationDto chargingStationDto = stationService.saveChargingStationDetails(station);
			return chargingStationDto;

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

	public List<ChargingStationDto> getAvailableStation(StationRequest stationRequest){
		List<ChargingStation> chargingStationList = stationService.getChargingStationByVehicleAndLocationAndPort(stationRequest.getVehicle(),stationRequest.getLocation(),stationRequest.getPort());

		return null;
	}

	@GetMapping("/station/{city}/{vehicle}/{port}")
	public List<ChargingStationDto> getChargingStationByLocationAndVehicleAndPort(@PathVariable("city") String city,@PathVariable("vehicle") Vehicle vehicle,@PathVariable("port") Port port){
		List<ChargingStation> chargingStationDtoList = stationService.getChargingStationByVehicleAndLocationAndPort(vehicle,city,port);
		return chargingStationDtoList.stream().map(station -> mapper.map(station,ChargingStationDto.class)).collect(Collectors.toList());
	}

	@PostMapping("/time/{time}")
	public List<ChargingStationDto> availableStationByTime(@RequestBody StationRequest stationRequest, @PathVariable("time")String time){
		return stationService.getAvailableStationByTime(stationRequest,time);
	}
	
	
	@GetMapping
	public List<ChargingStation> getListOfStation() {
		return stationService.getAllChargingStation();
	}
	
	@PostMapping("/upload/{stationId}")
	public void fileUpload(@RequestParam("image") MultipartFile image, @PathVariable("stationId") Long stationId) throws IOException {

		  System.out.println(image.getOriginalFilename());
		String fileName = stationService.uploadImage(path, image, stationId);
	  

	}
	
	
	@GetMapping("/image/{imageName}")
	public ResponseEntity<byte[]> getImage(@PathVariable String imageName) throws IOException {
	    String path1 = path + File.separator + imageName;
	    System.out.println(path1);
	    byte[] imageBytes = stationService.getImage(path1);
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.IMAGE_JPEG);
	    headers.setContentDisposition(ContentDisposition.builder("attachment")
	            .filename(imageName)
	            .build());
	    return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
	}
		
}
