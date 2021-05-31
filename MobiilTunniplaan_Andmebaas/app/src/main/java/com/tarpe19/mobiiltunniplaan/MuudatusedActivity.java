package com.tarpe19.mobiiltunniplaan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MuudatusedActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView aineInfo, klassiInfo;
    Spinner spinner1, spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muudatused);

        aineInfo = findViewById(R.id.SubjectText);
        klassiInfo = findViewById(R.id.InfoText);
        spinner1 = findViewById(R.id.date);
        spinner1.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.DateDropdownText, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner2 = findViewById(R.id.day);
        spinner2.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.DayDropdownText, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        // selection valimisel võiks info refreshida automaatselt, kuid kui see ei õnnestu, siis võib lisada nupu
    }

    public void onBack(View view) {
        onBackPressed();
    }

    public void OnNextActivity(View view) {
        Intent newActivity = new Intent(this, EelistusedActivity.class);
        startActivity(newActivity);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}