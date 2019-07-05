package com.example.mytravelhci.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;


import com.example.mytravelhci.R;
import com.example.mytravelhci.SideMenuClass;
import com.google.android.material.snackbar.Snackbar;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.mikepenz.materialdrawer.Drawer;

public class Currency extends AppCompatActivity {

    MaterialSpinner spinner;
    MaterialSpinner spinner2;

    private Drawer drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        drawer = new SideMenuClass(this).drawer;

        spinner = (MaterialSpinner) findViewById(R.id.spinner);
        spinner.setItems("EUR", "USD", "GBP", "JPY");
        /*spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
            }
        });*/

        spinner2 = (MaterialSpinner) findViewById(R.id.spinner2);
        spinner2.setItems("EUR", "USD", "GBP", "JPY");
        /*spinner2.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
            }
        });*/

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

    public void swapCurrency(View view) {
        int value = spinner.getSelectedIndex();
        spinner.setSelectedIndex(spinner2.getSelectedIndex());
        spinner2.setSelectedIndex(value);
    }
}
