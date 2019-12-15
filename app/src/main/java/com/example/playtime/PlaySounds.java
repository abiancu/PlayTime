package com.example.playtime;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.os.Build;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class PlaySounds extends AppCompatActivity {

    private SoundPool sounds;
    private int song1, song2, song3;
    private VideoView vidView = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_sounds);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            // see else statement, same attributes
            sounds = new SoundPool.Builder()
                    .setMaxStreams(6)
                    .setAudioAttributes(audioAttributes)
                    .build();

            // else SDK is 20 use the old Constructor
            // maxStreams - how many sounds to play in the pool
            // AudioManager - the type of music to play
            // srcQuality - never implemented
        } else {
            sounds = new SoundPool(6, AudioManager.STREAM_MUSIC, 0);
        }

        //load music
        song1 = sounds.load(this, R.raw.sound1, 1);
        song2 = sounds.load(this, R.raw.song2, 1);
        song3 = sounds.load(this, R.raw.song3, 1);


        vidView = findViewById(R.id.videoView);
        vidView.setMediaController(new MediaController(this)); // this adds the media controller
        Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.song1);
        vidView.setVideoURI(video);
        vidView.setZOrderOnTop(true); //don't merge video with other widgets
    }

    public void playSound(View v){
        switch (v.getId()){
            case R.id.button_sound1:
                sounds.play(song1,1,1,0,0,1);
                sounds.autoPause();
                break;
            case R.id.button_sound2:
                sounds.play(song2,1,1,0,0,1);
                sounds.autoPause();
                break;
            case R.id.button_sound3:
                sounds.play(song3,1,1,0,0,1);
                sounds.autoPause();
                break;
        }
    }

}
