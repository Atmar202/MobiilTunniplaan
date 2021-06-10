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
    int index = 7;
    String[] time = new String[]{"8:30 - 10:55", "11:00 - 11:45", "12:40 - 14:15", "11:50 - 12:35", "12:40 - 15:55", "8:30 - 11:45", "11:00 - 11:45", "12:40 - 14:15", "8:30 - 11:00", "10:10 - 13:25", "13:30 - 15:05", "14:20 - 15:55", "8:30 - 10:05", "10:10 - 11:45"};
    String[] subject = new String[]{"Inglise keel (agiilsed tarkvararaarenduse metoodikad)", "Ajalugu ja ühiskonnaõpetus", "Võrgurakendused", "Agiilsed tarkvaraarenduse metoodikad", "Andmebaasisüsteemide alused", "Vene keel", "Projektijuhtimine"};
    String[] sClass = new String[]{"B228", "B238", "A236", "B219","A116", "E10"};
    String[] teachers = new String[]{"Margit Uiboaid", "Silva Kiveste", "Kristjan Kivikangur", "Aleksandra Psenitsner","Ingvar Deresivski", "Irina Merkulova"};
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
                // Clear text first (due to appending)
                aineInfo.setText("");
                klassiInfo.setText("");
                mealbreak.setText("");
                aineInfo2.setText("");
                klassiInfo2.setText("");
                if(selectionText.equals("TARpe19")) {
                    switch (position) {
                        // ained lisada läbi for tsükli
                        case 0:
                            for (int i = 0; i < 2; i++) {
                                if (subject[i].length() > 25 && subject[i].substring(25).length() > 10) {
                                    aineInfo.append(time[i] + " " + subject[i].substring(0, 13) + "\n" + subject[i].substring(13, 30) + "\n" + subject[i].substring(30));
                                    klassiInfo.append(sClass[i] + " / " + teachers[i]);
                                    klassiInfo.append("\n\n");
                                    if (i != 1) {
                                        klassiInfo.append("\n");
                                        aineInfo.append("\n");
                                    }
                                } else if (subject[i].length() > 10) {
                                    aineInfo.append(time[i] + " " + subject[i].substring(0, 8) + "\n" + subject[i].substring(8));
                                    klassiInfo.append(sClass[i] + " / " + teachers[i] + "\n");
                                    if (i != 1) {
                                        klassiInfo.append("\n");
                                        aineInfo.append("\n");
                                    }
                                } else {
                                    aineInfo.append(time[i] + " " + subject[i]);
                                    klassiInfo.append(sClass[i] + " / " + teachers[i]);
                                    if (i != 1) {
                                        klassiInfo.append("\n");
                                        aineInfo.append("\n");
                                    }
                                }
                            }
                            mealbreak.setText(time[3] + " Söögivahetund");
                            aineInfo2.setText(time[4] + " " + subject[2].substring(0, 8) + "\n" + subject[2].substring(8));
                            klassiInfo2.setText(sClass[2] + " / " + teachers[2]);
                            break;
                        case 1:
                            aineInfo.setText(time[5] + " " + subject[3].substring(0, 13) + "\n" + subject[3].substring(13));
                            klassiInfo.setText(sClass[2] + " / " + teachers[2]);
                            mealbreak.setText(time[3] + " Söögivahetund");
                            for (int i = 2; i < 3; i++) {
                                aineInfo2.append(time[4] + " " + subject[i].substring(0, 8) + "\n" + subject[i].substring(8));
                                klassiInfo2.append(sClass[i] + " / " + teachers[i]);
                            }
                            break;
                        case 2:
                            aineInfo.setText(time[0] + " " + subject[4].substring(0, 8) + "\n" + subject[4].substring(8));
                            klassiInfo.setText(sClass[4] + " / " + teachers[4]);
                            mealbreak.setText(time[6] + " Söögivahetund");
                            for (int i = 0; i < 3; i++) {
                                if (subject[i].length() > 25 && subject[i].substring(25).length() > 10) {
                                    aineInfo2.append(time[3] + " " + subject[i].substring(0, 13) + "\n" + subject[i].substring(13, 30) + "\n" + subject[i].substring(30));
                                    klassiInfo2.append(sClass[i] + " / " + teachers[i]);
                                    klassiInfo2.append("\n\n");
                                    if (i != 2) {
                                        klassiInfo2.append("\n");
                                        aineInfo2.append("\n");
                                    }
                                } else if (subject[i].length() > 10) {
                                    if (i > 1) index = 11;
                                    aineInfo2.append(time[index] + " " + subject[i].substring(0, 8) + "\n" + subject[i].substring(8));
                                    klassiInfo2.append(sClass[i] + " / " + teachers[i] + "\n");
                                    if (i != 2) {
                                        klassiInfo2.append("\n");
                                        aineInfo2.append("\n");
                                    }
                                } else {
                                    aineInfo2.append(time[i] + " " + subject[i]);
                                    klassiInfo2.append(sClass[i] + " / " + teachers[i]);
                                    if (i != 2) {
                                        klassiInfo2.append("\n");
                                        aineInfo2.append("\n");
                                    }
                                }
                            }
                            break;
                        case 3:
                            aineInfo.setText(time[5] + " " + subject[3].substring(0, 13) + "\n" + subject[4].substring(13));
                            klassiInfo.setText(sClass[2] + " / " + teachers[2]);
                            break;
                        case 4:
                            klassiInfo.append(sClass[3] + " / " + teachers[3]+"\n");
                            aineInfo.append(time[12] + " " + subject[5]+"\n");
                            klassiInfo.append(sClass[4] + " / " + teachers[4]+"\n");
                            aineInfo.append(time[13] + " " + subject[4].substring(0, 8) + "\n" + subject[4].substring(8));
                            mealbreak.setText(time[3] + " Söögivahetund");
                            aineInfo2.setText(time[7] + " " + subject[4].substring(0, 8) + "\n" + subject[4].substring(8));
                            klassiInfo2.setText(sClass[4] + " / " + teachers[4]);
                            break;
                    }
                } else if(selectionText.equals("TARge19")) {
                    if(position == 2){
                        aineInfo.append(time[9] + " " + subject[3].substring(0, 13) + "\n" + subject[3].substring(13)+"\n");
                        klassiInfo.append(sClass[2] + " / " + teachers[2]+"\n\n");
                        aineInfo.append(time[10] + " " + subject[6] + "\n");
                        klassiInfo.append(sClass[5] + " / " + teachers[5]);
                    }
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
        newActivity.putExtra("STRING", selectionText);
        startActivity(newActivity);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}