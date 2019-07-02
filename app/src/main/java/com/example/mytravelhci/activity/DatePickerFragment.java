package com.example.mytravelhci.activity;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.widget.DatePicker;

import java.util.Calendar;


public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener{


    public DatePickerFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker.
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        if(getActivity().getClass().toString().contains("AddTrip")) {
            AddTrip activity = (AddTrip) getActivity();
            activity.processDatePickerResult(year, month, day, getTag());
        }
        else if(getActivity().getClass().toString().contains("EditTrip")){
            EditTrip activity = (EditTrip) getActivity();
            activity.processDatePickerResult(year, month, day, getTag());
        }
        else{

        }
    }
}
