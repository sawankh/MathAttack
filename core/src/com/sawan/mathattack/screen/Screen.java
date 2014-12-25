/**
 * File name:	Screen.java
 * Version:		1.0
 * Date:		25/12/2014 16:19:25
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
package com.sawan.mathattack.screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * The Class Screen.
 *
 * @author Sawan J. Kapai Harpalani
 */
public abstract class Screen {
	
	/**
	 * Creates the.
	 */
	public abstract void create();
	
	/**
	 * Render.
	 *
	 * @param sprite_batch the sprite_batch
	 */
	public abstract void render(SpriteBatch sprite_batch);
	
	/**
	 * Resize.
	 *
	 * @param width the width
	 * @param height the height
	 */
	public abstract void resize(int width, int height);
	
	/**
	 * Dispose.
	 */
	public abstract void dispose();
	
	/**
	 * Hide.
	 */
	public abstract void hide();
	
	/**
	 * Pause.
	 */
	public abstract void pause();
	
	/**
	 * Resume.
	 */
	public abstract void resume();
	
	/**
	 * Update.
	 */
	public abstract void update();
}
