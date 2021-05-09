package com.example.movieservice.movie.model;

public class Movie {

    private String ID;
    private String name;
    private MovieType type;

    public Movie(String ID, String name, MovieType type) {
        this.ID = ID;
        this.name = name;
        this.type = type;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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
