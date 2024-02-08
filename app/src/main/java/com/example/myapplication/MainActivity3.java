package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
  Button  b1, back;
  EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        e1 = findViewById(R.id.editTextText4); // Replace with your actual EditText IDs
        e2 = findViewById(R.id.editTextText5);
        b1 = (Button) findViewById(R.id.back);
        back=(Button)findViewById(R.id.button4);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();


                if (s1.isEmpty() || s2.isEmpty()) {
                    // If either field is empty, show a message and prevent login
                    Toast.makeText(MainActivity3.this, "Please enter ID and Password", Toast.LENGTH_SHORT).show();
                } else if (!s2.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).+$")) {
                    // If password doesn't meet the criteria, show a message
                    Toast.makeText(MainActivity3.this, "Password must contain at least one uppercase letter, one lowercase letter, and one number", Toast.LENGTH_SHORT).show();
                } else {

                    Intent intent = new Intent(MainActivity3.this, MainActivity6.class);
                    startActivity(intent);
                }

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(MainActivity3.this, MainActivity.class);
                startActivity(intent1);

            }
        });
    }
}