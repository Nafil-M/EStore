package com.example.e_store.WomensSection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e_store.Checkout.CheckoutActivity;
import com.example.e_store.KidsSection.GirlsAdapter;
import com.example.e_store.R;

public class WomensDetailedActivity extends AppCompatActivity {

    TextView brand,rate,small,medium,large,xlarge,desc,sizetype,buynowbtn,addtocart;
    WomensDetailedAdapter womensDetailedAdapter;
    RecyclerView recyclerView;
    String sizee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_womens_detailed);

        brand = findViewById(R.id.brandddd);
        rate = findViewById(R.id.rate);
        small = findViewById(R.id.smallsize);
        medium = findViewById(R.id.mediumsize);
        large = findViewById(R.id.largesize);
        xlarge = findViewById(R.id.xlsize);
        desc = findViewById(R.id.desc);
        sizetype = findViewById(R.id.sizetype);
        buynowbtn = findViewById(R.id.buy);
        addtocart = findViewById(R.id.addtocart);


        addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sizee = sizetype.getText().toString();

                if (sizee.equals("")){
                    Toast.makeText(WomensDetailedActivity.this, "Please select size", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(WomensDetailedActivity.this, "Item added to Cart", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

        recyclerView = findViewById(R.id.imgrecycler);
        womensDetailedAdapter = new WomensDetailedAdapter(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(womensDetailedAdapter);

        small.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                small.setBackgroundResource(R.drawable.disabled);
                medium.setBackgroundResource(R.drawable.btn_background);
                large.setBackgroundResource(R.drawable.btn_background);
                xlarge.setBackgroundResource(R.drawable.btn_background);
                sizetype.setText("Small");
            }
        });

        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                small.setBackgroundResource(R.drawable.btn_background);
                medium.setBackgroundResource(R.drawable.disabled);
                large.setBackgroundResource(R.drawable.btn_background);
                xlarge.setBackgroundResource(R.drawable.btn_background);
                sizetype.setText("Medium");
            }
        });

        large.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                small.setBackgroundResource(R.drawable.btn_background);
                medium.setBackgroundResource(R.drawable.btn_background);
                large.setBackgroundResource(R.drawable.disabled);
                xlarge.setBackgroundResource(R.drawable.btn_background);
                sizetype.setText("Large");
            }
        });

        xlarge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                small.setBackgroundResource(R.drawable.btn_background);
                medium.setBackgroundResource(R.drawable.btn_background);
                large.setBackgroundResource(R.drawable.btn_background);
                xlarge.setBackgroundResource(R.drawable.disabled);
                sizetype.setText("X Large");
            }
        });

        buynowbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sizee = sizetype.getText().toString();

                if (sizee.equals("")){
                    Toast.makeText(WomensDetailedActivity.this, "Please select size", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(WomensDetailedActivity.this, CheckoutActivity.class);
                    startActivity(intent);
                }

            }
        });

    }

    public void onClickBack(View view) {
        finish();
    }
}