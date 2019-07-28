package com.example.muhammadarslan.practiceproject;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction ft =  getSupportFragmentManager().beginTransaction();
        ft.add(R.id.topfragment,new TopFragment());
        ft.commit();
    }
}
