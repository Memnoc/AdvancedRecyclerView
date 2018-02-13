package com.smartdroidesign.advancedrecyclerview.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.smartdroidesign.advancedrecyclerview.R;
import com.smartdroidesign.advancedrecyclerview.services.OnItemClickListener;

/**
 * Created by mstara on 12/02/2018.
 */

public class CardViewHolder extends RecyclerView.ViewHolder {

    public ImageView mImageView;
    public TextView mLineOne;
    public TextView mLineTwo;

    public CardViewHolder(View itemView, final OnItemClickListener listener) {
        super(itemView);
        mImageView = itemView.findViewById(R.id.imageOne);
        mLineOne = itemView.findViewById(R.id.lineOneTxt);
        mLineTwo  =itemView.findViewById(R.id.lineTwoTxt);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position);
                    }
                }
            }
        });
    }
}
