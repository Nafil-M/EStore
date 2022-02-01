package com.example.e_store.KidsSection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.e_store.R;

public class KidsActivity extends AppCompatActivity {

    TextView boys,girls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids);

        boys = findViewById(R.id.boys);
        girls = findViewById(R.id.girls);

        boys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KidsActivity.this,BoysActivity.class);
                startActivity(intent);
            }
        });

        girls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KidsActivity.this,GirlsActivity.class);
                startActivity(intent);
            }
        });


    }

    public void onClickBack(View view) {
        finish();
    }
}