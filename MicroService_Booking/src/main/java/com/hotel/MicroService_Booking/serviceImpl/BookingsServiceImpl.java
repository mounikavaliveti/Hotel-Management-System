package com.hotel.MicroService_Booking.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.MicroService_Booking.Dao.BookingsRepository;
import com.hotel.MicroService_Booking.entity.Bookings;
import com.hotel.MicroService_Booking.model.BookingsDto;
import com.hotel.MicroService_Booking.service.BookingsService;

@Service
public class BookingsServiceImpl implements BookingsService{

	@Autowired
	BookingsRepository reservationsRepository;
	
	public String saveBookings(BookingsDto reservationsDto) {
		Bookings reservation = new Bookings(reservationsDto.getId(),
				reservationsDto.getCategory(),reservationsDto.getRoomNo(),
				reservationsDto.getCheckin(),reservationsDto.getCheckout(),
				reservationsDto.getName(),reservationsDto.getContactNo(),
				reservationsDto.getEmail(),reservationsDto.getAddressProof(),
				reservationsDto.getProofId(),reservationsDto.getPaymentStatus(),reservationsDto.getCompany(),
				reservationsDto.getCity(),reservationsDto.getSpoc(),reservationsDto.getPaymentType(),
				reservationsDto.getAmount(),reservationsDto.getStatus());

		Bookings confirmedReservation =reservationsRepository.save(reservation);
		
		return confirmedReservation.getId();
	}
	
	 public List<BookingsDto> getAllBookings(){
		 
		 List<Bookings> staffList= reservationsRepository.findAll();
			
			List<BookingsDto> result = new ArrayList<BookingsDto>();
			if(!staffList.isEmpty()) {
				for(Bookings s:staffList){
					BookingsDto reservationsDto = new BookingsDto(s.getId(),s.getCategory(),s.getRoomNo(),
							s.getCheckIn(),s.getCheckOut(),s.getName(),s.getContactNo(),s.getEmail(),
							s.getAddressProof(),s.getProofId(),s.getPaymentStatus(),s.getCompany(),
							s.getCity(),s.getSpoc(),s.getPaymentType(),s.getAmount(),s.getStatus());
					result.add(reservationsDto);
				}
			}
		return result;
	 }
		
	    public BookingsDto findById(String id) {
	    	BookingsDto reservationsDto = null;
			Optional<Bookings> reservations = reservationsRepository.findById(id);
			
			if(reservations.isPresent()) {
				Bookings s =reservations.get();
				reservationsDto = new BookingsDto(s.getId(),s.getCategory(),s.getRoomNo(),
						s.getCheckIn(),s.getCheckOut(),s.getName(),s.getContactNo(),s.getEmail(),
						s.getAddressProof(),s.getProofId(),s.getPaymentStatus(),s.getCompany(),
						s.getCity(),s.getSpoc(),s.getPaymentType(),s.getAmount(),s.getStatus());
			}
			
		    return reservationsDto;	
	    }
		
	    
	    public BookingsDto findByRoomNo(String roomNo) {
	    	BookingsDto reservationsDto = null;
			Bookings s = reservationsRepository.findByRoomNo(roomNo);
			
			if(null != s) {
				reservationsDto = new BookingsDto(s.getId(),s.getCategory(),s.getRoomNo(),
						s.getCheckIn(),s.getCheckOut(),s.getName(),s.getContactNo(),s.getEmail(),
						s.getAddressProof(),s.getProofId(),s.getPaymentStatus(),s.getCompany(),
						s.getCity(),s.getSpoc(),s.getPaymentType(),s.getAmount(),s.getStatus());
			}
			
		    return reservationsDto;	
	    }
	    
	    
		public String deleteBookingsById(String id) {
			reservationsRepository.deleteById(id);
			return id;
		}

		@Override
		public Object testHm() {
			// TODO Auto-generated method stub
			return null;
		}

}
