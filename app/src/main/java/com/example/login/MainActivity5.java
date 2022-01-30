package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity5 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        ListView listView = findViewById(R.id.list);
        Intent i = getIntent();
        ArrayList<String> values = i.getStringArrayListExtra("extra_jawaban");
        //ArrayList<String> values1 = i.getStringArrayListExtra("extra_jawaban1");

        ArrayAdapter<String> adapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,android.R.id.text1, values);
        listView.setAdapter(adapter);




    }
}