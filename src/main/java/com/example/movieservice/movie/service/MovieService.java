package com.example.movieservice.movie.service;

import com.example.movieservice.movie.model.Movie;
import com.example.movieservice.movie.model.MovieType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private static ArrayList<Movie> movies = new ArrayList<Movie>();

    static {
        movies.add(new Movie(1, "Movie 1", MovieType.COMEDY));
        movies.add(new Movie(2, "Movie 2", MovieType.HISTORIC));
        movies.add(new Movie(3, "Movie 3", MovieType.HORROR));
    }

    public MovieService() {}

    public List<Movie> getAllMovies() {
        return movies;
    }

    public Movie getMovieById(int id) {
        Optional<Movie> foundMovieOptional;
        if ((foundMovieOptional = movies.stream().filter((Movie movie) -> movie.getid() == id).findFirst()).isPresent())
            return foundMovieOptional.get();
        else
            throw new NoSuchElementException("No movie found for id: " + id);
    }
}
