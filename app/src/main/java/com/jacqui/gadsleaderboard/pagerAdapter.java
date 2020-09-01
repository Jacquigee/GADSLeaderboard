package com.jacqui.gadsleaderboard;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class pagerAdapter extends FragmentPagerAdapter {

    private int numOfTabs;

    public pagerAdapter(FragmentManager fm, int numOfTabs){
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new LearningFragment();
            case 1:
                return new SkillsFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
