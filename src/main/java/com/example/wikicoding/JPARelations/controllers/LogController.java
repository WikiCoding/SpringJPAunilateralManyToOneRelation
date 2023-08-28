package com.example.wikicoding.JPARelations.controllers;

import com.example.wikicoding.JPARelations.models.Log;
import com.example.wikicoding.JPARelations.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/log")
public class LogController {
    @Autowired
    private LogService logService;

    @PostMapping("/car/id={id}")
    public ResponseEntity<Log> addLog(@PathVariable("id") int id, @RequestBody Log log) {
        var response = logService.addLog(log, id);
        if (response != null) {
            return ResponseEntity.status(201).body(log);
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/car/id={id}")
    public ResponseEntity<List<Log>> getLogByCarId(@PathVariable("id") int id) {
        var response = logService.getLogsByCar(id);
        if (response != null) {
            return ResponseEntity.status(200).body(response);
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Log>> getAllLogs() {
        return ResponseEntity.status(200).body(logService.getAllLogs());
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteLog(@PathVariable("id") int id) {
        logService.deleteLog(id);
    }
}
