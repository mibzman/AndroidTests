package com.mundotricolin.ingame;

import org.cocos2d.layers.CCScene;


public class CuevaOro extends CCScene {
	
	CuevaOroLayer cueva;
	
	public CuevaOro()
	{
		super();
		
		cueva = new CuevaOroLayer(this);
		addChild(cueva);
	}

}
