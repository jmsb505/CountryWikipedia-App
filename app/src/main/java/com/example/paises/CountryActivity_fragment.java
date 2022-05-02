package com.example.paises;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.sql.Array;
import java.util.ArrayList;

public class CountryActivity_fragment extends Fragment {
    private ListView countryLV;
    private String origenContinent;
    private int orientation;
    private ArrayList<Flag> banderaspais;
    private CountryData instance=CountryData.getInstance();
    private AssetManager assetManager;
    private CountryAdapter adaptador;
    public CountryActivity_fragment(String origenContinent,int orientation)
    {
        this.origenContinent=origenContinent;
        this.orientation=orientation;
        this.banderaspais=new ArrayList<Flag>();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view =
                inflater.inflate(R.layout.fragment_countries, container, false);
        countryLV=(ListView) view.findViewById(R.id.countryLV);
        displayContinents();
        return view;
    }
    public void displayContinents(){
        assetManager=getResources().getAssets();
        instance.getdataPic().forEach(e->{
            if(e.getimageUrl().contains(origenContinent)) {
                banderaspais.add(e);
            }
        });
        adaptador=new CountryAdapter(this.getContext(),banderaspais,assetManager);
        countryLV.setAdapter(adaptador);
        adaptador.notifyDataSetChanged();
    }
}
