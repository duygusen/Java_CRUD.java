package com.tobeto.a.spring.repositories;

import com.tobeto.a.spring.entities.Car;
import com.tobeto.a.spring.services.dtos.car.responses.CarResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepository extends MongoRepository<Car, Integer> {

    @Query("Select new com.tobeto.a.spring.services.dtos.car.responses.CarResponse(c.id, c.status) From Car c Where c.status = :status ")
    List<CarResponse> findByStatus(@Param("status") String status);

    @Query("Select new com.tobeto.a.spring.services.dtos.car.responses.CarResponse(c.id, c.modelYear) From Car c Where c.modelYear > :modelYear")
    List<CarResponse> findByModelYear(@Param("modelYear") int modelYear);

    //@Query("SELECT c FROM Car c WHERE c.modelName = :modelName")
    List<Car> findByModelName(String modelName);


}
