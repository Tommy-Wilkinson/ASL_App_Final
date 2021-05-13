package com.cse535.aslclassifyapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class PracticeActivity extends Activity {
    String selectedGesture;
    SharedPreferences sharedPreferences;
    String userLastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        Intent intent = getIntent();
        selectedGesture = intent.getExtras() != null ? intent.getExtras().getString(AppConstants.EXTRA_SEL_GESTURE_KEY) : "UNKNOWN";

        if (null == savedInstanceState) {
            Bundle bundle = new Bundle();
            bundle.putString(AppConstants.EXTRA_SEL_GESTURE_KEY, selectedGesture);

            sharedPreferences = getSharedPreferences(AppConstants.ASL_APP, Context.MODE_PRIVATE);
            userLastName = sharedPreferences.getString(AppConstants.SP_LAST_NAME_KEY, null);
            bundle.putString(AppConstants.SP_LAST_NAME_KEY, userLastName);

            Log.d("PracticeActivity", userLastName);
            Camera2VideoFragment fragment = Camera2VideoFragment.newInstance();
            fragment.setArguments(bundle);


            // AutoFitTextureView and Camera2VideoFragment obtained from https://github.com/android/camera-samples/tree/master/Camera2VideoJava
            // and modified for this assignment
            getFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        }
    }
}
