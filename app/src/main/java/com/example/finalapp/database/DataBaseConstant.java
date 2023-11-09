package com.example.finalapp.database;

public class DataBaseConstant {
    public static final String DATA_BASE_NAME = "labs.db";
    public static final int DATA_BASE_VERSION = 1;
    public static final String LABS_TABLE_NAME = "TableLabs";
    public static final String LAB_ID = "id";
    public static final String LAB_NAME = "name";
    public static final String LAB_LINK = "link";
    public static final String LAB_CHECK = "checkLab";

    public static final String CREATE_TABLE_LABS = "CREATE TABLE IF NOT EXISTS " + LABS_TABLE_NAME +
            " ( " + LAB_ID + " INTEGER PRIMARY KEY, " + LAB_NAME + " TEXT, " + LAB_LINK + " TEXT, " + LAB_CHECK + " TEXT);";

    public static final String DELETE_TABLE_LABS =
            "DROP TABLE IF EXISTS " + LABS_TABLE_NAME;
}
