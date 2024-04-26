package com.example.ecoapp.ui.profile;



import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.ecoapp.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;
    private static final String COINS = "Coins";
    private TextView Coins;
    private static final String PREF_NAME = "UserData";
    private int coinsCount;
    private TextView Name;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        Name = binding.name;
        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        String login = sharedPreferences.getString("login", "");

        Name.setText(login);

        Coins = binding.coinsProfile;

        SharedPreferences sharedPreferences2 = requireActivity().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        coinsCount = sharedPreferences2.getInt(COINS, 0);
        Coins.setText(String.valueOf(coinsCount));
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}