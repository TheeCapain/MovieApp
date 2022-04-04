package com.example.movieappbackend.config;

import com.example.movieappbackend.Entity.Movie;
import com.example.movieappbackend.Entity.MovieGroup;
import com.example.movieappbackend.Entity.Netflix;
import com.example.movieappbackend.component.MovieComponent;

public class Main {

    public static void main(String[] args) {
        MovieComponent adventureComponent = new MovieGroup("Adventure", "A fun trip");
        MovieComponent horrorComponent = new MovieGroup("Horror", "A scary trip");
        MovieComponent fantasyComponent = new MovieGroup("Fantasy", "a subgenre of Adventure");
        MovieComponent allMovies = new MovieGroup("Movies", "Every single movie");

        allMovies.add(adventureComponent);
        adventureComponent.add(new Movie("Pirates of Danmark", "Wild danes being pirates"));
        adventureComponent.add(new Movie("Avatar", "Blue people vs humans, who will win?"));

        adventureComponent.add(fantasyComponent);
        fantasyComponent.add(new Movie("Harry Potter", "Yer a wizard Harry"));
        fantasyComponent.add(new Movie("Harry Potter 2", "Yer a hairy wizard"));

        allMovies.add(horrorComponent);
        horrorComponent.add(new Movie("Scream", "Its loud"));
        horrorComponent.add(new Movie("Ice age","Its melting"));

        Netflix netflix = new Netflix(allMovies);
        netflix.getMovieList();

    }
}
