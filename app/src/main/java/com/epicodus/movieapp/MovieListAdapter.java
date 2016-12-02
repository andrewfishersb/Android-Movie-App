package com.epicodus.movieapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 12/1/16.
 */
public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder>{
    private ArrayList<Movie> mMovies = new ArrayList<>();
    private Context mContext;
    private static final int MAX_WIDTH = 400;
    private static final int MAX_HEIGHT = 300;


    public MovieListAdapter(Context context, ArrayList<Movie> movies){
        mContext=context;
        mMovies=movies;
    }



    @Override
    public MovieListAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item, parent, false);
        MovieViewHolder viewHolder = new MovieViewHolder(view);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(MovieListAdapter.MovieViewHolder holder, int position){
        holder.bindMovie(mMovies.get(position));
    }

    @Override
    public int getItemCount(){
        return mMovies.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @Bind(R.id.movieImageView) ImageView mMoviePosterView;
        @Bind(R.id.movieNameTextView) TextView mMovieTitle;
        @Bind(R.id.movieSynopsisTextView) TextView mMovieSynopsis;

        private Context mContext;


        public MovieViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this,itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }


        public void bindMovie(Movie movie){
            mMovieTitle.setText(movie.getTitle());
            mMovieSynopsis.setText(movie.getSynopsis());
            Picasso.with(mContext).load(movie.getPoster()).resize(MAX_WIDTH, MAX_HEIGHT)
                    .centerCrop().into(mMoviePosterView);
        }

        @Override
        public void onClick(View v){
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext,MovieDetailActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("movies", Parcels.wrap(mMovies));
            mContext.startActivity(intent);

        }
    }
}
