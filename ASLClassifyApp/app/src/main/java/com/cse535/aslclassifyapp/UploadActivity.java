package com.cse535.aslclassifyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;

import com.loopj.android.http.*;

import cz.msebera.android.httpclient.Header;


public class UploadActivity extends AppCompatActivity {
    String selectedGesture;
    String videoPath;
    String TAG = "UploadActivityClass";
    String POST_URL="http://10.0.2.2:5000/uploader";
    //String POST_URL="http://0.0.0.0:5000/uploader";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        Intent intent = getIntent();
        selectedGesture = intent.getExtras() != null ? intent.getExtras().getString(AppConstants.EXTRA_SEL_GESTURE_KEY) : "UNKNOWN";

        TextView gestureName = findViewById(R.id.uploadGestureName);
        gestureName.setText(selectedGesture);

        videoPath = intent.getExtras() != null ? intent.getExtras().getString(AppConstants.EXTRA_VIDEO_ABS_PATH) : "UNKNOWN";

        final VideoView gestureVideo = findViewById(R.id.uploadGestureVideo);
        gestureVideo.setVideoURI(Uri.fromFile(new File(videoPath)));
        gestureVideo.requestFocus();

        gestureVideo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                gestureVideo.start();
            }
        });
        gestureVideo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                gestureVideo.start();
            }
        });

        Button uploadButton = findViewById(R.id.uploadButton);
        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: add logic for upload here
                // videoPath = path to video


                File sourceFile = new File(videoPath);
                final String file_name = sourceFile.getName();
                if (sourceFile.isFile()) {
                    Log.e(TAG, "Uploading file " + sourceFile.getAbsolutePath());
                    byte[] myByteArray = new byte[(int) sourceFile.length()];
                    RequestParams params = new RequestParams();
                    try {
                        params.put("uploaded_file", sourceFile, file_name);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    AsyncHttpClient client = new AsyncHttpClient();
                    client.post(POST_URL, params, new AsyncHttpResponseHandler() {
                        @Override
                        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                            if (statusCode == 200) {
                                Toast.makeText(getApplication().getBaseContext(), "Practice Video Uploaded Successfully", Toast.LENGTH_LONG).show();
                                Log.e("SUCCESS", "The Practice video uploaded successfully");
                            }
                        }
                        @Override
                        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                            Toast.makeText(getBaseContext(), "Upload failed! Please try again later.",
                                    Toast.LENGTH_LONG).show();
                            Log.e("FAILURE", "Something went wrong. Please try again later.");
                        }
                    });
                    Intent intent = new Intent(UploadActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Log.e(TAG, "Invalid File");
                }
            }
        });
    }
}
