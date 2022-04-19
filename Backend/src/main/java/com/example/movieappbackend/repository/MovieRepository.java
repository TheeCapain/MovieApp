package com.example.movieappbackend.repository;

import com.example.movieappbackend.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
