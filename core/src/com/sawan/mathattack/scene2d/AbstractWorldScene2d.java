/**
 * File name:	AbstractWorldScene2d.java
 * Version:		1.0
 * Date:		@date 13:13:39
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

package com.sawan.mathattack.scene2d;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;
import com.sawan.mathattack.settings.MtxLogger;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractWorldScene2d.
 */
public class AbstractWorldScene2d extends Group {
	//
	/** The log tag. */
	protected final String logTag = "MtxWorldLog";
	
	/** The log active. */
	public static boolean logActive = true;

	// World background image
	/** The image background. */
	private Image imageBackground;

	// World second counter (1 second tick)
	/** The start time. */
	private long startTime = System.nanoTime();
	
	/** The seconds time. */
	private long secondsTime = 0L;

	/**
	 * Instantiates a new abstract world scene2d.
	 *
	 * @param posX the pos x
	 * @param posY the pos y
	 * @param worldWidth the world width
	 * @param worldHeight the world height
	 */
	public AbstractWorldScene2d(float posX, float posY, float worldWidth,
			float worldHeight) {
		super();
		setSize(worldWidth, worldHeight);
		setPosition(posX, posY);
		//
		MtxLogger.log(logActive, true, logTag, "World Set: W: " + worldWidth
				+ " - " + "H: " + worldHeight);
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.scenes.scene2d.Group#act(float)
	 */
	@Override
	public void act(float delta) {
		super.act(delta);
		// Update world clock (1 second tick)
		// ############################################################
		if (System.nanoTime() - startTime >= 1000000000) {
			secondsTime++;
			startTime = System.nanoTime();
		}
	}

	/**
	 * Sets the background texture.
	 *
	 * @param textureBackground the texture background
	 * @param scaling the scaling
	 * @param fillParent the fill parent
	 * @param touchable the touchable
	 */
	public void setBackgroundTexture(TextureRegion textureBackground,
			Scaling scaling, boolean fillParent, boolean touchable) {
		Drawable tBg = new TextureRegionDrawable(textureBackground);
		Image imgbg = new Image(tBg, scaling);
		this.imageBackground = imgbg;
		imgbg.setFillParent(fillParent);

		if (!touchable) {
			imgbg.setTouchable(Touchable.disabled);
		}

		addActor(imgbg);
		//
		MtxLogger.log(logActive, true, logTag, "World bacground image set");
	}

	/**
	 * Render the world for MVC style development, otherwise use act & draw of
	 * stage.
	 * */
	public void render() {

	}

	/**
	 * Gets the image background.
	 *
	 * @return the image background
	 */
	public Image getImageBackground() {
		return imageBackground;
	}

	/**
	 * Sets the image background.
	 *
	 * @param imageBackground the new image background
	 */
	public void setImageBackground(Image imageBackground) {
		this.imageBackground = imageBackground;
	}

	/**
	 * Gets the seconds time.
	 *
	 * @return the seconds time
	 */
	public long getSecondsTime() {
		return secondsTime;
	}

	/**
	 * Sets the seconds time.
	 *
	 * @param secondsTime the new seconds time
	 */
	public void setSecondsTime(long secondsTime) {
		this.secondsTime = secondsTime;
	}
}
