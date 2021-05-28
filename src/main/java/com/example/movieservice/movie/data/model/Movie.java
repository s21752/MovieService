package com.example.movieservice.movie.data.model;

import com.sun.istack.NotNull;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity()
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private MovieType type;

    @NonNull
    @Column(nullable = false, columnDefinition = "bit default false")
    private Boolean isAvailable = false;

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

    @NonNull
    public Boolean getAvailable() { return isAvailable; }

    public void setAvailable(@NonNull Boolean available) { isAvailable = available; }

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
