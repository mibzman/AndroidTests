package com.example.buttonwars;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
    public final static String EXTRA_MESSAGE = "com.example.buttonwars.MESSAGE";
    public final static String EXTRA_MESSAGE2 = "com.example.buttonwars.MESSAGE2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendNames();
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public void sendNames() {
        Intent intent = new Intent(this, MainGaim.class);
        EditText player1 = (EditText) findViewById(R.id.player1);
        String message = player1.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        EditText player2 = (EditText) findViewById(R.id.player2);
        String message2 = player2.getText().toString();
        intent.putExtra(EXTRA_MESSAGE2, message2);
        startActivity(intent);
    }
}
