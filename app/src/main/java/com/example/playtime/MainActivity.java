package com.example.playtime;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //ADD LISTENERS
        Button btnNumGame = findViewById(R.id.btnGame1);
        btnNumGame.setOnClickListener(this);

        Button btnNameCap = findViewById(R.id.btnGame2);
        btnNameCap.setOnClickListener(this);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override public void onClick(View v){
        Button btnGuessNum = findViewById(R.id.btnGame1);
        Button btnNameCap = findViewById(R.id.btnGame2);

        //go to another activity
        //TODO: call the new activity method
       switch (v.getId()){
           case R.id.btnGame1:
               gussNumActivity();
               break;
           case R.id.btnGame2:
               nameCapActivity();
               break;

       }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    //intent methods
    public void gussNumActivity(){
        Intent intent = new Intent(MainActivity.this, GuessNumber.class);
        this.startActivity(intent);
    }

    public void nameCapActivity(){
        Intent intent = new Intent(MainActivity.this, NameCapital.class);
        this.startActivity(intent);
    }


}
