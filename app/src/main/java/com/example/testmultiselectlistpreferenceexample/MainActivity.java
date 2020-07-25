package com.example.testmultiselectlistpreferenceexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    ColorsAdapter mColorsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button goToSettingsButton = findViewById(R.id.goToSettingsButton);
        RecyclerView colors_RecyclerView = findViewById(R.id.colors_RecyclerView);

          mColorsAdapter= new ColorsAdapter(this, new ArrayList<ColorItem>());
        colors_RecyclerView.setAdapter(mColorsAdapter);

        goToSettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SettingsActivity.class));
            }
        });
    }

    private void loadData() {

        mColorsAdapter.clear();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        Set<String> setsColor = sharedPreferences.getStringSet(ConstantOfApp.MULTI_SELECT_LIST_KEY, null);
        if (setsColor!=null){
            for (Iterator<String> it = setsColor.iterator(); it.hasNext(); ) {

                ColorItem colorItem= new ColorItem(it.next());
                mColorsAdapter.add(colorItem);
            }
            mColorsAdapter.notifyDataSetChanged();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();

        //load data
        loadData();
    }
}