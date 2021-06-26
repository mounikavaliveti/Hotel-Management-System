package com.hotel.MicroService_Booking;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hotel.MicroService_Booking.model.ReturnResponse;
import com.hotel.MicroService_Booking.service.BookingsService;

@SpringBootTest
class MicroServiceBookingApplicationTests {

	 @Mock
	    BookingsService reservationsServiceImpl;

	@Test
	void contextLoads() {
		  Assert.assertEquals("Docker set up done!!",reservationsServiceImpl.testHm());
	}
	 @Test
	    public void testDeleteBookingsById(){
	        Mockito.when(reservationsServiceImpl.deleteBookingsById(Mockito.anyString())).thenReturn("Success");
	        Assert.assertEquals(new ResponseEntity(new ReturnResponse("Success"), HttpStatus.OK),
	        		reservationsServiceImpl.deleteBookingsById(Mockito.anyString()));
	    }
}
