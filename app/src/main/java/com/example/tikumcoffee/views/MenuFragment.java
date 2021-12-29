package com.example.tikumcoffee.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tikumcoffee.adapters.CoffeeAdapter;
import com.example.tikumcoffee.adapters.MenuListAdapter;
import com.example.tikumcoffee.databinding.FragmentMenuBinding;
import com.example.tikumcoffee.models.Coffee;
import com.example.tikumcoffee.models.MenuCoffee;

public class MenuFragment extends Fragment implements MenuListAdapter.MenuInterface {

    FragmentMenuBinding fragmentMenuBinding;
    MenuListAdapter menuListAdapter;


    public MenuFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        fragmentMenuBinding = FragmentMenuBinding.inflate(inflater,container,false);

        return fragmentMenuBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        menuListAdapter = new MenuListAdapter();
        fragmentMenuBinding.menuRecyclerView.setAdapter(menuListAdapter);

    }

    @Override
    public void addItem(MenuCoffee menuCoffee) {

    }

    @Override
    public void onItemClick(MenuCoffee menuCoffee) {

    }
}
