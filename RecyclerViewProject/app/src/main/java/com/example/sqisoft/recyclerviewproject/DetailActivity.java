package com.example.sqisoft.recyclerviewproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import uk.co.senab.photoview.PhotoViewAttacher;

public class DetailActivity extends AppCompatActivity {

    PhotoViewAttacher mAttacher;
    RelativeLayout DetailLayout;

    BackPressCloseHandler backPressCloseHandler;
    ViewPager pager;
    int currentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        DetailLayout = (RelativeLayout)findViewById(R.id.DetailLayout);
        backPressCloseHandler = new BackPressCloseHandler(this);

        Intent intent = getIntent();
        String imagePath = intent.getStringExtra("imagePath");
        ArrayList<ColorDataItem> dataItems = intent.getParcelableArrayListExtra("dataItems");
        Log.i("테스트","테스트 = "+dataItems.get(1).getImagePath());
        currentIndex = (int)intent.getIntExtra("currentIndex",777);


/*

        Bitmap bmp = BitmapFactory.decodeFile(imagePath);
        ImageView iv = (ImageView) findViewById(R.id.imageView);
        iv.setImageBitmap(bmp);
         mAttacher = new PhotoViewAttacher(iv);
*/


        pager= (ViewPager)findViewById(R.id.pager);
        CustomAdapter adapter= new CustomAdapter(getLayoutInflater(),dataItems);
        pager.setAdapter(adapter);
        pager.setCurrentItem(currentIndex);
    /*    mAttacher = new PhotoViewAttacher(pager);*/

        /** 리스트로 가기 버튼 */
        Button btn = (Button)findViewById(R.id.btn_back);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }




}
