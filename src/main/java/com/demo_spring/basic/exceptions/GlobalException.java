package com.demo_spring.basic.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
    
    @ExceptionHandler(value = IllegalStateException.class)
    ResponseEntity<String> hadlingBadRequestException(IllegalStateException exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    ResponseEntity<String> hadlingServer500Exception(IllegalArgumentException exception){
        return ResponseEntity.internalServerError().body(exception.getMessage());
    }
}
