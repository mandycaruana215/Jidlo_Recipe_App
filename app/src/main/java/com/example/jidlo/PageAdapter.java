/*
package com.example.jidlo;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;


public class PageAdapter extends FragmentStateAdapter {
    public PageAdapter(@NonNull FragmentActivity fragmentActivity){
        super(fragmentActivity);
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){
            case 0:
                return new BreakfastFragment();

            case 1:
                return new LunchFragment();

            case 2:
                return new DinnerFragment();

            case 3:
                return new SnacksFragment();

            case 4:
                return new DessertsFragment();

            default: return new BreakfastFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
*/
