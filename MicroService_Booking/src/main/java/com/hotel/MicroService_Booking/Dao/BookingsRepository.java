package com.hotel.MicroService_Booking.Dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hotel.MicroService_Booking.entity.Bookings;

@Repository
public interface BookingsRepository  extends MongoRepository<Bookings, String>{

    public Bookings findByRoomNo(String RoomNo);
}
