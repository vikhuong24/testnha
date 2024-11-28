package com.example.test;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.example.test.fragment.BookMarkFragment;
import com.example.test.fragment.HomeFragment;
import com.example.test.fragment.InfomationFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView ;
        loadFragment(new HomeFragment());
        bottomNavigationView = findViewById(R.id.bottomnavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment  fragment = null;
                if (item.getItemId()== R.id.bookmark){
                    fragment = new BookMarkFragment();
                }if (item.getItemId()== R.id.user){
                    fragment = new InfomationFragment();
                }if (item.getItemId()== R.id.home) {
                    fragment = new HomeFragment();
                }
                return loadFragment(fragment);
            }
        });

    }
    private boolean  loadFragment(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container,fragment)
                    .commit();
            return  true;
        }
        return false;
    }

}