package com.example.playtime;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class NameCapital extends AppCompatActivity{

    TextView displayCountry;
    String countryName;
    InputStream country;


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

        //loadJSON();

        displayCountry = findViewById(R.id.txtCountryToGuess);

        try
        {
            //getting the JSON file
            JSONObject obj = new JSONObject(loadJSON());

            //getting the JSON array
            JSONArray countries = obj.getJSONArray("countries");

            //loop through the list
            for(int i = 0; i < countries.length(); i++)
            {
                //each object in the countries array
                JSONObject name = countries.getJSONObject(i);
                countryName = name.getString("country");
                displayCountry.setText(countryName);
            }

        } catch (JSONException e){
            e.printStackTrace();
        }


    }


    //METHOD TO LOAD JSON FILE
    public String loadJSON(){
        String countries_json;
        try
        {
            country = getAssets().open("samplecountry.json");
            int size = country.available();
            byte[] buffer = new byte[size];
            country.read(buffer);
            country.close();
            countries_json = new String(buffer, "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return countries_json;
    }
}
