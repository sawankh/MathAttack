/**
 * File name:	EmptyGroup.java
 * Version:		1.0
 * Date:		@date 13:12:18
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

package com.sawan.mathattack.models;

import com.sawan.mathattack.scene2d.AbstractGroup;

// TODO: Auto-generated Javadoc
/**
 * The Class EmptyGroup.
 */
public class EmptyGroup extends AbstractGroup {

	/**
	 * Instantiates a new empty group.
	 *
	 * @param posX the pos x
	 * @param posY the pos y
	 * @param width the width
	 * @param height the height
	 */
	public EmptyGroup(float posX, float posY, float width, float height) {
		super(posX, posY, width, height);
	}

	/**
	 * Instantiates a new empty group.
	 *
	 * @param width the width
	 * @param height the height
	 * @param DIPActive the DIP active
	 */
	public EmptyGroup(float width, float height, boolean DIPActive) {
		super(width, height, DIPActive);
	}
}
