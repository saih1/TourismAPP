package com.saihtoo.tourismapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.LauncherActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BotRecyclerViewAdapter.OnRowClickListener {
    LinearLayout linearLayout;
    RecyclerView topRecyclerView;
    RecyclerView botRecyclerView;
    TopRecyclerViewAdapter topViewAdapter;
    BotRecyclerViewAdapter botViewAdapter;
    List<Destinations> destinationsList= new ArrayList<>();
    Data myData = new Data();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = findViewById(R.id.linearLayout);
        topRecyclerView = findViewById(R.id.topRecycler);
        botRecyclerView = findViewById(R.id.botRecycler);

        //New instances of Destinations class
        //Add data to destinationList
        for (int i = 0; i < myData.getLength(); i++) {
            Destinations d = new Destinations(i, myData.getImage(i), myData.getTitle(i), myData.getText(i));
            destinationsList.add(d);
        }

        //Setup Recycler Views
        botViewAdapter = new BotRecyclerViewAdapter(destinationsList, this, this);
        botRecyclerView.setAdapter(botViewAdapter);
        RecyclerView.LayoutManager botManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        botRecyclerView.setLayoutManager(botManager);

        topViewAdapter = new TopRecyclerViewAdapter(destinationsList, this);
        topRecyclerView.setAdapter(topViewAdapter);
        RecyclerView.LayoutManager topManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        topRecyclerView.setLayoutManager(topManager);
    }

    @Override
    public void onClick(int position) {
        Fragment frag;
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        frag = DestinationFragment.newInstance(myData.getTitle(position), myData.getText(position),
                myData.getImage(position));
        transaction.add(R.id.mainFragment, frag);
        transaction.commit();
        linearLayout.setVisibility(View.INVISIBLE);
    }

    public void onBackPressed() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.remove(manager.getFragments().get(0));
        transaction.commit();
        linearLayout.setVisibility(View.VISIBLE);
    }
}