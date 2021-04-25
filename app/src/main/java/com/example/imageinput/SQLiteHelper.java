package com.example.imageinput;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class SQLiteHelper extends SQLiteOpenHelper {
    public SQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context,  name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db = getWritableDatabase();
        db.execSQL("create table if not exists food(Id integer primary key autoincrement,name VARCHAR,image BLOB )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void insertData(String name, byte[] img) {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "insert into food values(NULL,?,?)";

        SQLiteStatement statement = db.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, name);
        statement.bindBlob(2, img);

        statement.executeInsert();
    }

}