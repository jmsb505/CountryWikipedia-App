package com.example.paises;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

public class CountryActivity_fragment extends Fragment {
    ListView countryLV;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view =
                inflater.inflate(R.layout.fragment_countries, container, false);
        countryLV=(ListView) view.findViewById(R.id.countryLV);

        return view;
    }
}
