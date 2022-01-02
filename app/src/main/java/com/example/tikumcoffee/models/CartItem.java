package com.example.tikumcoffee.models;

import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.DiffUtil;

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
    @BindingAdapter("android:setValue")
    public static void getSelectedSpinnerValue(Spinner spinner,int quantity){
        spinner.setSelection(quantity -1, true);
    }

    public static DiffUtil.ItemCallback<CartItem> itemCallback = new DiffUtil.ItemCallback<CartItem>() {
        @Override
        public boolean areItemsTheSame(@NonNull CartItem oldItem, @NonNull CartItem newItem) {
            return oldItem.getQuantity() == newItem.getQuantity();
        }

        @Override
        public boolean areContentsTheSame(@NonNull CartItem oldItem, @NonNull CartItem newItem) {
            return oldItem.equals(newItem);
        }
    };

}
