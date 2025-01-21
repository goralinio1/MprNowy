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

    /**
     * Endpoint do aktualizacji producentów i pobierania danych samochodów
     * na podstawie listy marek podanych przez użytkownika.
     *
     * @param brands Lista marek samochodów.
     * @return Odpowiedź z potwierdzeniem.
     */
    @GetMapping("/update")
    public ResponseEntity<String> updateProducersAndFetchCars(@RequestParam List<String> brands) {
        carService.updateProducersAndFetchCars(brands);
        return ResponseEntity.ok("Producers updated and car data fetched for the last 10 years for brands: " + brands);
    }
}


