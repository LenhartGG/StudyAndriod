package com.example.uiwidgettest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_1 = (Button)findViewById(R.id.button1);
        Button button_2 = (Button)findViewById(R.id.button2);
        editText = (EditText) findViewById((R.id.edit_text));
        button_1.setOnClickListener(this);
        button_2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch(v.getId()) {
            case R.id.button1:
                //...
                Intent intent = new Intent(MainActivity.this, WebView.class);
                startActivity(intent);
                break;
            case R.id.button2:
                String inputText = editText.getText().toString();
                Toast.makeText(MainActivity.this, inputText, Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
