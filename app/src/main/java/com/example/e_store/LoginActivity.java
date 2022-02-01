package com.example.e_store;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText userName,passWord;
    TextView login,rememberMe,tvsignUp;
    ProgressDialog progressDialog;
    ImageView showpassword;
    String name,pass;

        @SuppressLint("ClickableViewAccessibility")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userName = findViewById(R.id.edittext);
        passWord = findViewById(R.id.edittext2);
        login = findViewById(R.id.loginbtn);
        showpassword = findViewById(R.id.imagepassword);
        tvsignUp = findViewById(R.id.sign);
        rememberMe = findViewById(R.id.remember);
        progressDialog = new ProgressDialog(this);

        showpassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        passWord.setInputType(InputType.TYPE_CLASS_TEXT);
                        break;
                    case MotionEvent.ACTION_UP:
                        passWord.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                        break;
                }
                return true;
            }
        });

        rememberMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = userName.getText().toString();
                pass = passWord.getText().toString();


                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(pass)) {
                    Toast.makeText(LoginActivity.this, "All Fields are Important", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(LoginActivity.this, "Username and Password saved", Toast.LENGTH_SHORT).show();

                    SharedPreferences sp = getSharedPreferences("Login", MODE_PRIVATE);
                    SharedPreferences.Editor Ed = sp.edit();
                    Ed.putString("Unm", name);
                    Ed.putString("Psw", pass);
                    Ed.commit();
                }
            }
        });

        name = userName.getText().toString();
        pass = passWord.getText().toString();

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(pass)) {
            SharedPreferences sp1 = this.getSharedPreferences("Login", MODE_PRIVATE);

            String unm = sp1.getString("Unm", null);
            String pss = sp1.getString("Psw", null);

            userName.setText(unm);
            passWord.setText(pss);
        }


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = userName.getText().toString();
                pass = passWord.getText().toString();



                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(pass)) {
                    Toast.makeText(LoginActivity.this, "All Fields are Important", Toast.LENGTH_SHORT).show();
                }
                else {
                    progressDialog.setMessage("Please wait while Login..");
                    progressDialog.setTitle("Login");
                    progressDialog.setCanceledOnTouchOutside(false);
                    progressDialog.show();

                    Login();

                }
            }
        });

        tvsignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void Login() {
        //call api presenter
        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}