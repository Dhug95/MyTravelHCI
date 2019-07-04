package com.example.mytravelhci.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mytravelhci.R;
import com.example.mytravelhci.SideMenuClass;
import com.example.mytravelhci.fragment.HomeFragment;
import com.example.mytravelhci.fragment.ProfileFragment;
import com.example.mytravelhci.fragment.TripsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;

public class LoggedHomeActivity extends AppCompatActivity {

    private HomeFragment homeFragment;
    private TripsFragment tripsFragment;
    private ProfileFragment profileFragment;

    private Drawer drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        drawer = new SideMenuClass(this).drawer;

        Intent intent = getIntent();
        Boolean registered = intent.getBooleanExtra("registered", false);
        Log.i("REGISTERED VALUE: ", registered.toString());
        if (registered) {
            Snackbar mySnackbar = Snackbar.make(findViewById(R.id.coordinator_logged),
                    R.string.account_created, Snackbar.LENGTH_SHORT);
            mySnackbar.getView().setBackgroundResource(R.color.customGreen);
            mySnackbar.show();
        }

        homeFragment = new HomeFragment();
        tripsFragment = new TripsFragment();
        profileFragment = new ProfileFragment();

        Boolean trip_added = intent.getBooleanExtra("Trip added!", false);
        if(trip_added){
            setFragment(tripsFragment);
            Snackbar mySnackbar = Snackbar.make(findViewById(R.id.coordinator_logged),
                    "Trip created!", Snackbar.LENGTH_SHORT);
            mySnackbar.getView().setBackgroundResource(R.color.customGreen);
            mySnackbar.show();
        }
        else {
            setFragment(homeFragment);
        }

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 16908332: {
                drawer.openDrawer();
            }

            default:
                return super.onOptionsItemSelected(item);
        }
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

    public void passwordChanged(View view) {
        Snackbar mySnackbar = Snackbar.make(findViewById(R.id.coordinator_logged),
                "Password changed!", Snackbar.LENGTH_SHORT);
        mySnackbar.getView().setBackgroundResource(R.color.customGreen);
        mySnackbar.show();
    }

    public void gotoAddTrip(View view) {
        Intent intent = new Intent(this, AddTrip.class);
        startActivity(intent);
    }
}
