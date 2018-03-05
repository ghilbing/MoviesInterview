package com.example.codepath.moviesinterview.network.callback;

import com.example.codepath.moviesinterview.model.Movie;

import java.util.ArrayList;

/**
 * Created by gretel on 2/28/18.
 */

public interface LatestMoviesCallback {
    void onSuccess(ArrayList<Movie> movies, int page);
    void onError(Error error);
}
