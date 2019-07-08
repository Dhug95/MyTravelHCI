package com.example.mytravelhci.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import com.example.mytravelhci.R;
import com.jaredrummler.materialspinner.MaterialSpinner;

public class EditPayment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_payment);
        MaterialSpinner spinner = findViewById(R.id.currencySpinner);
        spinner.setItems("EUR", "USD", "GBP", "JPY");
        spinner.setText("EUR");

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_white_24dp);

        // Enable the Up button
        ab.setHomeAsUpIndicator(upArrow);
        ab.setDisplayHomeAsUpEnabled(true);
    }

    public void showDatePicker(View view) {
        Integer iddio = Integer.valueOf(view.getId());
        DatePickerFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), iddio.toString());
    }

    public void goToSplit(View view){
        Intent intent = new Intent(this, CostSplitActivity.class);
        startActivity(intent);
    }
}
