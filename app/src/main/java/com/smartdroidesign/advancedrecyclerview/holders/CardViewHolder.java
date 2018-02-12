package com.smartdroidesign.advancedrecyclerview.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.smartdroidesign.advancedrecyclerview.R;

/**
 * Created by mstara on 12/02/2018.
 */

public class CardViewHolder extends RecyclerView.ViewHolder {

    public ImageView mImageView;
    public TextView mLineOne;
    public TextView mLineTwo;

    public CardViewHolder(View itemView) {
        super(itemView);
        mImageView = itemView.findViewById(R.id.imageOne);
        mLineOne = itemView.findViewById(R.id.lineOneTxt);
        mLineTwo  =itemView.findViewById(R.id.lineTwoTxt);
    }
}
