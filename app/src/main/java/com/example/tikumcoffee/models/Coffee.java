package com.example.tikumcoffee.models;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import java.util.Objects;

public class Coffee {
    private String coffeeId;
    private String coffeeName;
    private Integer coffeePrice;
    private Integer coffeeImage;

    public Coffee(String coffeeId, String coffeeName, String coffeeDescription, Integer coffeePrice, Integer coffeeImage) {
        this.coffeeId = coffeeId;
        this.coffeeName = coffeeName;
        this.coffeePrice = coffeePrice;
        this.coffeeImage = coffeeImage;
    }

    public String getCoffeeId() {
        return coffeeId;
    }

    public void setCoffeeId(String coffeeId) {
        this.coffeeId = coffeeId;
    }

    public String getCoffeeName() {
        return coffeeName;
    }

    public void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
    }


    public Integer getCoffeePrice() {
        return coffeePrice;
    }

    public void setCoffeePrice(Integer coffeePrice) {
        this.coffeePrice = coffeePrice;
    }

    public Integer getCoffeeImage() {
        return coffeeImage;
    }

    public void setCoffeeImage(Integer coffeeImage) {
        this.coffeeImage = coffeeImage;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "coffeeId='" + coffeeId + '\'' +
                ", coffeeName='" + coffeeName + '\'' +
                ", coffeePrice=" + coffeePrice +
                ", coffeeImage=" + coffeeImage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return getCoffeeId().equals(coffee.getCoffeeId()) && getCoffeeName().equals(coffee.getCoffeeName()) && getCoffeePrice().equals(coffee.getCoffeePrice()) && getCoffeeImage().equals(coffee.getCoffeeImage());
    }

    public static DiffUtil.ItemCallback<Coffee> itemCallback = new DiffUtil.ItemCallback<Coffee>() {
        @Override
        public boolean areItemsTheSame(@NonNull Coffee oldItem, @NonNull Coffee newItem) {
            return oldItem.getCoffeeId().equals(newItem.getCoffeeId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Coffee oldItem, @NonNull Coffee newItem) {
            return oldItem.equals(newItem);
        }
    };

}
