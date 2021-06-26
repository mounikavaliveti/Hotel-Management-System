package com.hotel.operations.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hotel.operations.entityDao.Register;

@Repository
public interface RegisterRepository extends MongoRepository<Register, String>{

	public Register findByEmailAndPassword(String email, String password);
}
