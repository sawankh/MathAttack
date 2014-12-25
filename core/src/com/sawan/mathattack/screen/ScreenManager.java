/**
 * File name:	ScreenManager.java
 * Version:		1.0
 * Date:		25/12/2014 16:27:26
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

// TODO: Auto-generated Javadoc
/**
 * The Class ScreenManager.
 *
 * @author Sawan J. Kapai Harpalani
 */
public class ScreenManager {
	
	/** The current_screen. */
	private static Screen current_screen;
	
	/**
	 * Sets the current screen.
	 *
	 * @param screen the new current screen
	 */
	public static void setCurrentScreen(Screen screen) {
		if (current_screen != null) {
			current_screen.dispose();
		}
		current_screen = screen;
		current_screen.create();
	}
	
	/**
	 * Gets the current screen.
	 *
	 * @return the current screen
	 */
	public static Screen getCurrentScreen() {
		return current_screen;
	}
}
