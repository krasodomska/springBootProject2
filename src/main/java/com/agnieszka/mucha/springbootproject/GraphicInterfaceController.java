package com.agnieszka.mucha.springbootproject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/cars")
@Controller
public class GraphicInterfaceController {
    List carList;
    List serchByIdCarList;


    public GraphicInterfaceController() {
        this.serchByIdCarList = new ArrayList<>();
        this.carList = new ArrayList<>();
        carList.add(new Car(1, "Skoda", "Fabia", Color.RED));
        carList.add(new Car(2, "Audi", "A4", Color.GREEN));
        carList.add(new Car(3, "Seat", "Leon", Color.BLUE));



    }

    @GetMapping
    public String getCarList(Model model) {
        model.addAttribute("cars", carList);
        model.addAttribute("newCar", new CarBuilder());
        model.addAttribute("carByID", serchByIdCarList);
        return "cars";
    }

    @PostMapping("/form")
    public String addCar(@ModelAttribute CarBuilder car) {
        carList.add(car.build());

        return "redirect:/cars";
    }

    @GetMapping("/delete")
    public String deleterCar(@ModelAttribute CarBuilder car) {
        Car carById = CarService.getCarById(car.getId(), carList);
        if (carById == null) return "carNotFound";

        carList.remove(carById);
        return "redirect:/cars";
    }

    @PostMapping("/getById")
    public String getCarByID(@ModelAttribute CarBuilder car) {
        Car carById = CarService.getCarById(car.getId(), carList);
        if (carById == null) return "carNotFound";

        serchByIdCarList.add(carById);
        return "redirect:/cars";
    }

    @PostMapping("/edit")
    public String modCar(@ModelAttribute CarBuilder car) {
        Car carById = CarService.getCarById(car.getId(), carList);
        if (carById == null) return "carNotFound";

        carList.remove(carById);
        carList.add(car.build());
        return "redirect:/cars";

    }
}
