package ru.netology.javaqa.products;

public class Product {

    protected int id;
    protected String name;
    protected long price;

    protected Product(int id, String name, long price) {
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
