package com.mundotricolin.ingame;

import org.cocos2d.layers.CCScene;

public class TeatroNacional extends CCScene {
	
	TeatroNacionalLayer teatro;
	
	public TeatroNacional()
	{
		super();
		
		teatro = new TeatroNacionalLayer(this);
		addChild(teatro);
	}

}
