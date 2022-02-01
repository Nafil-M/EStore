package com.example.e_store.MensSection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.e_store.KidsSection.BoysAdapter;
import com.example.e_store.R;

public class MensActivity extends AppCompatActivity {

    MensAdapter mensAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mens);

        recyclerView = findViewById(R.id.recyclermen);
        mensAdapter = new MensAdapter(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(mensAdapter);

    }

    public void onClickBack(View view) {
        finish();
    }
}