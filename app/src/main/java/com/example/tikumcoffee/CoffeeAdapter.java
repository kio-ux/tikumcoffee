package com.example.tikumcoffee;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Vector;

public class CoffeeAdapter extends ArrayAdapter<Coffee> {

    private Context context;
    private int resource;

    public CoffeeAdapter(@NonNull Context context, int resource, @NonNull Vector<Coffee> coffeeList) {
        super(context, resource, coffeeList);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String coffeeName = getItem(position).getCoffeeName();
        Integer coffeePrice = getItem(position).getCoffeePrice();
        Integer coffeeImage = getItem(position).getCoffeeImage();

        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resource, parent, false);

        TextView coffeeNameText = convertView.findViewById(R.id.coffeeNameText);
        ImageView coffeeNameImage = convertView.findViewById(R.id.coffeeImageInt);
        TextView coffeeNamePrice = convertView.findViewById(R.id.coffeePriceText);

        coffeeNameText.setText(coffeeName);
        coffeeNamePrice.setText(coffeePrice.toString());
        coffeeNameImage.setImageResource(coffeeImage);

        return convertView;

    }
}
