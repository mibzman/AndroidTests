package com.example.buttonwarsui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainGame extends Activity {
   /* int i = 0;
    int j = 0;
    int winScore = 20;
    public final static String EXTRA_MESSAGE3 = "com.example.buttonwars.MESSAGE3";
    public final static String EXTRA_MESSAGE4 = "com.example.buttonwars.MESSAGE4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        setupActionBar();
        getValues();
        readButtons();

    }
    public void readButtons(){
        final TextView pScore = (TextView) findViewById(R.id.pScore);
        final TextView cScore = (TextView) findViewById(R.id.cScore);
        final Button Plus = (Button) findViewById(R.id.plus);
        Plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = i +1;
                pScore.setText(""+i+"");
                compareScores();
            }
        });
        Button Minus = (Button) findViewById(R.id.minus);
        Minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                j = j -1;
                cScore.setText(""+j+"");
                compareScores();
            }
        });

    }
    public void compareScores(){
        if (i >= winScore) {
            sendP();
        }else if (j >= winScore) {
            sendC();
        }else {}

    }
    public void sendP(){
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
    public void sendC(){
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
    public void getValues(){
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
        getMenuInflater().inflate(R.menu.main_game, menu);
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
0*/
}
