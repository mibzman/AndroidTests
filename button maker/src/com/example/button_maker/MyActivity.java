package com.example.button_maker;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    private RelativeLayout myLInearLayout;
    private TextView valueTV;
    private Button valueB;
    Context context = this;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dobuttonStuff();
            }
        });
    }
    void dobuttonStuff(){
        Button valueB = (Button)findViewById(R.id.button2);
        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) valueB.getLayoutParams();
        lp.addRule(RelativeLayout.CENTER_HORIZONTAL);
        valueB.setLayoutParams(lp);
        valueB.setText("thedeveloperworldisyours");
        valueB.setId(1);

//add the textView and the Button to LinearLayout
        myLInearLayout.addView(valueTV);
        myLInearLayout.addView(valueB);

    }
    void tweaqkbutton(){

    }

}
