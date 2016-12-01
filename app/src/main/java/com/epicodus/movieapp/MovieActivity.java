package com.epicodus.movieapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MovieActivity extends AppCompatActivity {
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    private MovieListAdapter mAdapter;

    ArrayList<Movie> mMovies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        ButterKnife.bind(this);
        getMovies("car");
    }
    //, String date, String rating
    private void getMovies(String title) {
        final MovieService movieService = new MovieService();

        //date, rating,
        movieService.findMovies(title,  new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response)  {
                    mMovies = movieService.processResults(response);
                    MovieActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mAdapter = new MovieListAdapter(getApplicationContext(),mMovies);
                            mRecyclerView.setAdapter(mAdapter);
                            RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(MovieActivity.this);
                            mRecyclerView.setLayoutManager(layoutManager);
                            mRecyclerView.setHasFixedSize(true);
//                            String[] moviesArray = new String[mMovies.size()];
//                            for(int i =0;i<moviesArray.length;i++){
//                                moviesArray[i] = mMovies.get(i).getTitle();
//                                moviesArray[i] = mMovies.get(i).getPoster();
//                                moviesArray[i] = mMovies.get(i).getSynopsis();
                            }
                        });
                    }
            });

    }



}
