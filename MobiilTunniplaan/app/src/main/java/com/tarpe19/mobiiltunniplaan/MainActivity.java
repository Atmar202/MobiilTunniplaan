package com.tarpe19.mobiiltunniplaan;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText groupName;
    Spinner spinner;
    Button btn;
    int count, backgroundValue;
    List<String> spinnerItems;
    SharedPreferences mPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.search);
        groupName = findViewById(R.id.enterGroup);
        spinner = findViewById(R.id.chooseGroup);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.chooseGroup, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        count = spinner.getAdapter().getCount();
        spinnerItems = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            String text = spinner.getAdapter().getItem(i).toString();
            spinnerItems.add(text);
        }
        mPrefs = getSharedPreferences("com.tarpe19.mobiiltunniplaan",MODE_PRIVATE);
        backgroundValue = mPrefs.getInt("spinner_pos",0);
        if(backgroundValue > 0){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }
    // Vaata kas groupName sisaldab andmebaasis olevat päringut (TARpe19), kui mitte siis tagastada error
    // Võib kasutada lihtsat andmebaasi nagu nt: SQL Lite (Näitab staatilisi andmeid, mis ei sobi kui on vaja salvestada palju andmeid)
    // Kokkuvõtteks on lisada ühe rühma andmed (TARpe19) ja kõik tunniplaani muudatused andmebaasi, et demonstreerida kuidas see võiks töötada

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        // Prioriseerib rohkem spinneri valikut, kui sisestust
        btn.setOnClickListener(view1 -> {
            // Salvestada spinner selection ja selle kaudu leida selle rühma andmed
            String selectionText = spinner.getSelectedItem().toString();
            String group = groupName.getText().toString();
            if(position > 0){
                // Viib järgmissesse activityisse ja salvestab selectioni
                Intent newActivity = new Intent(MainActivity.this, TunniplaanActivity.class);
                newActivity.putExtra("STRING", selectionText);
                startActivity(newActivity);
            } else {
                for (int i = 1; i < spinnerItems.size(); i++) {
                    if (group.equalsIgnoreCase(spinnerItems.get(i))) {
                        Intent newActivity = new Intent(MainActivity.this, TunniplaanActivity.class);
                        newActivity.putExtra("STRING", spinnerItems.get(i));
                        startActivity(newActivity);
                        break;
                    }
                }
            }
        });
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) { }
}