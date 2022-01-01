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

        menuCoffeeList.add(new MenuCoffee(UUID.randomUUID().toString(), "Es kopi Gula Aren Tikum", 22000, "nanti link firebase", "Es kopi susu kekinian, kopi dengan susu dan gula aren yang disajikan dingin dengan es"));
        menuCoffeeList.add(new MenuCoffee(UUID.randomUUID().toString(), "Es Kopi Dalgona Tikum", 15000, "nanti link firebase", "Minuman viral pandemi yang dibuat dengan mencampurkan dan mengadukan campuran kopi, gula, dan air panas lalu disajikan dengan es"));
        menuCoffeeList.add(new MenuCoffee(UUID.randomUUID().toString(), "Kopi Vietnam", 25000, "nanti link firebase", "Kopi yang berasal dari Vietnam yang dibuat dari kopi dan susu kental manis"));
        menuCoffeeList.add(new MenuCoffee(UUID.randomUUID().toString(), "Americano", 20000, "nanti link firebase", "Kopi yang dibuat dengan mencampurkan seloku dengan air panas sebanyak 6 hingga 8 ons"));
        menuCoffeeList.add(new MenuCoffee(UUID.randomUUID().toString(), "Espresso (Shot Black)", 23000, "nanti link firebase", "Kopi dengan pembuatan menggunakan metode tekanan tinggi dari Italia, yaitu dengan menggiling biji kopi hingga alis dan dipadatkan"));
        menuCoffeeList.add(new MenuCoffee(UUID.randomUUID().toString(), "Kopi Latte", 26000, "nanti link firebase", "Kopi espresso yang di steam dengan susu"));
        menuCoffeeList.add(new MenuCoffee(UUID.randomUUID().toString(), "Kopi Piccolo", 26000, "nanti link firebase", "Kopi yang di steam dengan susu dengan campurn kopi lebih banyak"));

        mutableMenuCoffeeList.setValue(menuCoffeeList);
    }
}
