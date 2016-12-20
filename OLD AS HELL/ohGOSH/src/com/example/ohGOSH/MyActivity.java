package com.example.ohGOSH;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    private database mySQLiteAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mySQLiteAdapter = new database(this);
        mySQLiteAdapter.openToWrite();
        Button button = (Button) findViewById(R.id.button);
        final EditText first = (EditText) findViewById(R.id.editText);
        final EditText second = (EditText) findViewById(R.id.editText2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data1 = first.getText().toString();
                String data2 = second.getText().toString();
                mySQLiteAdapter.insert(data1, data2);
            }
        });
    }
}
