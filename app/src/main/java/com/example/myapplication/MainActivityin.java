package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivityin extends AppCompatActivity {

    Button start, comp, in,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activityin);
        start = findViewById(R.id.b1);
        comp = findViewById(R.id.b2);
        in = findViewById(R.id.b4);
        back = findViewById(R.id.back); // Initialize 'back' button

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // back to start page
                Intent intent = new Intent(MainActivityin.this, MainActivity.class);
                startActivity(intent);
            }
        });


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start.setBackgroundColor(getResources().getColor(R.color.blue));
                ////back to start page
                Intent intent = new Intent(MainActivityin.this, MainActivity4.class);
                startActivity(intent);
            }
        });

        comp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comp.setBackgroundColor(getResources().getColor(R.color.blue));
                Intent intent1 = new Intent(MainActivityin.this, MainActivity5.class);
                startActivity(intent1);
            }
        });

        in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                in.setBackgroundColor(getResources().getColor(R.color.blue));
                //back to in page
                Intent intent2 = new Intent(MainActivityin.this, MainActivityin.class);
                startActivity(intent2);
            }
        });
    }
}