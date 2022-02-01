package com.example.e_store.KidsSection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.e_store.R;

import java.util.ArrayList;

public class BoysActivity extends AppCompatActivity {

    BoysAdapter boysAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boys);

        recyclerView = findViewById(R.id.recyclerboys);
        boysAdapter = new BoysAdapter(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(boysAdapter);
    }

    public void onClickBack(View view) {
        finish();
    }
}