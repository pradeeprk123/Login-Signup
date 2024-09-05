package com.example.madassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;


import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class NavigationDrawer extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_naw,R.string.close_naw);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ImportFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_import);
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.nav_import){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ImportFragment()).commit();
        }
        else if(id == R.id.nav_gallery){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new GalleryFragment()).commit();
        }
        else if(id == R.id.nav_slideshow){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new SlideshowFragment()).commit();
        }
        else if(id == R.id.nav_build){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ToolsFragment()).commit();
        }
        else if (id == R.id.logout){
            Toast.makeText(this, "Logging Out!!!", Toast.LENGTH_SHORT).show();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }

}