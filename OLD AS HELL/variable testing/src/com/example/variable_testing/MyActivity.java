package com.example.variable_testing;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    int A = 14;
    int B = 4;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        /*Button print = (Button) findViewById(R.id.button3);
        print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView aa = (TextView) findViewById(R.id.textView);
                TextView bb = (TextView) findViewById(R.id.textView2);
                aa.setText("Variable A = " + A);
                bb.setText("Variable B = " + B);
            }
        }); */
    }
    public void aFirst(View view) {
       A = B;
    }
    public void bFirst(View view){
        B = A;
    }
    public void printResults(View view) {
        TextView aa = (TextView) findViewById(R.id.textView);
        TextView bb = (TextView) findViewById(R.id.textView2);
        aa.setText("Variable A = " + A);
        bb.setText("Variable B = " + B);
    }

}
