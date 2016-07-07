package com.epicodus.movieapp.models;

import org.parceler.Parcel;

import java.util.ArrayList;

/**
 * Created by Guest on 7/6/16.
 */

@Parcel
public class Movie {
    String mTitle;
    String mSynopsis;
    String mPosterUrl;
    double mRating;
    String mReleaseDate;
    String mDirector;
    ArrayList<String> mActors;
    String mMovieId;

    public Movie() {}

    public Movie(String title, String synopsis, String posterUrl, double rating, String releaseDate, String movieId) {
        this.mTitle = title;
        this.mSynopsis = synopsis;
        this.mPosterUrl = posterUrl;
        this.mRating = rating;
        this.mReleaseDate = releaseDate;
        this.mMovieId = movieId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getSynopsis() {
        return mSynopsis;
    }

    public String getPosterUrl() {
        return "http://image.tmdb.org/t/p/w500/" + mPosterUrl;
    }

    public double getRating() {
        return mRating;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public String getmMovieId() {
        return mMovieId;
    }

    public void setDirector(String director) {
        this.mDirector = director;
    }

    public String getDirector() {
        return mDirector;
    }

    public void setActors(ArrayList<String> actors) {
        this.mActors = actors;
    }

    public ArrayList<String> getActors() {
        return mActors;
    }
}