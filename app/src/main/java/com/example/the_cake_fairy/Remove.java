package com.example.the_cake_fairy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.the_cake_fairy.Database.DBHandler;

import java.util.List;

public class Remove extends AppCompatActivity {
    EditText cakename,weight,category,price;
    Button Search,Delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);

        cakename =findViewById(R.id.etCakeNameDelete);
        weight = findViewById(R.id.etWeightDelete);
        category = findViewById(R.id.etCategoryDelete);
        price = findViewById(R.id.etPriceDelete);
        Search = findViewById(R.id.btnSearchDelete);
        Delete = findViewById(R.id.btnDeleteDelete);

        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(cakename.length()==0){
                    cakename.setError("Enter Cake Name.You Can Find Names In AVAILABLE LIST");
                }

                DBHandler dbHandler = new DBHandler(getApplicationContext());
                List cake = dbHandler.readAllInfo(cakename.getText().toString());

                if (cake.isEmpty()){
                    Toast.makeText(Remove.this, "cake name is not found.You Can Find Names In AVAILABLE LIST", Toast.LENGTH_SHORT).show();
                    cakename.setText(null);
                }

                else {
                    Toast.makeText(Remove.this, "cake name is found! Cake Name : "+cake.get(0).toString(), Toast.LENGTH_SHORT).show();
                    cakename.setText(cake.get(0).toString());
                    weight.setText(cake.get(1).toString());
                    category.setText(cake.get(2).toString());
                    price.setText(cake.get(3).toString());
                }
            }
        });

        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHandler dbHandler = new DBHandler(getApplicationContext());
                dbHandler.deleteInfo(cakename.getText().toString());

                Toast.makeText(Remove.this, "cake deleted", Toast.LENGTH_SHORT).show();

                cakename.setText(null);
                weight.setText(null);
                category.setText(null);
                price.setText(null);


            }
        });

    }
}