package com.example.sqisoft.recyclerviewproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // Populating our data set
        List<ColorDataItem> dataItems = new ArrayList<ColorDataItem>();
        for(int i=0;i<90;i++)
        dataItems.add(new ColorDataItem("/storage/emulated/0/DCIM/HIKVISION/20161004_114634.jpg"));


        // Creating new adapter object
        MyAdapter myAdapter = new MyAdapter(dataItems,this);
        recyclerView.setAdapter(myAdapter);

        // Setting the layoutManager
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

    }
}
