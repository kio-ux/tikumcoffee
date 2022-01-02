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
    private MutableLiveData<Double> mutableTotalPrice = new MutableLiveData<>();

    public LiveData<List<CartItem>> getCart(){
        if(mutableCart.getValue()==null){
            initCart();
        }
        return mutableCart;
    }
    public void initCart(){
        mutableCart.setValue(new ArrayList<CartItem>());
        calculateCartTotal();
    }

    public boolean addItemToCart(MenuCoffee menuCoffee){
        if (mutableCart.getValue()==null){
            initCart();
        }
        List<CartItem> cartItemList = new ArrayList<>(mutableCart.getValue());
        for (CartItem cartItem : cartItemList){
            if (cartItem.getMenuCoffee().getId().equals(menuCoffee.getId())){
                if (cartItem.getQuantity()==10){
                    return false;
                }

                int index = cartItemList.indexOf(cartItem);
                cartItem.setQuantity(cartItem.getQuantity()+1);
                cartItemList.set(index,cartItem);

                mutableCart.setValue(cartItemList);
                calculateCartTotal();

                return true;

            }
        }

        CartItem cartItem = new CartItem(menuCoffee,1);
        cartItemList.add(cartItem);
        mutableCart.setValue(cartItemList);
        calculateCartTotal();
        return true;
    }
    public void removeItemFromCart(CartItem cartItem){
        if (mutableCart.getValue()==null){
            return;
        }
        List<CartItem> cartItemList = new ArrayList<>(mutableCart.getValue());
        cartItemList.remove(cartItem);
        mutableCart.setValue(cartItemList);
        calculateCartTotal();
    }
    public void changeQuantity(CartItem cartItem,int quantity){
        if (mutableCart.getValue()==null){
            return;
        }
        List<CartItem> cartItemList = new ArrayList<>(mutableCart.getValue());
        CartItem updatedItem = new CartItem(cartItem.getMenuCoffee(),quantity);
        cartItemList.set(cartItemList.indexOf(cartItem),updatedItem);
        mutableCart.setValue(cartItemList);
        calculateCartTotal();
    }

    private void calculateCartTotal(){
        if(mutableCart.getValue()==null)return;
        double total = 0.0;
        List<CartItem> cartItemList = mutableCart.getValue();
        for (CartItem cartItem: cartItemList){
            total += cartItem.getMenuCoffee().getHargaCoffee()* cartItem.getQuantity();
        }
        mutableTotalPrice.setValue(total);
    }

    public LiveData<Double> getTotalPrice(){
        if (mutableTotalPrice.getValue()==null){
            mutableTotalPrice.setValue(0.0);
        }
        return mutableTotalPrice;
    }


}
