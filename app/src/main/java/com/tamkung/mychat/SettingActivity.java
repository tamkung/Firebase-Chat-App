package com.tamkung.mychat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Switch;

import com.akexorcist.localizationactivity.ui.LocalizationActivity;

import java.util.ArrayList;

public class SettingActivity extends LocalizationActivity {

    private Switch darkmode;
    Button btn_th, btn_en, btn_ja;

    private RelativeLayout re_layout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.setting);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingActivity.this, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        darkmode = findViewById(R.id.switch1);
        re_layout = findViewById(R.id.re_layout);
        btn_th = findViewById(R.id.btn_thai);
        btn_en = findViewById(R.id.btn_eng);
        btn_ja = findViewById(R.id.btn_jap);

        darkmode.setChecked(false);
        darkmode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {
                if (bChecked) {
                    re_layout.setBackgroundColor(getColor(R.color.colorGray));
                } else {
                    re_layout.setBackgroundColor(getColor(R.color.colorWhite));
                }
            }
        });

        btn_th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLanguage("th");
            }
        });

        btn_en.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLanguage("en");
            }
        });

        btn_ja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLanguage("ja");
            }
        });
    }

}
