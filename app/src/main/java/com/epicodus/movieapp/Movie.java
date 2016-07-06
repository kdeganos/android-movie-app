package com.epicodus.movieapp;

import java.util.ArrayList;

/**
 * Created by Guest on 7/6/16.
 */
public class Movie {
    private String mTitle;
    private String mSynopsis;
    private String mPosterUrl;
    private double mRating;
    private String mReleaseDate;

    public Movie(String title, String synopsis, String posterUrl, double rating, String releaseDate) {
        this.mTitle = title;
        this.mSynopsis = synopsis;
        this.mPosterUrl = posterUrl;
        this.mRating = rating;
        this.mReleaseDate = releaseDate;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getSynopsis() {
        return mSynopsis;
    }

    public String getPosterUrl() {
        return "http://image.tmdb.org/t/p/w154/" + mPosterUrl;
    }

    public double getRating() {
        return mRating;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }
}