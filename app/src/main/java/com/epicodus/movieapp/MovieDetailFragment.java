package com.epicodus.movieapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieDetailFragment extends Fragment {
    @Bind(R.id.imageView) ImageView mPosterView;
    @Bind(R.id.titleTextView) TextView mTitleView;
    @Bind(R.id.synopsisTextView) TextView mSynopsisView;
    @Bind(R.id.releaseDateTextView) TextView mReleaseView;
    @Bind(R.id.ratingTextView) TextView mRatingView;

    private Movie mMovie;

    public static MovieDetailFragment newInstance (Movie movie) {
       MovieDetailFragment movieDetailFragment = new MovieDetailFragment();
       Bundle args = new Bundle();
       args.putParcelable("movie", Parcels.wrap(movie));
       movieDetailFragment.setArguments(args);
        return movieDetailFragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMovie = Parcels.unwrap(getArguments().getParcelable("movie"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_detail, container, false);
        ButterKnife.bind(this, view);

        Picasso.with(view.getContext()).load(mMovie.getPoster()).into(mPosterView);
        mTitleView.setText(mMovie.getTitle());
        mSynopsisView.setText(mMovie.getSynopsis());
        mReleaseView.setText(mMovie.getReleaseDate());
        mRatingView.setText(mMovie.getRating() + "/10");

        return view;
    }


}
