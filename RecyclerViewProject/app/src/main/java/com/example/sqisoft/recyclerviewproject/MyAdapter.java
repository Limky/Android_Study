package com.example.sqisoft.recyclerviewproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.List;

/**
 * Created by SQISOFT on 2016-10-05.
 */
public class MyAdapter extends RecyclerView.Adapter {

    private List<ColorDataItem> dataItems;
    private Context context;
    ColorDataItem dataItem;

    // Adapter constructor
    public MyAdapter(List<ColorDataItem> dataItems, Context context) {
        this.context = context;
        this.dataItems = dataItems;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View layoutView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, null);

        return new MyViewHolder(layoutView);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int position) {

        dataItem = dataItems.get(position);

        // Casting the viewHolder to MyViewHolder so I could interact with the views
        MyViewHolder myViewHolder = (MyViewHolder) viewHolder;
        myViewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("getImagePath","getImagePath = "+ dataItems.get(position).getImagePath());
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("imagePath",dataItems.get(position).getImagePath());
                ((Activity) context).startActivity(intent);
                ((Activity) context).finish();
            }
        });

     //   myViewHolder.imageView.setImageBitmap(BitmapFactory.decodeFile(dataItem.getImagePath()));


        Uri uri = Uri.fromFile(new File(dataItems.get(position).getImagePath()));
        Picasso.with(context)
                .load(uri)
                .placeholder(R.drawable.dx)
                .resize(452,432)
                .into(myViewHolder.imageView);



    }

    @Override
    public int getItemCount() {

        return dataItems.size();
    }

    /** This is our ViewHolder class */
    public static class MyViewHolder extends RecyclerView.ViewHolder  {

        public ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView); // Must call super() first

            imageView = (ImageView) itemView.findViewById(R.id.imageView);


        }

    }


}
