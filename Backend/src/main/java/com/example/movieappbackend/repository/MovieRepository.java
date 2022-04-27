package com.example.movieappbackend.repository;

import com.example.movieappbackend.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    List<Movie> findMovieByMovieTitleContaining(String movieTitle);
}
