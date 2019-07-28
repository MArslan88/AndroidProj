package com.example.muhammadarslan.fragmentspractice;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // getting view of ViewPager
        viewPager=(ViewPager)findViewById(R.id.myViewPager);

        // ArrayList of fragments
        ArrayList<Fragment> fragments=new ArrayList<>();

        // Object of Fragments
        FirstFragment firstFragment=new FirstFragment();
        SecondFragment secondFragment=new SecondFragment();
        ThirdFragment thirdFragment=new ThirdFragment();

        // Adding Title to fragments
        firstFragment.setmTitle("First");
        secondFragment.setmTitle("Second");
        thirdFragment.setmTitle("Third");

        // Adding fragments to ArrayList
        fragments.add(firstFragment);
        fragments.add(secondFragment);
        fragments.add(thirdFragment);

        // Object for PagerAdapter setAdapter in viewpager
        MyPagerAdapter myPagerAdapter=new MyPagerAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(myPagerAdapter);

    }
}
