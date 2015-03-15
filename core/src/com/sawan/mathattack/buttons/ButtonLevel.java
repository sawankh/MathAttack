/**
 * File name:	ButtonLevel.java
 * Version:		1.0
 * Date:		14/03/2015 23:10:50
 * Author:		Sawan
 * Copyright:	Copyright 200X Sawan
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
package com.sawan.mathattack.buttons;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.sawan.mathattack.asset.UIAssets;
import com.sawan.mathattack.scene2d.ui.AbstractButton;

/**
 * @author Sawan
 *
 */
public class ButtonLevel extends AbstractButton {

	private static final int UNDEFINED_LEVEL = -999;
	
	// Level texture and star textures
	private TextureRegion texture_star_holder;
	private TextureRegion texture_star;
	
	// Star size and position settings
	private float star_width;
	private float star_height;
	private float star_pos_x_start;
	private float star_pos_y_start;
	
	// Font(for writting levels)
	private BitmapFont font;
	
	private int level_number;
	
	public ButtonLevel(Drawable up, Drawable down) {
		super(UIAssets.cartwheel_font, up, down);
		star_pos_x_start = 0;
		star_pos_y_start = 0;
		level_number = UNDEFINED_LEVEL;
	}
	
	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		
		// If level is defined and font exist then draw else draw default button
		if (level_number !=  UNDEFINED_LEVEL && font != null) {
			super.draw(batch, parentAlpha);
			drawLevelNumber(batch);
			drawText(batch);
			drawStars(batch);
			drawExternalTexture(batch);
		} else {
			super.draw(batch, parentAlpha);
			drawText(batch);
			drawStars(batch);
			drawExternalTexture(batch);
		}

	}
	
	private void drawStars(SpriteBatch batch) {
		if (texture_star_holder != null && texture_star != null) {
			
		}
	}
	
	private void drawText(SpriteBatch batch) {
		
	}
	
	private void drawExternalTexture(SpriteBatch batch) {
		
	}
	
	private void drawLevelNumber(SpriteBatch batch) {
		
	}
}
