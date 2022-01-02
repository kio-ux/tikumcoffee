package com.example.tikumcoffee.views;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;

import com.example.tikumcoffee.R;
import com.example.tikumcoffee.adapters.CartListAdapter;
import com.example.tikumcoffee.databinding.FragmentCartBinding;
import com.example.tikumcoffee.databinding.FragmentMenuBinding;
import com.example.tikumcoffee.models.CartItem;
import com.example.tikumcoffee.viewmodels.MenuViewModel;

import java.util.List;

public class CartFragment extends Fragment implements CartListAdapter.CartInterface {

    MenuViewModel menuViewModel;
    FragmentCartBinding fragmentCartBinding;
    NavController navController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart,container,false);

        navController = Navigation.findNavController(view);

        fragmentCartBinding = FragmentCartBinding.inflate(inflater,container,false);
        return fragmentCartBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CartListAdapter cartListAdapter = new CartListAdapter(this);

        fragmentCartBinding.cartRecyclerView.setAdapter(cartListAdapter);
        fragmentCartBinding.cartRecyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));

        menuViewModel = new ViewModelProvider(requireActivity()).get(MenuViewModel.class);
        menuViewModel.getCart().observe(getViewLifecycleOwner(), new Observer<List<CartItem>>() {
            @Override
            public void onChanged(List<CartItem> cartItems) {
              cartListAdapter.submitList(cartItems);
              fragmentCartBinding.btnAddToCart.setEnabled(cartItems.size()>0);
            }
        });
        menuViewModel.getTotalPrice().observe(getViewLifecycleOwner(), new Observer<Double>() {
            @Override
            public void onChanged(Double aDouble) {
                fragmentCartBinding.TotalOrder.setText("Total : Rp"+aDouble.toString());
            }
        });

        fragmentCartBinding.btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_cartFragment2_to_fragmentCheckout);
            }
        });
    }

    @Override
    public void deleteItem(CartItem cartItem) {
    menuViewModel.removeItemFromCart(cartItem);
    }

    @Override
    public void changeQuantity(CartItem cartItem, int quantity) {
        menuViewModel.changeQuantity(cartItem,quantity);
    }
}
