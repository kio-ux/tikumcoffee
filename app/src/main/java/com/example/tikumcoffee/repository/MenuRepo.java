package com.example.tikumcoffee.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.tikumcoffee.models.MenuCoffee;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MenuRepo {

    private MutableLiveData<List<MenuCoffee>> mutableMenuCoffeeList;

    public LiveData<List<MenuCoffee>> getMenuCoffees() {
        if (mutableMenuCoffeeList ==  null) {
            mutableMenuCoffeeList = new MutableLiveData<>();
            loadMenuCoffee();
        }
        return mutableMenuCoffeeList;
    }

    private void loadMenuCoffee() {
        List<MenuCoffee> menuCoffeeList = new ArrayList<>();

        menuCoffeeList.add(new MenuCoffee(UUID.randomUUID().toString(), "Kopi Gula Aren", 18000, "nanti link firebase"));
        menuCoffeeList.add(new MenuCoffee(UUID.randomUUID().toString(), "Kopi Dalgona", 18000, "nanti link firebase"));
        menuCoffeeList.add(new MenuCoffee(UUID.randomUUID().toString(), "Matcha Latte", 18000, "nanti link firebase"));
        menuCoffeeList.add(new MenuCoffee(UUID.randomUUID().toString(), "Kopi kir aja sendiri", 18000, "nanti link firebase"));
        menuCoffeeList.add(new MenuCoffee(UUID.randomUUID().toString(), "Kopi ah", 18000, "nanti link firebase"));
        menuCoffeeList.add(new MenuCoffee(UUID.randomUUID().toString(), "Americano", 18000, "nanti link firebase"));
        menuCoffeeList.add(new MenuCoffee(UUID.randomUUID().toString(), "Kopi Vietnam", 18000, "nanti link firebase"));

        mutableMenuCoffeeList.setValue(menuCoffeeList);
    }
}
