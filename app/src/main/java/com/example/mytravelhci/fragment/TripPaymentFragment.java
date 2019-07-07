package com.example.mytravelhci.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.mytravelhci.R;
import com.example.mytravelhci.activity.MainActivity;
import com.google.android.material.tabs.TabLayout;
import com.leinardi.android.speeddial.SpeedDialActionItem;
import com.leinardi.android.speeddial.SpeedDialView;

public class TripPaymentFragment extends Fragment {

    /*
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 2;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter pagerAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.trip_payment_fragment, container, false);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) v.findViewById(R.id.mPager);
        pagerAdapter = new TripPaymentFragment.ScreenSlidePagerAdapter(getChildFragmentManager());
        mPager.setAdapter(pagerAdapter);

        TabLayout tabLayout = (TabLayout) v.findViewById(R.id.tabs);
        mPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mPager));

        SpeedDialView speedDialView = v.findViewById(R.id.speedDial);

        speedDialView.addActionItem(
                new SpeedDialActionItem.Builder(R.id.fab_debt_payment, R.drawable.debt_payment_white)
                        .setLabel("Pay off debt")
                        .create()
        );

        speedDialView.addActionItem(
                new SpeedDialActionItem.Builder(R.id.fab_my_payment, R.drawable.my_payment_white)
                        .setLabel("Add payment")
                        .create()
        );

        speedDialView.setOnActionSelectedListener(new SpeedDialView.OnActionSelectedListener() {
            @Override
            public boolean onActionSelected(SpeedDialActionItem speedDialActionItem) {
                switch (speedDialActionItem.getId()) {
                    case R.id.fab_my_payment:
                        return false; // true to keep the Speed Dial open
                    case R.id.fab_debt_payment:
                        return false; // true to keep the Speed Dial open
                    default:
                        return false;
                }
            }
        });

        // Inflate the layout for this fragment
        return v;
    }

    /**
     * A simple pager adapter that represents 3 HomeSlide objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentPagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new PaymentsOverviewFragment();
                case 1:
                    return new PaymentsHistoryFragment();
                default:
                    throw new IllegalStateException();
            }
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
