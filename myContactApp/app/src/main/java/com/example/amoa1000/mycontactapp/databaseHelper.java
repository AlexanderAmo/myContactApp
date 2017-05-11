package com.example.amoa1000.mycontactapp;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by amoa1000 on 5/11/2017.
 */
public class databaseHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "";
    public static final String DATA_NAME = "";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";

    public databaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
