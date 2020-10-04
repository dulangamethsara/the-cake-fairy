package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class viewActivity2 extends AppCompatActivity {
    Button next2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view2);

        next2=(Button)findViewById(R.id.btnnext);
        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPaymentActivity2();
            }
        });
    }

    public void openPaymentActivity2(){
        Intent intent=new Intent(this,PaymentActivity2.class);
        startActivity(intent);

    }
}