package com.example.wikicoding.JPARelations.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Table
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Entity(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("createdAt")
    private LocalDateTime createdAt;

//    @JsonProperty("logId")
//    @OneToMany(mappedBy = "car", fetch = FetchType.LAZY, orphanRemoval = true)
//    private List<Log> logId;

    public Car(int id) {
        this.id = id;
    }

    public Car(String name, LocalDateTime createdAt) {
        this.name = name;
        this.createdAt = createdAt;
    }
}
