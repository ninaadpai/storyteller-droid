package com.dev.ninaadpai.storyteller;

import android.graphics.Typeface;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dev.ninaadpai.storyteller.fragments.AllStoriesFragment;
import com.dev.ninaadpai.storyteller.fragments.BookmarksFragment;
import com.dev.ninaadpai.storyteller.fragments.ForYouFragment;
import com.dev.ninaadpai.storyteller.fragments.ProfileFragment;

public class MainActivity extends AppCompatActivity {
    TextView mainActivityTitle;
    Typeface greatVibes;
    FrameLayout content;
    FragmentManager fragmentManager;
    Animation slideUp, slideDown;
    RelativeLayout topToolbar, bottomToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        topToolbar = (RelativeLayout) findViewById(R.id.topToolbar);
        bottomToolbar = (RelativeLayout) findViewById(R.id.bottomToolbar);
        mainActivityTitle = (TextView) findViewById(R.id.mainActivityTitle);
        slideDown= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
        slideUp= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
        topToolbar.startAnimation(slideDown);
        bottomToolbar.startAnimation(slideUp);
        greatVibes = Typeface.createFromAsset(getAssets(), "fonts/GreatVibes-Regular.ttf");
        mainActivityTitle.setTypeface(greatVibes);
        content = (FrameLayout) findViewById(R.id.content);
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content, new AllStoriesFragment(), "Home").commit();
        findViewById(R.id.all).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.content, new AllStoriesFragment(), "Home").commit();
            }
        });
        findViewById(R.id.for_you).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.content, new ForYouFragment(), "Home").commit();
            }
        });
        findViewById(R.id.new_story).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.content, new AllStoriesFragment(), "Home").commit();
            }
        });
        findViewById(R.id.bookmarks).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.content, new BookmarksFragment(), "Home").commit();
            }
        });
        findViewById(R.id.profile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.content, new ProfileFragment(), "Home").commit();
            }
        });
    }
}
