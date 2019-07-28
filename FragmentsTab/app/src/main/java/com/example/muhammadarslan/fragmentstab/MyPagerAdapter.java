package com.example.muhammadarslan.fragmentstab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by Muhammad Arslan on 9/23/2017.
 */

public class MyPagerAdapter extends FragmentStatePagerAdapter {

    ArrayList<Fragment> mFragments=new ArrayList<>();

    public MyPagerAdapter(FragmentManager fm, ArrayList<Fragment> mFragments) {
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
                return ((FirstFragment)mFragments.get(position)).getmTitle();
            case 1:
                return ((SecondFragment)mFragments.get(position)).getmTitle();
            case 2:
                return ((ThirdFragment)mFragments.get(position)).getmTitle();
            default:
                return "Unknown";
        }
    }
}
