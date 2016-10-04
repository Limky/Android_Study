package com.example.sqisoft.androidstudy;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;


public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<MyData> MyDataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        //mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),3));

/*        gridmanager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == 0) return 2;
                return 1;
            }
        });*/


        Bitmap bmp = BitmapFactory.decodeFile("/storage/emulated/0/DCIM/HIKVISION/20161004_114634.jpg");
        // specify an adapter (see also next example)
        MyDataset = new ArrayList<>();
        mAdapter = new MyAdapter(MyDataset,this);
        mRecyclerView.setAdapter(mAdapter);


        MyDataset.add(new MyData("#ToyStroy", "/storage/emulated/0/DCIM/HIKVISION/20161004_114634.jpg"));
        MyDataset.add(new MyData("#ToyStroy", "/storage/emulated/0/DCIM/HIKVISION/20161004_114634.jpg"));
        MyDataset.add(new MyData("#ToyStroy", "/storage/emulated/0/DCIM/HIKVISION/20161004_114634.jpg"));
        MyDataset.add(new MyData("#ToyStroy", "/storage/emulated/0/DCIM/HIKVISION/20161004_114634.jpg"));
        MyDataset.add(new MyData("#ToyStroy", "/storage/emulated/0/DCIM/HIKVISION/20161004_114634.jpg"));
        MyDataset.add(new MyData("#ToyStroy", "/storage/emulated/0/DCIM/HIKVISION/20161004_114634.jpg"));
        MyDataset.add(new MyData("#ToyStroy", "/storage/emulated/0/DCIM/HIKVISION/20161004_114634.jpg"));
        MyDataset.add(new MyData("#ToyStroy", "/storage/emulated/0/DCIM/HIKVISION/20161004_114634.jpg"));
        MyDataset.add(new MyData("#ToyStroy", "/storage/emulated/0/DCIM/HIKVISION/20161004_114634.jpg"));
        MyDataset.add(new MyData("#ToyStroy", "/storage/emulated/0/DCIM/HIKVISION/20161004_114634.jpg"));
        MyDataset.add(new MyData("#ToyStroy", "/storage/emulated/0/DCIM/HIKVISION/20161004_114634.jpg"));
        MyDataset.add(new MyData("#ToyStroy", "/storage/emulated/0/DCIM/HIKVISION/20161004_114634.jpg"));
        MyDataset.add(new MyData("#ToyStroy", "/storage/emulated/0/DCIM/HIKVISION/20161004_114634.jpg"));
        MyDataset.add(new MyData("#ToyStroy", "/storage/emulated/0/DCIM/HIKVISION/20161004_114634.jpg"));
        MyDataset.add(new MyData("#ToyStroy", "/storage/emulated/0/DCIM/HIKVISION/20161004_114634.jpg"));
        MyDataset.add(new MyData("#ToyStroy", "/storage/emulated/0/DCIM/HIKVISION/20161004_114634.jpg"));
        MyDataset.add(new MyData("#ToyStroy", "/storage/emulated/0/DCIM/HIKVISION/20161004_114634.jpg"));
        MyDataset.add(new MyData("#ToyStroy", "/storage/emulated/0/DCIM/HIKVISION/20161004_114634.jpg"));
        MyDataset.add(new MyData("#ToyStroy", "/storage/emulated/0/DCIM/HIKVISION/20161004_114634.jpg"));
        MyDataset.add(new MyData("#ToyStroy", "/storage/emulated/0/DCIM/HIKVISION/20161004_114634.jpg"));
        MyDataset.add(new MyData("#ToyStroy", "/storage/emulated/0/DCIM/HIKVISION/20161004_114634.jpg"));


    /*    MyDataset.add(new MyData("#InsideOut", R.mipmap.ice));
        MyDataset.add(new MyData("#Mini", R.mipmap.backimg1));
        MyDataset.add(new MyData("#ToyStroy", R.mipmap.backimg2));
        MyDataset.add(new MyData("#ToyStroy", R.mipmap.backimg3));
        MyDataset.add(new MyData("#ToyStroy", bmp));
        MyDataset.add(new MyData("#ToyStroy", R.mipmap.backimg5));
        MyDataset.add(new MyData("#ToyStroy", R.mipmap.backimg6));
        MyDataset.add(new MyData("#ToyStroy", R.mipmap.backimg7));
        MyDataset.add(new MyData("#ToyStroy", R.mipmap.backimg8));
        MyDataset.add(new MyData("#ToyStroy", R.mipmap.backimg9));
        MyDataset.add(new MyData("#ToyStroy", R.mipmap.imagetest));
        MyDataset.add(new MyData("#ToyStroy", R.mipmap.test3));*/
        //MyDataset.add(new MyData("#ToyStroy", R.mipmap.imagetest2));
    }

}

