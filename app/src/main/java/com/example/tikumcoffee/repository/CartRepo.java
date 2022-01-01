package com.example.tikumcoffee.repository;

import android.view.Menu;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.tikumcoffee.models.CartItem;
import com.example.tikumcoffee.models.MenuCoffee;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CartRepo {

    private MutableLiveData<List<CartItem>> mutableCart = new MutableLiveData<>();

    public LiveData<List<CartItem>> getCart(){
        if(mutableCart.getValue()==null){
            initCart();
        }
        return mutableCart;
    }
    public void initCart(){
        mutableCart.setValue(new ArrayList<CartItem>());
    }

    public boolean addItemToCart(MenuCoffee menuCoffee){
        if (mutableCart.getValue()==null){
            initCart();
        }
        List<CartItem> cartItemList = new ArrayList<>(mutableCart.getValue());

        CartItem cartItem = new CartItem(menuCoffee,1);
        cartItemList.add(cartItem);
        mutableCart.setValue(cartItemList);
        return true;
    }


}
