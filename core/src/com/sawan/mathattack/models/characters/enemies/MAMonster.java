/**
 * File name:	BlueMonster.java
 * Version:		1.0
 * Date:		21/03/2015 18:55:57
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
package com.sawan.mathattack.models.characters.enemies;

import com.sawan.mathattack.scene2d.AbstractActor;

// TODO: Auto-generated Javadoc
/**
 * The Class MAMonster.
 *
 * @author Sawan
 */
public class MAMonster extends AbstractActor {
	
	/** The world width. */
	float worldWidth;
	
	/** The speed. */
	float speed;
	
	/** The is moving. */
	boolean isMoving;
	
	/** The is looping. */
	boolean isLooping;
	
	/** The is alive. */
	boolean isAlive;
	
	
	/**
	 * Instantiates a new MA monster.
	 *
	 * @param width the width
	 * @param height the height
	 * @param DIPActive the DIP active
	 */
	public MAMonster(float width, float height, boolean DIPActive) {
		super(width, height, DIPActive);
		isAlive = true;
	}
	
	/**
	 * Start moving.
	 *
	 * @param worldWidth the world width
	 * @param speed the speed
	 * @param isMoving the is moving
	 * @param isLooping the is looping
	 */
	public void startMoving(float worldWidth,  float speed, boolean isMoving, boolean isLooping){
		this.worldWidth = worldWidth;
		this.speed = speed;
		this.isMoving = isMoving;
		this.isLooping = isLooping;

	}
	
	/* (non-Javadoc)
	 * @see com.sawan.mathattack.scene2d.AbstractActor#act(float)
	 */
	@Override
	public void act(float delta) {
		super.act(delta);
		//
		if (isLooping) {
			checkPosition();
		}
		//
		if(isMoving){
			translateWithoutAcc(-speed, 0, delta);
		}
	}

	/**
	 * Check position.
	 */
	private void checkPosition() {
		if(getX() < -200){
			setX(worldWidth + 200);
		}
	}

	/**
	 * Checks if is alive.
	 *
	 * @return the isAlive
	 */
	public boolean isAlive() {
		return isAlive;
	}

	/**
	 * Sets the alive.
	 *
	 * @param isAlive the isAlive to set
	 */
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	
}
