package com.example.databasetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private MyDatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper = new MyDatabaseHelper(this, "BookStore.db", null, 2);
        Button create_database = findViewById(R.id.create_database);
        Button add_data = findViewById(R.id.add_data);
        Button update_data = findViewById(R.id.update_data);
        Button delete_data = findViewById(R.id.delete_data);
        Button query_data = findViewById(R.id.query_data);

        create_database.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.getWritableDatabase();
            }
        });

        add_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = databaseHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                //开始组装第一条数据
                values.put("name", "The Da Vinci Code");
                values.put("author", "Dan Brown");
                values.put("pages", 454);
                values.put("price", 16.96);
                db.insert("Book", null, values); //插入第一条数据
                values.clear();
                //开始组装第二条数据
                values.put("name", "The Da Vinci Code2");
                values.put("author", "Dan Brown2");
                values.put("pages", 510);
                values.put("price", 19.96);
                db.insert("Book", null, values); //插入第二条数据
            }
        });

        update_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = databaseHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                //开始组装第一条数据
                values.put("price", 10.99);
                db.update("Book", values, "name = ?", new String[] {"The Da Vinci Code"});
            }
        });

        delete_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = databaseHelper.getWritableDatabase();
                db.delete("Book", "pages>?", new String[]{ "500" });
            }
        });

        query_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = databaseHelper.getWritableDatabase();
                //查询 Book 表中的所有数据
                Cursor cursor = db.query("Book", null, null, null, null, null, null);
                if(cursor.moveToFirst()){
                    do {
                        //遍历cursor对象，取出数据并打印
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        double price = cursor.getDouble(cursor.getColumnIndex("price"));
                        Log.d("MainActivity", "book name is " + name);
                        Log.d("MainActivity", "book author is " + author);
                        Log.d("MainActivity", "book pages is " + pages);
                        Log.d("MainActivity", "book price is " + price);
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
        });
    }
}
