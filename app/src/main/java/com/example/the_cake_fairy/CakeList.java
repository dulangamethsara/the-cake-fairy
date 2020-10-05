package com.example.the_cake_fairy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.the_cake_fairy.Database.DBHandler;

import java.util.ArrayList;

public class CakeList extends AppCompatActivity {

    ListView cakeList;
    ArrayList dataList;
    ArrayAdapter adapter;

    DBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cake_list);

        cakeList = findViewById(R.id.cakes_list);
        db = new DBHandler(getApplicationContext());
        dataList = db.readAllInfo();
        adapter =  new ArrayAdapter(this,android.R.layout.simple_list_item_1,dataList);
        cakeList.setAdapter(adapter);

        cakeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String text = cakeList.getItemAtPosition(i).toString();
                Toast.makeText(CakeList.this, "cake", Toast.LENGTH_SHORT).show();

            }
        });
    }
}