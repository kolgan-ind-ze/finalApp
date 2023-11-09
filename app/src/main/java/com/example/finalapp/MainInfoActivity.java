package com.example.finalapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.finalapp.data.Labs;
import com.example.finalapp.data.LabsAdapter;
import com.example.finalapp.database.DataBaseManager;

import java.util.List;

public class MainInfoActivity extends AppCompatActivity {
    RecyclerView recView;
    DataBaseManager dbManager;
    List<Labs> labs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_info);
        dbManager = new DataBaseManager(this);
        dbManager.openDB();
        recView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recView.setLayoutManager(linearLayoutManager);
        labs = dbManager.getLabs();
        LabsAdapter expensesAdapter = new LabsAdapter(labs, this, dbManager);
        if (labs.size() > 0){
            recView.setAdapter(expensesAdapter);
        }

    }


    @Override
    protected void onResume() {
        super.onResume();
        dbManager.openDB();
        recView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recView.setLayoutManager(linearLayoutManager);
        labs = dbManager.getLabs();
        LabsAdapter expensesAdapter = new LabsAdapter(labs, this, dbManager);
        if (labs.size() > 0){
            recView.setAdapter(expensesAdapter);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbManager.closeDB();
    }
}

