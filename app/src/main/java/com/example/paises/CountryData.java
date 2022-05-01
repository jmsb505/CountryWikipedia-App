package com.example.paises;

import android.graphics.Bitmap;
import android.graphics.Picture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CountryData {
    private ArrayList<Flag> dataPic;
    private Map<String,Flag> dataMap;
    private Map<String, Bitmap> cache;
    private Map<String, Bitmap> cacheBigPics;
    private static CountryData instancia=new CountryData();
    public static CountryData getInstance(){return instancia;}
    private CountryData()
    {
        dataPic=new ArrayList<>();
        dataMap=new HashMap<>();
        cache=new HashMap<>();
        cacheBigPics=new HashMap<>();
    }
    public void clearDataSet()
    {
        dataPic.clear();
        dataMap.clear();
        cache.clear();
        cacheBigPics.clear();
    }
    public ArrayList<Flag> getdataPic()
    {
        return dataPic;
    }
    public Map<String,Flag> getdataMap(){return dataMap;}
    public void addPicture(String title,String url)
    {
        dataPic.add(new Flag(title,url));
    }
    public void addToDataMap(String title,Flag pic){dataMap.put(title,pic);}
    public void addtoCache(String url,Bitmap bmap)
    {
        cache.put(url,bmap);
    }
    public void addtoBigPicsCache(String url,Bitmap bmap)
    {
        cacheBigPics.put(url,bmap);
    }
    public Map<String, Bitmap> getCache() {
        return cache;
    }
    public Map<String, Bitmap> getBigPicsCache() {
        return cacheBigPics;
    }

}
