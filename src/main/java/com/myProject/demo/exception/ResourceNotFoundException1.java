package com.myProject.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException1 extends Exception{

    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException1(String message){
        super(message);
    }
}