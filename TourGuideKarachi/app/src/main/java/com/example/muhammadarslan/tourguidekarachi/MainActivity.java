package com.example.muhammadarslan.tourguidekarachi;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // getting ViewPager

        ViewPager viewPager=(ViewPager)findViewById(R.id.myViewPager);

        // ArrayList for fragments
        ArrayList <Fragment> fragments=new ArrayList<>();

        // Object for Fragments
        HotelFragment hotelFragment=new HotelFragment();
        ShopsFragment shopsFragment=new ShopsFragment();
        CinemaFragment cinemaFragment=new CinemaFragment();

        // Adding title for Fragments
        hotelFragment.setmTitle("Hotels");
        shopsFragment.setmTitle("Shops");
        cinemaFragment.setmTitle("Cinemas");


        // Adding Fragments to ArrayList
        fragments.add(hotelFragment);
        fragments.add(shopsFragment);
        fragments.add(cinemaFragment);


        //object for pagerAdapter setAdapter in viewpager
        MyPageAdapter myPagerAdapter=new MyPageAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(myPagerAdapter);

    }
}
