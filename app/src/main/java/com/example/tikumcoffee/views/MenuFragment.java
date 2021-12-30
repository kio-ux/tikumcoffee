package com.example.tikumcoffee.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;

import com.example.tikumcoffee.adapters.CoffeeAdapter;
import com.example.tikumcoffee.adapters.MenuListAdapter;
import com.example.tikumcoffee.databinding.FragmentMenuBinding;
import com.example.tikumcoffee.models.Coffee;
import com.example.tikumcoffee.models.MenuCoffee;
import com.example.tikumcoffee.viewmodels.MenuViewModel;

import java.util.List;

public class MenuFragment extends Fragment implements MenuListAdapter.MenuInterface {

    FragmentMenuBinding fragmentMenuBinding;
    MenuListAdapter menuListAdapter;
    MenuViewModel menuViewModel;


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
        fragmentMenuBinding.menuRecyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));
        fragmentMenuBinding.menuRecyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.HORIZONTAL));

        menuViewModel = new ViewModelProvider(requireActivity()).get(MenuViewModel.class);
        menuViewModel.getProducts().observe(getViewLifecycleOwner(), new Observer<List<MenuCoffee>>() {
            @Override
            public void onChanged(List<MenuCoffee> menuCoffees) {
                menuListAdapter.submitList(menuCoffees);
            }
        });
    }

    @Override
    public void addItem(MenuCoffee menuCoffee) {

    }

    @Override
    public void onItemClick(MenuCoffee menuCoffee) {

    }
}
