package com.example.listviewtest;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class CustomListViewActivity extends AppCompatActivity {

    public List<Fruit> fruitList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);

        //将系统自带的标题栏隐藏掉
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }

        initFruits();   //初始化水果数据
        FruitAdapter adapter = new FruitAdapter(CustomListViewActivity.this, R.layout.fruit_item, fruitList);
        ListView customListView = (ListView) findViewById(R.id.customListView);
        customListView.setAdapter(adapter);
        customListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(CustomListViewActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void initFruits(){
        for(int i = 0; i < 2; i++){
            Fruit apple = new Fruit("Apple", R.mipmap.ic_launcher);
            fruitList.add(apple);
            Fruit banana = new Fruit("Banana", R.mipmap.ic_launcher);
            fruitList.add(banana);
            Fruit orange = new Fruit("Orange", R.mipmap.ic_launcher);
            fruitList.add(orange);
            Fruit watermelon = new Fruit("Watermelon", R.mipmap.ic_launcher);
            fruitList.add(watermelon);
            Fruit pear = new Fruit("Pear", R.mipmap.ic_launcher);
            fruitList.add(pear);
            Fruit grape = new Fruit("Grape", R.mipmap.ic_launcher);
            fruitList.add(grape);
            Fruit pineapple = new Fruit("Pineapple", R.mipmap.ic_launcher);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit("Strawberry", R.mipmap.ic_launcher);
            fruitList.add(strawberry);
            Fruit cherry = new Fruit("Cherry", R.mipmap.ic_launcher);
            fruitList.add(cherry);
            Fruit mango = new Fruit("Mango", R.mipmap.ic_launcher);
            fruitList.add(mango);
        }
    }
}
