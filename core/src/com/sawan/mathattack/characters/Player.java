/**
 * File name:	Player.java
 * Version:		1.0
 * Date:		@date 19:56:04
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

import com.badlogic.gdx.math.Vector2;
import com.sawan.mathattack.textures.TextureManager;

/**
 * The Class Player.
 */
public class Player extends Entity {

	/**
	 * Instantiates a new player.
	 *
	 * @param position the position
	 * @param direction the direction
	 */
	public Player(Vector2 position, Vector2 direction) {
		super(TextureManager.PLAYER, position, direction);
	}

	/* (non-Javadoc)
	 * @see com.sawan.mathattack.characters.Entity#update()
	 */
	@Override
	public void update() {	
		position.add(direction);
	}

}
