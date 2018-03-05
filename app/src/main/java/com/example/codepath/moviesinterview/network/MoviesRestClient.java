package com.example.codepath.moviesinterview.network;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * Created by gretel on 2/28/18.
 */

public class MoviesRestClient {
    private static final String BASE_URL = "https://api.themoviedb.org/3/";
    private static final String MOVIES_API_KEY = "c0ce143817426b86ae199a8ede8d8775";
    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler){
        if(params == null){
            params = new RequestParams();

        }
        params.put("api_key", MOVIES_API_KEY);
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler){
        if (params == null){
            params = new RequestParams();

        }
        params.put("api_key", MOVIES_API_KEY);
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl){
        return BASE_URL + relativeUrl;
    }

}
