package com.cse535.aslclassifyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner gestureSpinner;
    SharedPreferences sharedPreferences;
    String userLastName;
    EditText lastNameField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gestureSpinner = findViewById(R.id.gestureSpinner);
        gestureSpinner.setOnItemSelectedListener(this);

        sharedPreferences = getSharedPreferences(AppConstants.ASL_APP, Context.MODE_PRIVATE);
        userLastName = sharedPreferences.getString(AppConstants.SP_LAST_NAME_KEY, null);

        lastNameField = findViewById(R.id.lastName);
        if (userLastName != null && userLastName.length() > 0) {
            lastNameField.setText(userLastName);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        final String selectedGesture = parent.getItemAtPosition(position).toString();

        if (selectedGesture.equalsIgnoreCase("Select a gesture...")) {
            Toast.makeText(getBaseContext(), "Please select a gesture in order to proceed.",
                    Toast.LENGTH_LONG).show();
            return;
        }

        userLastName = lastNameField.getText().toString();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(AppConstants.SP_LAST_NAME_KEY, userLastName);
        editor.apply();

        if (userLastName == null || userLastName.length() == 0) {
            Toast.makeText(getBaseContext(), "Please enter your last name in order to proceed.",
                    Toast.LENGTH_LONG).show();
            return;
        }

        Log.d("MainActivity", "last name : " + userLastName);
        proceedToVideoActivity(selectedGesture);
    }

    public void proceedToVideoActivity(String selectedGesture) {
        Intent intent = new Intent(MainActivity.this, VideoActivity.class);
        intent.putExtra(AppConstants.EXTRA_SEL_GESTURE_KEY, selectedGesture);
        startActivity(intent);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) { }
}
