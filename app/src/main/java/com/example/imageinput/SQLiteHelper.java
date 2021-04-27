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
        db.execSQL("create table if not exists food(Id integer primary key autoincrement,image BLOB,option1 VARCHAR,option2 VARCHAR,option3 VARCHAR,option4 VARCHAR,answer VARCHAR)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void insertData(byte[] col1, String col2, String col3, String col4, String col5, String col6) {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "insert into food values(Null,?,?,?,?,?,?)";

        SQLiteStatement statement = db.compileStatement(sql);
        statement.clearBindings();

        statement.bindBlob(1, col1);
        statement.bindString(2, col2);
        statement.bindString(3, col3);
        statement.bindString(4, col4);
        statement.bindString(5, col5);
        statement.bindString(6, col6);

        statement.executeInsert();
    }
}