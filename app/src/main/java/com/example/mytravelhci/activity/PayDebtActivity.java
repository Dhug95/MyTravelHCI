package com.example.mytravelhci.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mytravelhci.R;
import com.jaredrummler.materialspinner.MaterialSpinner;

public class PayDebtActivity extends AppCompatActivity {

    TextView receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_debt);

        MaterialSpinner spinner = (MaterialSpinner) findViewById(R.id.currencySpinner);
        spinner.setItems("EUR", "JPY", "USD", "GBP");
        spinner.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        receiver = findViewById(R.id.receiver);

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


    public void chooseUser(View view) {
        AlertDialog ad = new AlertDialog.Builder(this)
                .setTitle("Choose user")
                .setPositiveButton("Cancel", null)
                .setItems(R.array.users, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        receiver.setText(getResources().getStringArray(R.array.users)[i]);
                    }
                })
                .show();
    }

    public void goToPayment(View view) {
        Intent intent = new Intent(this, TripPageActivity.class);
        intent.putExtra("debt_paid", true);
        intent.putExtra("frag_to_set", "payments");
        startActivity(intent);
    }
}
