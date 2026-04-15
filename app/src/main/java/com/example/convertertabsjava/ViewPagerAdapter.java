package com.example.convertertabsjava;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;


public class ViewPagerAdapter extends FragmentStateAdapter {

    private static final int TOTAL_TABS = 2;

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    /**
     * Create and return a new instance of the fragment for a given position.
     * @param position 0 for Temperature, 1 for Distance
     * @return Fragment instance
     */
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new TempFragment();
        } else {
            return new DistanceFragment();
        }
    }

    /**
     * @return The total number of tabs managed by the adapter.
     */
    @Override
    public int getItemCount() {
        return TOTAL_TABS;
    }
}
