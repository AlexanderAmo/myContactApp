package com.example.amoa1000.mycontactapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

        editName = (EditText) findViewById(R.id.editText_name);

    }

    public void  addData(View v){
        boolean isInserted = mydb.insertData(editName.getText().toString());
        if(isInserted = true){
            Log.d("MyContact", "Data Inserted successful");
        }
        else{
            Log.d("MyContact", "Data Inserted not successful");

        }
    }

    public void viewData(View v){
        Cursor res = mydb.getAllData();

        if(res.getCount() == 0){
            showMessage("error: ", "THERE ISNT ANY DATA BITCH");
            return;

        }

        StringBuffer buffer = new StringBuffer();
        //setup a loop with moveToNext method
        // append each Col to buffer
        // use getString method
       for(int i = 0; i< res.getColumnCount();i++){
           showMessage("Data", buffer.toString());
        }

    }

    private void showMessage(String title, String message) {

    }
}
