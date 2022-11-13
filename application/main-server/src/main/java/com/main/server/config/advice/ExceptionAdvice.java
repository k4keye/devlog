package com.main.server.config.advice;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity exceptionHandler(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity exceptionHandler(IllegalStateException e){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
    }
    @ExceptionHandler(IllegalAccessException.class)
    public ResponseEntity exceptionHandler(IllegalAccessException e){
        return ResponseEntity.status(HttpStatus.LOCKED).body(e.getMessage());
    }
}
