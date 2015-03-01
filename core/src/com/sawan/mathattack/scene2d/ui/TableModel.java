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
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.sawan.mathattack.settings.AppSettings;



public class TableModel extends Table {
	public TextureRegion textureBackground;
	public boolean isBackgroundTextureActive;

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

	public TableModel(TextureRegion textureBackground, float x, float y,
			float width, float height) {
		isBackgroundTextureActive = true;
		this.textureBackground = textureBackground;
		setBounds(x, y, width, height);
		setPosition(x, y);
		setHeight(height);
		setWidth(width);
	}

	public TableModel(TextureRegion textureBackground, float width, float height) {
		isBackgroundTextureActive = true;
		this.textureBackground = textureBackground;
		setHeight(height);
		setWidth(width);
	}

	public TableModel(TextureRegion textureBackground) {
		isBackgroundTextureActive = true;
		this.textureBackground = textureBackground;
	}

	public TableModel(Skin skin) {
		super(skin);
	}

	public TableModel(float width, float height) {
		setHeight(height);
		setWidth(width);
	}

	public TableModel() {
		super();
	}

	public TextureRegion getTextureBackground() {
		return textureBackground;
	}

	public void setTextureBackground(TextureRegion textureBackground,
			boolean isBackgroundTextureActive) {
		this.textureBackground = textureBackground;
		this.isBackgroundTextureActive = isBackgroundTextureActive;
	}

	public void setBackgroundTextureActive(boolean isBackgroundTextureActive) {
		this.isBackgroundTextureActive = isBackgroundTextureActive;
	}

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
