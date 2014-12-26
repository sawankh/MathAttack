/**
 * File name:	Entity.java
 * Version:		1.0
 * Date:		25/12/2014 19:44:35
 * Author:		Sawan J. Kapai Harpalani
 * Copyright:	Copyright 200X Sawan J. Kapai Harpalani
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
package com.sawan.mathattack.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

// TODO: Auto-generated Javadoc
/**
 * The Class Entity.
 *
 * @author Sawan J. Kapai Harpalani
 */
public abstract class Entity {
	
	/** The texture. */
	protected Texture texture;
	
	/** The position. */
	protected Vector2 position;
	
	/** The direction. */
	protected Vector2 direction;
	
	/**
	 * Instantiates a new entity.
	 *
	 * @param texture the texture
	 * @param position the position
	 * @param direction the direction
	 */
	public Entity(Texture texture, Vector2 position, Vector2 direction) {
		this.texture = texture;
		this.position = position;
		this.direction = direction;
	}

	/**
	 * Update.
	 *
	 */
	public abstract void update();
	
	/**
	 * Render.
	 *
	 * @param sprite_batch the sprite_batch
	 */
	public void render(SpriteBatch sprite_batch) {
		sprite_batch.draw(texture, position.x, position.y);
	}
	
	/**
	 * @return the position
	 */
	public Vector2 getPosition() {
		return position;
	}

	
	/**
	 * Sets the direction.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public void setDirection(float x, float y) {
		direction.set(x, y);
		direction = direction.scl(Gdx.graphics.getDeltaTime());
	}
	
	
}
