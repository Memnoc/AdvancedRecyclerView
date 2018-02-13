package com.smartdroidesign.advancedrecyclerview.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smartdroidesign.advancedrecyclerview.R;
import com.smartdroidesign.advancedrecyclerview.holders.CardViewHolder;
import com.smartdroidesign.advancedrecyclerview.models.CardItems;
import com.smartdroidesign.advancedrecyclerview.services.OnItemClickListener;

import java.util.ArrayList;

/**
 * Created by mstara on 12/02/2018.
 */

public class CardAdapter extends RecyclerView.Adapter<CardViewHolder> {

    private ArrayList<CardItems> mCardList;
    private OnItemClickListener mListener;



    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public CardAdapter(ArrayList<CardItems> cardList) {
        mCardList = cardList;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item_content, parent, false);
        CardViewHolder cvh = new CardViewHolder(v, mListener);
        return cvh;
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        CardItems currentItem = mCardList.get(position);

        holder.mImageView.setImageResource(currentItem.getmImageResource());
        holder.mLineOne.setText(currentItem.getmLineOne());
        holder.mLineTwo.setText(currentItem.getmLineTwo());

    }

    @Override
    public int getItemCount() {
        return mCardList.size();
    }

}
