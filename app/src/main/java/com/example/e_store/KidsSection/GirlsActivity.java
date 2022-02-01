package com.example.e_store.KidsSection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.e_store.R;

public class GirlsActivity extends AppCompatActivity {

    GirlsAdapter girlsAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girls);

        recyclerView = findViewById(R.id.recyclergirls);
        girlsAdapter = new GirlsAdapter(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(girlsAdapter);

    }
    public void onClickBack(View view) {
        finish();
    }
}