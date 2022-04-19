package com.example.movieappbackend.controller;

import com.example.movieappbackend.Entity.Movie;
import com.example.movieappbackend.component.MovieComponent;
import com.example.movieappbackend.repository.MovieRepository;
import com.example.movieappbackend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @Autowired
    MovieRepository movieRepository;

    private Sort.Direction getSortDirection(String direction) {
        if (direction.equals("desc")) {
            return Sort.Direction.DESC;
        } else {
            return Sort.DEFAULT_DIRECTION;
        }
    }

    @GetMapping("/moviesort")
    public ResponseEntity<List<Movie>> getPageOfMovies(@RequestParam(defaultValue = "movieTitle,asc") String[] sort) {
        for (String s : sort) {
            System.out.println(s);
        }
        List<Sort.Order> orders = new ArrayList<>();

        if (sort[0].contains(",")) {
            for (String sortOrder : sort) {
                String[] _sort = sortOrder.split(",");
                orders.add(new Sort.Order(getSortDirection(_sort[1]), _sort[0]));
            }
        } else {
            orders.add(new Sort.Order(getSortDirection(sort[1]), sort[0]));
        }

        List<Movie> movies = movieRepository.findAll(Sort.by(orders));

        if (movies.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/all-movies")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public Movie getSingleMovie(@PathVariable int id) {
        return movieService.getSingleMovie(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public MovieComponent postMovie(@RequestBody Movie movie) {
        return movieService.saveMovie(movie);
    }
}
