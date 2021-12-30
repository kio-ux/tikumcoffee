package com.example.tikumcoffee.models;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.DiffUtil;

import com.bumptech.glide.Glide;

import java.util.Objects;

public class MenuCoffee {
    private String id;
    private String namaCoffee;
    private double hargaCoffee;
    private String imageCoffee;

    public MenuCoffee(String id, String namaCoffee, double hargaCoffee, String imageCoffee) {
        this.id = id;
        this.namaCoffee = namaCoffee;
        this.hargaCoffee = hargaCoffee;
        this.imageCoffee = imageCoffee;
    }

    @Override
    public String toString() {
        return "MenuCoffee{" +
                "id='" + id + '\'' +
                ", namaCoffee='" + namaCoffee + '\'' +
                ", hargaCoffee=" + hargaCoffee +
                ", imageCoffee='" + imageCoffee + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaCoffee() {
        return namaCoffee;
    }

    public void setNamaCoffee(String namaCoffee) {
        this.namaCoffee = namaCoffee;
    }

    public double getHargaCoffee() {
        return hargaCoffee;
    }

    public void setHargaCoffee(double hargaCoffee) {
        this.hargaCoffee = hargaCoffee;
    }

    public String getImageCoffee() {
        return imageCoffee;
    }

    public void setImageCoffee(String imageCoffee) {
        this.imageCoffee = imageCoffee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuCoffee that = (MenuCoffee) o;
        return Double.compare(that.getHargaCoffee(), getHargaCoffee()) == 0 && getId().equals(that.getId()) && getNamaCoffee().equals(that.getNamaCoffee()) && getImageCoffee().equals(that.getImageCoffee());
    }

    public static DiffUtil.ItemCallback<MenuCoffee> itemCallback = new DiffUtil.ItemCallback<MenuCoffee>() {
        @Override
        public boolean areItemsTheSame(@NonNull MenuCoffee oldItem, @NonNull MenuCoffee newItem) {
            return oldItem.getId().equals(newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull MenuCoffee oldItem, @NonNull MenuCoffee newItem) {
            return oldItem.equals(newItem);
        }
    };

    @BindingAdapter("android:menuCoffeeImage")
    public  static void loadImage(ImageView imageView, String ImageCoffee) {
        Glide.with(imageView)
                .load(ImageCoffee)
                .fitCenter()
                .into(imageView);
    }


}
