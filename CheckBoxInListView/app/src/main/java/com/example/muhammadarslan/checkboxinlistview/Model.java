package com.example.muhammadarslan.checkboxinlistview;

/**
 * Created by Muhammad Arslan on 11/14/2017.
 */

public class Model {
    private String name;
    private int value; /* 0 checkbox disable, 1 checkbox enable */

    Model(String name, int value){
        this.name = name;
        this.value = value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName(){
        return this.name;
    }
    public int getValue(){
        return this.value;
    }
}
