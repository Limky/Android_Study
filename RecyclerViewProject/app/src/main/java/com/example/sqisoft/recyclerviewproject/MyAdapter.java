package com.example.sqisoft.recyclerviewproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by SQISOFT on 2016-10-05.
 */
public class MyAdapter extends RecyclerView.Adapter {

    private List<ColorDataItem> dataItems;
    private Context context;

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
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        ColorDataItem dataItem = dataItems.get(position);
        // Casting the viewHolder to MyViewHolder so I could interact with the views
        MyViewHolder myViewHolder = (MyViewHolder) viewHolder;

     //   myViewHolder.imageView.setImageBitmap(BitmapFactory.decodeFile(dataItem.getImagePath()));
        Picasso.with(context)
                .load("http://www.selphone.co.kr/homepage/img/team/3.jpg")
                .placeholder(R.drawable.dx)
                .resize(252,232)
                .into(myViewHolder.imageView);



    }

    @Override
    public int getItemCount() {

        return dataItems.size();
    }

    /** This is our ViewHolder class */
    public static class MyViewHolder extends RecyclerView.ViewHolder {


        public ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView); // Must call super() first

            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}
