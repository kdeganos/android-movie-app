package com.epicodus.movieapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.movieapp.models.Movie;
import com.epicodus.movieapp.R;
import com.epicodus.movieapp.ui.MovieDetailActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 7/6/16.
 */
public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder> {
    public static final String TAG = MovieListAdapter.class.getSimpleName();
    private ArrayList<Movie> mMovies = new ArrayList<>();
    private Context mContext;

    public MovieListAdapter(Context context, ArrayList<Movie> movies) {
        mContext = context;
        mMovies = movies;
    }

    @Override
    public MovieListAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item, parent, false);
        MovieViewHolder viewHolder = new MovieViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MovieListAdapter.MovieViewHolder holder, int position) {
        holder.bindMovie(mMovies.get(position));
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @Bind(R.id.posterImageView) ImageView mPosterImageView;
        @Bind(R.id.movieTitleTextView) TextView mMovieTitleTextView;
        @Bind(R.id.synopsisTextView) TextView mSynopsisTextView;
//        @Bind(R.id.releaseDateTextView) TextView mReleaseDateTextView;
        @Bind(R.id.ratingTextView) TextView mRatingTextView;

        private Context mContext;

        public MovieViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, MovieDetailActivity.class);
            intent.putExtra("position", itemPosition + "");
            intent.putExtra("movies", Parcels.wrap(mMovies));
            mContext.startActivity(intent);
        }

        public void bindMovie(Movie movie) {
            Picasso.with(mContext).load(movie.getPosterUrl()).resize(77, 150).into(mPosterImageView);
            mMovieTitleTextView.setText(movie.getTitle());
            mSynopsisTextView.setText(movie.getSynopsis());
//            mReleaseDateTextView.setText("Release Date: " + movie.getReleaseDate());
            mRatingTextView.setText("Release Date: " + movie.getReleaseDate() + "     " + "Rating: " + String.valueOf(movie.getRating()));
        }
    }
}