package com.example.ecoapp.ui.events;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.ecoapp.CustomeAdapter;
import com.example.ecoapp.ImageModel;
import com.example.ecoapp.R;
import com.example.ecoapp.databinding.FragmentDashboardBinding;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private ListView lv;
    private CustomeAdapter customeAdapter;
    private ArrayList<ImageModel> imageModelArrayList;
    private int[] myImageList = new int[]{R.drawable.bottles_for_recycling, R.drawable.bottles_for_recycling, R.drawable.bottles_for_recycling, R.drawable.bottles_for_recycling};
    private String[] myImageNameList = new String[]{"Сдайте 10 пластиковых бутылок в ближайший пункт переработки и получите 50 эко-баллов",
            "Сдайте 10 пластиковых бутылок в ближайший пункт переработки и получите 50 эко-баллов", "Сдайте 10 пластиковых бутылок в ближайший пункт переработки и получите 50 эко-баллов",
            "Сдайте 10 пластиковых бутылок в ближайший пункт переработки и получите 50 эко-баллов"};
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        lv = (ListView) root.findViewById(R.id.listView);
        imageModelArrayList = populateList();
        Log.d("hjhjh",imageModelArrayList.size()+"");
        customeAdapter = new CustomeAdapter(getContext(),imageModelArrayList);
        lv.setAdapter(customeAdapter);

        return root;
    }

    private ArrayList<ImageModel> populateList(){
        ArrayList<ImageModel> list = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            ImageModel imageModel = new ImageModel();
            imageModel.setName(myImageNameList[i]);
            imageModel.setImage_drawable(myImageList[i]);
            list.add(imageModel);
        }
        return list;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}