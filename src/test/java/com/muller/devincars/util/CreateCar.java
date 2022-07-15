package com.muller.devincars.util;

import com.muller.devincars.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CreateCar {

    public static Car carValid() {
        Car car = new Car();
        car.setAno(2020);
        car.setFabricante("Ford");
        car.setModelo("Ranger");
        return car;
    }

    public static List<Car> createListCar() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(1L, "Chevrolet", "Onix", 2020));
        carList.add(new Car(2L, "Kia", "Sportage", 2021));
        carList.add(new Car(3L, "Tesla", "Model S", 2022));
        return carList;
    }
}
