package com.mundotricolin.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MundoTricolinActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void abrirRegistro(View view) {
        Intent i = new Intent(this, Registro.class );
        startActivity(i);
    }
    public void abrirLogin(View view) {
        Intent i = new Intent(this, Login.class );
        startActivity(i);
    }
}