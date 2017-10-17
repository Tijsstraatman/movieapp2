package com.capgemini.movieapp2.controller;


import com.capgemini.movieapp2.model.Movie;
import com.capgemini.movieapp2.repository.RepositoryMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieController {

    @Autowired
    private RepositoryMovie repository;

    public MovieController() {
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addMovie")
    public Movie addMovie(@RequestBody Movie movie) {

        return repository.save(movie);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getMovieList")
    public List<Movie> getMovieList() {
        List<Movie> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }


}

