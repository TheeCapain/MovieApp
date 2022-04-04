package com.example.movieappbackend.config;

import com.example.movieappbackend.Entity.Movie;
import com.example.movieappbackend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class initData implements CommandLineRunner {

    @Autowired
    MovieService movieService;


    @Override
    public void run(String... args) throws Exception {
        Movie movie = new Movie();
        movie.setMovieTitle("Harry Potter");
        movie.setMoviePosterHref("https://static.posters.cz/image/750webp/105075.webp");
        movieService.saveMovie(movie);
    }
}
