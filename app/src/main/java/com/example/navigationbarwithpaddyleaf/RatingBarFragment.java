package com.example.navigationbarwithpaddyleaf;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RatingBarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RatingBarFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
Button btn;
RatingBar ratingBar;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RatingBarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RatingBarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RatingBarFragment newInstance(String param1, String param2) {
        RatingBarFragment fragment = new RatingBarFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v= inflater.inflate(R.layout.fragment_rating_bar, container, false);
     ratingBar=v.findViewById(R.id.rating);
      btn=v.findViewById(R.id.rating_bar_submit);
      btn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Toasty.success(getActivity(), "Rating Value"+ratingBar.getRating(), Toast.LENGTH_LONG, true).show();
              //Toast.makeText(getActivity(), "Rating Value"+ratingBar.getRating(), Toast.LENGTH_LONG).show();
          }
      });
        return v;
    }
}