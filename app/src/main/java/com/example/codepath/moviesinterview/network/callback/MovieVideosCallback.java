package com.example.codepath.moviesinterview.network.callback;

import com.example.codepath.moviesinterview.model.Video;

import java.util.ArrayList;

/**
 * Created by gretel on 2/28/18.
 */

public interface MovieVideosCallback {
    void onSuccess(ArrayList<Video> videos);
    void onError(Error error);

}
