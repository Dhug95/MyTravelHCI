package com.example.mytravelhci.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
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
        spinner.setHint("Select Currency");
        spinner.setItems("EUR", "YEN", "US", "UK");
        spinner.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);


        /*spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
            }
        });*/
    }

    public void startHome(View view) {
        Toast t = Toast.makeText(getApplicationContext(),"Account created!",Toast.LENGTH_LONG);
        t.show();
        Intent intent = new Intent(this, NotLoggedHomeActivity.class);
        startActivity(intent);
    }
}
