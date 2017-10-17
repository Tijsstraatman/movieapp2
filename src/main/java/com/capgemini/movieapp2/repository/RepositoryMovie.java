package com.capgemini.movieapp2.repository;

import com.capgemini.movieapp2.model.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepositoryMovie extends CrudRepository<Movie,Integer> {

    List<Movie> findOneByTitle(String title);
}
