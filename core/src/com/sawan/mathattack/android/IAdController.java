/**
 * File name:	IAdController.java
 * Version:		1.0
 * Date:		@date 13:02:30
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


package com.sawan.mathattack.android;

// TODO: Auto-generated Javadoc
/**
 * The Interface IAdController.
 */
public interface IAdController {
	
	/**
	 * Gets the ad controller app brain.
	 *
	 * @return the ad controller app brain
	 */
	public IAdControllerAppBrain getAdControllerAppBrain();

	/**
	 * Gets the ad controller ad mob.
	 *
	 * @return the ad controller ad mob
	 */
	public IAdControllerAdMob getAdControllerAdMob();

	/**
	 * Gets the ad controller airpush.
	 *
	 * @return the ad controller airpush
	 */
	public IAdControllerAirpush getAdControllerAirpush();

	/**
	 * Gets the i ad controller leadbolt.
	 *
	 * @return the i ad controller leadbolt
	 */
	public IAdControllerLeadbolt getIAdControllerLeadbolt();

	/**
	 * Gets the i ad controller tapjoy.
	 *
	 * @return the i ad controller tapjoy
	 */
	public IAdControllerTapjoy getIAdControllerTapjoy();
}
