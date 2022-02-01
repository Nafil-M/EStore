package com.example.e_store.Cart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.e_store.KidsSection.BoysAdapter;
import com.example.e_store.R;

public class CartActivity extends AppCompatActivity {

    TextView buynow;
    CartAdapter cartAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        buynow = findViewById(R.id.buynoww);
        recyclerView = findViewById(R.id.cartrecyc);
        cartAdapter = new CartAdapter(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(cartAdapter);

        buynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartActivity.this,CartBuyNowActivity.class);
                startActivity(intent);
            }
        });

    }

    public void onClickBack(View view) {
        finish();
    }
}