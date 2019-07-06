package com.example.mytravelhci.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;

import com.example.mytravelhci.R;
import com.example.mytravelhci.SideMenuClass;
import com.example.mytravelhci.fragment.HomeSlideFirst;
import com.example.mytravelhci.fragment.HomeSlideSecond;
import com.example.mytravelhci.fragment.HomeSlideThird;
import com.example.mytravelhci.fragment.TripInfoFragment;
import com.example.mytravelhci.fragment.TripPaymentFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.mikepenz.materialdrawer.Drawer;

import java.util.Objects;

public class TripPageActivity extends AppCompatActivity {

    private TripInfoFragment infoFragment;
    private TripPaymentFragment paymentFragment;

    private Drawer drawer;
    private Context thisContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_page);

        Intent intent = getIntent();
        boolean created_now = intent.getBooleanExtra("created_now", false);
        boolean edited = intent.getBooleanExtra("edited", false);
        if (created_now) {
            Snackbar mySnackbar = Snackbar.make(findViewById(R.id.coordinator_logged),
                    "Trip created!", Snackbar.LENGTH_SHORT);
            mySnackbar.getView().setBackgroundResource(R.color.customGreen);
            mySnackbar.show();
        }
        if (edited) {
            Snackbar mySnackbar = Snackbar.make(findViewById(R.id.coordinator_logged),
                    "Trip updated.", Snackbar.LENGTH_SHORT);
            mySnackbar.getView().setBackgroundResource(R.color.customGreen);
            mySnackbar.show();
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //toolbar.getOverflowIcon().setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP);
        toolbar.setOverflowIcon(getDrawable(R.drawable.ic_dots_white_24dp));

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        drawer = new SideMenuClass(this).drawer;

        infoFragment = new TripInfoFragment();
        paymentFragment = new TripPaymentFragment();

        setFragment(infoFragment);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

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

    public void goToEdit(MenuItem item) {
        Intent intent = new Intent(this, EditTrip.class);
        startActivity(intent);
    }

    public void deleteTrip(MenuItem item) {
        AlertDialog ad = new AlertDialog.Builder(this)
                .setTitle("Confirm deletion")
                .setMessage("Are you sure you want to delete this trip?")
                .setPositiveButton("Cancel", null)
                .setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        Intent intent = new Intent(thisContext, LoggedHomeActivity.class);
                        intent.putExtra("frag_to_set", "trips");
                        intent.putExtra("deleted", true);
                        thisContext.startActivity(intent);
                    }
                })
                .show();
        ad.getButton(ad.BUTTON_NEGATIVE).setTextColor(getResources().getColor(R.color.customRed));
    }
}
