package com.example.jidlo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHelper(this);

        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }
        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.pager);
        ViewPageAdapter adapter = new ViewPageAdapter(getSupportFragmentManager());

        adapter.addFragment(new BreakfastFragment(), "Breakfast");
        adapter.addFragment(new LunchFragment(), "Lunch");
        adapter.addFragment(new DinnerFragment(), "Dinner");
        adapter.addFragment(new SnacksFragment(), "Snacks");
        adapter.addFragment(new DessertsFragment(), "Desserts");

        viewPager.setAdapter(adapter);

        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);

        View view1 = LayoutInflater.from(this).inflate(R.layout.custom_tab_layout, null);
        ((ImageView) view1.findViewById(R.id.image)).setImageResource(R.drawable.breakfast);

        View view2 = LayoutInflater.from(this).inflate(R.layout.custom_tab_layout, null);
        ((ImageView) view2.findViewById(R.id.image)).setImageResource(R.drawable.lunch);

        View view3 = LayoutInflater.from(this).inflate(R.layout.custom_tab_layout, null);
        ((ImageView) view3.findViewById(R.id.image)).setImageResource(R.drawable.dinner);

        View view4 = LayoutInflater.from(this).inflate(R.layout.custom_tab_layout, null);
        ((ImageView) view4.findViewById(R.id.image)).setImageResource(R.drawable.snacks);

        View view5 = LayoutInflater.from(this).inflate(R.layout.custom_tab_layout, null);
        ((ImageView) view5.findViewById(R.id.image)).setImageResource(R.drawable.desserts);

        tabLayout.getTabAt(0).setCustomView(view1);
        tabLayout.getTabAt(1).setCustomView(view2);
        tabLayout.getTabAt(2).setCustomView(view3);
        tabLayout.getTabAt(3).setCustomView(view4);
        tabLayout.getTabAt(4).setCustomView(view5);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);



    }
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen((GravityCompat.START))){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem){

        switch (menuItem.getItemId()){

            case R.id.nav_contactUs:
                Intent intent = new Intent (MainActivity.this, ContactUsForm.class);
                startActivity(intent);
                break;

            case R.id.nav_profile:
                Intent intent1 = new Intent (MainActivity.this, ProfileActivity.class);
                startActivity(intent1);
                break;

            case R.id.nav_send_recipe:
                Intent intent2 = new Intent (MainActivity.this, SendARecipeActivity.class);
                startActivity(intent2);
                break;

            case R.id.nav_login:
                Intent intent3 = new Intent (MainActivity.this, LoginActivity.class);
                startActivity(intent3);
                break;




        }
        return true;
    }
}
