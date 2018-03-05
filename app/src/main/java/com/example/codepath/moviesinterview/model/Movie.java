package com.example.codepath.moviesinterview.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by gretel on 2/28/18.
 */

public class Movie implements Parcelable {

    private Long movieId;

    private String title;

    private String overview;

    private String posterPath;

    private String backdropPath;

    private Double averageRating;

    private String homepage;

    private String date;

    private ArrayList<ProductionCompanies> productionCompanies;

    private ArrayList<Video> videos;

    private int voteCount;

    protected Movie() {
        averageRating = 0D;
        productionCompanies = new ArrayList<>();
        videos = new ArrayList<>();
    }

    public Movie(JSONObject jsonObject) throws JSONException {
        this();

        if (jsonObject.has("id")) setMovieId(jsonObject.getLong("id"));
        if (jsonObject.has("title")) setTitle(jsonObject.getString("title"));
        if (jsonObject.has("overview")) setOverview(jsonObject.getString("overview"));
        if (jsonObject.has("poster_path")) setPosterPath(jsonObject.getString("poster_path"));
        if (jsonObject.has("backdrop_path")) setBackdropPath(jsonObject.getString("backdrop_path"));
        if (jsonObject.has("vote_average")) setAverageRating(jsonObject.getDouble("vote_average"));
        if (jsonObject.has("homepage")) setHomepage(jsonObject.getString("homepage"));
        if (jsonObject.has("release_date")) setDate(jsonObject.getString("release_date"));
        if (jsonObject.has("vote_count")) setVoteCount(jsonObject.getInt("vote_count"));

        if (jsonObject.has("production_countries")) {
            JSONArray jsonProductionCountries = jsonObject.getJSONArray("production_countries");
            for (int i = 0; i < jsonProductionCountries.length(); i++) {
                productionCompanies.add(new ProductionCompanies(jsonProductionCountries.getJSONObject(i)));
            }
        }
    }

    protected Movie(Parcel in) {
        this();

        movieId = in.readLong();
        title = in.readString();
        overview = in.readString();
        posterPath = in.readString();
        backdropPath = in.readString();
        voteCount = in.readInt();
        date = in.readString();
        averageRating = in.readDouble();
        homepage = in.readString();

        in.readTypedList(productionCompanies, ProductionCompanies.CREATOR);
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<ProductionCompanies> getProductionCompanies() {
        return productionCompanies;
    }

    public void setProductionCompanies(ArrayList<ProductionCompanies> productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    public ArrayList<Video> getVideos() {
        return videos;
    }

    public void setVideos(ArrayList<Video> videos) {
        this.videos = videos;
    }

    public String getPosterUrl(int width) {
        return String.format(Locale.getDefault(), "https://image.tmdb.org/t/p/w%d/%s", width, getPosterPath());
    }

    public String getBackdropUrl(int width) {
        return String.format(Locale.getDefault(), "https://image.tmdb.org/t/p/w%d/%s", width, getBackdropPath());
    }

    public boolean hasYouTubeVideos() {
        for (Video video : videos) {
            if ("YouTube".equals(video.getSite())) return true;
        }
        return false;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(movieId);
        dest.writeString(title);
        dest.writeString(overview);
        dest.writeString(posterPath);
        dest.writeString(backdropPath);
        dest.writeInt(voteCount);
        dest.writeString(date);
        dest.writeDouble(averageRating);
        dest.writeString(homepage);
        dest.writeTypedList(productionCompanies);
    }
}

