/**
 * File name:	Bullet.java
 * Version:		1.0
 * Date:		27/3/2015 12:02:33
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
package com.sawan.mathattack.models.ammunition;

import com.sawan.mathattack.scene2d.AbstractActor;

/**
 * @author Itop1
 *
 */
public class Bullet extends AbstractActor {
	float worldWidth;
	float speed;
	boolean isMoving;
	
	/**
	 * @param width
	 * @param height
	 * @param DIPActive
	 */
	public Bullet(float width, float height, boolean DIPActive) {
		super(width, height, DIPActive);	
	}
	
	public void startMoving(float worldWidht, float speed, boolean isMoving) {
		this.worldWidth = worldWidht;
		this.speed = speed;
		this.isMoving = isMoving;
	}
	

	@Override
	public void act(float delta) {
		super.act(delta);
		
		if(isMoving){
			translateWithoutAcc(speed, 0, delta);
		}
	}

	
}
