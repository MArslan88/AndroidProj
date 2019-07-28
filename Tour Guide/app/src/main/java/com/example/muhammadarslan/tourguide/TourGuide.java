package com.example.muhammadarslan.tourguide;

/**
 * Created by Muhammad Arslan on 9/4/2017.
 */

public class TourGuide {

    private String mTitle;
    private String mDescription;
    /** Image resource ID for the item*/
    private int mImageResourceId=NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED=-1;

    public TourGuide(String mTitle, String mDescription, int mImageResourceId) {
        this.mTitle = mTitle;
        this.mDescription = mDescription;
        this.mImageResourceId = mImageResourceId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmDescription() {
        return mDescription;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
