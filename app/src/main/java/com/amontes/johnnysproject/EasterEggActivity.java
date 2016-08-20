package com.amontes.johnnysproject;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class EasterEggActivity extends AppCompatActivity {

    Button backButton;
    MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easter_egg);

        mPlayer = MediaPlayer.create(EasterEggActivity.this, R.raw.input);
        mPlayer.start();

        backButton = (Button)findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }

        });

    }

    //Clean up.


    @Override
    protected void onDestroy() {
        super.onDestroy();

        mPlayer.stop();

    }

}