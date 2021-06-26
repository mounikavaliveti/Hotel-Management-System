package com.hotel.operations.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hotel.operations.entityDao.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
}
