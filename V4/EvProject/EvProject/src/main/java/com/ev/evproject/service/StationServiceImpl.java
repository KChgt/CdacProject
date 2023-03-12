package com.ev.evproject.service;

import com.ev.evproject.dto.AvailableStation;
import com.ev.evproject.dto.ChargingStationDto;
import com.ev.evproject.entity.ChargingSlot;
import com.ev.evproject.entity.ChargingStation;
import com.ev.evproject.entity.ImageNames;
import com.ev.evproject.entity.SlotSchedule;
import com.ev.evproject.enums.Port;
import com.ev.evproject.enums.Vehicle;
import com.ev.evproject.exceptions.ResourceNotFoundException;
import com.ev.evproject.repository.ImageRepository;
import com.ev.evproject.repository.OrderRepository;
import com.ev.evproject.repository.SlotRepository;
import com.ev.evproject.repository.SlotScheduleRepository;
import com.ev.evproject.repository.StationRepository;
import com.ev.evproject.requestObject.StationRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class StationServiceImpl implements StationService{

    @Autowired
    StationRepository stationRepository;
    @Autowired
    SlotRepository slotRepository;

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ModelMapper mapper;
    @Autowired
    SlotScheduleRepository slotScheduleRepository;
    @Autowired
    SlotService slotService;
    
    @Autowired
    ImageRepository imageRepository;

    @Override
    public ChargingStation saveChargingStation(ChargingStation chargingStation) {
        return stationRepository.save(chargingStation);
    }

    @Override
    public ChargingStationDto saveChargingStationDetails(ChargingStation chargingStation) {
        return mapper.map(stationRepository.save(chargingStation),ChargingStationDto.class);
    }

    @Override
    public ChargingStation updateChargingStation(ChargingStation chargingStation) {
        if(stationRepository.existsById(chargingStation.getChargingStationId())){
            return stationRepository.save(chargingStation);
        }
        throw new ResourceNotFoundException("Invalid Station : Update Failed");
    }
    @Override
    public ChargingStationDto updateChargingStationDetails(ChargingStation chargingStation) {
        if(stationRepository.existsById(chargingStation.getChargingStationId())){
            return mapper.map(stationRepository.save(chargingStation),ChargingStationDto.class);
        }
        throw new ResourceNotFoundException("Invalid Station : Update Failed");
    }

    @Override
    public ChargingStation getChargingStation(Long id) {
        return stationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Station not found"));
    }

    @Override
    public ChargingStation getChargingStationByEmail(String email) {
        return stationRepository.findByEmail(email);
    }

    @Override
    public List<ChargingStation> getAllChargingStation() {
        return stationRepository.findAll();
    }

    public List<ChargingStationDto> getChargingStationByLocation(String city){
        List<ChargingStation> chargingStationList = stationRepository.findByAddress_City(city);
        List<ChargingStationDto> chargingStationDtoList = chargingStationList.stream()
                .map(station -> mapper.map(station,ChargingStationDto.class))
                .collect(Collectors.toList());
        return chargingStationDtoList;
    }
//    @Override
//    public List<ChargingStationDto> getChargingStationByLocationAndPort(String city, String port) {
//        List<ChargingStationDto> chargingStationDtoList = new ArrayList<>();
//        List<ChargingStation> chargingStationList = stationRepository.findByAddressCity(city);
//        Set<ChargingSlot> slotList = slotRepository.findByPort(port);
//        for(ChargingStation station : chargingStationList){
//            for(ChargingSlot slot : slotList){
//                if(station.getChargingStationId().equals(slot.getChargingStation().getChargingStationId())){
//                    chargingStationDtoList.add(mapper.map(station,ChargingStationDto.class));
//                }
//            }
//        }
//        return chargingStationDtoList;
//    }
    @Override
    public List<ChargingStationDto> getChargingStationByLocationAndPort(String city, Port port){
        Set<ChargingStation> chargingStationsSet = new HashSet<>();
        List<ChargingStation> chargingStationList = stationRepository.findByAddressCity(city);
        for(ChargingStation station: chargingStationList){
                chargingStationsSet.add(slotRepository.findByPortAndAndChargingStation_ChargingStationId(port,station.getChargingStationId()));
        }
        List<ChargingStationDto> chargingStationDtoList = chargingStationsSet
                .stream()
                .map(station-> mapper.map(station,ChargingStationDto.class))
                .collect(Collectors.toList());
        return chargingStationDtoList;
    }
    @Override
    public ChargingStationDto getChargingStationDetails(Long id) {
        ChargingStation chargingStation = stationRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Station Not found"));
        return mapper.map(chargingStation,ChargingStationDto.class);
    }
//Changed
    public List<ChargingStation> getChargingStationByVehicleAndLocationAndPort(Vehicle vehicle, String city, Port port){
        Set<ChargingStation> chargingStationsSet = new HashSet<>();
        List<ChargingStation> chargingStationList = stationRepository.findByAddressCity(city);
        for(ChargingStation station: chargingStationList){
            List<ChargingSlot> chargingStationList2=slotRepository.findByPortAndVehicalAndChargingStationChargingStationId(port,vehicle,station.getChargingStationId());
            chargingStationsSet.add(chargingStationList2.get(0).getChargingStation());
            System.out.println(chargingStationsSet);
        }
        return chargingStationsSet.stream().toList();
    }

//changed
    public List<ChargingStation> getChargingStationByVehicleAndCityAndPort(Vehicle vehicle, String city, Port port){
        System.out.println("getChargingSlotByVehicleAndCityAbdPort");
        List<ChargingStation> chargingSlotList =new ArrayList<>();
        List<ChargingStation> chargingStationList = stationRepository.findByAddressCity(city);
        for(ChargingStation station : chargingStationList){
            List<ChargingSlot> chargingSlotList1 = station.getChargingSlots();
            for(ChargingSlot slot : chargingSlotList1){
                ChargingSlot chargingSlots = slotRepository.findByChargingSlotIdAndPortAndVehical(slot.getChargingSlotId(),port,vehicle);
                chargingSlotList.add(chargingSlots.getChargingStation());
            }
        }
        return chargingSlotList;
    }




    @Override
    public String deleteChargingStation(Long id) {
        if(stationRepository.existsById(id)){
            stationRepository.deleteById(id);
        }
        throw new ResourceNotFoundException("Invalid Id : deletion failed");
    }


    @Override
    public ChargingStationDto logInChargingStation(String email, String password) {
        ChargingStation chargingStation = stationRepository.findByEmailAndPassword(email, password);
        return mapper.map(chargingStation, ChargingStationDto.class);
    }

//    public List<AvailableStation> getAvailableStation(OrderRequest orderRequest){
//        AvailableStation availableStation = new AvailableStation();
//        Set<AvailableStation> availableStationSet = new HashSet<>();
//        List<LocalTime> bookedTime = new ArrayList<>();
//        List<ChargingStation> chargingStationList = slotRepository.findByPortAndChargingStation_Address_City(orderRequest.getPort(),orderRequest.getLocation());
//        for (ChargingStation station: chargingStationList) {
//            // this is because if I code station.getChargingSlots I will get all slot and then filter it out according to port and vehicle which will be length;
//            List<ChargingSlot> chargingSlotList = slotRepository.findByVehicleAndPortAndChargingStation_ChargingStationId(orderRequest.getVehicle(),orderRequest.getPort(),station.getChargingStationId());
//            for(ChargingSlot slot : chargingSlotList){
//               List<SlotBooking> orderList = orderRepository.findByBookingDateAndChargingSlot_ChargingSlotId(orderRequest.getDate(), slot.getChargingSlotId());
//               for(SlotBooking order : orderList){
//                   bookedTime.add(order.getBookingTime());
//                   LocalTime timeAfterOneHour = order.getBookingTime().plusHours(1);
//                   bookedTime.add(timeAfterOneHour);
//               }
//            }
//        }
//    }

//    isuue with slotschedule i need to check all slot timing availability and then return station.
//    @Override
//    public List<AvailableStation> getAvailableStation(StationRequest request){
//        List<AvailableStation> availableStationList = new ArrayList<>();
//        List<ChargingStation> chargingStationList =  getChargingStationByVehicleAndLocationAndPort(request.getVehicle(),request.getLocation(),request.getPort());
//        for(ChargingStation station : chargingStationList){
//            List<ChargingSlot> chargingSlotList = station.getChargingSlots();
//            for(ChargingSlot slot : chargingSlotList){
//                List<SlotSchedule> slotSchedule = slotScheduleRepository.findByDateAndChargingSlot_ChargingSlotId(request.getDate(),slot.getChargingSlotId());
//                availableStationList.add(new AvailableStation(station, slotSchedule));
//            }
//        }
//        return availableStationList;
//    }

    public List<ChargingStationDto> getAvailableStationByTime(StationRequest request, String time){
        Vehicle vehicle = request.getVehicle();
        Port port = request.getPort();
        String city = request.getLocation();
        LocalDate date = request.getDate();
        List<ChargingStation> availableStationList = new ArrayList<>();
        List<ChargingStation> chargingStationList =  getChargingStationByVehicleAndCityAndPort(vehicle,city,port);
        ChargingStation previous = null;
        for(ChargingStation station : chargingStationList){
                if(previous==null){
                    ChargingSlot slot = slotService.checkAvailableSlot(station.getChargingStationId(), vehicle, port, date, time);
                    availableStationList.add(slot.getChargingStation());
                    previous =station;
                    continue;
                }
                if(!previous.getChargingStationId().equals(station.getChargingStationId())) {
                    ChargingSlot slot = slotService.checkAvailableSlot(station.getChargingStationId(), vehicle, port, date, time);
                    availableStationList.add(slot.getChargingStation());
                }
                previous=station;
            }

        return availableStationList.stream().map(station-> mapper.map(station,ChargingStationDto.class)).collect(Collectors.toList());

    }
    
  public String uploadImage(String path, MultipartFile file, Long stationId) throws IOException {
		
    	ChargingStation station = stationRepository.findById(stationId).orElseThrow(null);
    	String name = file.getOriginalFilename();
		String filePath = path + File.separator + name;
		File f = new File(path);
		if(!f.exists()) {
			f.mkdir();
		}
		System.out.println(filePath);
		Files.copy(file.getInputStream(), Paths.get(filePath));
		ImageNames image1 = new ImageNames((long) 0, name, station);
		imageRepository.save(image1);
		return name;
		
	}

    public byte[] getImage(String path) throws IOException {
        File file = new File(path);
        
        return Files.readAllBytes(file.toPath());
    }

}




