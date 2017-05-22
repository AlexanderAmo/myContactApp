package com.example.amoa1000.mycontactapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class searchContactss extends AppCompatActivity {

    databaseHelper myDb;
    EditText search;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_contactss);

        myDb = new databaseHelper(this);
        search = (EditText) findViewById(R.id.editText_search);
    }

    public void viewData(View v){
        Cursor res = myDb.getAllData();
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

    public void searchData(View v){
        Cursor res = myDb.getAllData();
        if(res.getCount() == 0){
            showMessage("error: ", "THERE ISNT ANY DATA");
            return;
        }

        StringBuffer buffer = new StringBuffer();

        while(res.moveToNext()) {
            if(search.getText().toString().toLowerCase().equals(res.getString(1).toLowerCase())) {
                buffer.append(res.getString(1)+ " ");
                buffer.append(res.getString(2)+ " ");
                buffer.append(res.getString(3) + " ");
            }
            buffer.append("\n\n");
        }
        showMessage("Your Contacts", buffer.toString());
    }

    private void showMessage(String title, String message) {
        AlertDialog.Builder Builder = new AlertDialog.Builder(this);
        Builder.setCancelable(true);
        Builder.setTitle(title);
        Builder.setMessage(message);
        Builder.show();

    }

    public  void  MainScreen(View v){
        Intent intent = new Intent(this,life.class);
        startActivity(intent);
    }


}
