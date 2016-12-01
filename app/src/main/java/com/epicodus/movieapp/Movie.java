package com.epicodus.movieapp;

/**
 * Created by Guest on 12/1/16.
 */
public class Movie {
    String title;
    String poster;
    String synopsis;
    String director;
    //maybe get id later and create a new query
    public Movie(String title, String poster, String synopsis){
        this.title = title;
        this.poster = poster;
        this.synopsis = synopsis;
    }

    public String getTitle() {
        return title;
    }

    public String getPoster() {
        return poster;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getDirector() {
        return director;
    }
}
