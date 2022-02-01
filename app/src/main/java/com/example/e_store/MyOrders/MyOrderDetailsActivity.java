package com.example.e_store.MyOrders;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e_store.LoginActivity;
import com.example.e_store.MainActivity;
import com.example.e_store.R;
import com.example.e_store.WomensSection.WomensDetailedAdapter;

public class MyOrderDetailsActivity extends AppCompatActivity {

    RecyclerView recyclerVieww;
    MyOrderdetailsImageAdapter myOrderdetailsImageAdapter;
    TextView brand,descreption,size,address,totalprice,cancelbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order_details);

        brand = findViewById(R.id.brandname);
        descreption = findViewById(R.id.descreptionod);
        size = findViewById(R.id.sizeee);
        address = findViewById(R.id.addressdetails);
        totalprice = findViewById(R.id.grandtotal);
        cancelbtn = findViewById(R.id.cancelorder);

        recyclerVieww = findViewById(R.id.imgrecycler2);
        myOrderdetailsImageAdapter = new MyOrderdetailsImageAdapter(this);

        recyclerVieww.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));
        recyclerVieww.setHasFixedSize(true);
        recyclerVieww.setAdapter(myOrderdetailsImageAdapter);

        cancelbtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MyOrderDetailsActivity.this);

                builder.setTitle("Confirm");
                builder.setMessage("Are you sure?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MyOrderDetailsActivity.this, "Order Cancelled", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(MyOrderDetailsActivity.this,MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // Do nothing
                        dialog.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();

                // Get the alert dialog buttons reference
                Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
                Button negativeButton = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);

                // Change the alert dialog buttons text and background color
                positiveButton.setTextColor(R.color.blue);

                negativeButton.setTextColor(R.color.blue);

            }
        });

    }

    public void onClickBack(View view) {
        finish();
    }
}