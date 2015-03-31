/**
 * File name:	IScreen.java
 * Version:		1.0
 * Date:		@date 13:11:03
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

package com.sawan.mathattack.interfaces;

// TODO: Auto-generated Javadoc
/**
 * The Interface IScreen.
 */
public interface IScreen {
	/**
	 * Set up screen elements. Call this method in constructor first
	 * <p>
	 * SUCH AS:<br>
	 * - Load assets<br>
	 * - Set back button active<br>
	 * - Set background texture<br>
	 * */
	public void setUpScreenElements();

	/**
	 * Set up screen menu.
	 */
	public void setUpMenu();
}
