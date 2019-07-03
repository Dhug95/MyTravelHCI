package com.example.mytravelhci.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mytravelhci.R;
import com.google.android.material.snackbar.Snackbar;
import com.jaredrummler.materialspinner.MaterialSpinner;

import java.util.ArrayList;
import java.util.List;

public class SignupPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);

        MaterialSpinner spinner = (MaterialSpinner) findViewById(R.id.currencySpinner);
        spinner.setItems("Select Currency", "EUR", "YEN", "US", "UK");
        spinner.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_white_24dp);

        // Enable the Up button
        ab.setHomeAsUpIndicator(upArrow);
        ab.setDisplayHomeAsUpEnabled(true);

        /*spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
            }
        });*/
    }

    public void startHome(View view) {
        Intent intent = new Intent(this, LoggedHomeActivity.class);
        intent.putExtra("registered", true);
        startActivity(intent);
    }
}
