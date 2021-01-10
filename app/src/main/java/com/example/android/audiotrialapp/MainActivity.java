package com.example.android.audiotrialapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mp; // for keeping state of play
    private AudioManager am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mp = MediaPlayer.create(this, R.raw.alert_air_horn);
        am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        attachListeners();
    }


    public void attachListeners() {
        findViewById(R.id.playButton).setOnClickListener(v -> {
            v = (ImageView) v;
            if (mp.isPlaying())
                mp.pause();
            else
                mp.start();
        });
    }

    public void addVolume(View view) {
        if (!am.isVolumeFixed())
            am.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
    }

    public void decreaseVolume(View view) {
        if (!am.isVolumeFixed())
            am.adjustVolume(AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI);
    }
}