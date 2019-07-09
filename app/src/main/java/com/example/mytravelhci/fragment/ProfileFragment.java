package com.example.mytravelhci.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mytravelhci.R;
import com.google.android.material.snackbar.Snackbar;
import com.jaredrummler.materialspinner.MaterialSpinner;


public class ProfileFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        MaterialSpinner spinner = (MaterialSpinner) v.findViewById(R.id.currencySpinner);
        spinner.setItems("EUR", "JPY", "USD", "GBP");
        spinner.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                Snackbar.make(view, "New currency: " + item, Snackbar.LENGTH_SHORT).show();
            }
        });

        // Inflate the layout for this fragment
        return v;
    }

}
