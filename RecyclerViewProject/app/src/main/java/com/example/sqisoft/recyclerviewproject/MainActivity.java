package com.example.sqisoft.recyclerviewproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.File;
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


        File files = new File("/storage/emulated/0/DCIM/HIKVISION/");
        if(files.listFiles().length>0){  // 안에 있는 파일의 갯수가 0보다 클때
            for(File data : files.listFiles()){
                dataItems.add(new ColorDataItem("/storage/emulated/0/DCIM/HIKVISION/"+ data.getName()));// 로그에 파일의 이름이 찍힘
            }
        }


        // Creating new adapter object
        MyAdapter myAdapter = new MyAdapter(dataItems,this);
        recyclerView.setAdapter(myAdapter);

        // Setting the layoutManager
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

    }


}
