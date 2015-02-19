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

public class AbstractWorldScene2d extends Group {
	//
	protected final String logTag = "MtxWorldLog";
	public static boolean logActive = true;

	// World background image
	private Image imageBackground;

	// World second counter (1 second tick)
	private long startTime = System.nanoTime();
	private long secondsTime = 0L;

	public AbstractWorldScene2d(float posX, float posY, float worldWidth,
			float worldHeight) {
		super();
		setSize(worldWidth, worldHeight);
		setPosition(posX, posY);
		//
		MtxLogger.log(logActive, true, logTag, "World Set: W: " + worldWidth
				+ " - " + "H: " + worldHeight);
	}

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

	public Image getImageBackground() {
		return imageBackground;
	}

	public void setImageBackground(Image imageBackground) {
		this.imageBackground = imageBackground;
	}

	public long getSecondsTime() {
		return secondsTime;
	}

	public void setSecondsTime(long secondsTime) {
		this.secondsTime = secondsTime;
	}
}
