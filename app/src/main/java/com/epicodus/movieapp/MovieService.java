package com.epicodus.movieapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;


import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Guest on 12/1/16.
 */
public class MovieService {

    //String rating, String date,
    public static void findMovies(String title, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder().build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.MOVIE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.MOVIE_TITLE, title);
        urlBuilder.addQueryParameter(Constants.MOVIE_QUERY, title);
//        urlBuilder.addQueryParameter(Constants.MOVIE_RATING, rating);
//        urlBuilder.addQueryParameter(Constants.MOVIE_RELEASE_DATE, date);
        urlBuilder.addQueryParameter(Constants.API_KEY_QUERY_PARAMETER, Constants.MOVIE_KEY);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder().url(url).build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Movie> processResults(Response response) {
        ArrayList<Movie> movies = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject databaseJSON = new JSONObject(jsonData);
                JSONArray resultsJSON = databaseJSON.getJSONArray("results");
                for (int i = 0; i < resultsJSON.length(); i++) {
                    JSONObject movieJSON = resultsJSON.getJSONObject(i);
                    String title = movieJSON.getString("title");
                    String poster = movieJSON.getString("poster_path");
                    String synopsis = movieJSON.getString("overview");

                    Movie movie = new Movie(title, poster, synopsis);
                    movies.add(movie);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();

        }
        return movies;
    }
}
