package com.example.codepath.moviesinterview.network;

import android.util.Log;

import com.example.codepath.moviesinterview.model.Movie;
import com.example.codepath.moviesinterview.model.Video;
import com.example.codepath.moviesinterview.network.callback.LatestMoviesCallback;
import com.example.codepath.moviesinterview.network.callback.MovieDetailsCallback;
import com.example.codepath.moviesinterview.network.callback.MovieVideosCallback;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Locale;

import cz.msebera.android.httpclient.Header;

/**
 * Created by gretel on 2/28/18.
 */

public class MoviesRestClientImplementation {

    private static final String TAG_LOG = MoviesRestClientImplementation.class.getCanonicalName();

    public static void getLastestMovies(int page, final LatestMoviesCallback callback) {
        RequestParams params = new RequestParams();
        params.put("page", String.valueOf(page));

        MoviesRestClient.get("movie/now_playing", params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    int page = response.getInt("page");

                    JSONArray jsonMovies = response.getJSONArray("results");
                    ArrayList<Movie> movies = new ArrayList<>();
                    for (int i = 0; i < jsonMovies.length(); i++) {
                        movies.add(new Movie(jsonMovies.getJSONObject(i)));
                    }

                    callback.onSuccess(movies, page);
                } catch (JSONException ex) {
                    Log.e(TAG_LOG, ex.toString());
                    callback.onError(new Error(ex.getMessage()));
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                callback.onError(new Error(throwable.getMessage()));
            }
        });
    }

    public static void getMovieDetails(Long movieId, final MovieDetailsCallback callback) {
        String url = String.format(Locale.getDefault(), "movie/%d", movieId);
        MoviesRestClient.get(url, null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    callback.onSuccess(new Movie(response));
                } catch (JSONException ex) {
                    Log.e(TAG_LOG, ex.toString());
                    callback.onError(new Error(ex.getMessage()));
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                callback.onError(new Error(throwable.getMessage()));
            }
        });
    }

    public static void getMovieVideos(Long movieId, final MovieVideosCallback callback) {
        String url = String.format(Locale.getDefault(), "movie/%d/videos", movieId);
        MoviesRestClient.get(url, null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONArray jsonVideos = response.getJSONArray("results");
                    ArrayList<Video> videos = new ArrayList<>();
                    for (int i = 0; i < jsonVideos.length(); i++) {
                        videos.add(new Video(jsonVideos.getJSONObject(i)));
                    }

                    callback.onSuccess(videos);
                } catch (JSONException ex) {
                    Log.e(TAG_LOG, ex.toString());
                    callback.onError(new Error(ex.getMessage()));
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                callback.onError(new Error(throwable.getMessage()));
            }
        });
    }

}

