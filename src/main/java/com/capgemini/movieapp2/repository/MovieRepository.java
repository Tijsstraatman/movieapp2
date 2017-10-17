package com.capgemini.movieapp2.repository;

import com.capgemini.movieapp2.model.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository {

    Movie findByOneTitle(String title);
}
