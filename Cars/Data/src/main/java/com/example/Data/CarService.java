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

    /**
     * Aktualizuje producentów i pobiera dane samochodów z ostatnich 10 lat
     * na podstawie listy marek podanych przez użytkownika.
     *
     * @param brands Lista marek samochodów (np. ["Toyota", "BMW"]).
     */
    public void updateProducersAndFetchCars(List<String> brands) {
        // Zapisz producentów w bazie danych
        for (String brandName : brands) {
            catalogData.getProducerRepository().findByName(brandName)
                    .orElseGet(() -> catalogData.getProducerRepository().save(new Producer(brandName)));
        }

        // Pobierz aktualny rok
        int currentYear = java.time.Year.now().getValue();

        // Pobierz dane samochodów dla każdej marki z ostatnich 10 lat
        for (String brandName : brands) {
            for (int year = currentYear - 10; year <= currentYear; year++) {
                List<Map<String, Object>> carDataList = carApiService.fetchCarDataByBrandAndYear(brandName, year);

                for (Map<String, Object> carData : carDataList) {
                    // Pobierz lub utwórz producenta
                    Producer producer = catalogData.getProducerRepository().findByName(brandName)
                            .orElseGet(() -> catalogData.getProducerRepository().save(new Producer(brandName)));

                    // Pobierz lub utwórz model samochodu
                    String modelName = (String) carData.get("model");
                    CarModel carModel = catalogData.getCarModelRepository().findByProducerId(producer.getId()).stream()
                            .filter(model -> model.getName().equalsIgnoreCase(modelName))
                            .findFirst()
                            .orElseGet(() -> catalogData.getCarModelRepository().save(new CarModel(modelName, producer)));

                    // Pobierz lub utwórz klasę samochodu
                    String carClassName = (String) carData.get("class");
                    CarClass carClass = catalogData.getCarClassRepository().findByName(carClassName)
                            .orElseGet(() -> catalogData.getCarClassRepository().save(new CarClass(carClassName)));

                    // Pobierz lub utwórz rodzaj paliwa
                    String fuelTypeName = (String) carData.get("fuel_type");
                    FuelType fuelType = catalogData.getFuelTypeRepository().findByName(fuelTypeName)
                            .orElseGet(() -> catalogData.getFuelTypeRepository().save(new FuelType(fuelTypeName)));

                    // Utwórz i zapisz samochód
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
