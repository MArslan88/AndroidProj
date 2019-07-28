package com.example.muhammadarslan.androidreviewapp;

/**
 * Created by Muhammad Arslan on 12/3/2017.
 */

public class Model {
    private String mMovieTitle;
    private String mMovieDescription;
    private String mTitleImage;
    private String mYouTubeUrl;

    public Model(String mMovieTitle, String mMovieDescription, String mTitleImage, String mYouTubeUrl) {
        this.mMovieTitle = mMovieTitle;
        this.mMovieDescription = mMovieDescription;
        this.mTitleImage = mTitleImage;
        this.mYouTubeUrl = mYouTubeUrl;
    }

    public Model(String mMovieTitle, String mMovieDescription, String mYouTubeUrl) {
        this.mMovieTitle = mMovieTitle;
        this.mMovieDescription = mMovieDescription;
        this.mYouTubeUrl = mYouTubeUrl;
    }

    public String getmMovieTitle() {
        return mMovieTitle;
    }

    public void setmMovieTitle(String mMovieTitle) {
        this.mMovieTitle = mMovieTitle;
    }

    public String getmMovieDescription() {
        return mMovieDescription;
    }

    public void setmMovieDescription(String mMovieDescription) {
        this.mMovieDescription = mMovieDescription;
    }

    public String getmTitleImage() {
        return mTitleImage;
    }

    public void setmTitleImage(String mTitleImage) {
        this.mTitleImage = mTitleImage;
    }

    public String getmYouTubeUrl() {
        return mYouTubeUrl;
    }

    public void setmYouTubeUrl(String mYouTubeUrl) {
        this.mYouTubeUrl = mYouTubeUrl;
    }
}
