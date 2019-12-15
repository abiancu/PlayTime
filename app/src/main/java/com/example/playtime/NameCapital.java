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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class NameCapital extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_capital);
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


        TextView county = findViewById(R.id.txtCountry);
        TextView capital = findViewById(R.id.txtCapital);
        Button btn_ncEnter = findViewById(R.id.btn_ncEnter);

        try {
            JSONObject obj = new JSONObject(readJSONFromAsset());
            JSONArray countries = obj.getJSONArray("samplecountry.json");

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }


    public String readJSONFromAsset() {
        String json = null;
        try {
            InputStream input = getAssets().open("samplecountry.json");
            int size = input.available();
            byte[] buffer = new byte[size];
            input.read(buffer);
            input.close();
            json = new String(buffer, "UTF-8");
        }catch (IOException ex){
            ex.printStackTrace();
            return  null;
        }
        return json;
    }
}
