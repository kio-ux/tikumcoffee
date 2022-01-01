package com.example.tikumcoffee.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tikumcoffee.databinding.MenuRowBinding;
import com.example.tikumcoffee.models.MenuCoffee;

public class MenuListAdapter extends ListAdapter<MenuCoffee, MenuListAdapter.MenuViewHolder> {

    MenuInterface menuInterface;
    public MenuListAdapter(MenuInterface menuInterface) {
        super(MenuCoffee.itemCallback);
        this.menuInterface = menuInterface;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        MenuRowBinding menuRowBinding = MenuRowBinding.inflate(layoutInflater,parent,false);
        menuRowBinding.setMenuInterface(menuInterface);

        return new MenuViewHolder(menuRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {

        MenuCoffee menuCoffee = getItem(position);
        holder.menuRowBinding.setMenuCoffee(menuCoffee);
    }

    class MenuViewHolder extends RecyclerView.ViewHolder{

        MenuRowBinding menuRowBinding;


        public MenuViewHolder(MenuRowBinding binding) {
            super(binding.getRoot());
            this.menuRowBinding = binding;

        }
    }
    public interface MenuInterface{
        void addItem(MenuCoffee menuCoffee);
        void onItemClick(MenuCoffee menuCoffee);
    }




}
