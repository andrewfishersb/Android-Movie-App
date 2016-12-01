package com.epicodus.movieapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 12/1/16.
 */
public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder>{
    private ArrayList<Movie> mMovies = new ArrayList<>();
    private Context mContext;



    public MovieListAdapter(Context context, ArrayList<Movie> movies){
        mContext=context;
        mMovies=movies;
    }


    //didnt get here
    @Override
    public MovieListAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item, parent, false);
        MovieViewHolder viewHolder = new MovieViewHolder(view);

        return viewHolder;
    }

        //didnt get here
    @Override
    public void onBindViewHolder(MovieListAdapter.MovieViewHolder holder, int position){
        holder.bindMovie(mMovies.get(position));
    }

    @Override
    public int getItemCount(){
        return mMovies.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder{

       // @Bind(R.id.movieImageView) ImageView mMoviePosterView;
        @Bind(R.id.movieNameTextView) TextView mMovieTitle;
        @Bind(R.id.movieSynopsisTextView) TextView mMovieSynopsis;

        private Context mContext;

        //fails
        public MovieViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this,itemView);
            mContext = itemView.getContext();

        }

        //fails
        public void bindMovie(Movie movie){
            mMovieTitle.setText(movie.getTitle());
            mMovieSynopsis.setText(movie.getSynopsis());
            //mMoviePosterView    link: http://image.tmdb.org/t/p/w500/jpeg key
        }
    }
}
