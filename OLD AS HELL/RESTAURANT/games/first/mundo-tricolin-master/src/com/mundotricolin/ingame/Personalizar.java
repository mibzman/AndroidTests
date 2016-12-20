package com.mundotricolin.ingame;

import org.cocos2d.layers.CCScene;



public class Personalizar extends CCScene {
	
	PersonalizarLayer pantalla;
	
	public Personalizar()
	{
		super();
		
		pantalla = new PersonalizarLayer(this);
		addChild(pantalla);
	}

}

