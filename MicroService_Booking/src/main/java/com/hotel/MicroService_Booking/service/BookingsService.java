package com.hotel.MicroService_Booking.service;

import java.util.List;

import com.hotel.MicroService_Booking.model.BookingsDto;


public interface BookingsService {

	public String saveBookings(BookingsDto reservationsDto);
	
    public List<BookingsDto> getAllBookings();
	
    public BookingsDto findById(String id);
    
    public BookingsDto findByRoomNo(String id);
	
	public String deleteBookingsById(String id);

	public Object testHm();
}
