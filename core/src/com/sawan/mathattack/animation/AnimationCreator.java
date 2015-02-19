/**
 * File name:	AnimationCreator.java
 * Version:		1.0
 * Date:		@date 13:07:58
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

package com.sawan.mathattack.animation;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimationCreator {

	/**
	 * Get animation from texture atlas (Based on TexturePacker). Each frames'
	 * base name should be same. This is for multi textures, (Each frame stored
	 * individually in texture atlas)
	 * <p>
	 * EXAMPLE: <br>
	 * baseName = "walk"<br>
	 * frame1 = "walk00" (Actual name in texture atlas)<br>
	 * frame2 = "walk01" (Actual name in texture atlas)<br>
	 * frame3 = "walk02" (Actual name in texture atlas)<br>
	 * ...
	 * 
	 * @param textureAtlas
	 *            atlas which contains texture frames
	 * @param animationBaseName
	 *            base name of the frames in atlas
	 * @param numberOfFrames
	 *            number of frames of the animation
	 * @param frameDuration
	 *            each frame duration on play
	 * @return animation created
	 * 
	 * */
	public static Animation getAnimationFromMultiTextures(
			TextureAtlas textureAtlas, String animationBaseName,
			int numberOfFrames, float frameDuration, boolean flipX,
			boolean flipY) {
		// Key frames list
		TextureRegion[] keyFrames = new TextureRegion[numberOfFrames];

		// Set key frames (each textures region from atlas)
		for (int i = 0; i < numberOfFrames; i++) {
			TextureRegion frame = textureAtlas.findRegions(animationBaseName)
					.get(i);
			frame.flip(flipX, flipY);
			keyFrames[i] = frame;
		}

		//
		Animation animation = new Animation(frameDuration, keyFrames);
		return animation;
	}

	/**
	 * Get animation from texture atlas (Based on TexturePacker). There is only
	 * single texture which contains all frames (It is like a single png which
	 * has all the frames). Each frames' width should be same for proper results
	 * <p>
	 * 
	 * @param textureAtlas
	 *            atlas which contains the single animation texture
	 * @param animationName
	 *            name of the animation in atlas
	 * @param numberOfFrames
	 *            number of frames of the animation
	 * @param frameDuration
	 *            each frame duration on play
	 * @return animation created
	 * 
	 * */
	public static Animation getAnimationFromSingleTexture(
			TextureAtlas textureAtlas, String animationName,
			int numberOfFrames, float frameDuration) {
		// Get animation texture (single texture)
		TextureRegion textureRegion = textureAtlas.findRegion(animationName);

		// Key frames list
		TextureRegion[] keyFrames = new TextureRegion[numberOfFrames];

		// Set key frames (each comes from the single texture)
		for (int i = 0; i < numberOfFrames; i++) {
			keyFrames[i] = new TextureRegion(textureRegion,
					(textureRegion.getRegionWidth() / numberOfFrames) * i, 0,
					textureRegion.getRegionWidth() / numberOfFrames,
					textureRegion.getRegionHeight());
		}

		//
		Animation animation = new Animation(frameDuration, keyFrames);
		return animation;
	}

	/**
	 * Get animation from texture atlas (Based on TexturePacker). There is only
	 * single texture which contains all frames (It is like a single png which
	 * has all the frames). Each frames' width should be same for proper results
	 * <p>
	 * 
	 * @param textureAtlas
	 *            atlas which contains the single animation texture
	 * @param animationName
	 *            name of the animation in atlas
	 * @param numberOfFrames
	 *            number of frames of the animation
	 * @param numberOfMaximumFramesInTheSheet
	 *            maximum number of frame in a row in the sheet
	 * @param numberOfRows
	 *            number of rows that the sheet contains
	 * @param indexOfAnimationRow
	 *            the row index (starts from 0) that desired animation exists
	 * @param frameDuration
	 *            each frame duration on play
	 * @return animation created
	 * 
	 * */
	public static Animation getAnimationFromSingleTextureMultiRows(
			TextureAtlas textureAtlas, String animationName,
			int numberOfFrames, int numberOfMaximumFramesInTheSheet,
			int numberOfRows, int indexOfAnimationRow, float frameDuration) {
		// Get animation texture (single texture)
		TextureRegion textureRegion = textureAtlas.findRegion(animationName);

		// Key frames list
		TextureRegion[] keyFrames = new TextureRegion[numberOfFrames];

		// Set key frames (each comes from the single texture)
		for (int i = 0; i < numberOfFrames; i++) {
			keyFrames[i] = new TextureRegion(
					textureRegion,
					(textureRegion.getRegionWidth() / numberOfMaximumFramesInTheSheet)
							* i, textureRegion.getRegionHeight() / numberOfRows
							* indexOfAnimationRow,
					textureRegion.getRegionWidth()
							/ numberOfMaximumFramesInTheSheet,
					textureRegion.getRegionHeight() / numberOfRows);
		}

		//
		Animation animation = new Animation(frameDuration, keyFrames);
		return animation;
	}
}
