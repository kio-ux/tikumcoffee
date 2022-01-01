package com.example.tikumcoffee.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.tikumcoffee.R;
import com.example.tikumcoffee.models.CartItem;
import com.example.tikumcoffee.viewmodels.MenuViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

    NavController navController;
    MenuViewModel menuViewModel;
    private static final String TAG = "HomeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView botNav = findViewById(R.id.bottomNav);
        NavController navController = Navigation.findNavController(this,R.id.fragment_container);
        NavigationUI.setupWithNavController(botNav, navController);
        NavigationUI.setupActionBarWithNavController(this, navController);

        menuViewModel = new ViewModelProvider(this).get(MenuViewModel.class);
        menuViewModel.getCart().observe(this, new Observer<List<CartItem>>() {
            @Override
            public void onChanged(List<CartItem> cartItems) {
                Log.d(TAG, "onChanged: "+cartItems.size());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        NavigationUI.onNavDestinationSelected(item, navController);
        return super.onOptionsItemSelected(item);
    }
}