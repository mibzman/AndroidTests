package com.example.ColatzER;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */


    int round = 0;
    int[] anArray = new int[100];
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        buttonWatcher();

    }

    public void buttonWatcher() {
        final Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              final EditText input = (EditText) findViewById(R.id.editText);
              String inputString = input.getText().toString();
              int inputInt = Integer.parseInt(inputString);
              colatzER(inputInt);
            }
        });
    }
    public void colatzER(int inputInt) {
        final TextView textView = (TextView) findViewById(R.id.textView);
        final TextView textView2 = (TextView) findViewById(R.id.textView2);
        anArray[round] = inputInt;
        if (inputInt != 1){
        if ( (inputInt & 1) == 0 ){
           //textView.setText("ITS EVEN!  WOO!!");
            int outputInt = inputInt/2 ;
            round++;
            colatzER(outputInt);

        } else {
           //textView.setText("ITS ODD!! WOO!!");
            int outputInt = ((inputInt*3) + 1);
            round++;
            colatzER(outputInt);
        }
        }else{
           /* if (anArray.length >= 1) {
                textView.setText(anArray[0]);
            }

// note that i starts at 1, since we already printed the element at index 0
            for (int i = 1; i < anArray.length; i++) {
                textView2.setText(", " + anArray[i]);
            } */
            //textView.setText(" " + inputInt + " ");

        }
    }
}
