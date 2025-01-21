package com.example.Model.Repositories;

public interface ICatalogData {
    ProducerRepository getProducerRepository();
    CarModelRepository getCarModelRepository();
    CarClassRepository getCarClassRepository();
    FuelTypeRepository getFuelTypeRepository();
    CarRepository getCarRepository();
}
