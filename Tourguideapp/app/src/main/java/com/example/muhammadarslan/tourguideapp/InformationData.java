package com.example.muhammadarslan.tourguideapp;

/**
 * Created by Muhammad Arslan on 8/26/2018.
 */

public class InformationData {

    private String mName;
    private String mDescription;
    private String mAddress;
    private String mContact;

    public InformationData(String Name, String Description, String Address, String Contact) {
        mName = Name;
        mDescription = Description;
        mAddress = Address;
        mContact = Contact;
    }

    public String getmName() {
        return mName;
    }

    public String getmDescription() {
        return mDescription;
    }

    public String getmAddress() {
        return mAddress;
    }

    public String getmContact() {
        return mContact;
    }
}
