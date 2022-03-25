package com.example.navigationbarwithpaddyleaf.ui.home;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.navigationbarwithpaddyleaf.BackKeyPressListner;
import com.example.navigationbarwithpaddyleaf.CropDiseasesActivity;
import com.example.navigationbarwithpaddyleaf.R;
import com.example.navigationbarwithpaddyleaf.SliderAdapter;
import com.example.navigationbarwithpaddyleaf.databinding.FragmentHomeBinding;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class HomeFragment extends Fragment implements BackKeyPressListner {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    Button button;
    private int[] images;
    SliderAdapter adapter;
    SliderView sliderView;
    public static BackKeyPressListner listner;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        sliderView=root.findViewById(R.id.sliderView);
        images=new int[]{R.drawable.slider9,R.drawable.slider5,R.drawable.slider6,R.drawable.slider7,R.drawable.slider8};
        adapter=new SliderAdapter(images);
        sliderView.setSliderAdapter(adapter);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.DROP);
        sliderView.startAutoCycle();

       // final TextView textView = binding.textHome;
        //final ImageView imageView = binding.image;
        final Button button = binding.homebutton;
       // homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
          //  @Override
           // public void onChanged(@Nullable String s) {
               // textView.setText(s);
           // }
       // });

        //for passing intent
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), CropDiseasesActivity.class);
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

    @Override
    public void backPress() {
        AlertDialog.Builder alertdialog;
        alertdialog = new AlertDialog.Builder(getActivity());
        alertdialog.setIcon(R.drawable.ic_baseline_warning_24);
        alertdialog.setTitle("Exit");
        alertdialog.setMessage("Do You Want to Exit");
        alertdialog.setCancelable(false);

        alertdialog.setPositiveButton("Yes", (dialog, which) -> getActivity().finish());
        alertdialog.setNegativeButton("No", (dialog, which) -> dialog.cancel());

        AlertDialog alertDialog = alertdialog.create();
        alertDialog.show();
    }
    @Override
    public void onPause() {
        listner = null;
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        listner = this;
    }
}