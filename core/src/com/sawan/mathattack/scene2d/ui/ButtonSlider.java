/**
 * File name:	ButtonSlider.java
 * Version:		1.0
 * Date:		@date 13:14:33
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
package com.sawan.mathattack.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.sawan.mathattack.settings.AppSettings;

// TODO: Auto-generated Javadoc
/**
 * The Class ButtonSlider.
 */
public class ButtonSlider extends Slider {

	/**
	 * Instantiates a new button slider.
	 *
	 * @param min the min
	 * @param max the max
	 * @param stepSize the step size
	 * @param vertical the vertical
	 * @param style the style
	 * @param width the width
	 * @param height the height
	 * @param DIPActive the DIP active
	 */
	public ButtonSlider(float min, float max, float stepSize, boolean vertical,
			SliderStyle style, float width, float height, boolean DIPActive) {
		super(min, max, stepSize, vertical, style);
		//
		if (DIPActive) {
			setSize(width * AppSettings.getWorldSizeRatio(), height
					* AppSettings.getWorldSizeRatio());
		}
	}
}
