package com.tarpe19.mobiiltunniplaan;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class TunniplaanActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView aineInfo, klassiInfo, aineInfo2, klassiInfo2, mealbreak, groupHeader;
    String selectionText;
    String[] time = new String[]{"8:30 - 10:05", "10:10 - 11:45", "12:40 - 14:15"};
    String[] subject = new String[]{"Inglise keel (agiilsed tarkvararaarenduse metoodikad)", "Ajalugu ja ühiskonnaõpetus", "Võrgurakendused"};
    Spinner spinner1, spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tunniplaan);
        groupHeader = findViewById(R.id.groupHeader);
        aineInfo = findViewById(R.id.subjectText);
        klassiInfo = findViewById(R.id.infoText);
        aineInfo2 = findViewById(R.id.subjectText2);
        klassiInfo2 = findViewById(R.id.infoText2);
        mealbreak = findViewById(R.id.mealbreak);
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
        Resources res = getResources();
        String text = res.getString(R.string.groupText, selectionText);
        groupHeader.setText(text);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    // ained lisada läbi for tsükli
                    case 0:
                        for(int i = 0; i < time.length; i++) {
                            if(subject[i].length() > 25 && subject[i].substring(25).length() > 10) {
                                aineInfo.append(time[i] + " " + subject[i].substring(0, 13) + "\n" + subject[i].substring(0, 30) + "\n" + subject[i].substring(30) + "\n");
                            }
                            else if(subject[i].length() > 10){
                                aineInfo.append(time[i] + " " + subject[i].substring(0, 13) + "\n" + subject[i].substring(13) + "\n");
                            } else {
                                aineInfo.append(time[i] + " " + subject[i] + "\n");
                            }
                        }
                        klassiInfo.setText("B228 / Margit Uiboaid\n\n\nB238 / Silva Kiveste");
                        mealbreak.setText("11:50 - 12:35 Söögivahetund");
                        aineInfo2.setText("12:40 - 15:55 Võrguraken\ndused");
                        klassiInfo2.setText("A236 / Kristjan Kivikangur");
                        break;
                    case 1:
                        aineInfo.setText("8:30 - 11:45 Agiilsed tark\nvaraarenduse meetodid");
                        klassiInfo.setText("A236 / Kristjan Kivikangur");
                        mealbreak.setText("11:50 - 12:35 Söögivahetund");
                        aineInfo2.setText("12:40 - 15:55 Võrguraken\ndused");
                        klassiInfo2.setText("A236 / Kristjan Kivikangur");
                        break;
                    case 2:
                        aineInfo.setText("8:30 - 11:00 Andmebaasi\nsüsteemide alused");
                        klassiInfo.setText("A116 / Ingvar Deresivski");
                        mealbreak.setText("11:00 - 11:45 Söögivahetund");
                        aineInfo2.setText("11:50 - 12:35 Inglise keel (agii\nlsed tarkvaraarendused meto\nodikad)\n12:40 - 14:15 Ajalugu ja ühis\nkonnaõpetus\n14:20 - 15:55 Võrguraken\ndused");
                        klassiInfo2.setText("B228 / Margit Uiboaid\n\n\nB238 / Silva Kiveste\n\nA236 / Kristjan Kivikangur");
                        break;
                    case 3:
                        aineInfo.setText("8:30 - 11:45 Agii\nlsed tarkvaraarenduse\nmetoodikad");
                        klassiInfo.setText("A236 / Kristjan Kivikangur");
                        mealbreak.setText("");
                        aineInfo2.setText("");
                        klassiInfo2.setText("");
                        break;
                    case 4:
                        aineInfo.setText("8:30 - 10:05 Vene keel\n10:10 - 11:45 Andmebaasi\nsüsteemide alused");
                        klassiInfo.setText("B219 / Aleksandra\nPsenitsner\nA116 / Ingvar Deresivski");
                        mealbreak.setText("11:50 - 12:35 Söögivahetund");
                        aineInfo2.setText("12:40 - 14:15 Andmebaasi\nsüsteemide alused");
                        klassiInfo2.setText("A116 / Ingvar Deresivski");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    // Viib tagasi eelmisse activitysse
    public void onBack(View view) {
        new AlertDialog.Builder(this)
                .setTitle("Tagasi esilehele?")
                .setMessage("Oled kindel, et soovid tagasi esilehele minna?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, (dialog, which) -> onBackPressed()).setIcon(android.R.drawable.ic_dialog_alert).show();
    }

    public void onNextActivity(View view) {
        Intent newActivity = new Intent(this, MuudatusedActivity.class);
        startActivity(newActivity);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}