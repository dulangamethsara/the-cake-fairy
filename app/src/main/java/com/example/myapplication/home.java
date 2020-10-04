package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class home extends AppCompatActivity {

    Button registration, userLogin, ALogin;

    Button home,account,cart,search,menu;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.registration);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, userRegister.class);
                startActivity(intent);
            }
        });

        button = (Button) findViewById(R.id.ULogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, userLogin.class);
                startActivity(intent);
            }
        });

        button = (Button) findViewById(R.id.ALogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, addminRegister.class);
                startActivity(intent);
            }
        });


        button = (Button) findViewById(R.id.home);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, userRegister.class);
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.account);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, userRegister.class);
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.cart);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, userRegister.class);
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.search);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, userRegister.class);
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.menu);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, userRegister.class);
                startActivity(intent);
            }
        });

        home = findViewById(R.id.home);
        account = findViewById(R.id.account);
        cart = findViewById(R.id.cart);
        search = findViewById(R.id.search);
        menu = findViewById(R.id.menu);



        registration = findViewById(R.id.registration);
        userLogin = findViewById(R.id.ULogin);
        ALogin = findViewById(R.id.ALogin);
    }


}


