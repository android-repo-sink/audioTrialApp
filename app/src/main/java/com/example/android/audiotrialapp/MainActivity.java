package com.example.android.audiotrialapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mp = MediaPlayer.create(this, R.raw.alert_air_horn);
        attachListeners();
    }

    private MediaPlayer mp; // for keeping state of play

    public void attachListeners() {
        findViewById(R.id.playButton).setOnClickListener(v -> {
            v = (ImageView) v;
            if (mp.isPlaying()) {
                ((ImageView) v).setImageResource(android.R.drawable.ic_media_play);
            } else {
                ((ImageView) v).setImageResource(android.R.drawable.ic_media_pause);
                mp.start();
            }
        });
    }

    public void addVolume(View view) {
    }

    public void decreaseVolume(View view) {
    }
}