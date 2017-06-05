package com.dev.ninaadpai.storyteller.fragments;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dev.ninaadpai.storyteller.LandingActivity;
import com.dev.ninaadpai.storyteller.MainActivity;
import com.dev.ninaadpai.storyteller.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllStoriesFragment extends Fragment {
    TextView onGoing, completed;
    public AllStoriesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_stories, container, false);
        onGoing = (TextView)view.findViewById(R.id.onGoing);
        completed = (TextView)view.findViewById(R.id.completed);
        onGoing.setTypeface(LandingActivity.roboto);
        completed.setTypeface(LandingActivity.roboto);
        return view;
    }
}
