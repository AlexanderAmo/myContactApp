package com.example.amoa1000.mycontactapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class life extends AppCompatActivity {

    databaseHelper mydb;

    EditText editName;
    EditText editNumber;
    EditText editAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life);


        mydb = new databaseHelper(this);

        editName = (EditText) findViewById(R.id.editText_name);
        editAddress = (EditText) findViewById(R.id.editText_address);
        editNumber = (EditText) findViewById(R.id.editText_number);


    }

    public void  addData(View v){
        boolean isInserted = mydb.insertData(editName.getText().toString(), editNumber.getText().toString(), editAddress.getText().toString());
        if(isInserted = true){
            Toast.makeText(this,"Contacted added successfully!",Toast.LENGTH_SHORT).show();
        }
        else{

            Toast.makeText(this,"Contacted didn't get added!",Toast.LENGTH_SHORT).show();


        }
    }

    public void viewData(View v){
        Cursor res = mydb.getAllData();

        if(res.getCount() == 0){
           showMessage("error: ", "THERE ISNT ANY DATA");
            return;
        }

        StringBuffer buffer = new StringBuffer();

       while(res.moveToNext()) {                                         // setup a loop with moveToNext method
           for (int i = 1;i< res.getColumnCount();i++){                 // append each Col to buffer
               buffer.append(res.getString(i) + " ");                        // use getString method
           }
           buffer.append("\n\n");
       }
        showMessage("Your Contacts", buffer.toString());
    }


    public void searchScreen(View v){
        Intent intent = new Intent(this,searchContactss.class);
        startActivity(intent);
    }



    private void showMessage(String title, String message) {
        AlertDialog.Builder Builder = new AlertDialog.Builder(this);
        Builder.setCancelable(true);
        Builder.setTitle(title);
        Builder.setMessage(message);
        Builder.show();

    }
}
