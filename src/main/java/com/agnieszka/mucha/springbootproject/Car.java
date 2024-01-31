package com.agnieszka.mucha.springbootproject;


import jakarta.validation.constraints.NotNull;


public record Car(
        @NotNull
        long id,

        @NotNull
        String brand,

        @NotNull
        String model,

        @NotNull
        Color color) {

}
