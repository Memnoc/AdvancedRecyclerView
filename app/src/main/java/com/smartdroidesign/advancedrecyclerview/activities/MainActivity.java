package com.smartdroidesign.advancedrecyclerview.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.smartdroidesign.advancedrecyclerview.R;
import com.smartdroidesign.advancedrecyclerview.adapters.CardAdapter;
import com.smartdroidesign.advancedrecyclerview.models.CardItems;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<CardItems> cardList = new ArrayList<>();
        cardList.add(new CardItems(R.drawable.ic_android, "Line 1", "Line 2"));
        cardList.add(new CardItems(R.drawable.ic_audio, "Line 3", "Line 4"));
        cardList.add(new CardItems(R.drawable.ic_sun, "Line 5", "Line 6"));
        cardList.add(new CardItems(R.drawable.ic_android, "Line 7", "Line 8"));
        cardList.add(new CardItems(R.drawable.ic_audio, "Line 9", "Line 10"));
        cardList.add(new CardItems(R.drawable.ic_sun, "Line 11", "Line 12"));
        cardList.add(new CardItems(R.drawable.ic_android, "Line 13", "Line 14"));
        cardList.add(new CardItems(R.drawable.ic_audio, "Line 15", "Line 16"));
        cardList.add(new CardItems(R.drawable.ic_sun, "Line 17", "Line 18"));
        cardList.add(new CardItems(R.drawable.ic_android, "Line 19", "Line 20"));
        cardList.add(new CardItems(R.drawable.ic_audio, "Line 21", "Line 22"));
        cardList.add(new CardItems(R.drawable.ic_sun, "Line 23", "Line 24"));

        mRecyclerView = findViewById(R.id.main_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new CardAdapter(cardList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }
}
