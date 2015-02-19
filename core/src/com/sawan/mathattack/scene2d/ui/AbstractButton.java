/**
 * File name:	AbstractButton.java
 * Version:		1.0
 * Date:		@date 13:13:48
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
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.sawan.mathattack.settings.AppSettings;

public abstract class AbstractButton extends Button {
	// Locked (Not mandatory)
	protected boolean isLockActive = false;
	protected TextureRegion textureLocked;

	// Text (Not mandatory)
	protected boolean isTextActive = false;
	protected float textPosX = 0.0f;
	protected float textPosY = 0.0f;
	protected String text = "";
	protected BitmapFont bitMapFont;

	// External texture (Not mandatory)
	protected boolean isExternalTextureActive = false;
	protected float externalTexturePosX = 0.0f;
	protected float externalTexturePosY = 0.0f;
	protected float externalTextureSizeW = 50.0f;
	protected float externalTextureSizeH = 50.0f;
	protected TextureRegion textureExternal;

	//
	private boolean DIPActive = false;

	public AbstractButton(BitmapFont bitMapFont, Drawable up, Drawable down) {
		super(up, down);
		this.bitMapFont = bitMapFont;
	}

	public AbstractButton(BitmapFont bitMapFont, Drawable up, Drawable down,
			float width, float height, boolean DIPActive) {
		super(up, down);
		this.bitMapFont = bitMapFont;
		this.DIPActive = DIPActive;
		//
		if (DIPActive) {
			setSize(width * AppSettings.getWorldSizeRatio(), height
					* AppSettings.getWorldSizeRatio());
			if (this.bitMapFont != null) {
				bitMapFont.setScale(AppSettings.getWorldSizeRatio());
			}
		}
	}

	@Override
	public Actor hit(float x, float y, boolean touchable) {
		// return super.hit(x, y, touchable);

		if (!isLockActive) {
			// If not locked detect the inputs
			return super.hit(x, y, touchable);
		} else {
			// If locked do not detect any hit by returning NULL
			return null;
		}
	}

	/**
	 * Get if the button lock active
	 * */
	public boolean isLockActive() {
		return isLockActive;
	}

	/**
	 * Set the lock, it overrides the hit method, so it wont detect hits, also
	 * if it is active, lock texture will be drawn
	 * 
	 * @see hit()
	 * */
	public void setLockActive(boolean isLockActive) {
		this.isLockActive = isLockActive;
	}

	/**
	 * Get lock texture
	 * */
	public TextureRegion getTextureLocked() {
		return textureLocked;
	}

	/**
	 * Set lock texture
	 * 
	 * @param textureLocked
	 *            the lock texture to draw
	 * @param isLockActive
	 *            to enable lock or not
	 * */
	public void setTextureLocked(TextureRegion textureLocked,
			boolean isLockActive) {
		this.textureLocked = textureLocked;
		this.isLockActive = isLockActive;
	}

	/**
	 * Get if text active
	 * */
	public boolean isTextActive() {
		return isTextActive;
	}

	/**
	 * Set the text active to be drawn
	 */
	public void setTextActive(boolean isTextActive) {
		this.isTextActive = isTextActive;
	}

	/**
	 * Get text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Set text (first initiation), later to change text use setTextChange
	 * 
	 * @param text
	 *            the text to be written
	 * @param isTextActive
	 *            to write/draw the text or not
	 * @see setTextChange
	 */
	public void setText(String text, boolean isTextActive) {
		this.text = text;
		this.isTextActive = isTextActive;
	}

	/**
	 * Set the new text
	 */
	public void setTextChange(String newText) {
		this.text = newText;
	}

	/**
	 * Set text position of text (it adds to original button positions' x and y)
	 */
	public void setTextPosXY(float x, float y) {
		textPosX = x;
		textPosY = y;

		if (DIPActive) {
			textPosX = x * AppSettings.getWorldPositionXRatio();
			textPosY = y * AppSettings.getWorldPositionYRatio();
		}
	}

	/**
	 * Get the font
	 */
	public BitmapFont getBitMapFont() {
		return bitMapFont;
	}

	/**
	 * Set the font
	 */
	public void setBitMapFont(BitmapFont bitMapFont) {
		this.bitMapFont = bitMapFont;

		if (DIPActive) {
			bitMapFont.setScale(AppSettings.getWorldSizeRatio());
		}
	}

	/**
	 * Is external texture active or not
	 */
	public boolean isExternalTextureActive() {
		return isExternalTextureActive;
	}

	/**
	 * Set external texture active to be drawn
	 */
	public void setExternalTextureActive(boolean isExternalTextureActive) {
		this.isExternalTextureActive = isExternalTextureActive;
	}

	/**
	 * Ger external texture
	 */
	public TextureRegion getTextureExternal() {
		return textureExternal;
	}

	/**
	 * Set external texture, it is all optional. This is for extra texture
	 * region to be drawn over everything
	 * <p>
	 * EXAMPLE<br>
	 * A menu button and there is a mini coin texture over the button in the
	 * right side
	 */
	public void setTextureExternal(TextureRegion textureExternal,
			boolean isExternalTextureActive) {
		this.textureExternal = textureExternal;
		this.isExternalTextureActive = isExternalTextureActive;
	}

	/**
	 * Set external texture position
	 */
	public void setTextureExternalPosXY(float x, float y) {
		externalTexturePosX = x;
		externalTexturePosY = y;

		if (DIPActive) {
			externalTexturePosX = x * AppSettings.getWorldPositionXRatio();
			externalTexturePosY = y * AppSettings.getWorldPositionYRatio();
		}
	}

	/**
	 * Set external texture size
	 */
	public void setTextureExternalSize(float width, float height) {
		externalTextureSizeW = width;
		externalTextureSizeH = height;

		if (DIPActive) {
			externalTextureSizeW *= AppSettings.getWorldSizeRatio();
			externalTextureSizeH *= AppSettings.getWorldSizeRatio();
		}
	}

	public boolean isDIPActive() {
		return DIPActive;
	}

	public void setDIPActive(boolean dIPActive) {
		DIPActive = dIPActive;
	}
}
