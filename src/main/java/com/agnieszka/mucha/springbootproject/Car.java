package com.agnieszka.mucha.springbootproject;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;


public record Car(
        @NotNull
        @Min(0)
        @Max(100)
        long id,

        @NotNull
        String brand,

        @NotNull
        String model,

        @NotNull
        Color color) {

}
