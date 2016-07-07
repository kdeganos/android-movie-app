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

    public Movie() {}

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