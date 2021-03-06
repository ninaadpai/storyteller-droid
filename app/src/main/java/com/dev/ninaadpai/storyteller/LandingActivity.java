package com.dev.ninaadpai.storyteller;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class LandingActivity extends AppCompatActivity{
    TextView appTitle, subTitle, alreadyMember;
    Button signUpButton;
    Typeface greatVibes;
    public static Typeface roboto;
    Animation fadeIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        appTitle = (TextView) findViewById(R.id.appTitle);
        subTitle = (TextView) findViewById(R.id.subTitle);
        alreadyMember = (TextView) findViewById(R.id.alreadyAMember);
        signUpButton = (Button) findViewById(R.id.signUpButton);
        greatVibes = Typeface.createFromAsset(getAssets(), "fonts/GreatVibes-Regular.ttf");
        roboto = Typeface.createFromAsset(getAssets(), "fonts/RobotoCondensed-Bold.ttf");
        fadeIn= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        appTitle.setTypeface(greatVibes);
        subTitle.setTypeface(roboto);
        signUpButton.setTypeface(roboto);
        alreadyMember.setTypeface(roboto);
        appTitle.setAnimation(fadeIn);
        subTitle.setAnimation(fadeIn);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LandingActivity.this, MainActivity.class));
            }
        });
    }


//    public static boolean loggedIn() {
//        if (FirebaseAuth.getInstance().getCurrentUser() != null)
//            return true;
//        else
//            return false;
//    }
}
