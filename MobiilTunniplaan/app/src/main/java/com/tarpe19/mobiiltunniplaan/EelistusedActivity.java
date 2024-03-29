package com.tarpe19.mobiiltunniplaan;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class EelistusedActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch notifications;
    Spinner spinner;
    private SharedPreferences mPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPrefs = getSharedPreferences("com.tarpe19.mobiiltunniplaan",MODE_PRIVATE);
        setContentView(R.layout.activity_eelistused);
        spinner = findViewById(R.id.UIDropdown);
        notifications = findViewById(R.id.notificationsSwitch);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.UIDropdownText, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(mPrefs.getInt("spinner_pos",0));
        notifications.setChecked(mPrefs.getBoolean("switch_state", false));
        notifications.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if(isChecked) {
                new AlertDialog.Builder(EelistusedActivity.this)
                        .setTitle("Luba märguanded")
                        .setMessage("Oled kindel, et soovid märguandeid selle rühma tulevatest tunniplaani muudatustest?")
                        .setPositiveButton(android.R.string.yes, (dialog, which) -> Toast.makeText(EelistusedActivity.this, "Märguanded on sisse lülitatud.", Toast.LENGTH_SHORT).show()).setNegativeButton(android.R.string.no,
                        (dialogInterface, i) -> notifications.setChecked(false)).setIcon(android.R.drawable.ic_dialog_alert).show();
            } else {
                Toast.makeText(EelistusedActivity.this, "Märguanded on välja lülitatud.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor ed = mPrefs.edit();
        ed.putInt("spinner_pos", spinner.getSelectedItemPosition());
        ed.putBoolean("switch_state", notifications.isChecked());
        ed.apply();
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
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}