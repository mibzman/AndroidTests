package com.mundotricolin.ingame;

import org.cocos2d.events.CCTouchDispatcher;
import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;
import org.cocos2d.types.CGSize;

import android.view.MotionEvent;

import com.mundotricolin.ingame.Mundo;

public class MundoLayer extends CCLayer {
	
	CCSprite fondo;
	CCSprite casaTricolin;
	CCSprite teatroNacional;
	CCSprite cuevaOro;
	CCSprite tiendaTricolin;
	CCScene scene;
	Mundo escena;
	
	public MundoLayer(Mundo escena) 
	{
		super();
		
		CGSize winSize = CCDirector.sharedDirector().displaySize();
		this.escena = escena;
		
		// Crear fondo
		fondo = CCSprite.sprite("fondo.png");
		fondo.setPosition(winSize.width / 2.0f, winSize.height / 2.0f);
		fondo.setScale(0.9f);
		addChild(fondo);
		
		// Crear casaTricolin
		casaTricolin = CCSprite.sprite("cuadro.gif");
		casaTricolin.setScale(0.7f);
		casaTricolin.setAnchorPoint(0, 0);
		casaTricolin.setPosition(442,257);
		casaTricolin.setVisible(false);
		addChild(casaTricolin);
		
		// Crear teatroNacional
		teatroNacional = CCSprite.sprite("cuadro.gif");
		teatroNacional.setScale(0.7f);
		teatroNacional.setAnchorPoint(0, 0);
		teatroNacional.setVisible(false);
		teatroNacional.setPosition(333,240);
		addChild(teatroNacional);
		
		// Crear cuevaOro
		cuevaOro = CCSprite.sprite("cuadro.gif");
		cuevaOro.setScale(0.7f);
		cuevaOro.setAnchorPoint(0, 0);
		cuevaOro.setVisible(false);
		cuevaOro.setPosition(412,278);
		addChild(cuevaOro);
		
		// Crear tiendaTricolin
		tiendaTricolin = CCSprite.sprite("cuadro.gif");
		tiendaTricolin.setScale(0.7f);
		tiendaTricolin.setAnchorPoint(0, 0);
		tiendaTricolin.setVisible(false);
		tiendaTricolin.setPosition(362,160);
		addChild(tiendaTricolin);
		
		scheduleUpdate();
		setIsTouchEnabled(true);
	}
	
	
	public boolean ccTouchesEnded(MotionEvent event)
	{
		CGPoint convertedLocation = CCDirector.sharedDirector().convertToGL(CGPoint.make(event.getX(), event.getY()));
		
		if (casaTricolin.getBoundingBox().contains(convertedLocation.x,convertedLocation.y))
		{
			scene = new CasitaTricolin();
			CCDirector.sharedDirector().runWithScene(scene);
		}else if (teatroNacional.getBoundingBox().contains(convertedLocation.x,convertedLocation.y))
		{
			scene = new TeatroNacional();
			CCDirector.sharedDirector().runWithScene(scene);
		}else if (cuevaOro.getBoundingBox().contains(convertedLocation.x,convertedLocation.y))
		{
			scene = new CuevaOro();
			CCDirector.sharedDirector().runWithScene(scene);
		}
		else if (tiendaTricolin.getBoundingBox().contains(convertedLocation.x,convertedLocation.y))
		{
			scene = new TiendaTricolin();
			CCDirector.sharedDirector().runWithScene(scene);
		}
	    return CCTouchDispatcher.kEventHandled;
	}

}
