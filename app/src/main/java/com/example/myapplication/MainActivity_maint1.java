package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity_maint1 extends AppCompatActivity {

    Button next, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_maint1);

        next=findViewById(R.id.next);
        back=findViewById(R.id.back);

         next.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent i= new Intent(MainActivity_maint1.this, MainActivity2m.class);
                 startActivity(i);
             }
         });
         back.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent i1= new Intent(MainActivity_maint1.this,MainActivity6.class);
                 startActivity(i1) ;
             }
         });

    }
}