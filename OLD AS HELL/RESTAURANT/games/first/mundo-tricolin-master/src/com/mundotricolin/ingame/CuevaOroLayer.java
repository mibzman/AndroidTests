package com.mundotricolin.ingame;

import org.cocos2d.events.CCTouchDispatcher;
import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;
import org.cocos2d.types.CGSize;

import android.view.MotionEvent;

public class CuevaOroLayer extends CCLayer {
	
	CCSprite fondo;
	CCSprite regresar;
	CuevaOro escena;
	CGSize winSize = CCDirector.sharedDirector().displaySize();
	
	public CuevaOroLayer(CuevaOro escena) 
	{
		super();

		this.escena = escena;
		
		// Crear fondo
		fondo = CCSprite.sprite("fondoCueva.jpeg");
		fondo.setPosition(CGPoint.ccp(winSize.getWidth() / 2, winSize.getHeight() / 2));
		addChild(fondo);
		
		// Crear boton regresar
		regresar = CCSprite.sprite("botonRegresar.gif");
		regresar.setScale(0.7f);
		regresar.setAnchorPoint(0, 0);
		regresar.setPosition(75,30);
		addChild(regresar);
		
		scheduleUpdate();
		setIsTouchEnabled(true);
	}
	
	public boolean ccTouchesEnded(MotionEvent event)
	{
		CGPoint convertedLocation = CCDirector.sharedDirector().convertToGL(CGPoint.make(event.getX(), event.getY()));
		
		if (regresar.getBoundingBox().contains(convertedLocation.x,convertedLocation.y))
		{
			CCScene scene = new Mundo();
			CCDirector.sharedDirector().runWithScene(scene);
		}
	    return CCTouchDispatcher.kEventHandled;
	}

}
