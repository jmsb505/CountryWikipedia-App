package com.example.paises;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SettingsActivity extends AppCompatActivity {
    private AlertDialog.Builder builder;
    private AlertDialog alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        String[] listItems = new String[]{"Africa","Asia", "Europe","Oceania", "North_America", "South_America"};
        List<String> selectedItems = Arrays.asList(listItems);
        ArrayList<String> itemstosend=new ArrayList<>();
        boolean[] checkedItems = new boolean[listItems.length];
        builder = new AlertDialog.Builder(SettingsActivity.this);
        builder.setTitle("Settings");
        builder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String aux="";
                for (int i = 0; i < checkedItems.length; i++) {
                    if (checkedItems[i]) {
                        itemstosend.add(listItems[i]);
                    }
                }
                Intent intento=new Intent(getApplicationContext(),MainActivity.class);
                intento.putStringArrayListExtra("PaisesCargados",itemstosend);
                startActivity(intento);
            }
        });
        builder.setMultiChoiceItems(listItems, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                checkedItems[which] = isChecked;
            }
        });
        builder.setNeutralButton("CLEAR ALL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                for (int i = 0; i < checkedItems.length; i++) {
                    checkedItems[i] = false;
                }
            }
        });
        builder.setCancelable(false);
        builder.create();
        alertDialog = builder.create();
        alertDialog.show();
    }
}