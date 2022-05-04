package com.example.paises;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.os.Bundle;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {
    private MainActivity_fragment continents;
    private CountryActivity_fragment countries;
    private WebActivity_fragment web;
    private AssetManager assetManager;
    private FragmentManager fragmentManager;
    private boolean isPhone=true;
    private boolean hasCountries=false;
    private boolean hasWeb=false;
    CountryData instance=CountryData.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        continents=new MainActivity_fragment();
        fragmentManager=getSupportFragmentManager();
        assetManager=getAssets();
        try {
            loadGeography();
        } catch (IOException e) {
            e.printStackTrace();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.continentFL,continents).commit();
        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver,
                new IntentFilter("custom-message"));
        int screenSize = getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK;

        if (screenSize == Configuration.SCREENLAYOUT_SIZE_LARGE ||
                screenSize == Configuration.SCREENLAYOUT_SIZE_XLARGE)
            isPhone = false;

        if(isPhone) {
            setRequestedOrientation(
                    ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

    }
    public BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            int i=intent.getIntExtra("intent",0);
            if(i==0) {
                String continentName = intent.getStringExtra("Continent");
                Integer orientation = intent.getIntExtra("Orientation", 0);
                countries = new CountryActivity_fragment(continentName, orientation);
                if(isPhone) {
                    fragmentManager.beginTransaction().replace(R.id.continentFL, countries).addToBackStack(null).commit();
                }
                else{

                    if(hasCountries) {
                        fragmentManager.beginTransaction().replace(R.id.countryFL, countries).commit();
                    }
                    else{
                        fragmentManager.beginTransaction().add(R.id.countryFL, countries).commit();
                        hasCountries=true;
                    }

                }


            }
            else{
                String countryName = intent.getStringExtra("Country");
                Integer orientation = intent.getIntExtra("Orientation", 0);
                 web= new WebActivity_fragment(countryName, orientation);
                if(isPhone) {
                    fragmentManager.beginTransaction().replace(R.id.continentFL, web).addToBackStack(null).commit();}
                else{
                    if(hasWeb) {
                        fragmentManager.beginTransaction().replace(R.id.webFL, web).commit();
                    }
                    else{
                        fragmentManager.beginTransaction().add(R.id.webFL, web).commit();;
                        hasWeb=true;
                    }

                }

            }

        }
    };
    public void loadGeography() throws IOException{
        assetManager= getResources().getAssets();
        String[] filesAfrica=assetManager.list("Africa");
        String[] filesAsia=assetManager.list("Asia");
        String[] filesEurope=assetManager.list("Europe");
        String[] filesNorthAmerica=assetManager.list("North_America");
        String[] filesOceania=assetManager.list("Oceania");
        String[] filesSouthAmerica=assetManager.list("South_America");
        String[] filesContinents=assetManager.list("Continents");
        List<Flag> listCont= Arrays.stream(filesContinents).map(e->{
            String sub2=e.replaceAll("Continent.png","");
            instance.setContador(sub2,0);
            Flag f=new Flag(sub2,"Continents/"+e);
            return f;
        }).collect(Collectors.toList());
        listCont.forEach(e->instance.addContinent(e.getTitle(),e.getimageUrl()));

        List<Flag> listaAf=Arrays.stream(filesAfrica).map(e->{
            String[] sub=e.split("-");
            String sub2=sub[1].replaceAll(".png","");
            Flag f=new Flag(sub2,"Africa/"+e);
            return f;
        }).collect(Collectors.toList());
        System.out.println(listaAf.get(52).getTitle());

        listaAf.forEach(e->instance.addPicture(e.getTitle(),e.getimageUrl()));
        instance.setContador("Africa",listaAf.size());

        List<Flag> listaAs=Arrays.stream(filesAsia).parallel().map(e->{
            String[] sub=e.split("-");
            String sub2=sub[1].replaceAll(".png","");
            Flag f=new Flag(sub2,"Asia/"+e);
            return f;
        }).collect(Collectors.toList());
        listaAs.forEach(e->instance.addPicture(e.getTitle(),e.getimageUrl()));
        instance.setContador("Asia",listaAs.size());

        List<Flag>listaEU=Arrays.stream(filesEurope).parallel().map(e->{
            String[] sub=e.split("-");
            String sub2=sub[1].replaceAll(".png","");
            Flag f=new Flag(sub2,"Europe/"+e);
            return f;
        }).collect(Collectors.toList());
        listaEU.forEach(e->instance.addPicture(e.getTitle(),e.getimageUrl()));
        instance.setContador("Europe",listaEU.size());

        List<Flag>listaOC=Arrays.stream(filesOceania).parallel().map(e->{
            String[] sub=e.split("-");
            String sub2=sub[1].replaceAll(".png","");
            Flag f=new Flag(sub2,"Oceania/"+e);
            return f;
        }).collect(Collectors.toList());
        listaOC.forEach(e->instance.addPicture(e.getTitle(),e.getimageUrl()));
        instance.setContador("Oceania",listaOC.size());

        List<Flag>listaNA=Arrays.stream(filesNorthAmerica).parallel().map(e->{
            String[] sub=e.split("-");
            String sub2=sub[1].replaceAll(".png","");
            Flag f=new Flag(sub2,"North_America/"+e);
            return f;
        }).collect(Collectors.toList());
        listaNA.forEach(e->instance.addPicture(e.getTitle(),e.getimageUrl()));
        instance.setContador("North_America",listaNA.size());

        List<Flag>listaSA=Arrays.stream(filesSouthAmerica).parallel().map(e->{
            String[] sub=e.split("-");
            String sub2=sub[1].replaceAll(".png","");
            Flag f=new Flag(sub2,"South_America/"+e);
            return f;
        }).collect(Collectors.toList());
        listaSA.forEach(e->instance.addPicture(e.getTitle(),e.getimageUrl()));
        instance.setContador("South_America",listaSA.size());


    }

    @Override
    protected void onStart(){
        super.onStart();

    }
}