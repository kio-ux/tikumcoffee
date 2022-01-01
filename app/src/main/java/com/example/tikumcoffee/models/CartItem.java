package com.example.tikumcoffee.models;

import java.util.Objects;

public class CartItem {

    private MenuCoffee menuCoffee;
    private int quantity;

    public CartItem(MenuCoffee menuCoffee, int quantity) {
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
        return "CartItem{" +
                "menuCoffee=" + menuCoffee +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return getQuantity() == cartItem.getQuantity() && getMenuCoffee().equals(cartItem.getMenuCoffee());
    }

}
