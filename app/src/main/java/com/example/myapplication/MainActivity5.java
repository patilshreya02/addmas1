package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.view.MotionEvent;

public class MainActivity5 extends AppCompatActivity {

    private ImageView imageView;
    private ScaleGestureDetector scaleGestureDetector;
    private float scaleFactor = 1.0f;
    private float xDelta = 0.0f;
    private float yDelta = 0.0f;

    Button start, comp, in, back;

    @SuppressLint({"ClickableViewAccessibility", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        // Initialize the ScaleGestureDetector
        scaleGestureDetector = new ScaleGestureDetector(this, new ScaleListener());

        start = findViewById(R.id.b1);
        comp = findViewById(R.id.b2);
        in = findViewById(R.id.b4);
        back=findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Back to start page
                Intent intent = new Intent(MainActivity5.this, MainActivity.class);
                startActivity(intent);
            }
        });

        imageView = findViewById(R.id.imageView3); // Replace with your ImageView ID

        // Set onTouchListener to your ImageView for zooming
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                scaleGestureDetector.onTouchEvent(event);
                final int X = (int) event.getRawX();
                final int Y = (int) event.getRawY();
                switch (event.getAction() & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_DOWN:
                        xDelta = X - imageView.getX();
                        yDelta = Y - imageView.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        float newPosX = event.getRawX() - xDelta;
                        float newPosY = event.getRawY() - yDelta;

                        // Getting the bounds of the layout
                        int[] layoutPos = new int[2];
                        imageView.getLocationOnScreen(layoutPos);
                        int layoutX = layoutPos[0];
                        int layoutY = layoutPos[1];
                        int layoutWidth = imageView.getWidth();
                        int layoutHeight = imageView.getHeight();

                        // Limiting movement within the layout boundaries
                        if (newPosX < layoutX) {
                            newPosX = layoutX;
                        } else if (newPosX + imageView.getWidth() > layoutX + layoutWidth) {
                            newPosX = layoutX + layoutWidth - imageView.getWidth();
                        }

                        if (newPosY < layoutY) {
                            newPosY = layoutY;
                        } else if (newPosY + imageView.getHeight() > layoutY + layoutHeight) {
                            newPosY = layoutY + layoutHeight - imageView.getHeight();
                        }

                        imageView.setX(event.getRawX() - xDelta);
                        imageView.setY(event.getRawY() - yDelta);
                        break;
                }
                return true;
            }
        });



        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start.setBackgroundColor(getResources().getColor(R.color.blue));
                // Back to start page
                Intent intent = new Intent(MainActivity5.this, MainActivity4.class);
                startActivity(intent);
            }
        });

        comp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comp.setBackgroundColor(getResources().getColor(R.color.blue));
                Intent intent1 = new Intent(MainActivity5.this, MainActivity5.class);
                startActivity(intent1);
            }
        });

        in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                in.setBackgroundColor(getResources().getColor(R.color.blue));
                // Back to in page
                Intent intent2 = new Intent(MainActivity5.this, MainActivityin.class);
                startActivity(intent2);
            }
        });
    }


    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            scaleFactor *= detector.getScaleFactor();
            scaleFactor = Math.max(0.1f, Math.min(scaleFactor, 10.0f));
            imageView.setScaleX(scaleFactor);
            imageView.setScaleY(scaleFactor);
            return true;
        }
    }
}
