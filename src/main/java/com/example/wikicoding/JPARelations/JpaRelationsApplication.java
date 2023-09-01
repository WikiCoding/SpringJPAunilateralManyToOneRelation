package com.example.wikicoding.JPARelations;

import com.example.wikicoding.JPARelations.models.Car;
import com.example.wikicoding.JPARelations.models.Log;
import com.example.wikicoding.JPARelations.repositories.CarRepository;
import com.example.wikicoding.JPARelations.repositories.LogRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class JpaRelationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaRelationsApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CarRepository carRepository, LogRepository logRepository) {
		return args -> {
				carRepository.save(new Car("BMW", LocalDateTime.now()));
				carRepository.save(new Car("VW", LocalDateTime.now()));

				logRepository.save(new Log(245879, LocalDateTime.now(), 1.85, 50.0, new Car(1)));
				logRepository.save(new Log(246879, LocalDateTime.now(), 1.85, 50.0, new Car(1)));
				logRepository.save(new Log(247879, LocalDateTime.now(), 1.85, 50.0, new Car(2)));

		};
	}
}
