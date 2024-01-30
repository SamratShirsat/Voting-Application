package com.springboot.exceptions;

public class EmailAlreadyExist extends Exception{

    public EmailAlreadyExist(String errorMessage){
        super(errorMessage);
    }
}
