package com.agnieszka.mucha.springbootproject;


import java.util.List;
import java.util.stream.Collectors;


public class CarService {
    public static Car getCarById(long id, List<Car> carList) {
        return carList.stream()
                .filter(car -> car.id() == id)
                .findAny()
                .orElse(null);
    }

    public static List<Car> getCarsByColor(Color color, List<Car> carList) {
        return carList.stream()
                .filter(car -> car.color().equals(color))
                .collect(Collectors.toList());
    }


}
