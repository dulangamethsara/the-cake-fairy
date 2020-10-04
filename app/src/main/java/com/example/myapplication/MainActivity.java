package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Button home1,account1,cart1,search1,menu1;
    Button button;

    TextView userName,password;
    Button submit;

    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button)findViewById(R.id.registration);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this,userRegister.class);
                startActivity(intent);
            }
        });

        button1 = (Button)findViewById(R.id.ULogin);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this,userLogin.class);
                startActivity(intent);
            }
        });

        button1 = (Button)findViewById(R.id.ALogin);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, addminRegister.class);
                startActivity(intent);
            }
        });

        userName = findViewById(R.id.userName);
        password = findViewById(R.id.password);
        submit = findViewById(R.id.Submit);

        button = (Button) findViewById(R.id.home);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, userRegister.class);
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.account);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, userRegister.class);
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.cart);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, userRegister.class);
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.search);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, userRegister.class);
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.menu);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, userRegister.class);
                startActivity(intent);
            }
        });

        home1 = findViewById(R.id.home1);
        account1 = findViewById(R.id.account1);
        cart1 = findViewById(R.id.cart1);
        search1 = findViewById(R.id.search1);
        menu1 = findViewById(R.id.menu1);


    }
}