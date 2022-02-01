package com.example.e_store.Cart;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.e_store.Checkout.CheckoutActivity;
import com.example.e_store.MainActivity;
import com.example.e_store.R;

public class CartBuyNowActivity extends AppCompatActivity {

    TextView continuebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_buy_now);

        continuebtn = findViewById(R.id.continuee);
        
        continuebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                payement();
            }
        });

    }

    public void onClickBack(View view) {
        finish();
    }

    public void payement() {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_window, null);

        TextView cashondel = popupView.findViewById(R.id.cod);
        TextView onlinepayment = popupView.findViewById(R.id.onlinepay);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
//        popupView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                popupWindow.dismiss();
//                return true;
//            }
//        });

        cashondel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(CartBuyNowActivity.this);
                builder.setMessage("Order Placed Succesfully..!")
                        .setTitle("SUCCESS")
                        .setCancelable(false);
                AlertDialog alert = builder.create();
                alert.setButton("Continue", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        // Do call some activity. Do what you wish to;
                        Intent intent = new Intent(CartBuyNowActivity.this, MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                });

                //2. now setup to change color of the button
                alert.setOnShowListener( new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface arg0) {
                        alert.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.blue));
                    }
                });

                alert.show();

//                Toast.makeText(CheckoutActivity.this, "CASH ON DELIVERY", Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
            }
        });

        onlinepayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(CartBuyNowActivity.this);
                builder.setMessage("Sorry..This feature is not available yet..!")
                        .setTitle("WORK IN PROGRESS")
                        .setCancelable(false);
                AlertDialog alert = builder.create();
                alert.setButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        // Do call some activity. Do what you wish to;
                        dialog.dismiss();
                    }
                });

                //2. now setup to change color of the button
                alert.setOnShowListener( new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface arg0) {
                        alert.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.blue));
                    }
                });

                alert.show();

//                Toast.makeText(CheckoutActivity.this, "CASH ON DELIVERY", Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
            }
        });



    }
}