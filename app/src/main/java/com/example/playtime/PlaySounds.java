package com.example.playtime;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.os.Build;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;


public class PlaySounds extends AppCompatActivity {

    MediaPlayer player;



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

    }


    public void play(View v){
        if(player == null){
            switch (v.getId()) {

                case R.id.button_sound1:
                    player = MediaPlayer.create(this, R.raw.song1);
                    break;
                case R.id.button_sound2:
                    player = MediaPlayer.create(this, R.raw.song2);
                    break;
                case R.id.button_sound3:
                    player = MediaPlayer.create(this, R.raw.sound1);
                    break;
            }
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }

        player.start();
    }

    public void pause(View v){
        if(player != null)
            player.pause();

    }

    public void stop(View v){
        stopPlayer();
    }

    private void stopPlayer(){
        if(player != null){
            player.release();
            player = null;
        }
    }

    @Override protected void onStop(){
        super.onStop();
        stopPlayer();
    }
}
