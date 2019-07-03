package com.example.mytravelhci.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.mytravelhci.R;
import com.example.mytravelhci.fragment.HomeFragment;
import com.example.mytravelhci.fragment.ProfileFragment;
import com.example.mytravelhci.fragment.TripsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class LoggedHomeActivity extends AppCompatActivity {

    private HomeFragment homeFragment;
    private TripsFragment tripsFragment;
    private ProfileFragment profileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_home);

        homeFragment = new HomeFragment();
        tripsFragment = new TripsFragment();
        profileFragment = new ProfileFragment();

        setFragment(homeFragment);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.home:
                    setFragment(homeFragment);
                    return true;
                case R.id.myTrips:
                    setFragment(tripsFragment);
                    return true;
                case R.id.myProfile:
                    setFragment(profileFragment);
                    return true;
            }
            return false;
        }
    };

    private void setFragment(Fragment newFragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, newFragment);
        fragmentTransaction.commit();
    }
}
