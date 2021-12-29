package com.example.tikumcoffee.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tikumcoffee.databinding.CoffeeItemBinding;
import com.example.tikumcoffee.models.Coffee;

public class CoffeeAdapter extends ListAdapter<Coffee, CoffeeAdapter.CoffeeMenuHolder> {

    public CoffeeAdapter() {
        super(Coffee.itemCallback);
    }

    @NonNull
    @Override
    public CoffeeMenuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        CoffeeItemBinding coffeeItemBinding = CoffeeItemBinding.inflate(layoutInflater,parent,false);
        return new CoffeeMenuHolder(coffeeItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CoffeeMenuHolder holder, int position) {

        Coffee coffee = getItem(position);
//        holder.coffeeItemBinding.
    }

    class CoffeeMenuHolder extends RecyclerView.ViewHolder{

        CoffeeItemBinding coffeeItemBinding;

        public CoffeeMenuHolder(CoffeeItemBinding binding) {
            super(binding.getRoot());
            this.coffeeItemBinding = binding;
        }
    }
    public interface CoffeeInterface{
        void addItem(Coffee coffee);
        void onItemClick(Coffee coffee);
    }
}
