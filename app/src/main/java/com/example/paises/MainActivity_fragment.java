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
    private final CountryData instance= CountryData.getInstance();
    private ContinentAdapter adaptador;
    private ListView continentsLV;
    private AssetManager assetManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_continents, container, false);
        continentsLV=(ListView) view.findViewById(R.id.continetLV);
        assetManager= getResources().getAssets();
        adaptador=new ContinentAdapter(this.getContext(),instance.getContinentPic(), assetManager);
        continentsLV.setAdapter(adaptador);
        adaptador.notifyDataSetChanged();
        return view;

    }

}
