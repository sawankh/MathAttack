/**
 * File name:	Hero.java
 * Version:		1.0
 * Date:		20/03/2015 21:25:36
 * Author:		Sawan
 * Copyright:	Copyright 200X Sawan
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
package com.sawan.mathattack.models.characters;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.sawan.mathattack.scene2d.AbstractActor;

/**
 * @author Sawan
 *
 */
public class Hero extends AbstractActor {

	private int lifes;
	private boolean lost_life;
	private boolean alive;
	
	public final static int NUM_LIFES = 5;
	
	/**
	 * Instantiates a new hero.
	 *
	 * @param textureRegion the texture region
	 * @param isTextureRegionActive the is texture region active
	 * @param posX the pos x
	 * @param posY the pos y
	 * @param width the width
	 * @param height the height
	 */
	public Hero(TextureRegion textureRegion, boolean isTextureRegionActive,
			float posX, float posY, float width, float height) {
		super(textureRegion, isTextureRegionActive, posX, posY, width, height);
		lost_life = false;
		setLifes(NUM_LIFES);
	}
	
	
	
	/**
	 * @param width
	 * @param height
	 * @param DIPActive
	 */
	public Hero(float width, float height, boolean DIPActive) {
		super(width, height, DIPActive);
		lost_life = false;
		setLifes(NUM_LIFES);
	}



	/**
	 * Instantiates a new hero.
	 *
	 * @param posX the pos x
	 * @param posY the pos y
	 * @param width the width
	 * @param height the height
	 */
	public Hero(float posX, float posY, float width, float height) {
		super(posX, posY, width, height);
		lost_life = false;
		setLifes(NUM_LIFES);
	}



	/**
	 * @return the lifes
	 */
	public int getLifes() {
		return lifes;
	}



	/**
	 * @param lifes the lifes to set
	 */
	public void setLifes(int lifes) {
		this.lifes = lifes;
	}



	/**
	 * @return the lost_life
	 */
	public boolean isLost_life() {
		return lost_life;
	}



	/**
	 * @param lost_life the lost_life to set
	 */
	public void setLost_life(boolean lost_life) {
		this.lost_life = lost_life;
	}



	/**
	 * @return the alive
	 */
	public boolean isAlive() {
		return alive;
	}



	/**
	 * @param alive the alive to set
	 */
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	

}
