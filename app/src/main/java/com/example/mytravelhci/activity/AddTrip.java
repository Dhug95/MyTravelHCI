package com.example.mytravelhci.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DialogFragment;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.mytravelhci.R;
import com.google.android.material.button.MaterialButton;

public class AddTrip extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trip);

        MaterialButton departingButton = findViewById(R.id.departingButton);
        MaterialButton returnButton = findViewById(R.id.returnButton);

        departingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePicker(view);
            }
        });
        returnButton.setOnClickListener(new View.OnClickListener() {
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

        switch(Integer.parseInt(id)){
            case R.id.departingButton:{
                EditText departing = findViewById(R.id.departing);
                departing.setText(dateMessage);
                break;
            }
            case R.id.returnButton:{
                EditText arrival = findViewById(R.id.arrival);
                arrival.setText(dateMessage);
                break;
            }

        }
    }

    public void gotoLoggedHome(View view) {
        Intent intent = new Intent(this, LoggedHomeActivity.class);
        intent.putExtra("frag_to_set", "trips");
        intent.putExtra("Trip added!", true);
        startActivity(intent);
    }
}
