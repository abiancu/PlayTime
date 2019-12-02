package com.example.playtime;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class GuessNumber extends AppCompatActivity implements View.OnClickListener{

    EditText et_min, et_max;
    Button btn_Enter;
    TextView tv_output;
    Random rand;
    int min, max, output;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_number);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        /*Variables */
        et_min = findViewById(R.id.et_min);
        et_max = findViewById(R.id.et_max);
        btn_Enter = findViewById(R.id.btnEnter);
        tv_output = findViewById(R.id.tv_output);

        /*seeding random numbers*/
        rand = new Random();
        btn_Enter.setOnClickListener(this);




        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        /*local variables*/
        String tempMin, tempMax;

        tempMin = et_min.getText().toString();
        tempMax = et_max.getText().toString();

        if(tempMin.equals("") && !tempMax.equals("")){
            min = Integer.parseInt(tempMin);
            max = Integer.parseInt(tempMax);

            //convert to int to check the display
            if(max > min){
                output = rand.nextInt((max - min) + 1) + min;

                //displaying the number
                tv_output.setText(output);
            }

        }
    }
}
