package com.example.e_store.WomensSection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.e_store.KidsSection.BoysAdapter;
import com.example.e_store.R;

public class WomensActivity extends AppCompatActivity {

    WomensAdapter womensAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_womens);
        recyclerView = findViewById(R.id.recyclerwom);
        womensAdapter = new WomensAdapter(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(womensAdapter);

    }
    public void onClickBack(View view) {
        finish();
    }
}