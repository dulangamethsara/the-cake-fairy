package com.example.the_cake_fairy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.the_cake_fairy.Database.DBHandler;

import java.util.Locale;

public class Add extends AppCompatActivity {
    EditText cakename,weight,category,price;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        cakename =findViewById(R.id.etCakeNameADD);
        weight = findViewById(R.id.etWeightADD);
        category = findViewById(R.id.etCategoryADD);
        price = findViewById(R.id.etPriceADD);
        add = findViewById(R.id.BtnAddADD);

       add.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               if(cakename.length()==0){
                   cakename.setError("Enter Cake Name");
               }
               else if(weight.length()==0){
                   weight.setError("Enter Cake Weight");
               }
               else if(category.length()==0){
                   category.setError("Enter Cake Category");
               }
               else if( price.length()==0){
                   price.setError("Enter Cake Price");
               }

               DBHandler dbHandler = new DBHandler(getApplicationContext());
               long newId = dbHandler.addInfo(cakename.getText().toString(),weight.getText().toString(), category.getText().toString(),price.getText().toString());
               Toast.makeText(Add.this, "Cake Added....Cake ID :"+newId, Toast.LENGTH_SHORT).show();


                // add button eka click karama mekema inna
               //Intent i = new Intent(getApplicationContext(),Add.class);
               //startActivity(i);

               //Intent i = new Intent(getApplicationContext(),UR.class);
               //startActivity(i);

              cakename.setText(null);
              weight.setText(null);
              category.setText(null);
              price.setText(null);
           }
       });

    }
}



















