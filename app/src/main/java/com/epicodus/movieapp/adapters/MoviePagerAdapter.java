package com.epicodus.movieapp.adapters;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.epicodus.movieapp.models.Movie;
import com.epicodus.movieapp.ui.MovieDetailFragment;

import java.util.ArrayList;

/**
 * Created by Guest on 7/7/16.
 */
public class MoviePagerAdapter extends FragmentPagerAdapter{
    public static final String TAG = MoviePagerAdapter.class.getSimpleName();
    private ArrayList<Movie> mMovies;

    public MoviePagerAdapter(FragmentManager fm, ArrayList<Movie> movies) {
        super(fm);
        mMovies = movies;
        Log.d(TAG, "MoviePagerAdapter: " + mMovies);
    }

    @Override
    public Fragment getItem(int position) {
        return MovieDetailFragment.newInstance(mMovies.get(position));
    }

    @Override
    public int getCount() {
        return mMovies.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mMovies.get(position).getTitle();
    }
}
