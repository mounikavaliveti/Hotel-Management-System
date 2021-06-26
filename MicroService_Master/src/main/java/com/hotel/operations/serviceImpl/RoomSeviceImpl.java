package com.hotel.operations.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hotel.operations.Dto.RoomDto;
import com.hotel.operations.Repository.RoomRepository;
import com.hotel.operations.entityDao.Room;
import com.hotel.operations.service.RoomService;

@Service
public class RoomSeviceImpl implements RoomService {
	
	private static final String test = null;

	@Autowired
	RoomRepository roomRepository;

    @Autowired
    private RestTemplate template;

	public String saveRoom(RoomDto roomDto) {

		Room room = new Room(roomDto.getId(),roomDto.getRoomNo(), roomDto.getFloor(), roomDto.getCategory(), roomDto.getCapacity(),
				roomDto.getPrice(),roomDto.isBooked());
		System.out.println("Booked"+roomDto.isBooked());

		Room savedRoom =  roomRepository.save(room);

		return savedRoom.getRoomNo();
	}
	public String updateRoom(RoomDto roomDto) {

		Optional<Room> room = roomRepository.findById(roomDto.getId());
		System.out.println("Booked"+roomDto.isBooked());
		Room savedRoom = null;
		if(room.isPresent()){
			savedRoom =  roomRepository.save(new Room(roomDto.getId(),roomDto.getRoomNo(), roomDto.getFloor(), roomDto.getCategory(), roomDto.getCapacity(),
					roomDto.getPrice(),roomDto.isBooked()));
			return savedRoom.getRoomNo();
		}else{
			return "Unable to find Room";
		}

	}
	
	public List<RoomDto> searchRooms(Date requiredCheckin, Date requiredCheckout) throws ParseException {

		
		List<RoomDto> list = new ArrayList<RoomDto>();
	
		List<Room> rooms = roomRepository.findAll();
		rooms.stream().filter( room -> {
			ResponseEntity<ReservationsDto> reservation = template.getForEntity("http://localhost:8001/booking/findByroomNo/"+room.getRoomNo(), ReservationsDto.class);
			System.out.println("called");
			
			if(null !=reservation){
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


				if("Active".equalsIgnoreCase(reservation.getBody().getStatus())){
					Date existingCheckin = reservation.getBody().getCheckin();
					Date existingCheckout = reservation.getBody().getCheckout();
					if(isWithinRange(requiredCheckin,existingCheckin, existingCheckout) ||
							isWithinRange(requiredCheckout,existingCheckin, existingCheckout)){
						return false;
					}
				}else {
					return  true;
				}

			}
			return true;
		});
		rooms.forEach( room -> {
			list.add(new RoomDto(room.getId(),room.getRoomNo(),room.getFloor(),room.getCategory(),room.getCapacity(),
					room.getPrice(),room.isBooked()));
		});


		return list;
	}

	public boolean isWithinRange(Date testDate,Date startDate, Date endDate) {

		return testDate.getTime() >= startDate.getTime() &&
				testDate.getTime() <= endDate.getTime();
	}
	
	public List<RoomDto> getAllRooms(){
		
		List<Room> roomsList = roomRepository.findAll();
		
		List<RoomDto> result = new ArrayList<RoomDto>();
		
		for(Room room:roomsList) {
			RoomDto roomDto = new RoomDto(room.getId(),room.getRoomNo(),room.getFloor(),room.getCategory(),room.getCapacity(),room.getPrice(),room.isBooked());
			result.add(roomDto);
		}
		
		return result;
	}
	
	 public RoomDto findById(String id) {
		 
		    RoomDto roomDto = null;
			Optional<Room> room = roomRepository.findById(id);
			
			if(room.isPresent()) {
				Room s =room.get();
				roomDto = new RoomDto(s.getId(),s.getRoomNo(),s.getFloor(),s.getCategory(),s.getCapacity(),s.getPrice(),s.isBooked());
			}
			
		    return roomDto;
	 }
		
		public  String deleteRoomById(String id) {
			roomRepository.deleteById(id);
			
			return test;
			
		}

}
