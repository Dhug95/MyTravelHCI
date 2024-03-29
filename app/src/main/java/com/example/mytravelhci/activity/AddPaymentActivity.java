package com.example.mytravelhci.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.mytravelhci.R;
import com.google.android.material.button.MaterialButton;
import com.jaredrummler.materialspinner.MaterialSpinner;

public class AddPaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_payment);

        MaterialSpinner spinner = (MaterialSpinner) findViewById(R.id.currencySpinner);
        spinner.setItems("EUR", "JPY", "USD", "GBP");
        spinner.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        MaterialSpinner category_spinner = (MaterialSpinner) findViewById(R.id.categorySpinner);
        category_spinner.setItems("Food and drinks", "Transportation", "Shopping", "Other");
        category_spinner.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_white_24dp);

        // Enable the Up button
        ab.setHomeAsUpIndicator(upArrow);
        ab.setDisplayHomeAsUpEnabled(true);

        MaterialButton departingButton = findViewById(R.id.departingButton);
        departingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePicker(view);
            }
        });
    }

    public void showDatePicker(View view) {
        Integer iddio = Integer.valueOf(view.getId());
        DatePickerFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), iddio.toString());
    }

    public void processDatePickerResult(int year, int month, int day, String id) {
        String month_string = Integer.toString(month + 1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (month_string + "/"
                + day_string + "/" + year_string);

        switch (Integer.parseInt(id)) {
            case R.id.departing:
            case R.id.departingButton: {
                EditText departing = findViewById(R.id.departing);
                departing.setText(dateMessage);
                break;
            }
            case R.id.arrival:
            case R.id.returnButton: {
                EditText arrival = findViewById(R.id.arrival);
                arrival.setText(dateMessage);
                break;
            }

        }
    }

    public void goToSplit(View view) {
        Intent intent = new Intent(this, CostSplitActivity.class);
        startActivity(intent);
    }
}
