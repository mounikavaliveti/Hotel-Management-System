package com.hotel.operations.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hotel.operations.entityDao.Staff;

@Repository
public interface StaffRepository extends MongoRepository<Staff, String>{

}
