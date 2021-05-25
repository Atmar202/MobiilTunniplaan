package com.tarpe19.mobiiltunniplaan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText groupName;
    Spinner spinner;
    Button btn;

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
    }
    // Vaata kas groupName sisaldab andmebaasis olevat päringut (TARpe19), kui mitte siis tagastada error
    // Võib kasutada lihtsat andmebaasi nagu nt: SQL Lite (Näitab staatilisi andmeid, mis ei sobi kui on vaja salvestada palju andmeid)
    // Kokkuvõtteks on lisada ühe rühma andmed (TARpe19) ja kõik tunniplaani muudatused andmebaasi, et demonstreerida kuidas see võiks töötada

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        // Prioriseerib rohkem spinneri valikut, kui sisestust
        btn.setOnClickListener(view1 -> {
            if(position > 0){
                // Salvestada spinner selection ja selle kaudu leida selle rühma andmed
                String selectionText = spinner.getSelectedItem().toString();
                // Viib järgmissesse activityisse ja salvestab selectioni
                Intent newActivity = new Intent(MainActivity.this, TunniplaanActivity.class);
                newActivity.putExtra("STRING", selectionText);
                startActivity(newActivity);
            } else {
                // Proovib leida päringut, kuid kui ei leia siis tagastab SQL errori
                String group = groupName.getText().toString();
                if(!group.equals("")){
                    // Viib järgmisesse activityisse
                    Intent newActivity = new Intent(MainActivity.this, TunniplaanActivity.class);
                    startActivity(newActivity);
                    // TODO: Kasutab andmebaasi (SQLLite, et töötleda käsitisi kirjutatud päringud)
                } else {
                    Toast.makeText(MainActivity.this, "Unable to find the group when both values are empty.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) { }
}