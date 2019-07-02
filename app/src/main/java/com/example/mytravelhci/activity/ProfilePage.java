package com.example.mytravelhci.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.mytravelhci.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jaredrummler.materialspinner.MaterialSpinner;

public class ProfilePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        MaterialSpinner spinner = (MaterialSpinner) findViewById(R.id.currencySpinner);
        spinner.setItems("EUR", "YEN", "US", "UK", "EQRJH VBOWRINL");

        BottomNavigationView bnv = (BottomNavigationView) findViewById(R.id.bottomBar);
        bnv.getMenu().getItem(2).setChecked(true);

        bnv.getMenu().getItem(0).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent(getApplicationContext(), NotLoggedHomeActivity.class);
                startActivity(intent);
                return true;
            }
        });

        bnv.getMenu().getItem(1).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Toast t = Toast.makeText(getApplicationContext(), "a puttan e mammt!", Toast.LENGTH_LONG);
                t.show();
                return true;
            }
        });

        bnv.getMenu().getItem(2).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                return false;
            }
        });
    }

    public void startHome(View view) {
        Toast t = Toast.makeText(getApplicationContext(), "Succesfully logout!", Toast.LENGTH_LONG);
        t.show();
        Intent intent = new Intent(this, NotLoggedHomeActivity.class);
        startActivity(intent);
    }

    public void passwordChanged(View view) {
        Toast t = Toast.makeText(getApplicationContext(), "Password changed!", Toast.LENGTH_LONG);
        t.show();
    }
}
