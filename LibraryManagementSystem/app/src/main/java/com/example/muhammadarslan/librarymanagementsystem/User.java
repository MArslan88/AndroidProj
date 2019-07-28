package com.example.muhammadarslan.librarymanagementsystem;

/**
 * Created by Muhammad Arslan on 11/19/2017.
 */

public class User {
    private String userId;
    private String userName;
    private String passwor;
    private String userType;

    public User(String userId, String userType) {
        this.userId = userId;
        this.userType = userType;
    }

    public User(String userId, String userName, String passwor, String userType) {
        this.userId = userId;
        this.userName = userName;
        this.passwor = passwor;
        this.userType = userType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswor() {
        return passwor;
    }

    public void setPasswor(String passwor) {
        this.passwor = passwor;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
