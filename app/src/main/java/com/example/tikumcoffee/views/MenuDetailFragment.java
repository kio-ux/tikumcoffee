package com.example.tikumcoffee.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tikumcoffee.R;
import com.example.tikumcoffee.databinding.FragmentMenuDetailBinding;
import com.example.tikumcoffee.viewmodels.MenuViewModel;

public class MenuDetailFragment extends Fragment {

    FragmentMenuDetailBinding fragmentMenuDetailBinding;
    MenuViewModel menuViewModel;

    public MenuDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentMenuDetailBinding = FragmentMenuDetailBinding.inflate(inflater, container, false);
        return fragmentMenuDetailBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        menuViewModel = new ViewModelProvider(requireActivity()).get(MenuViewModel.class);
        fragmentMenuDetailBinding.setMenuViewModel(menuViewModel);
    }
}