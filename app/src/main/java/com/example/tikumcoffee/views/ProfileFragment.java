package com.example.tikumcoffee.views;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.tikumcoffee.R;

public class ProfileFragment extends Fragment implements View.OnClickListener{
    TextView usernameText;
    Button logoutButton;

    public ProfileFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile,container,false);

        logoutButton = view.findViewById(R.id.logoutButton);
        usernameText = view.findViewById(R.id.usernameProfileText);

        logoutButton.setOnClickListener(this);


        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View view) {
        if (view == logoutButton){
            Intent logout = new Intent(getActivity(), LoginActivity.class);
            startActivity(logout);
        }
    }
}