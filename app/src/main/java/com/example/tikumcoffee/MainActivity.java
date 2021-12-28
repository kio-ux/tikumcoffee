package com.example.tikumcoffee;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.Vector;

public class MainActivity extends Fragment {

    Vector<Coffee> coffeeList = new Vector<>();
    GridView gridView;

    private int[] mImages = new int[]{
            R.drawable.test_dua, R.drawable.test_satu, R.drawable.test_empat
    };

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main,container,false);

        setData();
        gridView = view.findViewById(R.id.coffeeGrid);
        CoffeeAdapter adapter = new CoffeeAdapter(getActivity(), R.layout.coffee_item, coffeeList);
        gridView.setAdapter(adapter);


        CarouselView carouselView = view.findViewById(R.id.carousel);
        carouselView.setPageCount(mImages.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(mImages[position]);
            }
        });


        return view;
    }

    private void setData(){
        coffeeList.add(new Coffee("C0001", "Dalgona Coffee", "Ini adalah kopi enak brow", 79000, R.drawable.dalgona));
        coffeeList.add(new Coffee("C0001", "Dalgona Coffee", "Ini adalah kopi enak brow", 79000, R.drawable.dalgona));
        coffeeList.add(new Coffee("C0001", "Dalgona Coffee", "Ini adalah kopi enak brow", 79000, R.drawable.dalgona));
        coffeeList.add(new Coffee("C0001", "Dalgona Coffee", "Ini adalah kopi enak brow", 79000, R.drawable.dalgona));

    }

}