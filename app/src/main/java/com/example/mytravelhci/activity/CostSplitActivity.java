package com.example.mytravelhci.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.mytravelhci.R;
import com.google.android.material.button.MaterialButton;

public class CostSplitActivity extends AppCompatActivity {

    private CheckBox mebox;
    private CheckBox user2box;
    private CheckBox user3box;
    private CheckBox selectAllBox;

    private TextView price1;
    private TextView price2;
    private TextView price3;

    private final static float total = 63.f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cost_split);

        //Carmine

        mebox = findViewById(R.id.me_checkbox);
        user2box = findViewById(R.id.user2_checkbox);
        user3box = findViewById(R.id.user3_checkbox);
        selectAllBox = findViewById(R.id.checkBox);

        price1 = findViewById(R.id.price_1);
        price2 = findViewById(R.id.price_2);
        price3 = findViewById(R.id.price_3);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_white_24dp);

        // Enable the Up button
        ab.setHomeAsUpIndicator(upArrow);
        ab.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        boolean edited = intent.getBooleanExtra("edited", false);
        if (edited) {
            mebox.setChecked(true);
            user2box.setChecked(true);
            user3box.setChecked(true);
            selectAllBox.setChecked(true);
            updatePrice(selectAllBox);
            MaterialButton addButton = findViewById(R.id.doneBtn);
            addButton.setText("Save changes");
        }
    }

    public void selectEveryone(View view) {
        if (!selectAllBox.isChecked()) {
            mebox.setChecked(false);
            user2box.setChecked(false);
            user3box.setChecked(false);
            selectAllBox.setChecked(false);
            updatePrice(view);
        } else {
            mebox.setChecked(true);
            user2box.setChecked(true);
            user3box.setChecked(true);
            selectAllBox.setChecked(true);
            updatePrice(view);
        }
    }

    public void resetBoxes(View view) {
        mebox.setChecked(false);
        user2box.setChecked(false);
        user3box.setChecked(false);
        selectAllBox.setChecked(false);
        updatePrice(view);
    }

    public void updatePrice(View view) {
        float count = 0.f;
        if (mebox.isChecked()) count++;
        if (user2box.isChecked()) count++;
        if (user3box.isChecked()) count++;
        if (mebox.isChecked()) {
            price1.setText("-€" + String.valueOf(total / count));
            price1.setTextColor(getColor(R.color.customRed));
        } else {
            price1.setText("-€0.00");
            price1.setTextColor(getColor(R.color.hintGray));

        }
        if (user2box.isChecked()) {
            price2.setText("-€" + String.valueOf(total / count));
            price2.setTextColor(getColor(R.color.customRed));
        } else {
            price2.setText("-€0.00");
            price2.setTextColor(getColor(R.color.hintGray));
        }
        if (user3box.isChecked()) {
            price3.setText("-€" + String.valueOf(total / count));
            price3.setTextColor(getColor(R.color.customRed));

        } else {
            price3.setText("-€0.00");
            price3.setTextColor(getColor(R.color.hintGray));

        }
    }

    public void goToPayRecap(View view) {
        Intent intent = new Intent(this, Payment_Recap.class);
        intent.putExtra("added", true);
        startActivity(intent);
    }
}
