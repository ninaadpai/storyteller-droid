package com.dev.ninaadpai.storyteller.fragments;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dev.ninaadpai.storyteller.LandingActivity;
import com.dev.ninaadpai.storyteller.MainActivity;
import com.dev.ninaadpai.storyteller.R;
import com.dev.ninaadpai.storyteller.adapters.StoryRecyclerAdapter;
import com.dev.ninaadpai.storyteller.pojo.Story;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.NativeExpressAdView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllStoriesFragment extends Fragment {
    TextView onGoing, completed;
    RecyclerView storyRecycler;
    StoryRecyclerAdapter storyRecyclerAdapter;
    List<Object> onGoingStoriesList;
    private static final String AD_UNIT_ID = "ca-app-pub-3940256099942544/1072772517";
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
        storyRecycler =(RecyclerView)view.findViewById(R.id.storyRecycler);
        storyRecycler.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        storyRecycler.setLayoutManager(layoutManager);
        onGoingStoriesList = new ArrayList<>();
        addStoryItems();
        addNativeAdItems();
        storyRecyclerAdapter = new StoryRecyclerAdapter(getContext(), onGoingStoriesList, 0);
        storyRecycler.setAdapter(storyRecyclerAdapter);
        onGoing.setTypeface(LandingActivity.roboto);
        completed.setTypeface(LandingActivity.roboto);
        onGoing.setText(Html.fromHtml("<u>Ongoing</u>"));
        onGoing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onGoing.setText(Html.fromHtml("<u>Ongoing</u>"));
                completed.setText(R.string.completed);
                storyRecyclerAdapter = new StoryRecyclerAdapter(getContext(), onGoingStoriesList, 0);
                storyRecycler.setAdapter(storyRecyclerAdapter);
            }
        });
        completed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                completed.setText(Html.fromHtml("<u>Completed</u>"));
                onGoing.setText(R.string.on_going);
                storyRecyclerAdapter = new StoryRecyclerAdapter(getContext(), onGoingStoriesList, 1);
                storyRecycler.setAdapter(storyRecyclerAdapter);
            }
        });
        return view;
    }

    private void addNativeAdItems() {
        for(int i=0; i<onGoingStoriesList.size(); i+=15) {
            NativeExpressAdView adView = new NativeExpressAdView(getContext());
            adView.setAdUnitId(AD_UNIT_ID);
            onGoingStoriesList.add(i,adView);
        }
        storyRecycler.post(new Runnable() {
            @Override
            public void run() {
                final float density = getActivity().getResources().getDisplayMetrics().density;
                AdSize size = new AdSize(
                        (int) (storyRecycler.getWidth() / density),
                        150);
                for (int i = 0; i < onGoingStoriesList.size(); i += 15) {
                    NativeExpressAdView adViewToSize = (NativeExpressAdView)onGoingStoriesList.get(i);
                    adViewToSize.setAdSize(size);
                    adViewToSize.loadAd(new AdRequest.Builder().build());
                }

            }
        });
    }

    private void addStoryItems() {
        for(int i=0; i<60; i++) {
            onGoingStoriesList.add(new Story("","Ninaad Pai","One day in the valley", "Jun 5th, 2017", "#new #letssee #politics #agenda", "14", 1));
        }
    }
}
