package com.example.paises;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.os.Bundle;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private MainActivity_fragment continents;
    AssetManager assetManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        continents=new MainActivity_fragment();
        assetManager=getAssets();
        getSupportFragmentManager().beginTransaction().replace(R.id.continentFL,continents).commit();
        try {
            continents.loadGeography(assetManager);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void onStart(){
        super.onStart();

    }
}