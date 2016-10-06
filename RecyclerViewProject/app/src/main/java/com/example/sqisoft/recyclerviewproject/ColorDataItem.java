package com.example.sqisoft.recyclerviewproject;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by SQISOFT on 2016-10-05.
 */

public class ColorDataItem implements Parcelable {

    private String imagePath;

    public ColorDataItem(String imagePath) {

        this.imagePath = imagePath;
    }

    protected ColorDataItem(Parcel in) {
        imagePath = in.readString();
    }

    public static final Creator<ColorDataItem> CREATOR = new Creator<ColorDataItem>() {
        @Override
        public ColorDataItem createFromParcel(Parcel in) {
            return new ColorDataItem(in);
        }

        @Override
        public ColorDataItem[] newArray(int size) {
            return new ColorDataItem[size];
        }
    };

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imagePath);

    }

}