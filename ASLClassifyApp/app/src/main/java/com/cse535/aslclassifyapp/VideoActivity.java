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
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {
    String selectedGesture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        Intent intent = getIntent();
        selectedGesture = intent.getExtras() != null ? intent.getExtras().getString(AppConstants.EXTRA_SEL_GESTURE_KEY) : "UNKNOWN";

        TextView gestureName = findViewById(R.id.gestureName);
        gestureName.setText(selectedGesture);

        final VideoView gestureVideo = findViewById(R.id.gestureVideo);
        setGestureVideoURI(gestureVideo);
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

        Button practiceButton = findViewById(R.id.practiceButton);
        practiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VideoActivity.this, PracticeActivity.class);
                intent.putExtra(AppConstants.EXTRA_SEL_GESTURE_KEY, selectedGesture);
                startActivity(intent);
            }
        });
    }

    protected void setGestureVideoURI(final VideoView vv) {
        String uriString;
        if (AppConstants.USE_GESTURE_URLS) {
            uriString = AppConstants.GESTURE_URLS.get(selectedGesture);
        } else {
            uriString = "android.resource://" + getPackageName() + "/" +
                    AppConstants.GESTURE_LOCAL_IDS.get(selectedGesture);
        }
        vv.setVideoURI(Uri.parse(uriString));
    }

    protected int getVideoId(String gesture) {
        if (gesture.equalsIgnoreCase("buy")) {
            return R.raw.buy;
        } else if (gesture.equalsIgnoreCase("house")) {
            return R.raw.house;
        } else if (gesture.equalsIgnoreCase("fun")) {
            return R.raw.fun;
        } else if (gesture.equalsIgnoreCase("hope")) {
            return R.raw.hope;
        } else if (gesture.equalsIgnoreCase("arrive")) {
            return R.raw.arrive;
        } else if (gesture.equalsIgnoreCase("really")) {
            return R.raw.really;
        } else if (gesture.equalsIgnoreCase("read")) {
            return R.raw.read;
        } else if (gesture.equalsIgnoreCase("lip")) {
            return R.raw.lip;
        } else if (gesture.equalsIgnoreCase("mouth")) {
            return R.raw.mouth;
        } else if (gesture.equalsIgnoreCase("some")) {
            return R.raw.some;
        } else if (gesture.equalsIgnoreCase("communicate")) {
            return R.raw.communicate;
        } else if (gesture.equalsIgnoreCase("write")) {
            return R.raw.write;
        } else if (gesture.equalsIgnoreCase("create")) {
            return R.raw.create;
        } else if (gesture.equalsIgnoreCase("pretend")) {
            return R.raw.pretend;
        } else if (gesture.equalsIgnoreCase("sister")) {
            return R.raw.sister;
        } else if (gesture.equalsIgnoreCase("man")) {
            return R.raw.man;
        } else if (gesture.equalsIgnoreCase("one")) {
            return R.raw.one;
        } else if (gesture.equalsIgnoreCase("drive")) {
            return R.raw.drive;
        } else if (gesture.equalsIgnoreCase("perfect")) {
            return R.raw.perfect;
        } else if (gesture.equalsIgnoreCase("mother")) {
            return R.raw.mother;
        }

        return 0;
    }
}
