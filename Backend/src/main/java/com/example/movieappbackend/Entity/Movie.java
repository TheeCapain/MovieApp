package com.example.movieappbackend.Entity;

import com.example.movieappbackend.component.MovieComponent;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;
    @NotNull
    private String movieTitle;
    private String movieDescription;
    private int movieLength;
    @Column(length = 999)
    private String moviePosterHref;


    public void displayMovieInfo(){
        System.out.println(movieTitle + " " + movieDescription);
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getName() {
        return this.movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public int getMovieLength() {
        return movieLength;
    }

    public void setMovieLength(int movieLength) {
        this.movieLength = movieLength;
    }

    public String getMoviePosterHref() {
        return moviePosterHref;
    }

    public void setMoviePosterHref(String moviePosterHref) {
        this.moviePosterHref = moviePosterHref;
    }


}
