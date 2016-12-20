package com.mundotricolin.ingame;

import org.cocos2d.layers.CCScene;

public class TiendaTricolin extends CCScene {
	
	TiendaTricolinLayer tienda;
	
	public TiendaTricolin()
	{
		super();
		
		tienda = new TiendaTricolinLayer(this);
		addChild(tienda);
	}

}
