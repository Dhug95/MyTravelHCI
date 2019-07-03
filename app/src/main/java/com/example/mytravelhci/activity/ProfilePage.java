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
