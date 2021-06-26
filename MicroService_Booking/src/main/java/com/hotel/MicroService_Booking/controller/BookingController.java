package com.hotel.MicroService_Booking.controller;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.MicroService_Booking.model.BookingsDto;
import com.hotel.MicroService_Booking.model.ReturnResponse;
import com.hotel.MicroService_Booking.service.BookingsService;

@CrossOrigin(exposedHeaders = {HttpHeaders.CONTENT_DISPOSITION})
@RestController
@RequestMapping("/booking")
public class BookingController {

  

   @Autowired
   BookingsService bookingImpl;


    @GetMapping(value = "/test/Api")
    public String testHm() {


        return "Working properly!!";
    }




	@PostMapping(value = "/save/reservation")
	public  void saveBooking(@RequestBody BookingsDto bookingsDto) {

		bookingImpl.saveBookings(bookingsDto);
		
		
	}
	
	@GetMapping(value="/getAll/reservations")
    public List<BookingsDto> getAllBookings(){
		return (bookingImpl.getAllBookings());
		
	}
	
	@GetMapping(value="/getreservation/byid/{id}")
    public BookingsDto   findBookingById(@PathVariable String id){
		return (bookingImpl.findById(id));
		
	}
	
	@GetMapping(value="/findByroomNo/{roomNo}")
    public BookingsDto findBookingRoomNo(@PathVariable String roomNo){
		return (bookingImpl.findByRoomNo(roomNo));
		
	}
	
	@DeleteMapping(value="/deletereservations/byid/{id}")
    public String deleteBookingsById(@PathVariable String id){
		String success=bookingImpl.deleteBookingsById(id);
		return success;
		
	}
	
}
