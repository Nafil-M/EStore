package com.example.e_store.MyOrders;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.e_store.MensSection.MensAdapter;
import com.example.e_store.R;

public class MyOrderActivity extends AppCompatActivity {

    MyOrdersAdapter myOrdersAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        recyclerView = findViewById(R.id.recyc);
        myOrdersAdapter = new MyOrdersAdapter(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(myOrdersAdapter);

    }

    public void onClickBack(View view) {
        finish();
    }

}