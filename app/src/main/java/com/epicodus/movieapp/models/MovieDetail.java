package com.epicodus.movieapp.models;

import java.util.ArrayList;

/**
 * Created by Guest on 7/6/16.
 */
public class MovieDetail {

    private String mTitle;
    private String mSynopsis;
    private String mDirector;
    private ArrayList<String> mActors;
    private String mPosterUrl;
    private double mRating;
    private String mReleaseDate;

    public MovieDetail(String title, String synopsis, String director, ArrayList<String> actors, String posterUrl, double rating, String releaseDate) {
        this.mTitle = title;
        this.mSynopsis = synopsis;
        this.mDirector = director;
        this.mActors = actors;
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
    public String getDirector() {
        return mDirector;
    }
    public ArrayList<String> getActors() {
        return mActors;
    }
    public String getPosterUrl() {
        return mPosterUrl;
    }
    public double getRating() {
        return mRating;
    }
    public String getReleaseDate() {
        return mReleaseDate;
    }
}
