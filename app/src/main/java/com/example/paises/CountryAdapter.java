package com.example.paises;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;


class CountryAdapter extends ArrayAdapter<Flag> {
    private CountryData instance= CountryData.getInstance();
    private int counter=0;
    private static class ViewHolder {
        ImageView iconoImagen;
        TextView title;
    }

    public CountryAdapter(Context context, ArrayList<Flag> pics){
        super(context,-1,pics);


    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Flag item=instance.getdataPic().get(position);
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

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        convertView.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View view) {
                return false;
            }
        });
        try {
            if(!item.getTitle().contains("Continent") || !item.getimageUrl().contains("Continent")||instance.getdataPic().contains(item)) {
                Drawable d = Drawable.createFromStream(this.getContext().getAssets().open(item.getimageUrl()), null);
                viewHolder.iconoImagen.setImageDrawable(d);
                viewHolder.title.append(item.getTitle());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return convertView;


    }}