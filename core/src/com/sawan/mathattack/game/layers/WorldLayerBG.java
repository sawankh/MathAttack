/**
 * File name:	WorldLayerBG.java
 * Version:		1.0
 * Date:		20/3/2015 10:04:11
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

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Scaling;
import com.sawan.mathattack.asset.GameAssets;
import com.sawan.mathattack.asset.levels.MALevelAssets;
import com.sawan.mathattack.game.managers.MAGameManager;
import com.sawan.mathattack.models.EmptyActor;
import com.sawan.mathattack.models.EmptyActorLight;
import com.sawan.mathattack.models.SmartActor;
import com.sawan.mathattack.models.characters.Hero;
import com.sawan.mathattack.scene2d.AbstractWorldScene2d;
import com.sawan.mathattack.settings.AppSettings;

/**
 * @author Itop1
 *
 */
public class WorldLayerBG extends AbstractWorldScene2d {
	MAGameManager gameManager;

	public final float SOIL_WIDHT = 205f / 3;
	public final float SOIL_HEIGHT = 208f /3;
	
	
	private ArrayList<Actor> hearts;
	
	public int level;
	
	public WorldLayerBG(MAGameManager gameManager, float posX, float posY,
			float worldWidth, float worldHeight, int level) {
		super(posX, posY, worldWidth, worldHeight);
		//
		this.gameManager = gameManager;
		this.level = level;
		
		MALevelAssets.setFILE_IMAGE_ATLAS(level);
		MALevelAssets.loadAll();
		
		//
		setUpBackround();
		setUpMountains();
		setUpBottomSoils();
		//setUpClouds();
		setUpLives(Hero.NUM_LIFES);
		
	}

	private void setUpBackround() {
		setBackgroundTexture(MALevelAssets.sky, Scaling.stretch, true, false);
	}

	private void setUpBottomSoils() {
		
		EmptyActor soil = new EmptyActor(1000f, 550f, true);
		soil.setTextureRegion(MALevelAssets.soil, true);
		
		soil.setPosition(0, 0);
		
		soil.setZIndex(2);
		addActor(soil);
	}

	private void setUpClouds() {
		Random rnd = new Random();
		//
		for (int i = 0; i < 8; i++) {
			//
			float rndSizeRatio = rnd.nextInt(80) + 20;
			//
			SmartActor currentCloud = new SmartActor(231 * rndSizeRatio / 100,
					128 * rndSizeRatio / 100, rnd, true);
			//
			currentCloud.setTextureRegion(MALevelAssets.clouds, true);
			currentCloud.setPosition(-200,
					(gameManager.getStage().getHeight() / 2) +(gameManager.getStage().getHeight() / 4));
			//
			//float posY = rnd.nextInt((int) gameManager.getStage().getHeight() / 10)
				//	+ gameManager.getStage().getHeight() / 3;
			float posY = rnd.nextInt((int) gameManager.getStage().getHeight()  - ((int) (gameManager.getStage().getHeight() / 2) + (int) (gameManager.getStage().getHeight() / 4))) + ((int) (gameManager.getStage().getHeight() / 2) + (int) (gameManager.getStage().getHeight() / 4)) ;
			
			//
			currentCloud.startActionMoveSideToSideFreely(15, -200,
					(int) gameManager.getStage().getWidth() + 200,(int) posY,
					15f);
			
			currentCloud.setZIndex(2);
			//
			addActor(currentCloud);
		}
	}
	
	public void setUpMountains() {
		EmptyActorLight mountain = new EmptyActorLight(1000f, 900f, true);
		
		mountain.setTextureRegion(MALevelAssets.mountains, true);
		mountain.setX(0);
		mountain.setY(0);
		
		mountain.setZIndex(1);
		
		addActor(mountain);
	}

	public void setUpLives(int num_lives) {
		hearts = new ArrayList<Actor>();
		for (int i = 0; i < num_lives; i++) {
			EmptyActor current_heart = new EmptyActor(25f, 25f, true);
			current_heart.setName(Integer.toString(i));
			
			float posX = (i * current_heart.getWidth()) + (50f * AppSettings.getWorldPositionXRatio());
			float posY = (gameManager.getStage().getHeight() - current_heart.getHeight()) - (50f * AppSettings.getWorldPositionYRatio());
			
			current_heart.setPosition(posX, posY);
			current_heart.setAnimation(GameAssets.heart, true, true);
			
			
			current_heart.setZIndex(2);
			
			hearts.add(current_heart);
			addActor(current_heart);
		}
	}
	
	public void removeHeart() {
		removeActor(hearts.get(hearts.size() - 1));
		hearts.remove(hearts.size() - 1);
	}
	
}
