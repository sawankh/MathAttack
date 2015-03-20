/**
 * File name:	Text.java
 * Version:		1.0
 * Date:		@date 13:15:54
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
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sawan.mathattack.scene2d.AbstractActorLight;
import com.sawan.mathattack.settings.AppSettings;

public class Text extends AbstractActorLight {
	private String text = "";
	private BitmapFont bitMapFont;
	//
	private float originalPosY;

	public Text(BitmapFont bitMapFont, float width, float height,
			boolean DIPActive) {
		super(width, height, DIPActive);
		this.bitMapFont = bitMapFont;
		//
		if (DIPActive) {
			bitMapFont.setScale(AppSettings.getWorldSizeRatio());
		}
	}

	public void setBitMapFont(BitmapFont bitMapFont, boolean DIPActive) {
		this.bitMapFont = bitMapFont;
		//
		if (DIPActive) {
			bitMapFont.setScale(AppSettings.getWorldSizeRatio());
		}
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		//
		drawText(batch);
	}

	private void drawText(SpriteBatch batch) {
		if (bitMapFont != null) {
			bitMapFont.draw(batch, text, getX(), getY());
		}
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public BitmapFont getBitMapFont() {
		return bitMapFont;
	}

	public float getOriginalPosY() {
		return originalPosY;
	}

	public void setOriginalPosY(float originalPosY) {
		this.originalPosY = originalPosY;
	}
}
