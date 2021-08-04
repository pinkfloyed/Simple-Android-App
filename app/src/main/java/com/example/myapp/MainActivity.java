package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.os.TokenWatcher;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    NavigationView nav;
    ActionBarDrawerToggle t;
    DrawerLayout d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar tool =(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(tool);

        nav=(NavigationView)findViewById(R.id.nav);
        d=(DrawerLayout)findViewById(R.id.draw);
        t=new ActionBarDrawerToggle(this,d,tool,R.string.low,R.string.high);
        d.addDrawerListener(t);
        t.syncState();


        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            Fragment x;
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId())
                {
                    case R.id.home:
                         x=new home();
                         break;
                    case R.id.about:
                        x=new about();
                        break;

                    case R.id.gallery:
                        x=new gallery();
                        break;

                    case R.id.settings:
                        x=new settings();
                        break;

                    case R.id.contact:
                        x=new contactmail();
                        break;

                    case R.id.call:
                        x=new call();
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,x).commit();
                d.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }
}