package com.capgemini.movieapp2.model;


import javax.persistence.Entity;


@Entity
public class Movie {

    private String title;
    private String rating;
    private Boolean watched;

    public Movie() {
    }

    public Movie(String title, String rating, Boolean watched) {
        this.title = title;
        this.rating = rating;
        this.watched = watched;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Boolean getWatched() {
        return watched;
    }

    public void setWatched(Boolean watched) {
        this.watched = watched;
    }


}

