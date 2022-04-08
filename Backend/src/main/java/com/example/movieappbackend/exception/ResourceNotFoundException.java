package com.example.movieappbackend.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;


public class ResourceNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public ResourceNotFoundException(String message){
        super(message);
    }

}
