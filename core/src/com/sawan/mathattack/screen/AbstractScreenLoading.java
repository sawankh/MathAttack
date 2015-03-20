/**
 * File name:	AbstractScreenLoading.java
 * Version:		1.0
 * Date:		@date 13:16:19
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

import com.sawan.mathattack.game.AbstractGame;
import com.sawan.mathattack.interfaces.IScreenLoading;

public abstract class AbstractScreenLoading extends AbstractScreen implements
		IScreenLoading {

	// Loading time before proceed to next screen
	private float loadingTime;

	public AbstractScreenLoading(AbstractGame game, String screenName) {
		super(game, screenName);
		loadingTime = 1f;
		//
		setUpLoading();
	}

	/**
	 * Get loading time
	 * */
	public float getLoadingTime() {
		return loadingTime;
	}

	/**
	 * Set a loading / splash time. Sometimes AssetManager loads very fast. It
	 * may needed to wait specific amount of time to show logo, spash image,
	 * etc... before proceeding next screen
	 * */
	public void setLoadingTime(float loadingTime) {
		this.loadingTime = loadingTime;
	}
}
