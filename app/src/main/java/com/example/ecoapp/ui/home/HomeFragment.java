package com.example.ecoapp.ui.home;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.ecoapp.advices.ElectricityMainActivity;
import com.example.ecoapp.advices.FoodMainActivity;
import com.example.ecoapp.advices.RecyclingMainActivity;
import com.example.ecoapp.advices.WaterMainActivity;
import com.example.ecoapp.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {


    private static final String PREF_NAME = "UserData";
    private FragmentHomeBinding binding;

    private TextView Login;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Login = binding.helloText;

        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        String login = sharedPreferences.getString("login", "");

        Login.setText(login);

        binding.buttonElectricity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ElectricityMainActivity.class);
                startActivity(intent);
            }
        });

        binding.buttonWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), WaterMainActivity.class);
                startActivity(intent);
            }
        });

        binding.buttonFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FoodMainActivity.class);
                startActivity(intent);
            }
        });

        binding.buttonRecycling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RecyclingMainActivity.class);
                startActivity(intent);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}