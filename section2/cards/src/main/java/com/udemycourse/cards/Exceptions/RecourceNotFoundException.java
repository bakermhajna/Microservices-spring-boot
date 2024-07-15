package com.udemycourse.cards.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecourceNotFoundException extends RuntimeException{

    public RecourceNotFoundException(String msg) {
        super(msg);
    }
}
