package com.example.wikicoding.JPARelations.services;

import com.example.wikicoding.JPARelations.models.Car;
import com.example.wikicoding.JPARelations.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public Car addNewCar(Car car) {
        car.setCreatedAt(LocalDateTime.now());
        carRepository.save(car);
        return car;
    }

    public void deleteCar(int id) {
        carRepository.deleteById(id);
    }
}
