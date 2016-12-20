package com.mundotricolin.ingame;

import org.cocos2d.events.CCTouchDispatcher;
import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCLabel;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;
import org.cocos2d.types.CGSize;
import org.cocos2d.types.ccColor3B;

import android.view.MotionEvent;

import com.mundotricolin.app.Actualizar;


public class PersonalizarLayer extends CCLayer {
	
	CCSprite fondo;
	CCSprite tricolin;
	CCSprite tricolina;
	CCSprite red;
	CCSprite blue;
	CCSprite yellow;
	CCSprite go;
	int personajeSeleccionado = 0;
	int colorSeleccionado = 0;
	int Usuario = 0;
	ccColor3B labelColor = new ccColor3B(60,60,60);
	
	Personalizar escena;
	
	public PersonalizarLayer(Personalizar escena) 
	{
		super();

		CGSize winSize = CCDirector.sharedDirector().displaySize();
		this.escena = escena;
		
		// Crear fondo
		fondo = CCSprite.sprite("fondoPersonalizar.gif");
		fondo.setPosition(winSize.width / 2.0f, winSize.height / 2.0f);
		fondo.setScale(1.5f);
		addChild(fondo);
		
		// Crear blue
		blue = CCSprite.sprite("blue.gif");
		blue.setPosition(winSize.width / 2.0f, winSize.height / 2.0f);
		blue.setScale(0.7f);
		blue.setAnchorPoint(-3f, 3f);
		addChild(blue);
		
		// Crear red
		red = CCSprite.sprite("red.gif");
		red.setPosition(winSize.width / 2.0f, winSize.height / 2.0f);
		red.setScale(0.7f);
		red.setAnchorPoint(0, 3f);
		addChild(red);
				
		// Crear yellow
		yellow = CCSprite.sprite("yellow.gif");
		yellow.setPosition(winSize.width / 2.0f, winSize.height / 2.0f);
		yellow.setScale(0.7f);
		yellow.setAnchorPoint(3f, 3f);
		addChild(yellow);
		
		// Crear tricolin
		tricolin = CCSprite.sprite("tricolin.png");
		tricolin.setPosition(winSize.width / 2.0f, winSize.height / 2.0f);
		tricolin.setScale(0.7f);
		tricolin.setAnchorPoint(-0.5f, 0);
		addChild(tricolin);
		
		// Crear tricolina
		tricolina = CCSprite.sprite("tricolina.jpeg");
		tricolina.setPosition(winSize.width / 2.0f, winSize.height / 2.0f);
		tricolina.setScale(0.7f);
		tricolina.setAnchorPoint(1.5f, 0);
		addChild(tricolina);
		
		// Crear go
		go = CCSprite.sprite("go.gif");
		go.setPosition(450,100);
		go.setScale(0.7f);
		go.setAnchorPoint(0, 0);
		addChild(go);
		
		CCLabel label = CCLabel.makeLabel("Selecciona un personaje", "DroidSans", 22);
		label.setColor(labelColor);
		label.setPosition(320, 400);
		addChild(label);
		
		CCLabel label2 = CCLabel.makeLabel("Selecciona un color", "DroidSans", 22);
		label2.setColor(labelColor);
		label2.setPosition(295, 210);
		addChild(label2);
		
		scheduleUpdate();
		setIsTouchEnabled(true);
	}
	
	@Override
	public boolean ccTouchesEnded(MotionEvent event)
    {
		CGPoint convertedLocation = CCDirector.sharedDirector().convertToGL(CGPoint.make(event.getX(), event.getY()));
		float x = convertedLocation.x;
		float y = convertedLocation.y;
		
		// Verificacion de personaje
        if(tricolin.getBoundingBox().contains(x, y))
        {
        	personajeSeleccionado=1;
        	actualizarDatos();
        }else if(tricolina.getBoundingBox().contains(x, y))
        {
        	personajeSeleccionado=2;
        }
		
		// Verificacion de color
		if(yellow.getBoundingBox().contains(x, y))
		{
			colorSeleccionado=1;
		}else if(red.getBoundingBox().contains(x, y))
		{
			colorSeleccionado=2;
		}else if(blue.getBoundingBox().contains(x, y))
		{
			colorSeleccionado=3;
		}
		
		//Click al boton
		if(go.getBoundingBox().contains(x, y))
		{
			if(actualizarDatos())
			{
				CCScene scene = new Mundo();
				CCDirector.sharedDirector().runWithScene(scene);
			}
			
		}
		
        return CCTouchDispatcher.kEventHandled;
    }
	
	
	public boolean actualizarDatos()
	{
		if(personajeSeleccionado!=0 && colorSeleccionado!=0)
		{
			Actualizar Obj = new Actualizar();
			if(Obj.clickbuttonModificar(personajeSeleccionado, colorSeleccionado))
			{
				return true;
			}else{
				//Mensaje de error verifique su conexion a internet
				return false;
			}
		}else{
            //Mensaje de error debe elegir personaje y color
			return false;
		}
	}


}

