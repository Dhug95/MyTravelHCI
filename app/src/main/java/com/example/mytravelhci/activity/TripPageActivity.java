package com.example.mytravelhci.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.mytravelhci.R;
import com.example.mytravelhci.SideMenuClass;
import com.example.mytravelhci.fragment.TripInfoFragment;
import com.example.mytravelhci.fragment.TripPaymentFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.mikepenz.materialdrawer.Drawer;

import java.util.Objects;

public class TripPageActivity extends AppCompatActivity {

    private TripInfoFragment infoFragment;
    private TripPaymentFragment paymentFragment;

    private Drawer drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_page);

        Intent intent = getIntent();
        Boolean created_now = intent.getBooleanExtra("created_now", false);
        if (created_now) {
            Snackbar mySnackbar = Snackbar.make(findViewById(R.id.coordinator_logged),
                    "Trip created!", Snackbar.LENGTH_SHORT);
            mySnackbar.getView().setBackgroundResource(R.color.customGreen);
            mySnackbar.show();
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.getOverflowIcon().setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        drawer = new SideMenuClass(this).drawer;

        infoFragment = new TripInfoFragment();
        paymentFragment = new TripPaymentFragment();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        setFragment(new TripInfoFragment());

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.trip_info:
                    setFragment(infoFragment);
                    return true;
                case R.id.payment:
                    setFragment(paymentFragment);
                    return true;
            }
            return false;
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.trip_menu, menu);
        return true;
    }

    private void setFragment(Fragment newFragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, newFragment);
        fragmentTransaction.commit();
    }

    public void showDatePicker(View view) {
        Integer iddio = Integer.valueOf(view.getId());
        DatePickerFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), iddio.toString());
    }

    public void goBack(View view) {
        this.onBackPressed();
    }

    public void openDrawer(View view) {
        drawer.openDrawer();
    }
}
