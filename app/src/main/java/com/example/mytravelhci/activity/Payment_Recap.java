package com.example.mytravelhci.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.mytravelhci.R;
import com.google.android.material.snackbar.Snackbar;

public class Payment_Recap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment__recap);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setOverflowIcon(getDrawable(R.drawable.ic_dots_white_24dp));

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_white_24dp);

        // Enable the Up button
        ab.setHomeAsUpIndicator(upArrow);
        ab.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        boolean added = intent.getBooleanExtra("added", false);
        if (added) {
            Snackbar mySnackbar = Snackbar.make(findViewById(R.id.coordinator),
                    "Payment added!", Snackbar.LENGTH_SHORT);
            mySnackbar.getView().setBackgroundResource(R.color.customGreen);
            mySnackbar.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.trip_menu, menu);
        return true;
    }

    public void goToEdit(MenuItem item) {
        Intent intent = new Intent(this, EditPayment.class);
        startActivity(intent);
    }

    public void deleteTrip(MenuItem item) {
        final Context thisContext = this;
        AlertDialog ad = new AlertDialog.Builder(this)
                .setTitle("Confirm deletion")
                .setMessage("Are you sure you want to delete this payment?")
                .setPositiveButton("Cancel", null)
                .setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        Intent intent = new Intent(thisContext, TripPageActivity.class);
                        intent.putExtra("frag_to_set", "payments");
                        intent.putExtra("pay_deleted", true);
                        thisContext.startActivity(intent);
                    }
                })
                .show();
        ad.getButton(ad.BUTTON_NEGATIVE).setTextColor(getResources().getColor(R.color.customRed));
    }

}
