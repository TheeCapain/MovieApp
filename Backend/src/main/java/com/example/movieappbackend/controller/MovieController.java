package com.example.movieappbackend.controller;

import com.example.movieappbackend.Entity.Movie;
import com.example.movieappbackend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/all-movies")
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }



}
