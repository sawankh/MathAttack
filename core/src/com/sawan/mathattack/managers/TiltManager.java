/**
 * File name:	TiltManager.java
 * Version:		1.0
 * Date:		@date 13:11:54
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

package com.sawan.mathattack.managers;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.sawan.mathattack.utils.UtilsNumbers;

// TODO: Auto-generated Javadoc
/**
 * The Class TiltManager.
 */
public class TiltManager {
	
	/** The is sensor active. */
	private boolean isSensorActive;
	
	/** The accel list for accuracy. */
	private ArrayList<Float> accelListForAccuracy;

	/**
	 * The Enum Accel.
	 */
	public enum Accel {
		
		/** The x. */
		X, 
 /** The y. */
 Y, 
 /** The z. */
 Z
	}

	/**
	 * Instantiates a new tilt manager.
	 */
	public TiltManager() {
		isSensorActive = true;
		accelListForAccuracy = new ArrayList<Float>();
	}

	/**
	 * Gets the accel x.
	 *
	 * @return the accel x
	 */
	public float getAccelX() {
		if (isSensorActive) {
			return Gdx.input.getAccelerometerX();
		} else {
			return 0.0f;
		}
	}

	/**
	 * Gets the accel y.
	 *
	 * @return the accel y
	 */
	public float getAccelY() {
		if (isSensorActive) {
			return Gdx.input.getAccelerometerY();
		} else {
			return 0.0f;
		}
	}

	/**
	 * Gets the accel z.
	 *
	 * @return the accel z
	 */
	public float getAccelZ() {
		if (isSensorActive) {
			return Gdx.input.getAccelerometerZ();
		} else {
			return 0.0f;
		}
	}

	/**
	 * Gets the accurate accel.
	 *
	 * @param accel the accel
	 * @param numberOfAvarage the number of avarage
	 * @return the accurate accel
	 */
	public float getAccurateAccel(Accel accel, int numberOfAvarage) {
		// FIXME
		// Not works fine

		float result = 0.0f;

		if (accel == Accel.X) {
			result = getAccelX();
		} else if (accel == Accel.Y) {
			result = getAccelY();
		} else if (accel == Accel.Z) {
			result = getAccelZ();
		} else {
			return result;
		}

		accelListForAccuracy.add(result);
		//
		if (accelListForAccuracy.size() >= numberOfAvarage) {
			result = UtilsNumbers.calculateAverage(accelListForAccuracy);
			accelListForAccuracy.clear();
			return result;
		} else {
			return 0.0f;
		}
	}

	/**
	 * Checks if is sensor active.
	 *
	 * @return true, if is sensor active
	 */
	public boolean isSensorActive() {
		return isSensorActive;
	}

	/**
	 * Sets the sensor active.
	 *
	 * @param isSensorActive the new sensor active
	 */
	public void setSensorActive(boolean isSensorActive) {
		this.isSensorActive = isSensorActive;
	}
}
