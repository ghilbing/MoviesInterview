package com.example.codepath.moviesinterview.network.callback;

import com.example.codepath.moviesinterview.model.Movie;

/**
 * Created by gretel on 2/28/18.
 */

public interface MovieDetailsCallback {
    void onSuccess(Movie movie);
    void onError(Error error);
}
