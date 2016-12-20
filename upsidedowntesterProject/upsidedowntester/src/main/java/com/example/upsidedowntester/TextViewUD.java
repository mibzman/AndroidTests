package com.example.upsidedowntester;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;


public class TextViewUD extends TextView {
    public TextViewUD(Context context) {
        super(context);
    }
    public TextViewUD(Context context, AttributeSet attrs){
        super(context, attrs);
    }
    public TextViewUD(Context context, AttributeSet attrs, int defStyle){
        super(context, attrs, defStyle);
    }
    @Override
    protected  void onDraw(Canvas canvas){
        canvas.save();
        float py = this.getHeight()/2.0f;
        float px = this.getWidth()/2.0f;
        Log.d("testUD", String.format("w: %d h: %d ", this.getWidth(), this.getHeight()));
        Log.d("testUD", String.format("w: %f h %f", py, px));
        super.onDraw(canvas);
        canvas.restore();
    }
}
