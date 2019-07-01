package com.example.mytravelhci.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.mytravelhci.R;

public class HomePageActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }

    public void goToSignup(View view) { //In realtà dovrebbe andare nella LoggedHome
        Intent intent = new Intent(this, SignupPage.class);
        startActivity(intent);
    }

    public void goCurrency(View view) {
        Intent intent = new Intent(this, Currency.class);
        startActivity(intent);
    }

    public void goToProfile(View view) {
        Intent intent = new Intent(this, ProfilePage.class);
        startActivity(intent);
    }
}
