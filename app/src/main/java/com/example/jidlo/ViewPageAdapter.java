package com.example.jidlo;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

public class ViewPageAdapter extends FragmentPagerAdapter {

    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> fragmentTitleList = new ArrayList<>();


    public ViewPageAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }


    @Override
    public int getCount() {
        return  fragmentTitleList.size();
            }

    /*@Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {

        return false;
    }*/

   /* public Fragment getItem(int position){
        switch (position) {
            case 0:
                BreakfastFragment breakfastFragment = new BreakfastFragment();
                return breakfastFragment;

            case 1:
                return new LunchFragment();

            case 2:
                return new DinnerFragment();

            case 3:
                return new SnacksFragment();

            case 4:
                return new DessertsFragment();

            default:
                return new BreakfastFragment();
        }
    }*/

    public void addFragment(Fragment fragment, String title){
        fragmentList.add(fragment);
        fragmentTitleList.add(title);
    }

    public CharSequence getPageTitle(int position) {
        return fragmentTitleList.get(position);
    }

}
