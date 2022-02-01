package com.example.e_store;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.e_store.Cart.CartActivity;
import com.example.e_store.KidsSection.KidsActivity;
import com.example.e_store.MensSection.MensActivity;
import com.example.e_store.MyOrders.MyOrderActivity;
import com.example.e_store.WomensSection.WomensActivity;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    RelativeLayout kids,men,women;
    ImageView cart;
    boolean doubleBackToExitPressedOnce = false;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.navigation_view);
        kids = findViewById(R.id.kidslyt);
        men = findViewById(R.id.menslyt);
        women = findViewById(R.id.womenslyt);
        cart = findViewById(R.id.cart_icon);

        setDrawerInMainActivity();

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cartintent = new Intent(MainActivity.this, CartActivity.class);
                startActivity(cartintent);
            }
        });


        kids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, KidsActivity.class);
                startActivity(intent);
            }
        });

        men.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MensActivity.class);
                startActivity(intent);
            }
        });

        women.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WomensActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setDrawerInMainActivity() {
        drawerLayout = findViewById(R.id.act_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("");
        drawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.drawer_open,
                R.string.drawer_close
        );
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_sort_24);

        navigationView = findViewById(R.id.navigation_view);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int menuItemId = item.getItemId();
                switch (menuItemId) {
                    case R.id.myac: {
//                            Intent intent = new Intent(HomeActivity.this, MyAccountActivity.class);
//                            startActivity(intent);
                        break;
                    }

                    case R.id.myorders: {
                        Intent mointent = new Intent(MainActivity.this, MyOrderActivity.class);
                        startActivity(mointent);
                        break;
                    }

                    case R.id.aboutus: {
                        Intent auintent = new Intent(Intent.ACTION_VIEW);
                        Uri uri = Uri.parse("https://www.google.com/");
                        auintent.setData(uri);
                        startActivity(auintent);
                        break;
                    }

                    case R.id.contactus: {
                        Intent cuintent = new Intent(Intent.ACTION_DIAL);
                        cuintent.setData(Uri.parse("tel:9999999999"));
                        startActivity(cuintent);
                        break;
                    }

                    case R.id.shareapp: {
                            Intent intent = new Intent(MainActivity.this,ShareAppActivity.class);
                            startActivity(intent);
                    }

                    case R.id.develeporcontact: {
                        Intent dcintent = new Intent(Intent.ACTION_VIEW);
                        Uri uri = Uri.parse("https://www.webinfosoftwares.com/");
                        dcintent.setData(uri);
                        startActivity(dcintent);
                        break;
                    }

                }
                return true;
            }
        });


    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}