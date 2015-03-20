/**
 * File name:	MathAttackButton.java
 * Version:		1.0
 * Date:		07/03/2015 20:19:41
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
package com.sawan.mathattack.buttons;

import java.util.Random;

import com.sawan.mathattack.models.SmartActor;

/**
 * The Class MathAttackButton.
 *
 * @author Sawan
 */
public class MathAttackButton extends SmartActor {

	/**
	 * Instantiates a new math attack button.
	 *
	 * @param width the width
	 * @param height the height
	 * @param rnd the rnd
	 * @param DIPActive the DIP active
	 */
	public MathAttackButton(float width, float height, Random rnd,
			boolean DIPActive) {
		super(width, height, rnd, DIPActive);
	}

}
