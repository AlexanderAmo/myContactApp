package com.example.amoa1000.mycontactapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class life extends AppCompatActivity {

    databaseHelper mydb;
    EditText editName;
    Button data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life);


        mydb = new databaseHelper(this);

    }
}
