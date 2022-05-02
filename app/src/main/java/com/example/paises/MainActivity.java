package com.example.paises;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetManager;
import android.os.Bundle;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private MainActivity_fragment continents;
    private CountryActivity_fragment countries;
    private AssetManager assetManager;
    private FragmentManager fragmentManager;
    CountryData instance=CountryData.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        continents=new MainActivity_fragment();
        fragmentManager=getSupportFragmentManager();
        assetManager=getAssets();
        getSupportFragmentManager().beginTransaction().replace(R.id.continentFL,continents).addToBackStack(null).commit();
        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver,
                new IntentFilter("custom-message"));
    }
    public BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // Get extra data included in the Intent
            String continentName = intent.getStringExtra("Continent");
           Integer orientation = intent.getIntExtra("Orientation",0);
            countries=new CountryActivity_fragment(continentName,orientation);
            fragmentManager.beginTransaction().replace(R.id.continentFL,countries).addToBackStack(null).commit();

        }
    };

    @Override
    protected void onStart(){
        super.onStart();

    }
}