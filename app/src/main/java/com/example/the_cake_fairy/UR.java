package com.example.the_cake_fairy;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.the_cake_fairy.Database.DBHandler;
import java.util.List;

public class UR extends AppCompatActivity {
    EditText cakename,weight,category,price;
    Button Search,Update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u_r);

        cakename =findViewById(R.id.etCakeNameUR);
        weight = findViewById(R.id.etWeightUR);
        category = findViewById(R.id.etCategoryUR);
        price = findViewById(R.id.etPriceUR);
        Search = findViewById(R.id.btnSearchUR);
        Update = findViewById(R.id.btnUpdateUR);

        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHandler dbHandler = new DBHandler(getApplicationContext());
                List cake = dbHandler.readAllInfo(cakename.getText().toString());

                if (cake.isEmpty()){
                    Toast.makeText(UR.this, "cake name is not found", Toast.LENGTH_SHORT).show();
                    cakename.setText(null);
                }

                else {
                    Toast.makeText(UR.this, "cake name is found! Cake Name : "+cake.get(0).toString(), Toast.LENGTH_SHORT).show();
                    cakename.setText(cake.get(0).toString());
                    weight.setText(cake.get(1).toString());
                    category.setText(cake.get(2).toString());
                    price.setText(cake.get(3).toString());
                }
            }
        });


        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHandler dbHandler = new DBHandler(getApplicationContext());

                Boolean status = dbHandler.updateInfo(cakename.getText().toString(),weight.getText().toString(),category.getText().toString(),price.getText().toString());
                if(status){
                    Toast.makeText(UR.this,"cake Updated",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(UR.this, "update failed", Toast.LENGTH_SHORT).show();
                }
            }
        });


        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(cakename.length()==0){
                    cakename.setError("Enter Cake Name.You Can Find Names In AVAILABLE LIST");
                }

                DBHandler dbHandler = new DBHandler(getApplicationContext());
                List cake = dbHandler.readAllInfo(cakename.getText().toString());

                if (cake.isEmpty()){
                    Toast.makeText(UR.this, "cake name is not found", Toast.LENGTH_SHORT).show();
                    cakename.setText(null);
                }

                else {
                    Toast.makeText(UR.this, "cake name found! Cake Name : "+cake.get(0).toString(), Toast.LENGTH_SHORT).show();
                    cakename.setText(cake.get(0).toString());
                    weight.setText(cake.get(1).toString());
                    category.setText(cake.get(2).toString());
                    price.setText(cake.get(3).toString());
                }
            }
        });


        Update.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                DBHandler dbHandler = new DBHandler(getApplicationContext());

                Boolean status = dbHandler.updateInfo(cakename.getText().toString(),weight.getText().toString(),category.getText().toString(),price.getText().toString());
                if(status){
                    Toast.makeText(UR.this,"cake Updated",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(UR.this, "update failed", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}