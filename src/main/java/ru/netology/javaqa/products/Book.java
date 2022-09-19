package ru.netology.javaqa.products;

public class Book extends Product {

    private String title;
    private String author;

    public Book(int id, String name, long price, String title, String author) {
        super(id, name, price);
        this.title = title;
        this.author = author;
    }
}
