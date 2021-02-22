package com.santiagomed93.demo.controllerAdvice.exceptionType;

public class BadRequestException extends Exception{
    public BadRequestException(String errorMessage){
        super(errorMessage);
    }
}
