package com.tobeto.a.spring.repositories;

import com.tobeto.a.spring.entities.Car;
import com.tobeto.a.spring.services.dtos.car.responses.GetListCarModelYear;
import com.tobeto.a.spring.services.dtos.car.responses.GetListCarStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {

    @Query("Select new com.tobeto.a.spring.services.dtos.car.responses.GetListCarStatus(c.id, c.status) From Car c Where c.status = :status ")
    List<GetListCarStatus> findByStatus(@Param("status") String status);

    @Query("Select new com.tobeto.a.spring.services.dtos.car.responses.GetListCarModelYear(c.id, c.modelYear) From Car c Where c.modelYear > :modelYear")
    List<GetListCarModelYear> findByModelYear(@Param("modelYear") int modelYear);
}