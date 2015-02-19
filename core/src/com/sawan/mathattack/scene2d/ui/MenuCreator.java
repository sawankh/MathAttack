/**
 * File name:	MenuCreator.java
 * Version:		1.0
 * Date:		@date 13:14:53
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

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider.SliderStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class MenuCreator {
	public static Table createTable(boolean fillParent, Skin skin) {
		Table table = new Table(skin);
		table.setFillParent(fillParent);
		return table;
	}

	public static ButtonGame createCustomGameButton(BitmapFont bitmapFont,
			TextureRegion up, TextureRegion down, float width, float height,
			boolean DIPActive) {
		Drawable dUp = new TextureRegionDrawable(up);
		Drawable dDown = new TextureRegionDrawable(down);
		return new ButtonGame(bitmapFont, dUp, dDown, width, height, true);
	}

	public static ButtonGame createCustomGameButton(BitmapFont bitmapFont,
			TextureRegion up, TextureRegion down) {
		Drawable dUp = new TextureRegionDrawable(up);
		Drawable dDown = new TextureRegionDrawable(down);
		return new ButtonGame(bitmapFont, dUp, dDown);
	}

	public static ButtonToggle createCustomToggleButton(BitmapFont bitmapFont,
			TextureRegion tOn, TextureRegion tOff, boolean isToggleActive) {
		Drawable dUp = new TextureRegionDrawable(tOn);
		Drawable dDown = new TextureRegionDrawable(tOff);
		return new ButtonToggle(bitmapFont, dUp, dDown, tOn, tOff,
				isToggleActive);
	}

	public static ButtonToggle createCustomToggleButton(BitmapFont bitmapFont,
			TextureRegion tOn, TextureRegion tOff, boolean isToggleActive,
			float width, float height, boolean DIPActive) {
		Drawable dUp = new TextureRegionDrawable(tOn);
		Drawable dDown = new TextureRegionDrawable(tOff);
		return new ButtonToggle(bitmapFont, dUp, dDown, tOn, tOff,
				isToggleActive, width, height, DIPActive);
	}

	public static ButtonSlider createCustomSlider(TextureRegion tBackground,
			TextureRegion tKnob, boolean isVertical, float min, float max,
			float stepSize, float width, float height, boolean DIPActive) {
		//
		Drawable dBg = new TextureRegionDrawable(tBackground);
		Drawable dKnob = new TextureRegionDrawable(tKnob);
		SliderStyle sliderStyle = new SliderStyle(dBg, dKnob);
		return new ButtonSlider(min, max, stepSize, isVertical, sliderStyle,
				width, height, DIPActive);
	}

}
