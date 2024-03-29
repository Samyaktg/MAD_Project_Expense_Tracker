package com.example.mad_project;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "myDatabase";    // Database Name
    public static final String TABLE_NAME = "myTable";   // Table Name
    public static final int DATABASE_Version = 1;    // Database Version
    public static final String UID = "_id";     // Column I (Primary Key)
    public static final String NAME = "Name";    //Column II
    public static final String MyPASSWORD = "Password";    // Column III
    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " VARCHAR(255) ," + MyPASSWORD + " VARCHAR(225));";
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    public Context context;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_Version);
        this.context = context;
    }

    public void onCreate(SQLiteDatabase db) {

        try {
            db.execSQL(CREATE_TABLE);
        } catch (Exception e) {
            Message.message(context, "" + e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            Message.message(context, "OnUpgrade");
            db.execSQL(DROP_TABLE);
            onCreate(db);
        } catch (Exception e) {
            Message.message(context, "" + e);
        }
    }
}