package com.example.movieservice.api.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ApiExceptionHandlers {

    @ExceptionHandler(value = {IllegalArgumentException.class})
    public ResponseEntity<String> illegalArgumentExceptionHandler(IllegalArgumentException e, WebRequest req) {
        return ResponseEntity.badRequest().body("Exception occured on request. Exception message: " + e.getMessage());
    }

    @ExceptionHandler(value = {NoSuchElementException.class})
    public ResponseEntity<String> noElementException(NoSuchElementException e, WebRequest req) {
        return ResponseEntity.badRequest().body("Exception occured on request. Exception message: " + e.getMessage());
    }
}
