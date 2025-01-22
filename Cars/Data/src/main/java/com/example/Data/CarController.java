package com.example.Data;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/update")
    public ResponseEntity<String> updateProducersAndFetchCars(@RequestParam List<String> brands) {
        carService.updateProducersAndFetchCars(brands);
        return ResponseEntity.ok("Samochody z ostatnich 10 lat zaktualizowane: " + brands);
    }
}


