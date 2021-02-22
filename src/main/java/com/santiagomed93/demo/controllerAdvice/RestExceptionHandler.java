package com.santiagomed93.demo.controllerAdvice;

import com.santiagomed93.demo.controllerAdvice.exceptionType.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public final ResponseEntity<ApiError> handleUserExistsException(BadRequestException ex){
        ApiError apiError = new ApiError();
        apiError.setStatus(HttpStatus.BAD_REQUEST);
        apiError.setMessage(ex.getMessage());
        return new ResponseEntity<>(apiError,apiError.getStatus());
    }
}
