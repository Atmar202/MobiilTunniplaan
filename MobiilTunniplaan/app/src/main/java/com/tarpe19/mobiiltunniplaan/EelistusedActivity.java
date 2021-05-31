package com.tarpe19.mobiiltunniplaan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;

public class EelistusedActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch notifications;
    Spinner spinner;
    int spinnerPos;
    public static final String SPINNER = "spinner";
    public static final String SWITCH = "switch";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eelistused);
        spinner = findViewById(R.id.UIDropdown);
        notifications = findViewById(R.id.notificationsSwitch);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.UIDropdownText, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        // TODO: SHAREDPREFERENCES ON PAIGAS, KUID EI TÖÖTA
        if(savedInstanceState != null){
            spinner.setSelection(savedInstanceState.getInt(SPINNER));
            notifications.setChecked(savedInstanceState.getBoolean(SWITCH));
        }
        notifications.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked) {
                    new AlertDialog.Builder(EelistusedActivity.this)
                            .setTitle("Allow notifications")
                            .setMessage("Are you sure you want to receive notifications from this group changes?")
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // Continue
                                }
                            }).setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            notifications.setChecked(false);
                        }}).setIcon(android.R.drawable.ic_dialog_alert).show();
                }
            }
        });
    }

    protected void onSaveInstanceState(@NonNull Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(SPINNER, spinnerPos);
        savedInstanceState.putBoolean(SWITCH, notifications.isChecked());
    }

    public void onBack(View view) {
        onBackPressed();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        if(position > 0){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        spinnerPos = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}