package com.example.movieappbackend.service;

import com.example.movieappbackend.Entity.Movie;
import com.example.movieappbackend.exception.ResourceNotFoundException;
import com.example.movieappbackend.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getSingleMovie(int id) {
        return movieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Movie not found"));
    }

    public Movie saveMovie(Movie movie) {
        movieRepository.save(movie);
        return movie;
    }

    public List<Movie> findMovieByTitle(String movieTitle){
        return movieRepository.findMovieByMovieTitleContaining(movieTitle);
    }

}
