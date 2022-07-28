package com.cars.cars.repository;

import com.cars.cars.domain.Logs;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepository extends MongoRepository<Logs,String> {
}
