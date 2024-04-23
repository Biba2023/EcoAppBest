package com.example.ecoapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.ecoapp.advices.electricity.ElectricityMainActivity;
import com.example.ecoapp.ui.home.HomeViewModel;

public class HomeFragment extends Fragment {

    private com.example.ecoapp.databinding.FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = com.example.ecoapp.databinding.FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.buttonElectricity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(requireContext(), ElectricityMainActivity.class);
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