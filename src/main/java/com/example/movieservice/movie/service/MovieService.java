package com.example.movieservice.movie.service;

import com.example.movieservice.movie.data.model.Movie;
import com.example.movieservice.movie.data.repository.MoviesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MovieService {

    private final MoviesRepository movieRepository;

    public MovieService(MoviesRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    private Optional<Movie> movieOptional(Movie movieToCheck) {
        return (movieRepository.findAll().stream().filter((Movie foundMovie) ->
                foundMovie.getType() == movieToCheck.getType()
                        && foundMovie.getName().equals(movieToCheck.getName()))).findFirst();
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id) {
        Optional<Movie> foundMovieOptional;
        if ((foundMovieOptional = movieRepository.findById(id)).isPresent())
            return foundMovieOptional.get();
        else
            throw new NoSuchElementException("No movie found for id: " + id);
    }

    public Movie setAvailable(Movie movie) {
        Optional<Movie> existingMovie;
        if ((existingMovie = movieOptional(movie)).isPresent()) {
            return makeAvailable(existingMovie.get());
        } else {
            throw new IllegalArgumentException("No such movie in the database yet");
        }
    }

    public Movie setAvailable(Long id) {
        Optional<Movie> existingMovie;
        if ((existingMovie = movieRepository.findById(id)).isEmpty())
            throw new IllegalArgumentException("No movie found for id: " + id);
        else {
            return makeAvailable(existingMovie.get());
        }
    }

    private Movie makeAvailable(Movie movie) {
        movieRepository.updateAvailability(movie.getid());
        movie.setAvailable(true);
        return movie;
    }

    public Movie saveNewMovie(Movie newMovie) {
        if (movieOptional(newMovie).isPresent())
            throw new IllegalArgumentException("Same movie is already present in the database");
        else {
            newMovie.setid((long) movieRepository.findAll().size() + 1);
            movieRepository.saveAndFlush(newMovie);
            return newMovie;
        }
    }

    public Movie updateMovie(Movie updatedMovie, Long idToUpdate) {
        Optional<Movie> existingMovie;
        if ((existingMovie = movieRepository.findById(idToUpdate)).isEmpty())
            throw new IllegalArgumentException("No movie found for id: " + idToUpdate);
        else {
            updatedMovie.setid(idToUpdate);
            movieRepository.delete(existingMovie.get());
            movieRepository.saveAndFlush(updatedMovie);
            return updatedMovie;
        }
    }

    public void deleteMovie(Long idToDelete) {
        if ((movieRepository.findById(idToDelete)).isEmpty())
            throw new NoSuchElementException("No element for this id found");
        else {
            movieRepository.deleteById(idToDelete);
        }
    }
}
