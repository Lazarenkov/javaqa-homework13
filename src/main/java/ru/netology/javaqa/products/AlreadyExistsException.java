package ru.netology.javaqa.products;

public class AlreadyExistsException extends RuntimeException{

    public AlreadyExistsException(String msg){
        super(msg);
    }
}
