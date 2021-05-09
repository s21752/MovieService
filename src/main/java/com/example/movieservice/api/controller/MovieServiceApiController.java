package com.example.movieservice.api.controller;

import com.example.movieservice.movie.model.Movie;
import com.example.movieservice.movie.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        Movie movie = movieService.getMovieById(id);
        return ResponseEntity.ok(movie);
    }

    @PostMapping
    public ResponseEntity<Movie> createNewMovie(@RequestBody Movie newMovie) {
        Movie createdMovie = movieService.saveNewMovie(newMovie);
        return ResponseEntity.ok(createdMovie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie updatedMovie) {
        Movie correctlyUpdatedMovie = movieService.updateMovie(updatedMovie, id);
        return ResponseEntity.ok(correctlyUpdatedMovie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }
}
