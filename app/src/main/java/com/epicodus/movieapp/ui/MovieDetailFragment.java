package com.epicodus.movieapp.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.movieapp.R;
import com.epicodus.movieapp.adapters.MovieListAdapter;
import com.epicodus.movieapp.models.Movie;
import com.epicodus.movieapp.services.MovieService;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieDetailFragment extends Fragment {
    private static final int MAX_WIDTH = 400;
    private static final int MAX_HEIGHT = 300;

    @Bind(R.id.fragmentPosterImageView) ImageView mImageLabel;
    @Bind(R.id.fragmentTitleTextView) TextView mMovieLabel;
    @Bind(R.id.fragmentSynopsisTextView) TextView mSynopsisLabel;
    @Bind(R.id.fragmentRatingTextView) TextView mRatingLabel;
    @Bind(R.id.websiteTextView) TextView mWebsiteLabel;
    @Bind(R.id.releaseDateTextView) TextView mReleaseDateLabel;
    @Bind(R.id.actorsTextView) TextView mActorsLabel;
    @Bind(R.id.directorTextView) TextView mDirectorLabel;


    private Movie mMovie;

    public static MovieDetailFragment newInstance(Movie movie) {
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_movie_detail, container, false);
        ButterKnife.bind(this, view);

        final MovieService movieService = new MovieService();
        movieService.getCredits(mMovie.getmMovieId(), new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {

                mMovie = movieService.processCredits(response, mMovie);

//                MovieDetailFragment.this.runOnUiThread(new Runnable() {

//                    @Override
//                    public void run() {
                        Picasso.with(view.getContext()).load(mMovie.getPosterUrl()).resize(MAX_WIDTH, MAX_HEIGHT).centerCrop().into(mImageLabel);

                        mMovieLabel.setText(mMovie.getTitle());
                        mSynopsisLabel.setText(mMovie.getSynopsis());
                        mRatingLabel.setText(Double.toString(mMovie.getRating()));
                        mReleaseDateLabel.setText("Released: " + mMovie.getReleaseDate());

//                    }
//                });
            }
        });



        return view;
    }

}
