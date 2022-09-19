package ru.netology.javaqa.products;

public class Smartphone extends Product {

    private String model;
    private String manufacturer;

    public Smartphone(int id, String name, long price, String model, String manufacturer) {
        super(id, name, price);
        this.model = model;
        this.manufacturer = manufacturer;
    }
}
