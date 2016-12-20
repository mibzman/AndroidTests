package com.mundotricolin.ingame;

import org.cocos2d.layers.CCScene;


public class CasitaTricolin extends CCScene {
	
	CasitaTricolinLayer casita;
	
	public CasitaTricolin()
	{
		super();
		
		casita = new CasitaTricolinLayer(this);
		addChild(casita);
	}

}
