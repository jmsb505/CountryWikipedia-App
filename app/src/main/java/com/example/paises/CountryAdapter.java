package com.example.paises;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


class CountryAdapter extends ArrayAdapter<Flag> {
    private CountryData instance= CountryData.getInstance();
    private static class ViewHolder {
        ImageView iconoImagen;
        TextView title;
        public void setIconoImagen(Drawable d) {
            iconoImagen.setImageDrawable(d);
        }
    }
    private AssetManager asset;
    private Context context=this.getContext();

    public CountryAdapter(Context context, ArrayList<Flag> pics,AssetManager assetManager){
        super(context,-1,pics);
        asset=assetManager;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Flag item=(Flag)getItem(position);
        ViewHolder viewHolder;
        if(convertView==null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.cell, parent, false);
            viewHolder.iconoImagen = (ImageView) convertView.findViewById(R.id.thumbV);
            viewHolder.title = (TextView) convertView.findViewById(R.id.titleV);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        String tituloDef=item.getTitle().replaceAll("_"," ");
        viewHolder.title.setText(tituloDef);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento=new Intent("custom-message");
                intento.putExtra("intent",1);
                intento.putExtra("Country",item.getTitle());
                intento.putExtra("Orientation",0);
                LocalBroadcastManager.getInstance(context).sendBroadcast(intento);

            }
        });
        convertView.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View view) {
                return false;
            }
        });
        try {

            InputStream ims= asset.open(item.getimageUrl());
            Drawable d = Drawable.createFromStream(ims,null);
            viewHolder.setIconoImagen(d);

        } catch (IOException e) {
            e.printStackTrace();

        }

        return convertView;


    }}