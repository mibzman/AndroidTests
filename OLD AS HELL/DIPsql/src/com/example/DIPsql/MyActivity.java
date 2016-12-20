package com.example.DIPsql;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MyActivity extends Activity {
    Context context = this;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button submit = (Button) findViewById(R.id.button2);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHandler db = new DatabaseHandler(context);
                EditText name = (EditText) findViewById(R.id.name);
                EditText number = (EditText) findViewById(R.id.number);
                String name1 =  name.getText().toString();
                String number1 =  number.getText().toString();
                db.addContact(new Contact(name1, number1));
            }
        });

    }
}