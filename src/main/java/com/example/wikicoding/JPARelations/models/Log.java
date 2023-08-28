package com.example.wikicoding.JPARelations.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Table
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity(name = "logs")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonProperty("current_odo")
    private int current_odo;

    @JsonProperty("createdAt")
    private LocalDateTime createdAt;

    @JsonProperty("amount")
    private double amount;

    @Column(name = "price_Liter")
    @JsonProperty("priceLiter")
    private double priceLiter;

    @Column(name = "liters_per_100km")
    @JsonProperty("litersPer100Km")
    private double litersPer100km;

    @Column(name = "liters")
    @JsonProperty("liters")
    private double liters;

    @Column(name = "last_tank_range")
    @JsonIgnore
    private int lastTankRange;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "car_id")
    private Car car;

    public Log(int current_odo, LocalDateTime createdAt, double priceLiter, double liters, Car car) {
        this.current_odo = current_odo;
        this.createdAt = createdAt;
        this.priceLiter = priceLiter;
        this.liters = liters;
        this.car = car;
    }
}
