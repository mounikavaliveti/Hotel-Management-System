package com.hotel.operations.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.hotel.operations.Dto.RoomDto;

public interface RoomService {

	public String saveRoom(RoomDto roomDto);
	public String updateRoom(RoomDto roomDto);
	
	public List<RoomDto> searchRooms(Date checkIn, Date checkOut) throws ParseException;
	
	public List<RoomDto> getAllRooms();
	
    public RoomDto findById(String id);
	
	public String deleteRoomById(String id);
}
