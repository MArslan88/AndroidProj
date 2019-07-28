package com.example.muhammadarslan.fragmentstab;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Getting view of ViewPrager
        ViewPager viewPager=(ViewPager)findViewById(R.id.myViewPager);

        // ArrayList of fragments
        ArrayList<Fragment> fragments=new ArrayList<>();

        // Objects of Fragments
        FirstFragment firstFragment=new FirstFragment();
        SecondFragment secondFragment=new SecondFragment();
        ThirdFragment thirdFragment=new ThirdFragment();

        // Set title to Fragments
        firstFragment.setmTitle(getString(R.string.first_tab));
        secondFragment.setmTitle(getString(R.string.second_tab));
        thirdFragment.setmTitle(getString(R.string.third_tab));

        // add fragments to ArrayList
        fragments.add(firstFragment);
        fragments.add(secondFragment);
        fragments.add(thirdFragment);

        // Object for pagerAdapter setadapter in viewpager
        MyPagerAdapter myPagerAdapter=new MyPagerAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(myPagerAdapter);
    }
}
