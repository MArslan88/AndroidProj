package com.example.muhammadarslan.cardviewexample;

/**
 * Created by Muhammad Arslan on 9/7/2017.
 */

public class Contact {
    private int mImage_id;
    private String mTitle, mDescription, mContact, mLocation;

    public Contact(int mImage_id, String mTitle, String mDescription, String mContact, String mLocation) {
        this.setmImage_id(mImage_id);
        this.setmTitle(mTitle);
        this.setmDescription(mDescription);
        this.setmContact(mContact);
        this.setmLocation(mLocation);
    }

    public int getmImage_id() {
        return mImage_id;
    }

    public void setmImage_id(int mImage_id) {
        this.mImage_id = mImage_id;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmContact() {
        return mContact;
    }

    public void setmContact(String mContact) {
        this.mContact = mContact;
    }

    public String getmLocation() {
        return mLocation;
    }

    public void setmLocation(String mLocation) {
        this.mLocation = mLocation;
    }
}
