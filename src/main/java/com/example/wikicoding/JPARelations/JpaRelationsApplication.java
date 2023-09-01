package com.example.wikicoding.JPARelations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaRelationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaRelationsApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(CarRepository carRepository, LogRepository logRepository) {
//		return args -> {
//				carRepository.save(new Car("BMW", LocalDateTime.now()));
//				carRepository.save(new Car("VW", LocalDateTime.now()));
//
//				logRepository.save(new Log(245879, LocalDateTime.now(), 1.85, 50.0, new Car(1)));
//				logRepository.save(new Log(246879, LocalDateTime.now(), 1.85, 50.0, new Car(1)));
//				logRepository.save(new Log(247879, LocalDateTime.now(), 1.85, 50.0, new Car(2)));
//
//		};
//	}
}
