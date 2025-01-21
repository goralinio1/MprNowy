package com.example.Service;

import com.example.Model.Entities.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarRestController {

    private final CarRestService carRestService;

    public CarRestController(CarRestService carRestService) {
        this.carRestService = carRestService;
    }


    @GetMapping("/producers")
    public List<Producer> getAllProducers() {
        return carRestService.getAllProducers();
    }

    @GetMapping("/producers/{id}")
    public Producer getProducerById(@PathVariable Long id) {
        return carRestService.getProducerById(id);
    }

    @PostMapping("/producers")
    public Producer createProducer(@RequestBody Producer producer) {
        return carRestService.saveProducer(producer);
    }

    @DeleteMapping("/producers/{id}")
    public ResponseEntity<Void> deleteProducer(@PathVariable Long id) {
        carRestService.deleteProducer(id);
        return ResponseEntity.noContent().build();
    }

    // CarModel endpoints
    @GetMapping("/models")
    public List<CarModel> getAllCarModels() {
        return carRestService.getAllCarModels();
    }

    @GetMapping("/models/{id}")
    public CarModel getCarModelById(@PathVariable Long id) {
        return carRestService.getCarModelById(id);
    }

    @PostMapping("/models")
    public CarModel createCarModel(@RequestBody CarModel carModel) {
        return carRestService.saveCarModel(carModel);
    }

    @DeleteMapping("/models/{id}")
    public ResponseEntity<Void> deleteCarModel(@PathVariable Long id) {
        carRestService.deleteCarModel(id);
        return ResponseEntity.noContent().build();
    }

    // CarClass endpoints
    @GetMapping("/classes")
    public List<CarClass> getAllCarClasses() {
        return carRestService.getAllCarClasses();
    }

    @GetMapping("/classes/{id}")
    public CarClass getCarClassById(@PathVariable Long id) {
        return carRestService.getCarClassById(id);
    }

    @PostMapping("/classes")
    public CarClass createCarClass(@RequestBody CarClass carClass) {
        return carRestService.saveCarClass(carClass);
    }

    @DeleteMapping("/classes/{id}")
    public ResponseEntity<Void> deleteCarClass(@PathVariable Long id) {
        carRestService.deleteCarClass(id);
        return ResponseEntity.noContent().build();
    }

    // FuelType endpoints
    @GetMapping("/fueltypes")
    public List<FuelType> getAllFuelTypes() {
        return carRestService.getAllFuelTypes();
    }

    @GetMapping("/fueltypes/{id}")
    public FuelType getFuelTypeById(@PathVariable Long id) {
        return carRestService.getFuelTypeById(id);
    }

    @PostMapping("/fueltypes")
    public FuelType createFuelType(@RequestBody FuelType fuelType) {
        return carRestService.saveFuelType(fuelType);
    }

    @DeleteMapping("/fueltypes/{id}")
    public ResponseEntity<Void> deleteFuelType(@PathVariable Long id) {
        carRestService.deleteFuelType(id);
        return ResponseEntity.noContent().build();
    }

    // Car endpoints
    @GetMapping("/cars")
    public List<Car> getAllCars() {
        return carRestService.getAllCars();
    }

    @GetMapping("/cars/{id}")
    public Car getCarById(@PathVariable Long id) {
        return carRestService.getCarById(id);
    }

    @PostMapping("/cars")
    public Car createCar(@RequestBody Car car) {
        return carRestService.saveCar(car);
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carRestService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }
}
