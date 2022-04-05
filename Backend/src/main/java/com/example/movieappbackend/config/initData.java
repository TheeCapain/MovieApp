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

        Movie movie1 = new Movie();
        movie1.setMovieTitle("Indiana Jones and the temple of Doom");
        movie1.setMoviePosterHref("https://image.posterlounge.dk/img/products/480000/477816/477816_poster_l.jpg");
        movieService.saveMovie(movie1);

        Movie movie2 = new Movie();
        movie2.setMovieTitle("Star Wars: The Last Jedi");
        movie2.setMoviePosterHref("https://static.posters.cz/image/750webp/97646.webp");
        movieService.saveMovie(movie2);

        Movie movie3 = new Movie();
        movie3.setMovieTitle("Tron Legacy");
        movie3.setMoviePosterHref("https://m.media-amazon.com/images/I/91ZueyN4XOL._AC_SY679_.jpg");
        movieService.saveMovie(movie3);

        Movie movie4 = new Movie();
        movie4.setMovieTitle("Kung fu panda 3");
        movie4.setMoviePosterHref("https://www.scope.dk/shared/11/954/china-film-kung-fu-panda-3-org.vers.-3-d_400x600c.jpg");
        movieService.saveMovie(movie4);
    }
}
