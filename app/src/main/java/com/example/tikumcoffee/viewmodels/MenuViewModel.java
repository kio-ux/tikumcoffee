package com.example.tikumcoffee.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tikumcoffee.models.MenuCoffee;
import com.example.tikumcoffee.repository.MenuRepo;

import java.util.List;

public class MenuViewModel extends ViewModel {

    MenuRepo menuRepo = new MenuRepo();

    MutableLiveData<MenuCoffee> mutableMenuCoffee = new MutableLiveData<>();

    public LiveData<List<MenuCoffee>> getProducts() { return menuRepo.getMenuCoffees(); }

    public  void  setMenuCoffee(MenuCoffee menuCoffee) {
        mutableMenuCoffee.setValue(menuCoffee);
    }

    public LiveData<MenuCoffee> getMenuCoffee() {
        return mutableMenuCoffee;
    }
}
