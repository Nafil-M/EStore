package com.example.e_store;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText userName,passWord,mobile;
    TextView register,tvlogIn;
    ProgressDialog progressDialog;
    String name,pass,mob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userName = findViewById(R.id.edittext);
        passWord = findViewById(R.id.edittext2);
        register = findViewById(R.id.regbtn);
        mobile = findViewById(R.id.mobile);
        tvlogIn = findViewById(R.id.log);
        progressDialog = new ProgressDialog(this);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = userName.getText().toString();
                pass = passWord.getText().toString();
                mob = mobile.getText().toString();



                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(mob)) {
                    Toast.makeText(RegisterActivity.this, "All Fields are Important", Toast.LENGTH_SHORT).show();

                }else if(mob.length() < 10){
                    Toast.makeText(RegisterActivity.this, "Invalid Mobile Number", Toast.LENGTH_SHORT).show();
                }
                else {
                    progressDialog.setMessage("Please wait while Login..");
                    progressDialog.setTitle("Login");
                    progressDialog.setCanceledOnTouchOutside(false);
                    progressDialog.show();

                    Register();

                }
            }
        });

        tvlogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

    }

    private void Register() {
        //call api presenter
        Intent intent2 = new Intent(RegisterActivity.this,LoginActivity.class);
        startActivity(intent2);
    }

}