package com.example.nother_websocket;

/**
 * Created by Sam on 4/7/2015.
 */
/**
 * Created by Sam on 4/7/2015.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.*;

import org.java_websocket.WebSocket;
import org.java_websocket.client.DefaultSSLWebSocketClientFactory;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

class WebSocketChatClient extends WebSocketClient {

    public WebSocketChatClient( URI serverUri ) {
        super( serverUri );
    }

    @Override
    public void onOpen( ServerHandshake handshakedata ) {
        System.out.println( "Connected" );

    }

    @Override
    public void onMessage( String message ) {
        System.out.println( "got: " + message );

    }

    @Override
    public void onClose( int code, String reason, boolean remote ) {
        System.out.println( "Disconnected" );
        System.exit( 0 );

    }

    @Override
    public void onError( Exception ex ) {
        ex.printStackTrace();

    }

}
