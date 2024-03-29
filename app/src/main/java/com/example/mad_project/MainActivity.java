package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    EditText PaymentET,AmountET,PaymentdelET;
    TextView Shower;
    DBAdapter helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PaymentET = (EditText) findViewById(R.id.PaymentET);
        PaymentdelET = (EditText) findViewById(R.id.PaymentdelET);
        AmountET = (EditText) findViewById(R.id.AmountET);
//        Shower = (TextView) findViewById(R.id.Shower);
        helper = new DBAdapter(this);
    }

    public void add_expense(View view){
        String payment = PaymentET.getText().toString();
        String amount = AmountET.getText().toString();
        Double amt = Double.parseDouble(amount);
        helper.insertData(payment,amount);
        Message.message(getApplicationContext(), "Succesfully Added");

    }

    public void viewdata(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
        String data = helper.getData();
        intent.putExtra("data",data);

        startActivity(intent);
    }
//    public  void update(View view) {
//        String old = currentname.getText().toString();
//        String n = newname.getText().toString();
//            int id = helper.updateName(old,n);
//            currentname.setText("");
//            newname.setText("");
//        }
//    }

    public void delete(View view){
        String payment = PaymentdelET.getText().toString();
        PaymentdelET.setText("");
        helper.delete(payment);
        }
    }


