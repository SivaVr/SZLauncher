package com.example.shivakumarm.szlauncher;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class LauncherAdapter extends FragmentStatePagerAdapter {

    static final int NUM_PAGES = 5;
    public LauncherAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return new Homescreen();
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}
