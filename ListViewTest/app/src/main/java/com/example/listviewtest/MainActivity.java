package com.example.listviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button toListView = (Button)findViewById(R.id.toListView);
        Button toCustomListView = (Button)findViewById(R.id.toCustomListView);
        toListView.setOnClickListener(this);
        toCustomListView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.toListView:
                Intent intent1 = new Intent(MainActivity.this, ListViewActivity.class);
                startActivity(intent1);
                break;
            case R.id.toCustomListView:
                Intent intent2 = new Intent(MainActivity.this, CustomListViewActivity.class);
                startActivity(intent2);
                break;
            default:
                break;
        }
    }
}
