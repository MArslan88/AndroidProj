package com.example.muhammadarslan.tourguidekarachi;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by Muhammad Arslan on 9/14/2017.
 */

public class MyPageAdapter extends FragmentStatePagerAdapter {

    ArrayList<Fragment> mFragments;

    public MyPageAdapter(FragmentManager fm, ArrayList<Fragment> mFragments) {
        super(fm);
        this.mFragments = mFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return ((HotelFragment)mFragments.get(position)).getmTitle();
            case 1:
                return ((ShopsFragment)mFragments.get(position)).getmTitle();
            case 2:
                return ((CinemaFragment)mFragments.get(position)).getmTitle();
            default:
                return "unknown";
        }

    }
}
