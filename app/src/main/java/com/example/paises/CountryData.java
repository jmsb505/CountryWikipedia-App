package com.example.paises;

import android.graphics.Bitmap;
import android.graphics.Picture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CountryData {
    private ArrayList<Flag> dataPic;
    private ArrayList<Flag> continentPic;
    private Map<String,Flag> dataMap;
    private static CountryData instancia=new CountryData();
    private Map<String,Integer> countryCounter;
    public static CountryData getInstance(){return instancia;}
    private CountryData()
    {
        continentPic=new ArrayList<>();
        dataPic=new ArrayList<>();
        dataMap=new HashMap<>();
        countryCounter=new HashMap<>();

    }
    public void clearDataSet()
    {
        dataPic.clear();
        continentPic.clear();
        dataMap.clear();
        countryCounter.clear();
    }
    public void setContador(String value,int number)
    {
        countryCounter.put(value,number);
    }
    public int getContador(String value)
    {
        return countryCounter.get(value);
    }
    public ArrayList<Flag> getdataPic()
    {
        return dataPic;
    }
    public ArrayList<Flag>getContinentPic(){return continentPic;}
    public Map<String,Flag> getdataMap(){return dataMap;}
    public void addPicture(String title,String url)
    {
        dataPic.add(new Flag(title,url));
    }
    public void addContinent(String title, String url)
    {
        continentPic.add(new Flag(title,url));
    }
    public void addToDataMap(String title,Flag pic){dataMap.put(title,pic);}

}
