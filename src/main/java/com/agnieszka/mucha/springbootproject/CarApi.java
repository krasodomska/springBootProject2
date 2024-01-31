package com.agnieszka.mucha.springbootproject;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("api/cars")
public class CarApi {
    List<Car> carList;

    public CarApi() {
        this.carList = new ArrayList<>();
        carList.add(new Car(1, "Skoda", "Fabia", Color.RED));
        carList.add(new Car(2, "Audi", "A4", Color.GREEN));
        carList.add(new Car(3, "Seat", "Leon", Color.BLUE));

    }

    @GetMapping(produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public List<Car> getCarList() {
        return carList;
    }

    @PostMapping
    public boolean addCar(@Validated @RequestBody Car car) {
        return carList.add(car);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable long id) {
        Car carById = CarController.getCarById(id, carList);
        if (carById != null) return new ResponseEntity<>(carById, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/color/{color}")
    public ResponseEntity<List<Car>> getCarByColor(@PathVariable Color color) {
        List<Car> carByColor = CarController.getCarsByColor(color, carList);
        if (!carByColor.isEmpty()) return new ResponseEntity<>(carByColor, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping()
    public ResponseEntity deleteCar(@RequestParam long id) {
        Car carById = CarController.getCarById(id, carList);
        if (carById != null) {
            carList.remove(carById);
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PutMapping()
    public ResponseEntity modCar(@RequestBody Car car) {
        Car carById = CarController.getCarById(car.id(), carList);
        if (carById != null) {
            carList.remove(carById);
            carList.add(car);
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity(HttpStatus.NOT_FOUND);
    }


}
