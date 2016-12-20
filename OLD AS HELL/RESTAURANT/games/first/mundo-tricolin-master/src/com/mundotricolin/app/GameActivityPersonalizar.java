package com.mundotricolin.app;

import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.opengl.CCGLSurfaceView;

import com.mundotricolin.ingame.*;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class GameActivityPersonalizar extends Activity {
	private CCGLSurfaceView mGLSurfaceView;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
                
        // set the window status, no tile, full screen and don't sleep
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        mGLSurfaceView = new CCGLSurfaceView(this);
        
        setContentView(mGLSurfaceView);
        
        // attach the OpenGL view to a window
        CCDirector.sharedDirector().attachInView(mGLSurfaceView);

        // no effect here because device orientation is controlled by manifest
        CCDirector.sharedDirector().setDeviceOrientation(CCDirector.kCCDeviceOrientationPortrait);
        
        // show FPS
        // set false to disable FPS display, but don't delete fps_images.png!!
        CCDirector.sharedDirector().setDisplayFPS(false);

        // frames per second
        CCDirector.sharedDirector().setAnimationInterval(1.0f / 60);

        
        //getIntent().getStringExtra("idUsuario");
        CCScene scene = new Personalizar();

        // Make the Scene active
        CCDirector.sharedDirector().runWithScene(scene);
    }
    
    @Override
    public void onStart() {
        super.onStart();        
    }

    @Override
    public void onPause() {
        super.onPause();

        CCDirector.sharedDirector().pause();
    }

    @Override
    public void onResume() {
        super.onResume();

        CCDirector.sharedDirector().resume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        CCDirector.sharedDirector().end();
    }
    

}
