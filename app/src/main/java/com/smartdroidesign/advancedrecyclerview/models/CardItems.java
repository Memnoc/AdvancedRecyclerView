package com.smartdroidesign.advancedrecyclerview.models;

/**
 * Created by mstara on 12/02/2018.
 */

public class CardItems {

    private int mImageResource;
    private String mLineOne;
    private String mLineTwo;

    public CardItems(int mImageResource, String mLineOne, String mLineTwo) {
        this.mImageResource = mImageResource;
        this.mLineOne = mLineOne;
        this.mLineTwo = mLineTwo;
    }

    public void changeTextOne (String text){
        mLineOne = text;
    }

    public int getmImageResource() {
        return mImageResource;
    }

    public String getmLineOne() {
        return mLineOne;
    }

    public String getmLineTwo() {
        return mLineTwo;
    }
}
