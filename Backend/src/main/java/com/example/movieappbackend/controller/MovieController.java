package com.example.movieappbackend.controller;

import com.example.movieappbackend.Entity.Movie;
import com.example.movieappbackend.component.MovieComponent;
import com.example.movieappbackend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public Optional<Movie> getSingleMovie(@PathVariable int id){
        return movieService.getSingleMovie(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public MovieComponent postMovie(@RequestBody Movie movie){
        return movieService.saveMovie(movie);
    }

}
