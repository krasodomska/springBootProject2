package com.agnieszka.mucha.springbootproject;

public class CarBuilder {
    private String brand;
    private String model;
    private int id;
    private Color color;

    public CarBuilder() {
        brand = "brand";
        model = "model";
        color = Color.DEFAULT;
    }

    public Car build() {
        return new Car(id, brand, model, color);
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getId() {
        return id;
    }

    public Color getColor() {
        return color;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
