package com.example.tikumcoffee.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.tikumcoffee.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView botNav = findViewById(R.id.bottomNav);
        NavController navController = Navigation.findNavController(this,R.id.fragment_container);
        NavigationUI.setupWithNavController(botNav, navController);
        NavigationUI.setupActionBarWithNavController(this, navController);
    }


}