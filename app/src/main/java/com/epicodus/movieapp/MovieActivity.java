package com.epicodus.movieapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MovieActivity extends AppCompatActivity {
    public static final String TAG = MovieActivity.class.getSimpleName();
    ArrayList<Movie> mMovies = new ArrayList<>();

    //, String date, String rating
    private void getMovies(String title) {
        final MovieService movieService = new MovieService();

        //date, rating,
        movieService.findMovies(title,  new Callback()
        {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                    mMovies = movieService.processResults(response);
                    MovieActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            String[] moviesArray = new String[mMovies.size()];
                            for(int i =0;i<moviesArray.length;i++){
                                moviesArray[i] = mMovies.get(i).getTitle();
                                moviesArray[i] = mMovies.get(i).getPoster();
                                moviesArray[i] = mMovies.get(i).getSynopsis();
                            }
                        }
                    });
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        getMovies("Harry");
    }
}
