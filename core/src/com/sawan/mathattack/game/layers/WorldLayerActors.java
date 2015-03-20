/**
 * File name:	WorldLayerActors.java
 * Version:		1.0
 * Date:		20/3/2015 10:05:12
 * Author:		Itop1
 * Copyright:	Copyright 200X Itop1
 *
 *				This file is part of Math Attack.
 *
 *				Math Attack is free software: you can redistribute it 
 *				and/or modify it under the terms of the GNU General
 *				Public License as published by the Free Software 
 *				Foundation, either version 3 of the License, 
 *				or (at your option) any later version.
 *
 *				Math Attack is distributed in the hope that it will 
 *				be useful, but WITHOUT ANY WARRANTY; without even 
 *				the implied warranty of MERCHANTABILITY or FITNESS 
 *				FOR A PARTICULAR PURPOSE. See the GNU General Public
 *			    License for more details.
 *
 *				You should have received a copy of the GNU General 
 *				Public License along with Math Attack. If not, see 
 *				http://www.gnu.org/licenses/.
 */
package com.sawan.mathattack.game.layers;

import com.sawan.mathattack.asset.HeroAssests;
import com.sawan.mathattack.game.managers.MAGameManager;
import com.sawan.mathattack.models.characters.Hero;
import com.sawan.mathattack.scene2d.AbstractWorldScene2d;

/**
 * @author Sawan
 *
 */
public class WorldLayerActors extends AbstractWorldScene2d {
	
	private MAGameManager gameManager;
	private Hero hero;
	
	public WorldLayerActors(MAGameManager gameManager, float posX, float posY, float worldWidth, float worldHeight) {
		super(posX, posY, worldWidth, worldHeight);
		this.gameManager =  gameManager;
		setUpHero();
	}
	
	public void setUpHero() {
		hero = new Hero(gameManager.getStage().getWidth() / 2 - 48, 120, 96, 96);
		hero.setAnimation(HeroAssests.hero_standing, true, true);
		addActor(hero);
	}
}
