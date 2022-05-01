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
import java.util.List;
import java.util.stream.Collectors;


public class MainActivity_fragment extends Fragment {
    CountryData instance= CountryData.getInstance();
    ContinentAdapter adaptador;
    ListView continentsLV;
    private AssetManager assetManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_continents, container, false);
        continentsLV=(ListView) view.findViewById(R.id.continetLV);
        try {
            loadGeography();
            adaptador.notifyDataSetChanged();



        } catch (IOException e) {
            e.printStackTrace();
        }
        return view;

    }
    public void loadGeography() throws IOException{
        assetManager= getResources().getAssets();
        adaptador=new ContinentAdapter(this.getContext(),instance.getContinentPic(), assetManager);
        continentsLV.setAdapter(adaptador);
        String[] filesAfrica=assetManager.list("Africa");
        System.out.println("Largo de africa"+filesAfrica.length);
        String[] filesAsia=assetManager.list("Asia");
        String[] filesEurope=assetManager.list("Europe");
        String[] filesNorthAmerica=assetManager.list("North_America");
        String[] filesOceania=assetManager.list("Oceania");
        String[] filesSouthAmerica=assetManager.list("South_America");
        String[] filesContinents=assetManager.list("Continents");
        List<Flag> listCont=Arrays.stream(filesContinents).map(e->{
            String sub2=e.replaceAll("Continent.png","");
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
        System.out.println("LARGO DE LISTA AFRICANA"+ listaAf.size());
        listaAf.forEach(e->instance.addPicture(e.getTitle(),e.getimageUrl()));

        List<Flag> listaAs=Arrays.stream(filesAsia).parallel().map(e->{
            String[] sub=e.split("-");
            String sub2=sub[1].replaceAll(".png","");
            Flag f=new Flag(sub2,"Asia/"+e);
            return f;
        }).collect(Collectors.toList());
        listaAs.forEach(e->instance.addPicture(e.getTitle(),e.getimageUrl()));

        List<Flag>listaEU=Arrays.stream(filesEurope).parallel().map(e->{
            String[] sub=e.split("-");
            String sub2=sub[1].replaceAll(".png","");
            Flag f=new Flag(sub2,"Europe/"+e);
            return f;
        }).collect(Collectors.toList());
        listaEU.forEach(e->instance.addPicture(e.getTitle(),e.getimageUrl()));

        List<Flag>listaOC=Arrays.stream(filesOceania).parallel().map(e->{
            String[] sub=e.split("-");
            String sub2=sub[1].replaceAll(".png","");
            Flag f=new Flag(sub2,"Oceania/"+e);
            return f;
        }).collect(Collectors.toList());
        listaOC.forEach(e->instance.addPicture(e.getTitle(),e.getimageUrl()));

        List<Flag>listaNA=Arrays.stream(filesNorthAmerica).parallel().map(e->{
            String[] sub=e.split("-");
            String sub2=sub[1].replaceAll(".png","");
            Flag f=new Flag(sub2,"North_America/"+e);
            return f;
        }).collect(Collectors.toList());
        listaNA.forEach(e->instance.addPicture(e.getTitle(),e.getimageUrl()));

        List<Flag>listaSA=Arrays.stream(filesSouthAmerica).parallel().map(e->{
            String[] sub=e.split("-");
            String sub2=sub[1].replaceAll(".png","");
            Flag f=new Flag(sub2,"South_America/"+e);
            return f;
        }).collect(Collectors.toList());
        listaSA.forEach(e->instance.addPicture(e.getTitle(),e.getimageUrl()));
        System.out.println("InstanceSIZEFINAL"+instance.getdataPic().size());


    }

}
