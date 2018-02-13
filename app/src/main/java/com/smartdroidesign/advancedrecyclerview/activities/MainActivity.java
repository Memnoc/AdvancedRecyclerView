package com.smartdroidesign.advancedrecyclerview.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.smartdroidesign.advancedrecyclerview.R;
import com.smartdroidesign.advancedrecyclerview.adapters.CardAdapter;
import com.smartdroidesign.advancedrecyclerview.models.CardItems;
import com.smartdroidesign.advancedrecyclerview.services.OnItemClickListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<CardItems> mCardList;

    private RecyclerView mRecyclerView;
    private CardAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Button buttonInsert;
    private Button buttonRemove;
    private EditText editTextInsert;
    private EditText editTextRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createExampleList();
        buildRecyclerView();
        setButtons();

        EditText editText = findViewById(R.id.search_edit_txt);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());

            }
        });

    }

    private void filter (String text) {
        ArrayList<CardItems> filteredList = new ArrayList<>();

        for (CardItems item: mCardList) {
            if (item.getmLineOne().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        mAdapter.filterList(filteredList);
    }

    public void insertItem (int position){
        mCardList.add(position, new CardItems(R.drawable.ic_android, "New Item At Position" + position, "This is line two"));
        mAdapter.notifyItemInserted(position);

    }

    public void removeItem (int position){
        mCardList.remove(position);
        mAdapter.notifyItemRemoved(position);


    }

    public void changeItem (int position, String text){
        mCardList.get(position).changeTextOne(text);
        mAdapter.notifyItemChanged(position);

    }

    public void createExampleList(){
        mCardList = new ArrayList<>();
        mCardList.add(new CardItems(R.drawable.ic_android, "Line 1", "Line 2"));
        mCardList.add(new CardItems(R.drawable.ic_audio, "Line 3", "Line 4"));
        mCardList.add(new CardItems(R.drawable.ic_sun, "Line 5", "Line 6"));

    }


    public void buildRecyclerView(){
        mRecyclerView = findViewById(R.id.main_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new CardAdapter(mCardList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                changeItem(position, "Clicked");
            }

            @Override
            public void onDeleteClick(int position) {
                removeItem(position);
            }
        });

    }

    public void setButtons ()
    {
        buttonInsert = findViewById(R.id.button_insert);
        buttonRemove = findViewById(R.id.button_remove);
        editTextInsert = findViewById(R.id.editText_insert);
        editTextRemove = findViewById(R.id.editText_remove);

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(editTextInsert.getText().toString());
                insertItem(position);
            }
        });

        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(editTextRemove.getText().toString());
                removeItem(position);

            }
        });
    }}
