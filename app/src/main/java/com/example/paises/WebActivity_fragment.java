package com.example.paises;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

public class WebActivity_fragment extends Fragment {
    WebView web;
    String country;
    int orientation;
    String url="https://en.wikipedia.org/wiki/";
    public WebActivity_fragment(String country,int orientation){
    this.country=country;
    this.orientation=orientation;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view =
                inflater.inflate(R.layout.fragment_web, container, false);
        web=(WebView) view.findViewById(R.id.webV);
        loadURL();
        return view;
    }

    public void loadURL(){
        web.setWebViewClient(new WebViewClient());
        web.loadUrl(url+country);
    }
}
