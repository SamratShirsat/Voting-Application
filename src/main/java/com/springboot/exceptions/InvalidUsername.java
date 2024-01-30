package com.springboot.exceptions;

public class InvalidUsername extends Exception {
    public InvalidUsername(String ErrorMessage){
        super(ErrorMessage);
    }
}
