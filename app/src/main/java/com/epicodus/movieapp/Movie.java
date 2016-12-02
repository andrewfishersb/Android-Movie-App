package com.epicodus.movieapp;
import org.parceler.Parcel;
import android.util.Log;

/**
 * Created by Guest on 12/1/16.
 */
@Parcel
public class Movie {
    String mTitle;
    String mPoster;
    String mSynopsis;
    String mReleaseDate;
    String mRating;

    public Movie() {
    }



    public Movie(String title, String poster, String synopsis, String releaseDate, String rating){
        this.mTitle = title;
        this.mPoster = poster;
        this.mSynopsis = synopsis;
        this.mReleaseDate = releaseDate;
        this.mRating = rating;

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

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public String getRating() {
        return mRating;
    }

}
