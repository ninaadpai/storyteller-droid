package com.dev.ninaadpai.storyteller.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dev.ninaadpai.storyteller.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ForYouFragment extends Fragment {


    public ForYouFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_for_you, container, false);
        return view;
    }

}
