package com.example.tikumcoffee.repository;

import com.example.tikumcoffee.models.MenuCoffee;

import java.util.Objects;

public class CartRepo {

    private MenuCoffee menuCoffee;
    private int quantity;

    public CartRepo(MenuCoffee menuCoffee, int quantity) {
        this.menuCoffee = menuCoffee;
        this.quantity = quantity;
    }

    public MenuCoffee getMenuCoffee() {
        return menuCoffee;
    }

    public void setMenuCoffee(MenuCoffee menuCoffee) {
        this.menuCoffee = menuCoffee;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartRepo{" +
                "menuCoffee=" + menuCoffee +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartRepo cartRepo = (CartRepo) o;
        return getQuantity() == cartRepo.getQuantity() && getMenuCoffee().equals(cartRepo.getMenuCoffee());
    }

}
