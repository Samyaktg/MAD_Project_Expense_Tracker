package com.example.mad_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBAdapter{
    DbHelper myhelper;

    public DBAdapter(Context context) {
        myhelper = new DbHelper(context);
    }

    public long insertData(String name, String pass) {
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelper.NAME, name);
        contentValues.put(DbHelper.MyPASSWORD, pass);
        long id = dbb.insert(DbHelper.TABLE_NAME, null, contentValues);
        return id;
    }

    public String getData() {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {DbHelper.UID, DbHelper.NAME, DbHelper.MyPASSWORD};
        Cursor cursor = db.query(DbHelper.TABLE_NAME, columns, null, null, null, null, null);
        StringBuffer buffer = new StringBuffer();
        while (cursor.moveToNext()) {
            int cid = cursor.getInt(cursor.getColumnIndexOrThrow(DbHelper.UID));
            String name = cursor.getString(cursor.getColumnIndexOrThrow(DbHelper.NAME));
            String password = cursor.getString(cursor.getColumnIndexOrThrow(DbHelper.MyPASSWORD));
            buffer.append(name + "   " + password + " \n");
        }
        return buffer.toString();
    }

    public int delete(String uname) {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] whereArgs = {uname};
        int count = db.delete(DbHelper.TABLE_NAME, DbHelper.NAME + " = ?", whereArgs);
        return count;
    }

    public int updateName(String oldName, String newName) {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelper.NAME, newName);
        String[] whereArgs = {oldName};
        int count = db.update(DbHelper.TABLE_NAME, contentValues, DbHelper.NAME + " = ?", whereArgs);
        return count;
    }

}