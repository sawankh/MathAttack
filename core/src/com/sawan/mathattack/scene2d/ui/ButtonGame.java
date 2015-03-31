/**
 * File name:	ButtonGame.java
 * Version:		1.0
 * Date:		@date 13:14:15
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


import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

// TODO: Auto-generated Javadoc
/**
 * The Class ButtonGame.
 */
public class ButtonGame extends AbstractButton {

	/**
	 * Instantiates a new button game.
	 *
	 * @param bitMapFont the bit map font
	 * @param up the up
	 * @param down the down
	 */
	public ButtonGame(BitmapFont bitMapFont, Drawable up, Drawable down) {
		super(bitMapFont, up, down);
	}

	/**
	 * Instantiates a new button game.
	 *
	 * @param bitMapFont the bit map font
	 * @param up the up
	 * @param down the down
	 * @param width the width
	 * @param height the height
	 * @param DIPActive the DIP active
	 */
	public ButtonGame(BitmapFont bitMapFont, Drawable up, Drawable down,
			float width, float height, boolean DIPActive) {
		super(bitMapFont, up, down, width, height, DIPActive);
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.scenes.scene2d.ui.Button#draw(com.badlogic.gdx.graphics.g2d.SpriteBatch, float)
	 */
	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		// If button locked
		// ##################################################################
		if (isLockActive && textureLocked != null) {
			drawLocked(batch);
		}

		// If text set and intented to be used
		// ##################################################################
		else if (text != "" && bitMapFont != null && isTextActive) {
			super.draw(batch, parentAlpha);
			drawText(batch);
			drawExternalTexture(batch);
		}

		// Draw default
		// ##################################################################
		else {
			super.draw(batch, parentAlpha);
			drawExternalTexture(batch);
		}
	}

	/**
	 * Draw external texture.
	 *
	 * @param batch the batch
	 */
	private void drawExternalTexture(SpriteBatch batch) {
		if(isExternalTextureActive && textureExternal != null){
			batch.draw(textureExternal, getX() + externalTexturePosX, getY() + externalTexturePosY, externalTextureSizeW, externalTextureSizeH);
		}
	}

	/**
	 * Draw locked.
	 *
	 * @param batch the batch
	 */
	private void drawLocked(SpriteBatch batch) {
		batch.draw(textureLocked, getX(), getY(), getWidth(), getHeight());
	}
	
	/**
	 * Draw text.
	 *
	 * @param batch the batch
	 */
	private void drawText(SpriteBatch batch) {
		bitMapFont.draw(batch, text, getX() +  textPosX, getY() + textPosY);
	}
}
