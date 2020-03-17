package com.example.databasetest;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static final String CREATE_DATABASE = "create table Book (" +
            "id integer primary key autoincrement, " +
            "author text, " +
            "price real, " +
            "pages integer, " +
            "name text)";

    private Context mContext;

    public MyDatabaseHelper(){
        
    }

}
