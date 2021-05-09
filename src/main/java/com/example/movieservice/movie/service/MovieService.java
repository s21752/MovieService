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
        movies.add(new Movie(1L, "Movie 1", MovieType.COMEDY));
        movies.add(new Movie(2L, "Movie 2", MovieType.HISTORIC));
        movies.add(new Movie(3L, "Movie 3", MovieType.HORROR));
    }

    public MovieService() {
    }

    public List<Movie> getAllMovies() {
        return movies;
    }

    public Movie getMovieById(Long id) {
        Optional<Movie> foundMovieOptional;
        if ((foundMovieOptional = movies.stream().filter((Movie movie) -> movie.getid().equals(id)).findFirst()).isPresent())
            return foundMovieOptional.get();
        else
            throw new NoSuchElementException("No movie found for id: " + id);
    }

    public Movie saveNewMovie(Movie newMovie) {
        if ((movies.stream().anyMatch((Movie movie) -> movie.getType() == newMovie.getType() && movie.getName().equals(newMovie.getName()))))
            throw new IllegalArgumentException("Same movie is already present in the database");
        else {
            newMovie.setid((long) movies.size() + 1);
            movies.add(newMovie);
            return newMovie;
        }
    }

    public Movie updateMovie(Movie updatedMovie, Long idToUpdate) {
        Optional<Movie> existingMovie;
        if ((existingMovie = movies.stream().filter((Movie movie) -> movie.getid().equals(idToUpdate)).findFirst()).isEmpty())
            throw new IllegalArgumentException("No movie found for id: " + idToUpdate);
        else {
            updatedMovie.setid(idToUpdate);
            movies.remove(existingMovie.get());
            movies.add(updatedMovie);
            return  updatedMovie;
        }
    }

    public void deleteMovie(Long idToDelete) {
        Optional<Movie> existingMovie;
        if ((existingMovie = movies.stream().filter((Movie movie) -> movie.getid().equals(idToDelete)).findFirst()).isEmpty())
            throw new NoSuchElementException("No element for this id found");
        else {
            movies.remove(existingMovie.get());
        }
    }
}
