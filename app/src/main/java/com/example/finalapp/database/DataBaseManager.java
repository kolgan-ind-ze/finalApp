package com.example.finalapp.database;

import static com.example.finalapp.database.DataBaseConstant.LABS_TABLE_NAME;
import static com.example.finalapp.database.DataBaseConstant.LAB_CHECK;
import static com.example.finalapp.database.DataBaseConstant.LAB_ID;
import static com.example.finalapp.database.DataBaseConstant.LAB_LINK;
import static com.example.finalapp.database.DataBaseConstant.LAB_NAME;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.finalapp.data.Labs;

import java.util.ArrayList;
import java.util.List;

public class DataBaseManager {
    private SQLiteDatabase db;
    private DataBaseHelper dbHelper;
    private Context context;
    public DataBaseManager(Context context){
        this.context = context;
        dbHelper = new DataBaseHelper(context);

    }

    public void openDB(){
        db = dbHelper.getWritableDatabase();
    }

    public void closeDB(){
        db.close();
    }

    @SuppressLint("Range")
    public List<Labs> getLabs(){
        List<Labs> labs = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM " +
                LABS_TABLE_NAME, null);
        while (cursor.moveToNext()){
            Labs lab = new Labs();
            lab.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(LAB_ID))));
            lab.setName(cursor.getString(cursor.getColumnIndex(LAB_NAME)));
            lab.setLink(cursor.getString(cursor.getColumnIndex(LAB_LINK)));
            lab.setCheck(cursor.getString(cursor.getColumnIndex(LAB_CHECK)));
            labs.add(lab);
        }
        cursor.close();
        return labs;
    }

    @SuppressLint("Range")
    public List<Labs> getLabsProgress(){
        List<Labs> labsProgress = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM " +
                LABS_TABLE_NAME, null);
        while (cursor.moveToNext()){
            Labs lab = new Labs();
            lab.setCheck(cursor.getString(cursor.getColumnIndex(LAB_CHECK)));
            labsProgress.add(lab);
        }
        cursor.close();
        return labsProgress;
    }

    public void readyLab(Labs lab){
        ContentValues cv = new ContentValues();
        cv.put(LAB_CHECK, lab.getCheck());
        db.update(LABS_TABLE_NAME, cv, LAB_ID +
                " = " + lab.getId(), null);
    }

    public void addLab(Labs lab){
        ContentValues cv = new ContentValues();
        cv.put(LAB_NAME, lab.getName());
        cv.put(LAB_LINK, lab.getLink());
        cv.put(LAB_CHECK, lab.getCheck());
        db.insert(LABS_TABLE_NAME, null, cv);
    }
}
