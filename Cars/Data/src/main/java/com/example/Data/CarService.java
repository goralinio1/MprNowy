package com.example.Data;

import com.example.Model.Entities.*;
import com.example.Model.Repositories.ICatalogData;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CarService {

    private final CarApiService carApiService;
    private final ICatalogData catalogData;

    public CarService(CarApiService carApiService, ICatalogData catalogData) {
        this.carApiService = carApiService;
        this.catalogData = catalogData;
    }

    public void updateProducersAndFetchCars(List<String> brands) {
        for (String brandName : brands) {
            catalogData.getProducerRepository().findByName(brandName)
                    .orElseGet(() -> catalogData.getProducerRepository().save(new Producer(brandName)));
        }

        int currentYear = java.time.Year.now().getValue();

        for (String brandName : brands) {
            for (int year = currentYear - 10; year <= currentYear; year++) {
                List<Map<String, Object>> carDataList = carApiService.fetchCarDataByBrandAndYear(brandName, year);

                for (Map<String, Object> carData : carDataList) {
                    Producer producer = catalogData.getProducerRepository().findByName(brandName)
                            .orElseGet(() -> catalogData.getProducerRepository().save(new Producer(brandName)));

                    String modelName = (String) carData.get("model");
                    CarModel carModel = catalogData.getCarModelRepository().findByProducerId(producer.getId()).stream()
                            .filter(model -> model.getName().equalsIgnoreCase(modelName))
                            .findFirst()
                            .orElseGet(() -> catalogData.getCarModelRepository().save(new CarModel(modelName, producer)));

                    String carClassName = (String) carData.get("class");
                    CarClass carClass = catalogData.getCarClassRepository().findByName(carClassName)
                            .orElseGet(() -> catalogData.getCarClassRepository().save(new CarClass(carClassName)));

                    String fuelTypeName = (String) carData.get("fuel_type");
                    FuelType fuelType = catalogData.getFuelTypeRepository().findByName(fuelTypeName)
                            .orElseGet(() -> catalogData.getFuelTypeRepository().save(new FuelType(fuelTypeName)));

                    Car car = new Car(
                            (Integer) carData.get("year"),
                            (Integer) carData.get("cylinders"),
                            (String) carData.get("drive"),
                            (String) carData.get("transmission"),
                            carModel,
                            carClass,
                            fuelType
                    );

                    catalogData.getCarRepository().save(car);
                }
            }
        }
    }
}
