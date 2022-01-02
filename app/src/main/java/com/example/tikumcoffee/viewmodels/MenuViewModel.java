package com.example.tikumcoffee.viewmodels;

import android.view.Menu;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tikumcoffee.models.CartItem;
import com.example.tikumcoffee.models.MenuCoffee;
import com.example.tikumcoffee.repository.CartRepo;
import com.example.tikumcoffee.repository.MenuRepo;

import java.util.List;

public class MenuViewModel extends ViewModel {

    MenuRepo menuRepo = new MenuRepo();
    CartRepo cartRepo = new CartRepo();

    MutableLiveData<MenuCoffee> mutableMenuCoffee = new MutableLiveData<>();

    public LiveData<List<MenuCoffee>> getProducts() { return menuRepo.getMenuCoffees(); }

    public  void  setMenuCoffee(MenuCoffee menuCoffee) {
        mutableMenuCoffee.setValue(menuCoffee);
    }

    public LiveData<MenuCoffee> getMenuCoffee() {
        return mutableMenuCoffee;
    }

    public LiveData<List<CartItem>> getCart(){

        return cartRepo.getCart();
    }

    public boolean addItemToCart(MenuCoffee menuCoffee){
        return  cartRepo.addItemToCart(menuCoffee);
    }
    public void removeItemFromCart(CartItem cartItem){
        cartRepo.removeItemFromCart(cartItem);
    }
    public void changeQuantity(CartItem cartItem, int quantity){
        cartRepo.changeQuantity(cartItem,quantity);
    }
    public LiveData<Double> getTotalPrice(){
        return cartRepo.getTotalPrice();
    }
    public void resetCart(){
        cartRepo.initCart();
    }
}
