package com.example.e_store.Checkout;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e_store.LoginActivity;
import com.example.e_store.MainActivity;
import com.example.e_store.R;

public class CheckoutActivity extends AppCompatActivity {

    EditText username,mobile,address,city,landmark,pincode,state,country;
    TextView checkoutbtn;
    String username1,mobile1,address1,city1,landmark1,pincode1,state1,country1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        username = findViewById(R.id.edittext);
        mobile = findViewById(R.id.edittext2);
        address = findViewById(R.id.address);
        city = findViewById(R.id.edittext3);
        landmark = findViewById(R.id.edittext4);
        pincode = findViewById(R.id.edittext5);
        state = findViewById(R.id.edittext6);
        country = findViewById(R.id.edittext7);
        checkoutbtn = findViewById(R.id.checkout);


        checkoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username1 = username.getText().toString();
                mobile1 = mobile.getText().toString();
                address1 = address.getText().toString();
                city1 = city.getText().toString();
                landmark1 = landmark.getText().toString();
                pincode1 = pincode.getText().toString();
                state1 = state.getText().toString();
                country1 = country.getText().toString();

                if (TextUtils.isEmpty(username1) || TextUtils.isEmpty(mobile1) || TextUtils.isEmpty(address1) || TextUtils.isEmpty(city1) || TextUtils.isEmpty(landmark1)
                        || TextUtils.isEmpty(pincode1) || TextUtils.isEmpty(state1) || TextUtils.isEmpty(country1)) {
                    Toast.makeText(CheckoutActivity.this, "All Fields are Important", Toast.LENGTH_SHORT).show();
                }else if (mobile1.length() != 10){
                    Toast.makeText(CheckoutActivity.this, "Invalid Mobile Number", Toast.LENGTH_SHORT).show();
                }else if (pincode1.length() != 6){
                    Toast.makeText(CheckoutActivity.this, "Invalid Pin Code", Toast.LENGTH_SHORT).show();
                }else {
                    paymentDialog();
                }
            }
        });
    }

    public void onClickBack(View view) {
        finish();
    }

    public void paymentDialog() {

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

                AlertDialog.Builder builder = new AlertDialog.Builder(CheckoutActivity.this);
                builder.setMessage("Order Placed Succesfully..!")
                        .setTitle("SUCCESS")
                        .setCancelable(false);
                AlertDialog alert = builder.create();
                alert.setButton("Continue", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        // Do call some activity. Do what you wish to;
                        Intent intent = new Intent(CheckoutActivity.this,MainActivity.class);
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

                AlertDialog.Builder builder = new AlertDialog.Builder(CheckoutActivity.this);
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