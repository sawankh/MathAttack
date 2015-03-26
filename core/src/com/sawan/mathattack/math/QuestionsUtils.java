/**
 * File name:	QuestionsUtils.java
 * Version:		1.0
 * Date:		26/3/2015 13:44:01
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
package com.sawan.mathattack.math;

import java.util.Random;

/**
 * @author Itop1
 *
 */
public class QuestionsUtils {
	
	// Implementing Fisher–Yates shuffle
	public static void shuffleArray(int[] ar) {
	    Random rnd = new Random();
	    
	    for (int i = ar.length - 1; i > 0; i--) {
	      int index = rnd.nextInt(i + 1);
	    
	      // Simple swap
	      int a = ar[index];
	      ar[index] = ar[i];
	      ar[i] = a;
	    }
	}
	
	public static int randomNumber(int lower_bound, int higher_bound) {
		// A random integer value in the range [Lower_bound, Higher_bound] 
		// Lower_bound + (int)(Math.random() * ((Higher_bound - Lower_bound) + 1))
		int random_number = lower_bound + (int)(Math.random() * ((higher_bound - lower_bound) + 1)) ;
		return random_number;
	}
}
