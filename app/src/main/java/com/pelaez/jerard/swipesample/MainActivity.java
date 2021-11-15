package com.pelaez.jerard.swipesample;

import android.media.Image;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    ImageView imgview;
    TextView sampletxt;
    GestureDetectorCompat gestureDetectorCompat;
    int ctr = 0;
    int delay = 100;
    int images [][] = {{R.drawable.one_black_flower,R.drawable.one_black_spade,R.drawable.one_red_diamond,R.drawable.one_red_heart},
            {R.drawable.two_black_flower,R.drawable.two_black_spade,R.drawable.two_red_diamond,R.drawable.two_red_hearts},
            {R.drawable.three_black_flower,R.drawable.three_black_spade,R.drawable.three_red_diamond,R.drawable.three_red_heart},
            {R.drawable.four_black_flower,R.drawable.four_black_spade,R.drawable.four_red_diamond,R.drawable.four_red_heart}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgview = (ImageView)findViewById(R.id.imagemain);
        sampletxt = (TextView)findViewById(R.id.text1);

        detectgesture();



    }

    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetectorCompat.onTouchEvent(event);
        return true;
    }

    private void detectgesture() {
        this.gestureDetectorCompat = new GestureDetectorCompat(this, new GestureDetector.SimpleOnGestureListener() {
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                float angle = (float) Math.toDegrees(Math.atan2((double) (e1.getY() - e2.getY()), (double) (e2.getX() - e1.getX())));
                if (ctr == 4) {
                    ctr = 0;
                    delay = 100;
                }
                if (angle > -45.0f && angle <= 45.0f) {

                    sampletxt.setText("Ace");
                    imgview.setImageResource(images[0][ctr]);
                    delay--;
                    if (delay == 20 || delay == 40 || delay == 60 || delay == 80 || delay == 0) {
                        ctr++;
                    }

                    return true;
                }
                else if ((angle >= 135.0f && angle < 180.0f) || (angle < -135.0f && angle > -180.0f)) {
                    sampletxt.setText("Two");
                    imgview.setImageResource(images[1][ctr]);
                    delay--;
                    if (delay == 20 || delay == 40 || delay == 60 || delay == 80 || delay == 0) {
                        ctr++;
                    }
                    return true;
                } else if (angle < -45.0f && angle >= -135.0f) {
                    sampletxt.setText("Three");
                    imgview.setImageResource(images[2][ctr]);
                    delay--;
                    if (delay == 20 || delay == 40 || delay == 60 || delay == 80 || delay == 0) {
                        ctr++;
                    }
                    return true;
                }
                else if (angle <= 225.0f || angle > 315.0f) {
                    sampletxt.setText("Four");
                    imgview.setImageResource(images[3][ctr]);
                    delay--;
                    if (delay == 20 || delay == 40 || delay == 60 || delay == 80 || delay == 0) {
                        ctr++;
                    }
                    return false;
                }

                else {
                    return true;
                }
            }
        });
    }

}



