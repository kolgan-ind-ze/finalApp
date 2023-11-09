package com.example.finalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.VideoView;

import com.example.finalapp.data.Labs;
import com.example.finalapp.database.DataBaseManager;

public class MainActivity extends AppCompatActivity {
    DataBaseManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbManager = new DataBaseManager(this);
        dbManager.openDB();
        //addLabs();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this, MainInfoActivity.class));
                finish();
            }
        }, 1500);
    }


    public void addLabs(){
        dbManager.openDB();
        dbManager.addLab(new Labs("Первая", "https://drive.google.com/file/d/1Kxi6OnKdtARSaXKGEJXgmXbQZH4WMDtH/view?hl=ru", "-"));
        dbManager.addLab(new Labs("Вторая", "https://drive.google.com/file/d/1PWoZhZF7EU5nNjicDaIys-h2Z84RMh1n/view?hl=ru", "+"));
        dbManager.addLab(new Labs("Третья", "https://drive.google.com/file/d/17IXsgmA8-TlbVpy-Y2YYzahVGxGmuSEF/view?hl=ru", "+"));
        dbManager.addLab(new Labs("Четвертая-Пятая", "https://drive.google.com/file/d/1C0Id1b4zdXfQlDvvgTs3pvFV_RvmGHVA/view?hl=ru", "-"));
        dbManager.addLab(new Labs("Шестая", "https://drive.google.com/file/d/1U5fc2OArobWsJYeZIsDFQFxzF_oY6JqL/view?hl=ru", "-"));
        dbManager.addLab(new Labs("Седьмая", "https://drive.google.com/file/d/1KH25qBykQp6xkmpaG8GNsoy_akUmMQKI/view", "-"));
        dbManager.addLab(new Labs("Восьмая", "https://drive.google.com/file/d/1jVxZ3KXHdz7Czv90HH5OKME45k83UrCq/view", "-"));
        dbManager.addLab(new Labs("Девятая", "https://docs.google.com/document/d/1lrQcPXuzf307vaJqbmpTNGUHPyoaXzr72xCaCy2dy2k/edit", "-"));
        dbManager.addLab(new Labs("Десятая-Одиннадцатая", "https://drive.google.com/file/d/1lr8FemfOUq-a-n1zV6sjQYzWyKfUMmtu/view", "-"));
        dbManager.addLab(new Labs("Двенадцатая", "https://drive.google.com/file/d/1xSfFsTbTK97F0qHStIiQjU44Tzt1dd4l/view", "-"));
        dbManager.addLab(new Labs("Тринадцатая", "https://drive.google.com/file/d/1DlFff92xQpllzdpUdu60fIAyEJf-PFKL/view", "-"));
        dbManager.addLab(new Labs("Четырнадцатая", "https://drive.google.com/file/d/1ySPvW_w9wc77sR_noEMmfBSaoRc50w3F/view", "-"));
        dbManager.addLab(new Labs("Пятнадцатая-Девятнадцатая", "https://drive.google.com/file/d/1mhWXHeYcAGLbyShuLZnbw27jPGI3wp4Q/view", "-"));
        dbManager.addLab(new Labs("Двадцатая", "https://drive.google.com/file/d/1BFMXsU7Y7F_AaceEEE-RN93qOtE3SE72/view", "-"));
        dbManager.addLab(new Labs("Двадцать первая-Двадцать четвертая", "https://drive.google.com/file/d/1z92ID8T-xcRFsVBPpZYlZ0oeddwIyAO-/view", "-"));
        dbManager.addLab(new Labs("Двадцать пятая", "https://drive.google.com/file/d/1b5_z_1pn-Kw834fptNO9PDKb1S3PgZJY/view", "-"));
        dbManager.addLab(new Labs("Двадцать шестая-Тридцатая", "https://drive.google.com/file/d/18NsPzsIMyfj7vI5hOXk58eiTHomDvLnF/view", "-"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbManager.closeDB();
    }
}