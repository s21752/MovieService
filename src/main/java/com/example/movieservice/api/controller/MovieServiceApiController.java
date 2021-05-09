package com.example.movieservice.api.controller;

import com.example.movieservice.movie.model.Movie;
import com.example.movieservice.movie.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieServiceApiController {

    MovieService movieService;

    public MovieServiceApiController(MovieService service) {
        this.movieService = service;
    }

    @RequestMapping("/exception")
    public void exceptionMapping() {
        throw new IllegalArgumentException("Generic illegal argument provided (╯ ͠° ͟ʖ ͡°)╯┻━┻");
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }
}
