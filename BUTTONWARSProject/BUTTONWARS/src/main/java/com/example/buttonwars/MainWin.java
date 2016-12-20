package com.example.buttonwars;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.os.Build;
import android.widget.TextView;

public class MainWin extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        // Show the Up button in the action bar.
        setupActionBar();
        setNames();
        getWin();
    }
    public void getWin(){
        Intent intent2 = getIntent();
        int result = intent2.getIntExtra("message3", 0);
        switch (result) {
            case 1: TextView player1Result = (TextView) findViewById(R.id.textView6);
                    player1Result.setText("YOU WON!!");
                    TextView player2Result = (TextView) findViewById(R.id.textView7);
                    player2Result.setText("YOU LOST!!");
                    break;
            case 0: TextView player1Result2 = (TextView) findViewById(R.id.textView6);
                    player1Result2.setText("YOU LOST!!");
                    TextView player2Result2 = (TextView) findViewById(R.id.textView7);
                    player2Result2.setText("YOU WON!!");
        }


    }
    public void setNames(){
        Intent intent2 = getIntent();
        String player1= intent2.getStringExtra(MainGaim.EXTRA_MESSAGE3);
        String player2 = intent2.getStringExtra(MainGaim.EXTRA_MESSAGE4);
        TextView player1Name = (TextView) findViewById(R.id.textView3);
        player1Name.setText(player1);
        TextView player2Name = (TextView) findViewById(R.id.textView4);
        player2Name.setText(player2);
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
        getMenuInflater().inflate(R.menu.main_win, menu);
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
