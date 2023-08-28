package com.example.wikicoding.JPARelations.controllers;

import com.example.wikicoding.JPARelations.models.Car;
import com.example.wikicoding.JPARelations.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping("/add")
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        return ResponseEntity.status(201).body(carService.addNewCar(car));
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCar(@PathVariable("id") int id) {
        carService.deleteCar(id);
    }
}
