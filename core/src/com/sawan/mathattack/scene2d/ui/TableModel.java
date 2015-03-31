/**
 * File name:	TableModel.java
 * Version:		1.0
 * Date:		@date 13:15:00
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

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.sawan.mathattack.settings.AppSettings;



// TODO: Auto-generated Javadoc
/**
 * The Class TableModel.
 */
public class TableModel extends Table {
	
	/** The texture background. */
	public TextureRegion textureBackground;
	
	/** The is background texture active. */
	public boolean isBackgroundTextureActive;

	/**
	 * Instantiates a new table model.
	 *
	 * @param textureBackground the texture background
	 * @param width the width
	 * @param height the height
	 * @param DIPActive the DIP active
	 */
	public TableModel(TextureRegion textureBackground, float width,
			float height, boolean DIPActive) {
		isBackgroundTextureActive = true;
		this.textureBackground = textureBackground;
		//
		if (DIPActive) {
			setSize(width * AppSettings.getWorldSizeRatio(), height
					* AppSettings.getWorldPositionYRatio());
		} else {
			setHeight(height);
			setWidth(width);
		}
	}

	/**
	 * Instantiates a new table model.
	 *
	 * @param textureBackground the texture background
	 * @param x the x
	 * @param y the y
	 * @param width the width
	 * @param height the height
	 */
	public TableModel(TextureRegion textureBackground, float x, float y,
			float width, float height) {
		isBackgroundTextureActive = true;
		this.textureBackground = textureBackground;
		setBounds(x, y, width, height);
		setPosition(x, y);
		setHeight(height);
		setWidth(width);
	}

	/**
	 * Instantiates a new table model.
	 *
	 * @param textureBackground the texture background
	 * @param width the width
	 * @param height the height
	 */
	public TableModel(TextureRegion textureBackground, float width, float height) {
		isBackgroundTextureActive = true;
		this.textureBackground = textureBackground;
		setHeight(height);
		setWidth(width);
	}

	/**
	 * Instantiates a new table model.
	 *
	 * @param textureBackground the texture background
	 */
	public TableModel(TextureRegion textureBackground) {
		isBackgroundTextureActive = true;
		this.textureBackground = textureBackground;
	}

	/**
	 * Instantiates a new table model.
	 *
	 * @param skin the skin
	 */
	public TableModel(Skin skin) {
		super(skin);
	}

	/**
	 * Instantiates a new table model.
	 *
	 * @param width the width
	 * @param height the height
	 */
	public TableModel(float width, float height) {
		setHeight(height);
		setWidth(width);
	}

	/**
	 * Instantiates a new table model.
	 */
	public TableModel() {
		super();
	}

	/**
	 * Gets the texture background.
	 *
	 * @return the texture background
	 */
	public TextureRegion getTextureBackground() {
		return textureBackground;
	}

	/**
	 * Sets the texture background.
	 *
	 * @param textureBackground the texture background
	 * @param isBackgroundTextureActive the is background texture active
	 */
	public void setTextureBackground(TextureRegion textureBackground,
			boolean isBackgroundTextureActive) {
		this.textureBackground = textureBackground;
		this.isBackgroundTextureActive = isBackgroundTextureActive;
	}

	/**
	 * Sets the background texture active.
	 *
	 * @param isBackgroundTextureActive the new background texture active
	 */
	public void setBackgroundTextureActive(boolean isBackgroundTextureActive) {
		this.isBackgroundTextureActive = isBackgroundTextureActive;
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.scenes.scene2d.ui.Table#draw(com.badlogic.gdx.graphics.g2d.SpriteBatch, float)
	 */
	@SuppressWarnings("rawtypes")
/**	public com.badlogic.gdx.scenes.scene2d.ui.Cell<Actor> add(Actor actor, float width, float height, boolean DIPActive) {
		if (DIPActive) {
			return super.add(actor).size(
					width * AppSettings.getWorldSizeRatio(),
					height * AppSettings.getWorldSizeRatio());
		} else {
			return super.add(actor);
		}
	}
**/
	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		// Then draw child actors over bg
		super.draw(batch, parentAlpha);

		// First draw bg
		if (textureBackground != null && isBackgroundTextureActive) {
			batch.draw(textureBackground, getX(), getY(), getOriginX(),
					getOriginY(), getWidth(), getHeight(), getScaleX(),
					getScaleY(), getRotation());
		}
	}
}
