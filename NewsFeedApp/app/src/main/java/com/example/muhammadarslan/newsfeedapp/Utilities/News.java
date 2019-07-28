package com.example.muhammadarslan.newsfeedapp.Utilities;

/**
 * Created by saqib on 25-Aug-17.
 */

public class News {

    private String mSection;
    private String mTitle;
    private String mType;
    private String mDatePublished;
    private String mUrl;

    public News(String section, String title, String type, String datePublished, String url) {
        this.mSection = section;
        this.mTitle = title;
        this.mType = type;
        this.mDatePublished = datePublished;
        this.mUrl = url;
    }

    public String getmSection() {
        return mSection;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmType() {
        return mType;
    }

    public String getmDatePublished() {
        return mDatePublished;
    }

    public String getmUrl() {
        return mUrl;
    }
}
