package com.example.movieservice.movie.model;

public class Movie {

    private Long id;
    private String name;
    private MovieType type;

    public Movie() {
        this.id = 0L;
        this.name = "";
        this.type = null;
    }

    public Movie(Long id, String name, MovieType type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public Movie(String name, MovieType type) {
        this.id = null;
        this.name = name;
        this.type = type;
    }

    public Long getid() {
        return id;
    }

    public void setid(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MovieType getType() {
        return type;
    }

    public void setType(MovieType type) {
        this.type = type;
    }
}
