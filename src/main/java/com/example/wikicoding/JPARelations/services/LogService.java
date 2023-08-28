package com.example.wikicoding.JPARelations.services;

import com.example.wikicoding.JPARelations.models.Car;
import com.example.wikicoding.JPARelations.models.Log;
import com.example.wikicoding.JPARelations.repositories.CarRepository;
import com.example.wikicoding.JPARelations.repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LogService {
    @Autowired
    private LogRepository logRepository;

    @Autowired
    private CarRepository carRepository;

    public List<Log> getAllLogs() {
        return logRepository.findAll();
    }

    public List<Log> getLogsByCar(int carId) {
        try {
            Car carFound = carRepository.findById(carId).orElse(null);
            assert carFound != null;
            return logRepository.getLogsByCarId(carFound);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Log addLog(Log log, int carId) {
        try {
            Optional<Car> response = carRepository.findById(carId);
            log.setCreatedAt(LocalDateTime.now());
            log.setAmount(log.getPriceLiter()*log.getLiters());

            if (response.isPresent()) {
                log.setCar(response.orElse(null));
                Integer maxId = getMaxId(carId);

                if (maxId != null) {
                    Optional<Log> previousLog = getPreviousLog(maxId);
                    assert previousLog.orElse(null) != null;
                    int kmsOdo = log.getCurrent_odo() - previousLog.orElse(null).getCurrent_odo();
                    if (kmsOdo <= 0) {
                        System.out.println("Kms difference cannot be negative");
                        return null;
                    } else {
                        log.setLastTankRange(kmsOdo);
                        log.setLitersPer100km((100*log.getLiters())/kmsOdo);
                    }
                } else {
                    log.setLastTankRange(0);
                }
                System.out.println(log);
                logRepository.save(log);
                return log;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Integer getMaxId(int carId) {
        return logRepository.getMaxId(carId);
    }

    private Optional<Log> getPreviousLog(Integer maxId) {
        return logRepository.findById(maxId);
    }

    public void deleteLog(int id) {
        logRepository.deleteById(id);
    }
}
