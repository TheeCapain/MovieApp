package com.example.movieappbackend.service;

import com.example.movieappbackend.Entity.Movie;
import com.example.movieappbackend.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public void saveMovie(Movie movie){
        movieRepository.save(movie);
    }
}
