package com.springboot.service;

public class EmailAlreadyExist extends Exception{
    public EmailAlreadyExist(String message) {
        super(message);
    }
}
