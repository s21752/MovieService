package com.example.movieservice.movie.data.repository;

import com.example.movieservice.movie.data.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface MoviesRepository extends JpaRepository<Movie, Long> {

    @Override
    List<Movie> findAll();

    @Override
    Optional<Movie> findById(Long aLong);

    @Override
    void delete(Movie movie);

    @Override
    <S extends Movie> S saveAndFlush(S s);

    @Override
    void deleteById(Long aLong);

    @Modifying
    @Transactional
    @Query("update Movie m set m.isAvailable = TRUE where m.id = :id")
    void updateAvailability(@Param(value = "id") Long id);
}
