package com.example.movieservice.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieServiceApiController {

    @RequestMapping("/exception")
    public void exceptionMapping() {
        throw new IllegalArgumentException("Generic illegal argument provided (╯ ͠° ͟ʖ ͡°)╯┻━┻");
    }
}
