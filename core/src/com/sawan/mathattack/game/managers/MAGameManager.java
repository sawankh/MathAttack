/**
 * File name:	MAGameManager.java
 * Version:		1.0
 * Date:		20/3/2015 9:52:54
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
package com.sawan.mathattack.game.managers;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.sawan.mathattack.game.AbstractGameManager;
import com.sawan.mathattack.game.GameState;
import com.sawan.mathattack.game.layers.WorldLayerActors;
import com.sawan.mathattack.game.layers.WorldLayerBG;
import com.sawan.mathattack.game.layers.WorldLayerOther;
import com.sawan.mathattack.interfaces.IGameManager;
import com.sawan.mathattack.screen.AbstractScreen;
import com.sawan.mathattack.settings.AppSettings;

/**
 * @author Sawan
 *
 */
public class MAGameManager extends AbstractGameManager implements IGameManager {

	public com.sawan.mathattack.game.layers.World world;
	public WorldLayerBG worldLayer_background;
	public WorldLayerActors worldLayer_actors;
	public WorldLayerOther worldLayer_other;

	public MAGameManager(Stage stage, AbstractScreen screen) {
		super(stage, screen);
		//
		setUpWorld();
		//
		setGameState(GameState.GAME_RUNNING);
	}

	@Override
	public void setUpWorld() {
		//
		// Create the main world and its world layers
		// #############################################################
		world = new com.sawan.mathattack.game.layers.World(this, 0, 0, AppSettings.SCREEN_W, AppSettings.SCREEN_H);
		
		//
		// World layers
		// #############################################################
		//
		// Layer1 - Background image, bottom soil, clouds
		// Layer2 - Flying enemy objects
		// Layer3 - Snow effect
		//
		worldLayer_background = new WorldLayerBG(this, 0, 0, AppSettings.SCREEN_W,
				AppSettings.SCREEN_H);
		worldLayer_actors = new WorldLayerActors(this, 0, 0, AppSettings.SCREEN_W,
				AppSettings.SCREEN_H);
		//worldLayer_other = new WorldLayerOther(this, 0, 0, AppSettings.SCREEN_W,
			//	AppSettings.SCREEN_H);

		//
		// Add all layers to world
		// #############################################################
		world.addActor(worldLayer_background);
		world.addActor(worldLayer_actors);
		//world.addActor(worldLayer_other);

		//
		// Add the main world to stage
		// #############################################################
		getStage().addActor(world);
	}

	@Override
	public void startLevel(int levelNumber) {

	}

	@Override
	public void checkGameCondition() {
		worldLayer_actors.isHeroAlive();
	}

	@Override
	public void update(float delta) {
		checkGameCondition();
		worldLayer_actors.checkCollision(worldLayer_actors.hero, worldLayer_actors.enemies);
		worldLayer_actors.hitEnemy(worldLayer_actors.bullets, worldLayer_actors.enemies);
		if (worldLayer_actors.hero.isLost_life()) {
			//worldLayer_background.setUpLives(worldLayer_actors.hero.getLifes());
			worldLayer_background.removeHeart();
			worldLayer_actors.hero.setLost_life(false);
		}
		
	}

	@Override
	public void saveGame() {

	}

    @Override
    public void setUpData() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setUpPreManagers() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setUpPostManagers() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
	

}
