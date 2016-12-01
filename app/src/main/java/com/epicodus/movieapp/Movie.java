package com.epicodus.movieapp;

import android.util.Log;

/**
 * Created by Guest on 12/1/16.
 */
public class Movie {
    String mTitle;
    String mPoster;
    String mSynopsis;
    String mDirector;
    //maybe get id later and create a new query
    public Movie(String title, String poster, String synopsis){
        this.mTitle = title;
        this.mPoster = poster;
        this.mSynopsis = synopsis;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getPoster() {
        String url = "http://image.tmdb.org/t/p/w500" +mPoster;
        return url;
    }

    public String getSynopsis() {
        return mSynopsis;
    }

    public String getDirector() {
        return mDirector;
    }
}
