package com.example.movieservice.movie.model;

public class Movie {

    private int id;
    private String name;
    private MovieType type;

    public Movie(int id, String name, MovieType type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
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
