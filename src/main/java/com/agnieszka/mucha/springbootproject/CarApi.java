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
            MediaType.APPLICATION_XML_VALUE
    })
    public List<Car> getCarList() {
        return carList;
    }

    @PostMapping
    public ResponseEntity<Car>  addCar(@Validated @RequestBody Car car) {
         carList.add(car);
         return new ResponseEntity<>(car, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable long id) {
        Car carById = CarService.getCarById(id, carList);
        if (carById == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(carById, HttpStatus.OK);
    }

    @GetMapping("/color/{color}")
    public ResponseEntity<List<Car>> getCarByColor(@PathVariable Color color) {
        List<Car> carByColor = CarService.getCarsByColor(color, carList);
        if (carByColor.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(carByColor, HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity deleteCar(@RequestParam long id) {
        Car carById = CarService.getCarById(id, carList);
        if (carById == null) return new ResponseEntity(HttpStatus.NOT_FOUND);

        carList.remove(carById);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PutMapping()
    public ResponseEntity modCar(@RequestBody Car car) {
        Car carById = CarService.getCarById(car.id(), carList);
        if (carById == null) return new ResponseEntity(HttpStatus.NOT_FOUND);

        carList.remove(carById);
        carList.add(car);
        return new ResponseEntity<>(HttpStatus.OK);

    }


}
