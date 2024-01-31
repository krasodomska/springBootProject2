package com.agnieszka.mucha.springbootproject;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;


public record Car(
        long id,
        @NotNull
        String brand,
        @NotNull
        String model,
        @NotNull
        String color) {

}
