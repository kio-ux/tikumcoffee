package com.example.tikumcoffee.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tikumcoffee.R;
import com.example.tikumcoffee.databinding.FragmentCheckoutBinding;
import com.example.tikumcoffee.viewmodels.MenuViewModel;


public class FragmentCheckout extends Fragment {

    NavController navController;
    FragmentCheckoutBinding fragmentCheckoutBinding;
    MenuViewModel menuViewModel;


    public FragmentCheckout() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentCheckoutBinding = FragmentCheckoutBinding.inflate(inflater,container,false);
        return fragmentCheckoutBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        menuViewModel = new ViewModelProvider(requireActivity()).get(MenuViewModel.class);
        fragmentCheckoutBinding.btnBackToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menuViewModel.resetCart();
                navController.navigate(R.id.action_fragmentCheckout_to_mainActivity2);
            }
        });
    }
}