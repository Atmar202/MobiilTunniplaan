package com.tarpe19.mobiiltunniplaan;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MuudatusedActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView aineInfo, klassiInfo;
    String selectionText;
    Spinner spinner1, spinner2;
    String[] subject = new String[]{"Andmebaasisüsteemide alused", "Võrgurakendused"};
    String[] sClass = new String[]{"A116", "A236"};

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
        Intent intent = getIntent();
        selectionText = intent.getStringExtra("STRING");
    }

    public void onBack(View view) {
        onBackPressed();
    }

    public void OnNextActivity(View view) {
        Intent newActivity = new Intent(this, EelistusedActivity.class);
        startActivity(newActivity);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        if(selectionText.equals("TARpe19")) {
            // Find correct date (that case: 17.05-23.05)
            switch (spinner1.getSelectedItemPosition()) {
                // Day - Monday (17.05)
                case 0:
                    switch (spinner2.getSelectedItemPosition()) {
                        case 0:
                            aineInfo.setText(subject[1]);
                            klassiInfo.setText(sClass[1] + " / " + "Lähevad kell 14:00");
                            break;
                        case 2:
                        case 4:
                            aineInfo.setText(subject[0].substring(0, 8) + "\n" + subject[0].substring(8));
                            klassiInfo.setText(sClass[0] + " / " + "Jääb ära; iseseisev töö kodus");
                            break;
                        default:
                            aineInfo.setText("");
                            klassiInfo.setText("");
                            break;
                    }
                    break;
                case 1:
                    switch (spinner2.getSelectedItemPosition()) {
                        case 2:
                        case 4:
                            aineInfo.setText(subject[0].substring(0, 8) + "\n" + subject[1].substring(8));
                            klassiInfo.setText(sClass[0] + " / " + "Jääb ära; iseseisev töö kodus");
                            break;
                        default:
                            aineInfo.setText("");
                            klassiInfo.setText("");
                            break;
                    }
                    break;
                case 4:
                    aineInfo.setText("-");
                    klassiInfo.setText("Konsultatsiooni nädal");
                    break;
                default:
                    aineInfo.setText("");
                    klassiInfo.setText("");
                    break;
            }
        } else {
            aineInfo.setText("");
            klassiInfo.setText("");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}