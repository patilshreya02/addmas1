package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    Button login, back;
    EditText e4,e5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        login = (Button) findViewById(R.id.back);
        e4 = (EditText) findViewById(R.id.editTextText4);
        e5 = (EditText) findViewById(R.id.editTextText5);
        back=findViewById(R.id.button4);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e4.getText().toString();
                String s2 = e5.getText().toString();

                if (s1.isEmpty() || s2.isEmpty()) {
                    // If either field is empty, show a message and prevent login
                    Toast.makeText(MainActivity2.this, "Please enter ID and Password", Toast.LENGTH_SHORT).show();
                } else if (!s2.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).+$")) {
                    // If password doesn't meet the criteria, show a message
                    Toast.makeText(MainActivity2.this, "Password must contain at least one uppercase letter, one lowercase letter, and one number", Toast.LENGTH_SHORT).show();
                } else
                {
                    Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
                    startActivity(intent);
                }
            }

        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }


}