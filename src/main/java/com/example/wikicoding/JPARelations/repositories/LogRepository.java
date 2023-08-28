package com.example.wikicoding.JPARelations.repositories;

import com.example.wikicoding.JPARelations.models.Car;
import com.example.wikicoding.JPARelations.models.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LogRepository extends JpaRepository<Log, Integer> {
    @Query("FROM logs WHERE car=?1")
    List<Log> getLogsByCarId(Car car);

    @Query("SELECT MAX(id) AS max_id FROM logs WHERE car.id = :carId")
    Integer getMaxId(@Param("carId") int carId);
}
