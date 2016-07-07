package com.epicodus.movieapp.services;

import com.epicodus.movieapp.Constants;
import com.epicodus.movieapp.models.Movie;
import com.epicodus.movieapp.ui.MovieActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Guest on 7/6/16.
 */
public class MovieService {
    public static final String TAG = MovieActivity.class.getSimpleName();

    public static void findMovies(String title, Callback callback) {

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.API_QUERY_PARAMETER, Constants.MOVIE_API_KEY);
        urlBuilder.addQueryParameter(Constants.SEARCH_QUERY_PARAMETER, title);
        String url = urlBuilder.build().toString();

        Request request= new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public static void getCredits(String movieId, Callback callback) {

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.BASE_CREDITS_URL + movieId + "/credits").newBuilder();
        urlBuilder.addQueryParameter(Constants.API_QUERY_PARAMETER, Constants.MOVIE_API_KEY);
        String url = urlBuilder.build().toString();

        Request request= new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Movie> processResults(Response response) {
        ArrayList<Movie> movies = new ArrayList<>();

        try {
            String jsonData = response.body().string();

            if (response.isSuccessful()) {
                JSONObject tmdbJSON = new JSONObject(jsonData);
                JSONArray moviesJSON = tmdbJSON.getJSONArray("results");
                for (int i = 0; i < moviesJSON.length(); i++) {
                    JSONObject movieJSON = moviesJSON.getJSONObject(i);
                    String title = movieJSON.getString("title");
                    String synopsis = movieJSON.getString("overview");
                    String posterUrl = movieJSON.getString("poster_path");
                    double rating = movieJSON.getDouble("vote_average");
                    String releaseDate = movieJSON.getString("release_date");
                    String movieId = movieJSON.getString("id");

                    Movie movie = new Movie(title, synopsis, posterUrl, rating, releaseDate, movieId);
                    movies.add(movie);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return movies;
    }

    public Movie processCredits (Response response, Movie movie) {
        ArrayList<String> actors = new ArrayList<>();
        String director = "unavailable";


        try {
            String jsonData = response.body().string();

            if (response.isSuccessful()) {
                JSONObject tmdbJSON = new JSONObject(jsonData);
                JSONArray castJSON = tmdbJSON.getJSONArray("cast");
                for (int i = 0; i < castJSON.length(); i++) {
                    JSONObject movieJSON = castJSON.getJSONObject(i);
                    String name = movieJSON.getString("name");

                    actors.add(name);
                }

                JSONArray crewJSON = tmdbJSON.getJSONArray("crew");

                for (int i = 0; i < crewJSON.length(); i++) {
                    JSONObject movieJSON = castJSON.getJSONObject(i);
                    if (movieJSON.getString("job").equals("Director")){
                        director = movieJSON.getString("name");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        movie.setActors(actors);
        movie.setDirector(director);
        return movie;
    }
}
