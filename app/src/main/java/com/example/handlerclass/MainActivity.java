package com.example.handlerclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

   //variable
    private static  int DELAY_TIME = 3000;
    Animation Anim_top, Anim_bottom;
    ImageView image;
    TextView tv_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Animations hook's
            Anim_top = AnimationUtils.loadAnimation(this,R.anim.top_anim);
            Anim_bottom = AnimationUtils.loadAnimation(this,R.anim.bottom_anim);

            image = (ImageView) findViewById(R.id.ImgVw);
            tv_txt = (TextView) findViewById(R.id.tv_txt);

                //set animation to image and text view
            image.setAnimation(Anim_bottom);
            tv_txt.setAnimation(Anim_top);

//handler Intent is used
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, newAct.class);
                startActivity(intent);
                finish();
            }
        }, DELAY_TIME);

    }

    }


