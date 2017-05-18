package com.example.amoa1000.mycontactapp;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class searchContacts extends AppCompatActivity {

    EditText search;
    databaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life);

        mydb = new databaseHelper(this);

        search = (EditText) findViewById(R.id.editText_search);
    }


     public void Search(View v){
        Cursor res = mydb.getAllData();
        if(res.getCount() == 0){
            showMessage("error: ", "THERE ISNT ANY DATA");
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while(res.moveToNext()){
            for(int i = 1; i<res.getColumnCount();i++){
                if(res.getString(i).equals(search.getText().toString()))
                    buffer.append(res.getString(i));
            }

        }
        showMessage("Data",buffer.toString());

     }



    private void showMessage(String title, String message) {
        AlertDialog.Builder Builder = new AlertDialog.Builder(this);
        Builder.setCancelable(true);
        Builder.setTitle(title);
        Builder.setMessage(message);
        Builder.show();

    }


}
