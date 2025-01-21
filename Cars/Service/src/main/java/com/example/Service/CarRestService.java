package com.example.Service;

import com.example.Model.Entities.*;
import com.example.Model.Repositories.ICatalogData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarRestService {

	private final ICatalogData catalogData;

	public CarRestService(ICatalogData catalogData) {
		this.catalogData = catalogData;
	}

	// Producer methods
	public List<Producer> getAllProducers() {
		return catalogData.getProducerRepository().findAll();
	}

	public Producer getProducerById(Long id) {
		return catalogData.getProducerRepository().findById(id)
				.orElseThrow(() -> new RuntimeException("Producer not found with id: " + id));
	}

	public Producer saveProducer(Producer producer) {
		return catalogData.getProducerRepository().save(producer);
	}

	public void deleteProducer(Long id) {
		if (catalogData.getProducerRepository().existsById(id)) {
			catalogData.getProducerRepository().deleteById(id);
		} else {
			throw new RuntimeException("Producer not found with id: " + id);
		}
	}

	// CarModel methods
	public List<CarModel> getAllCarModels() {
		return catalogData.getCarModelRepository().findAll();
	}

	public CarModel getCarModelById(Long id) {
		return catalogData.getCarModelRepository().findById(id)
				.orElseThrow(() -> new RuntimeException("CarModel not found with id: " + id));
	}

	public CarModel saveCarModel(CarModel carModel) {
		return catalogData.getCarModelRepository().save(carModel);
	}

	public void deleteCarModel(Long id) {
		if (catalogData.getCarModelRepository().existsById(id)) {
			catalogData.getCarModelRepository().deleteById(id);
		} else {
			throw new RuntimeException("CarModel not found with id: " + id);
		}
	}

	// CarClass methods
	public List<CarClass> getAllCarClasses() {
		return catalogData.getCarClassRepository().findAll();
	}

	public CarClass getCarClassById(Long id) {
		return catalogData.getCarClassRepository().findById(id)
				.orElseThrow(() -> new RuntimeException("CarClass not found with id: " + id));
	}

	public CarClass saveCarClass(CarClass carClass) {
		return catalogData.getCarClassRepository().save(carClass);
	}

	public void deleteCarClass(Long id) {
		if (catalogData.getCarClassRepository().existsById(id)) {
			catalogData.getCarClassRepository().deleteById(id);
		} else {
			throw new RuntimeException("CarClass not found with id: " + id);
		}
	}

	// FuelType methods
	public List<FuelType> getAllFuelTypes() {
		return catalogData.getFuelTypeRepository().findAll();
	}

	public FuelType getFuelTypeById(Long id) {
		return catalogData.getFuelTypeRepository().findById(id)
				.orElseThrow(() -> new RuntimeException("FuelType not found with id: " + id));
	}

	public FuelType saveFuelType(FuelType fuelType) {
		return catalogData.getFuelTypeRepository().save(fuelType);
	}

	public void deleteFuelType(Long id) {
		if (catalogData.getFuelTypeRepository().existsById(id)) {
			catalogData.getFuelTypeRepository().deleteById(id);
		} else {
			throw new RuntimeException("FuelType not found with id: " + id);
		}
	}

	// Car methods
	public List<Car> getAllCars() {
		return catalogData.getCarRepository().findAll();
	}

	public Car getCarById(Long id) {
		return catalogData.getCarRepository().findById(id)
				.orElseThrow(() -> new RuntimeException("Car not found with id: " + id));
	}

	public Car saveCar(Car car) {
		return catalogData.getCarRepository().save(car);
	}

	public void deleteCar(Long id) {
		if (catalogData.getCarRepository().existsById(id)) {
			catalogData.getCarRepository().deleteById(id);
		} else {
			throw new RuntimeException("Car not found with id: " + id);
		}
	}
}
