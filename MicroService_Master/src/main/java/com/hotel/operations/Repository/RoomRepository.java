package com.hotel.operations.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hotel.operations.entityDao.Room;

@Repository
public interface RoomRepository extends MongoRepository<Room, String>{

}
