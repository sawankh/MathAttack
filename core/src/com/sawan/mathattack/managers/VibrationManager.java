/**
 * File name:	VibrationManager.java
 * Version:		1.0
 * Date:		@date 13:11:59
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

import com.badlogic.gdx.Gdx;

public class VibrationManager {
	// Milliseconds (Mostly from MORSE CODE)
	public static final int BUZZ = 50;
	public static final int DOT = 100;
	public static final int DASH = 500;
	public static final int SHORT_GAP = 200;
	public static final int MEDIUM_GAP = 500;
	public static final int LONG_GAP = 1000;

	public VibrationManager() {
	}

	/**
	 * Vibrate, it only vibrates if SettingsManager.isVibrationOn(), 1000ms is 1
	 * second, also requires "android.permission.VIBRATE" in android manifest
	 * */
	public void vibrate(int milliseconds) {
		if (SettingsManager.isVibrationOn()) {
			Gdx.input.vibrate(milliseconds);
		}
	}

	/**
	 * Vibrate with a pattern, it only vibrates if
	 * SettingsManager.isVibrationOn(), 1000ms is 1 second, also requires
	 * "android.permission.VIBRATE" in android manifest
	 * */
	public void vibrate(long[] pattern, int repeat) {
		if (SettingsManager.isVibrationOn()) {
			Gdx.input.vibrate(pattern, repeat);
		}
	}

	/**
	 * Cancel vibration
	 * */
	public void cancel() {
		Gdx.input.cancelVibrate();
	}
}
