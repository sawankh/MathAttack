/**
 * File name:	World.java
 * Version:		1.0
 * Date:		20/3/2015 10:07:33
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

import com.sawan.mathattack.game.GameState;
import com.sawan.mathattack.game.managers.MAGameManager;
import com.sawan.mathattack.scene2d.AbstractWorldScene2d;

/**
 * @author Itop1
 *
 */
public class World extends AbstractWorldScene2d {
	MAGameManager gameManager;

	public World(MAGameManager gameManager, float posX, float posY,
			float worldWidth, float worldHeight) {
		super(posX, posY, worldWidth, worldHeight);
		//
		this.gameManager = gameManager;
	}

	@Override
	public void act(float delta) {
		//
		// Actors act under the world if only game state is Running
		// ####################################################################
		if (gameManager.getGameState() == GameState.GAME_RUNNING) {
			super.act(delta);
		}
	}
}
