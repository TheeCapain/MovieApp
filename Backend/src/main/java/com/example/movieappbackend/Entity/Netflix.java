package com.example.movieappbackend.Entity;

import com.example.movieappbackend.component.MovieComponent;

public class Netflix {
    MovieComponent movieList;

    public Netflix(MovieComponent movieList){
        this.movieList = movieList;
    }

    public void getMovieList(){
        movieList.displayMovieInfo();
    }
}
