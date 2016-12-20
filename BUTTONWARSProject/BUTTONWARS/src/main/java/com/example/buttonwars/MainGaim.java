package com.example.buttonwars;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainGaim extends Activity {
int i = 0;
int j = 0;
public final static String EXTRA_MESSAGE3 = "com.example.buttonwars.MESSAGE3";
public final static String EXTRA_MESSAGE4 = "com.example.buttonwars.MESSAGE4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        setupActionBar();
        getNames();
        readButtons();

    }
    public void readButtons(){
        final TextView p1Score = (TextView) findViewById(R.id.textView2);
        final TextView p1Score2 = (TextView) findViewById(R.id.textView10);
        final TextView p2Score = (TextView) findViewById(R.id.textView3);
        final TextView p2Score2 = (TextView) findViewById(R.id.textView11);
        final Button p1Plus = (Button) findViewById(R.id.button);
        p1Plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = i +1;
                p1Score.setText(""+i+"");
                p1Score2.setText(""+i+"");
                compareScores();
            }
        });
        Button p1Minus = (Button) findViewById(R.id.p1minus);
        p1Minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                j = j -1;
                p2Score.setText(""+j+"");
                p2Score2.setText(""+j+"");
                compareScores();
            }
        });
       Button p2Plus = (Button) findViewById(R.id.button2);
       p2Plus.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               j = j +1;
               p2Score.setText(""+j+"");
               p2Score2.setText(""+j+"");
               compareScores();
           }
       });
       Button p2Minus = (Button) findViewById(R.id.button3);
       p2Minus.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               i = i - 1;
               p1Score.setText(""+i+"");
               p1Score2.setText(""+i+"");
               compareScores();
           }
       });
    }
    public void compareScores(){
         if (i >= 20) {
            sendP1();
         }else if (j >= 20) {
         sendP2();
        }else {}

    }
    public void sendP1(){
        Intent intent2 = new Intent(this, MainWin.class);
        intent2.putExtra("message3", 1);
        TextView p1name = (TextView) findViewById(R.id.p1name);
        String name1 = p1name.getText().toString();
        intent2.putExtra(EXTRA_MESSAGE3, name1);
        TextView p2name = (TextView) findViewById(R.id.p2name);
        String name2 = p2name.getText().toString();
        intent2.putExtra(EXTRA_MESSAGE4, name2);  
        startActivity(intent2);

    }
    public void sendP2(){
        Intent intent2 = new Intent(this, MainWin.class);
        intent2.putExtra("message3", 0);
        TextView p1name = (TextView) findViewById(R.id.p1name);
        String name1 = p1name.getText().toString();
        intent2.putExtra(EXTRA_MESSAGE3, name1);
        TextView p2name = (TextView) findViewById(R.id.p2name);
        String name2 = p2name.getText().toString();
        intent2.putExtra(EXTRA_MESSAGE4, name2);
        startActivity(intent2);
    }
    public void getNames(){
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView p1name = (TextView) findViewById(R.id.p1name);
        p1name.setText(message);
        String message2 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE2);
        TextView p2name = (TextView) findViewById(R.id.p2name);
        p2name.setText(message2);
        TextView p2scoreTitle = (TextView) findViewById(R.id.textView);
        p2scoreTitle.setText(message2 + "'s");
        TextView p1scoreTitle = (TextView) findViewById(R.id.textView9);
        p1scoreTitle.setText(message + "'s");
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void setupActionBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
        getActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_gaim, menu);
        return true;
    }
    

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
               NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
