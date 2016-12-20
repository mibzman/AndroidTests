package com.example.nother_websocket;

import android.app.Activity;
import android.os.Bundle;

import android.util.Log;
import android.widget.TextView;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_10;
import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        try {
            WebSocketClient mWs = new WebSocketClient(new URI("wss://echo.websocket.org"), new Draft_10()) {
                @Override
                public void onMessage(String message) {
                    try {
                        JSONObject obj = new JSONObject(message);
                        String channel = obj.getString("channel");
                    }catch(Exception e){
                        Log.e("Image", "Failed to load image", e);
                    }
                }

                @Override
                public void onOpen(ServerHandshake handshake) {
                    System.out.println("opened connection");
                }

                @Override
                public void onClose(int code, String reason, boolean remote) {
                    System.out.println("closed connection");
                }

                @Override
                public void onError(Exception ex) {
                    ex.printStackTrace();
                }

            };
            //open websocket
            mWs.connect();
            JSONObject obj = new JSONObject();
            String butt = "butt";
            obj.put(butt, "butt");
            obj.get("output");
            String message = obj.toString();
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText(message);
            //send message
            //mWs.send(message);
        }catch(Exception e){
            Log.e("Image", "Failed to load image", e);
        }
    }
}
