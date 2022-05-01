package com.example.paises;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.io.IOException;
import java.util.Arrays;


public class MainActivity_fragment extends Fragment {
    CountryData instance= CountryData.getInstance();
    ContinentAdapter adaptador;
    ListView continentsLV;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_continents, container, false);
        continentsLV=(ListView) view.findViewById(R.id.continetLV);
        adaptador= new ContinentAdapter(getContext(),instance.getdataPic());
        continentsLV.setAdapter(adaptador);
        return view;
    }
    public void loadGeography(AssetManager assetManager) throws IOException{
        String[] filesAfrica=assetManager.list("Africa");
        String[] filesAsia=assetManager.list("Asia");
        String[] filesEurope=assetManager.list("Europe");
        String[] filesNorthAmerica=assetManager.list("North_America");
        String[] filesOceania=assetManager.list("Oceania");
        String[] filesSouthAmerica=assetManager.list("South_America");
        String[] filesContinents=assetManager.list("Continents");
        Arrays.stream(filesContinents).map(e->{
            String sub2=e.replaceAll(".png","");
            Flag f=new Flag(sub2,e);
            instance.addPicture(sub2,e);
            instance.addToDataMap(sub2,f);
            return f;
        });
        Arrays.stream(filesAfrica).map(e->{
            String[] sub=e.split("-");
            String sub2=sub[1].replaceAll(".png","");
            Flag f=new Flag(sub2,e);
            instance.addPicture(sub2,e);
            instance.addToDataMap(sub2,f);
            return f;
        });
        Arrays.stream(filesAsia).parallel().map(e->{
            String[] sub=e.split("-");
            String sub2=sub[1].replaceAll(".png","");
            Flag f=new Flag(sub2,e);
            instance.addPicture(sub2,e);
            instance.addToDataMap(sub2,f);
            return f;
        });
        Arrays.stream(filesEurope).parallel().map(e->{
            String[] sub=e.split("-");
            String sub2=sub[1].replaceAll(".png","");
            Flag f=new Flag(sub2,e);
            instance.addPicture(sub2,e);
            instance.addToDataMap(sub2,f);
            return f;
        });
        Arrays.stream(filesOceania).parallel().map(e->{
            String[] sub=e.split("-");
            String sub2=sub[1].replaceAll(".png","");
            Flag f=new Flag(sub2,e);
            instance.addPicture(sub2,e);
            instance.addToDataMap(sub2,f);
            return f;
        });
        Arrays.stream(filesNorthAmerica).parallel().map(e->{
            String[] sub=e.split("-");
            String sub2=sub[1].replaceAll(".png","");
            Flag f=new Flag(sub2,e);
            instance.addPicture(sub2,e);
            return f;
        });
        Arrays.stream(filesSouthAmerica).parallel().map(e->{
            String[] sub=e.split("-");
            String sub2=sub[1].replaceAll(".png","");
            Flag f=new Flag(sub2,e);
            instance.addPicture(sub2,e);
            instance.addToDataMap(sub2,f);
            return f;
        });
        //adaptador.notifyDataSetChanged();
    }

}
