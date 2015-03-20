/**
 * File name:	UtilsRandomizer.java
 * Version:		1.0
 * Date:		@date 13:17:16
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
package com.sawan.mathattack.utils;

import java.util.Random;

public class UtilsRandomizer {
	/**
	 * Get random number in a range (inclusive)
	 * */
	public static int getRandomInclusive(Random rnd, int min, int max) {
		return (rnd.nextInt(max + 1 - min) + min);
	}

	/**
	 * Get random number in a range (exclusive)
	 * */
	public static int getRandomExclusive(Random rnd, int min, int max) {
		int rndNumber = rnd.nextInt(max - min);
		if (rndNumber != 0)
			return rndNumber + min;
		else
			return rndNumber + min + 1;
	}
}
