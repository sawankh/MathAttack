/**
 * File name:	UtilsNumbers.java
 * Version:		1.0
 * Date:		@date 13:16:58
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

import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Pattern;

// TODO: Auto-generated Javadoc
/**
 * The Class UtilsNumbers.
 */
public class UtilsNumbers {
	//
	/** The Constant logTag. */
	protected final static String logTag = "MtxUtilsNumbersLog";
	
	/** The log active. */
	public static boolean logActive = true;

	/** The double pattern. */
	private static Pattern doublePattern = Pattern.compile("-?\\d+(\\.\\d*)?");

	/**
	 * Check if a string is parseable to integer/double.
	 *
	 * @param string the string
	 * @return true, if is int dob
	 */
	public static boolean isIntDob(String string) {
		return doublePattern.matcher(string).matches();
	}

	/**
	 * Shuffle an array for integers
	 * <p>
	 * EXAMPLE: <br>
	 * Array [1,2,3,4,5,6] getting shuffled <br>
	 * After shuffle [2,1,6,3,5,4] or any other combination.
	 *
	 * @param a            array to shuffle
	 */
	public static void shuffleArray(int[] a) {
		int n = a.length;
		Random random = new Random();
		random.nextInt();
		for (int i = 0; i < n; i++) {
			int change = i + random.nextInt(n - i);
			swap(a, i, change);
		}
	}

	/**
	 * Shuffle helper.
	 *
	 * @param a the a
	 * @param i the i
	 * @param change the change
	 */
	public static void swap(int[] a, int i, int change) {
		int helper = a[i];
		a[i] = a[change];
		a[change] = helper;
	}

	/**
	 * Calculate average number of float list.
	 *
	 * @param numbersList the numbers list
	 * @return the float
	 */
	public static float calculateAverage(ArrayList<Float> numbersList) {
		Float sum = 0f;
		for (Float number : numbersList) {
			sum += number;
		}
		return sum.floatValue() / numbersList.size();
	}

	/**
	 * Find the closets integer of a given integer among integer array list.
	 *
	 * @param list the list
	 * @param value the value
	 * @return the value found else -1
	 */
	public static int findClosestNumber(ArrayList<Integer> list, int value) {
		int closestMatch = -1;
		boolean isFirstNumberTaken = false;
		for (int i = 0; i < list.size(); i++) {
			if (!isFirstNumberTaken) {
				closestMatch = list.get(i);
				isFirstNumberTaken = true;
			} else {
				int current = Math.abs(value - closestMatch);
				int next = Math.abs(value - list.get(i));
				if (current > next) {
					closestMatch = list.get(i);
				}
			}
		}
		return closestMatch;
	}
}
