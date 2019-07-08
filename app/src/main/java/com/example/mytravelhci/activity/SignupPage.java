package com.example.mytravelhci.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;

import com.example.mytravelhci.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.jaredrummler.materialspinner.MaterialSpinner;

public class SignupPage extends AppCompatActivity {

    TextInputEditText tlEtPassword;

    TextInputLayout tilPasswordLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);

        tilPasswordLayout = (TextInputLayout) findViewById(R.id.til_password_layout);

        tlEtPassword = (TextInputEditText) findViewById(R.id.tiet_password);

        tlEtPassword.addTextChangedListener(new EditTextWatcher(this, tilPasswordLayout, tlEtPassword));

        MaterialSpinner spinner = (MaterialSpinner) findViewById(R.id.currencySpinner);
        spinner.setItems("Select", "EUR", "JPY", "USD", "GBP");
        spinner.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

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


    class EditTextWatcher implements TextWatcher {

        TextInputLayout layout;

        TextInputEditText view;

        Context context;

        public EditTextWatcher(Context con, TextInputLayout layout, TextInputEditText view) {

            this.view = view;

            this.layout = layout;

            this.context = con;

        }

        @Override

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override

        public void afterTextChanged(Editable editable) {

            switch (view.getId()) {

                case R.id.tiet_password:

                    if (isPasswordValid(tlEtPassword.getText().toString()) == false) {

                        tilPasswordLayout.setError("Invalid Password");

                        tlEtPassword.requestFocus();

                    } else {

                        tilPasswordLayout.setErrorEnabled(false);

                    }

                    break;

            }

        }

    }

    public static boolean isPasswordValid(String password) {

        return !TextUtils.isEmpty(password) && password.trim().length() == 8;

    }

}
