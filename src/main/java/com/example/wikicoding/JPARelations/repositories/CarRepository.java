package com.example.wikicoding.JPARelations.repositories;

import com.example.wikicoding.JPARelations.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
