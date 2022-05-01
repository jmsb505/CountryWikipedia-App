package com.example.paises;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.os.Bundle;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private MainActivity_fragment continents;
    private AssetManager assetManager;
    CountryData instance=CountryData.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        continents=new MainActivity_fragment();
        assetManager=getAssets();
        getSupportFragmentManager().beginTransaction().replace(R.id.continentFL,continents).commit();
    }
    @Override
    protected void onStart(){
        super.onStart();

    }
}