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

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractButton.
 */
public abstract class AbstractButton extends Button {
	// Locked (Not mandatory)
	/** The is lock active. */
	protected boolean isLockActive = false;
	
	/** The texture locked. */
	protected TextureRegion textureLocked;

	// Text (Not mandatory)
	/** The is text active. */
	protected boolean isTextActive = false;
	
	/** The text pos x. */
	protected float textPosX = 0.0f;
	
	/** The text pos y. */
	protected float textPosY = 0.0f;
	
	/** The text. */
	protected String text = "";
	
	/** The bit map font. */
	protected BitmapFont bitMapFont;

	// External texture (Not mandatory)
	/** The is external texture active. */
	protected boolean isExternalTextureActive = false;
	
	/** The external texture pos x. */
	protected float externalTexturePosX = 0.0f;
	
	/** The external texture pos y. */
	protected float externalTexturePosY = 0.0f;
	
	/** The external texture size w. */
	protected float externalTextureSizeW = 50.0f;
	
	/** The external texture size h. */
	protected float externalTextureSizeH = 50.0f;
	
	/** The texture external. */
	protected TextureRegion textureExternal;

	//
	/** The DIP active. */
	private boolean DIPActive = false;

	/**
	 * Instantiates a new abstract button.
	 *
	 * @param bitMapFont the bit map font
	 * @param up the up
	 * @param down the down
	 */
	public AbstractButton(BitmapFont bitMapFont, Drawable up, Drawable down) {
		super(up, down);
		this.bitMapFont = bitMapFont;
	}

	/**
	 * Instantiates a new abstract button.
	 *
	 * @param bitMapFont the bit map font
	 * @param up the up
	 * @param down the down
	 * @param width the width
	 * @param height the height
	 * @param DIPActive the DIP active
	 */
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

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.scenes.scene2d.ui.Table#hit(float, float, boolean)
	 */
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
	 * Get if the button lock active.
	 *
	 * @return true, if is lock active
	 */
	public boolean isLockActive() {
		return isLockActive;
	}

	/**
	 * Set the lock, it overrides the hit method, so it wont detect hits, also
	 * if it is active, lock texture will be drawn.
	 *
	 * @param isLockActive the new lock active
	 * @see hit()
	 */
	public void setLockActive(boolean isLockActive) {
		this.isLockActive = isLockActive;
	}

	/**
	 * Get lock texture.
	 *
	 * @return the texture locked
	 */
	public TextureRegion getTextureLocked() {
		return textureLocked;
	}

	/**
	 * Set lock texture.
	 *
	 * @param textureLocked            the lock texture to draw
	 * @param isLockActive            to enable lock or not
	 */
	public void setTextureLocked(TextureRegion textureLocked,
			boolean isLockActive) {
		this.textureLocked = textureLocked;
		this.isLockActive = isLockActive;
	}

	/**
	 * Get if text active.
	 *
	 * @return true, if is text active
	 */
	public boolean isTextActive() {
		return isTextActive;
	}

	/**
	 * Set the text active to be drawn.
	 *
	 * @param isTextActive the new text active
	 */
	public void setTextActive(boolean isTextActive) {
		this.isTextActive = isTextActive;
	}

	/**
	 * Get text.
	 *
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Set text (first initiation), later to change text use setTextChange.
	 *
	 * @param text            the text to be written
	 * @param isTextActive            to write/draw the text or not
	 * @see setTextChange
	 */
	public void setText(String text, boolean isTextActive) {
		this.text = text;
		this.isTextActive = isTextActive;
	}

	/**
	 * Set the new text.
	 *
	 * @param newText the new text change
	 */
	public void setTextChange(String newText) {
		this.text = newText;
	}

	/**
	 * Set text position of text (it adds to original button positions' x and y).
	 *
	 * @param x the x
	 * @param y the y
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
	 * Get the font.
	 *
	 * @return the bit map font
	 */
	public BitmapFont getBitMapFont() {
		return bitMapFont;
	}

	/**
	 * Set the font.
	 *
	 * @param bitMapFont the new bit map font
	 */
	public void setBitMapFont(BitmapFont bitMapFont) {
		this.bitMapFont = bitMapFont;

		if (DIPActive) {
			bitMapFont.setScale(AppSettings.getWorldSizeRatio());
		}
	}

	/**
	 * Is external texture active or not.
	 *
	 * @return true, if is external texture active
	 */
	public boolean isExternalTextureActive() {
		return isExternalTextureActive;
	}

	/**
	 * Set external texture active to be drawn.
	 *
	 * @param isExternalTextureActive the new external texture active
	 */
	public void setExternalTextureActive(boolean isExternalTextureActive) {
		this.isExternalTextureActive = isExternalTextureActive;
	}

	/**
	 * Ger external texture.
	 *
	 * @return the texture external
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
	 *
	 * @param textureExternal the texture external
	 * @param isExternalTextureActive the is external texture active
	 */
	public void setTextureExternal(TextureRegion textureExternal,
			boolean isExternalTextureActive) {
		this.textureExternal = textureExternal;
		this.isExternalTextureActive = isExternalTextureActive;
	}

	/**
	 * Set external texture position.
	 *
	 * @param x the x
	 * @param y the y
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
	 * Set external texture size.
	 *
	 * @param width the width
	 * @param height the height
	 */
	public void setTextureExternalSize(float width, float height) {
		externalTextureSizeW = width;
		externalTextureSizeH = height;

		if (DIPActive) {
			externalTextureSizeW *= AppSettings.getWorldSizeRatio();
			externalTextureSizeH *= AppSettings.getWorldSizeRatio();
		}
	}

	/**
	 * Checks if is DIP active.
	 *
	 * @return true, if is DIP active
	 */
	public boolean isDIPActive() {
		return DIPActive;
	}

	/**
	 * Sets the DIP active.
	 *
	 * @param dIPActive the new DIP active
	 */
	public void setDIPActive(boolean dIPActive) {
		DIPActive = dIPActive;
	}
}
