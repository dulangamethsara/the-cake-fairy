package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PaymentActivity2 extends AppCompatActivity {

    DatabaseHelper1 myDb1;
    EditText editno, editname, editcvv;
    Button btnAddData1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment2);

        myDb1 = new DatabaseHelper1(this);

        editno = (EditText) findViewById(R.id.editText123);
        editname = (EditText) findViewById(R.id.editText1234);
        editcvv = (EditText) findViewById(R.id.editText12345);
        btnAddData1 = (Button)findViewById(R.id.button_add1);
        AddData1();

    }


    public void AddData1() {
        btnAddData1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb1.insertData1(editno.getText().toString(),
                                editname.getText().toString(),
                                editcvv.getText().toString());
                        if (isInserted == true)
                            Toast.makeText(PaymentActivity2.this, "card added", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(PaymentActivity2.this, "card not Inserted", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}