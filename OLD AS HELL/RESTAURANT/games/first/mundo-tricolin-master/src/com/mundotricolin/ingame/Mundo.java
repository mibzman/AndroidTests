package com.mundotricolin.ingame;

import org.cocos2d.layers.CCScene;

import com.mundotricolin.ingame.MundoLayer;


public class Mundo extends CCScene {
	
	MundoLayer juego;
	
	public Mundo()
	{
		super();
		
		juego = new MundoLayer(this);
		addChild(juego);
	}

}
