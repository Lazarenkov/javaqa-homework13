package ru.netology.javaqa.products;

public class Product {

    int id;
    String name;
    long price;

    public Product(int id, String name, long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
