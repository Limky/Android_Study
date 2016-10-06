package com.example.sqisoft.recyclerviewproject;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> thumbsDatas = new ArrayList<String>();
    ArrayList<ColorDataItem> dataItems = new ArrayList<ColorDataItem>();
    Cursor imageCursor;

    private BackPressCloseHandler backPressCloseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 뒤로가기 핸들러
        backPressCloseHandler = new BackPressCloseHandler(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // Populating our data set
        getThumbInfo();

        // Creating new adapter object
        MyAdapter myAdapter = new MyAdapter(dataItems,this);
        recyclerView.setAdapter(myAdapter);

        // Setting the layoutManager
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

    }


    private void getThumbInfo(){

        String[] proj = new String[]{MediaStore.Images.Media._ID,
                MediaStore.Images.Media.DATA,
                MediaStore.Images.Media.DISPLAY_NAME,
                MediaStore.Images.Media.SIZE};

        final String orderBy = MediaStore.Images.Media.DATE_ADDED;

        imageCursor = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, proj, null, null, orderBy + " DESC");

        if (imageCursor != null && imageCursor.moveToFirst()){
            String title;
            String thumbsID;
            String thumbsImageID;
            String thumbsData;
            String data;
            String imgSize;


            int thumbsIDCol = imageCursor.getColumnIndex(MediaStore.Images.Media._ID);
            int thumbsDataCol = imageCursor.getColumnIndex(MediaStore.Images.Media.DATA);
            int thumbsImageIDCol = imageCursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME);
            int thumbsSizeCol = imageCursor.getColumnIndex(MediaStore.Images.Media.SIZE);
            int num = 0;
            int nCol = imageCursor.getColumnIndex(MediaStore.Images.Media.DATA); //bitmap
            do {
                thumbsID = imageCursor.getString(thumbsIDCol);
                thumbsData = imageCursor.getString(thumbsDataCol);
                thumbsImageID = imageCursor.getString(thumbsImageIDCol);
                thumbsImageID = imageCursor.getString(nCol);
                imgSize = imageCursor.getString(thumbsSizeCol);
                num++;
                if (thumbsImageID != null && thumbsImageID.startsWith("/storage/emulated/0/DCIM/HIKVISION")){
                    Log.d("test","img is " + thumbsImageID);
                    dataItems.add(new ColorDataItem(thumbsData));
                }
            }while (imageCursor.moveToNext());
        }
        imageCursor.close();
        return;
    }



    public void imageNameLoadfromFile(){
        File files = new File("/storage/emulated/0/DCIM/HIKVISION/");
        if(files.listFiles().length > 0){  // 안에 있는 파일의 갯수가 0보다 클때
            for(File data : files.listFiles()){

                Log.i("Data ","Name is  "+data.getName());
                dataItems.add(new ColorDataItem("/storage/emulated/0/DCIM/HIKVISION/"+ data.getName()));// 로그에 파일의 이름이 찍힘
            }
        }

    }


    @Override
    public void onBackPressed() {
        backPressCloseHandler.onBackPressed();
    }


}
