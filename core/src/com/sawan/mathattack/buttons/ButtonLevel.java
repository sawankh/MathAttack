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
 * The Class ButtonLevel.
 *
 * @author Sawan
 */
public class ButtonLevel extends AbstractButton {

	/** The Constant UNDEFINED_LEVEL. */
	private static final int UNDEFINED_LEVEL = -999;
	
	// Level texture and star textures
	/** The texture_star_holder. */
	private TextureRegion texture_star_holder;
	
	/** The texture_star. */
	private TextureRegion texture_star;
	
	/** The number of total stars. */
	private int numberOfTotalStars = 1;
	
	/** The number of earned stars. */
	private  int numberOfEarnedStars = 1;
	
	/** The star size width. */
	private float starSizeWidth; 
	
	/** The star size height. */
	private float starSizeHeight;
	
	// Star position settings
	/** The star_pos_x_start. */
	private float star_pos_x_start;
	
	/** The star_pos_y_start. */
	private float star_pos_y_start;
	
	// Font(for writting levels)
	/** The font. */
	private BitmapFont font;
	
	/** The level_number. */
	private int level_number;
	
	/**
	 * Instantiates a new button level.
	 *
	 * @param up the up
	 * @param down the down
	 */
	public ButtonLevel(Drawable up, Drawable down) {
		super(UIAssets.cartwheel_font, up, down);
		star_pos_x_start = 0;
		star_pos_y_start = 0;
		level_number = UNDEFINED_LEVEL;
	}
	
	/* (non-Javadoc)
	 * @see com.sawan.mathattack.scene2d.ui.AbstractButton#draw(com.badlogic.gdx.graphics.g2d.SpriteBatch, float)
	 */
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
	
	/**
	 * Draw stars.
	 *
	 * @param batch the batch
	 */
	private void drawStars(SpriteBatch batch) {
		if (texture_star_holder != null && texture_star != null) {
			// Updated start positions
			float activePosXStart = (getX() + getWidth() / 2) - ((starSizeWidth * numberOfTotalStars) / 2);
			float activePoxYStart = (getY() + starSizeHeight / 1.3f);	
						
			// Stars align together next by next (increase for each star)
			// S as Star
			// SSS (together aligned due to their widths)
			float currentPosX = getX();
						
			for(int i = 0; i < numberOfTotalStars; i++) {
				// Update new star holder positions (for multiple stars)
				currentPosX = activePosXStart + (starSizeWidth * i);
				batch.draw(texture_star_holder, currentPosX + star_pos_x_start, activePoxYStart + star_pos_y_start,starSizeWidth, starSizeHeight);	
			}
						
			for(int j = 0; j < numberOfEarnedStars; j++) {
				// Update new star position (for multiple stars)
				currentPosX = activePosXStart + (starSizeWidth * j);
				batch.draw(texture_star, currentPosX + star_pos_x_start, activePoxYStart + star_pos_y_start, starSizeWidth, starSizeHeight);		
			}
		}
	}
	
	/**
	 * Draw text.
	 *
	 * @param batch the batch
	 */
	private void drawText(SpriteBatch batch) {
		if (isTextActive && font != null) {
			font.draw(batch, text, getX() +  textPosX, getY() + textPosY);
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
	 * Draw level number.
	 *
	 * @param batch the batch
	 */
	private void drawLevelNumber(SpriteBatch batch) {
		// there i single numbers ( < 10) 
		// there is double numbers (9 >)
		float singePositionArranger = 2.5f;
		float doublePositionArranger = 2.8f;
				
		if (level_number < 10) {
			bitMapFont.draw(batch, "" + level_number, getX() + getWidth() / singePositionArranger,
							getY() + getHeight() / 1.4f);
		} else {
			bitMapFont.draw(batch, "" + level_number, getX() + getWidth() / doublePositionArranger,
							getY() + getHeight() / 1.4f);
				}
		
	}
	
	
	/**
	 * Set level stars (It can be any other object) for level achievements
	 * <p>
	 * EXAMPLE<br>
	 * There are 5 stars maximum can be achieved, and user earned 3 stars. It auto calculates the position and sizes of stars due to
	 * button sizes. However further adjustment can be done (optinal) with "setLevelStarSizeRatio", "setLevelStarPosXStart" and "setLevelStarPosYStart".
	 * !!starHolderTexture and starTexture should be in same sizes!!
	 * 
	 * @param starHolderTexture the holder texture for star or other achievement object.
	 * @param starTexture the texture for star or other achievement object.
	 * @param numberOfTotalStars number of total stars
	 * @param numberOfEarnedStars number of earned/achieved stars
	 * */
	public void setLevelStars(TextureRegion starHolderTexture, TextureRegion starTexture, int numberOfTotalStars, int numberOfEarnedStars){
		texture_star_holder = starHolderTexture;
		texture_star = starTexture;
		this.numberOfTotalStars = numberOfTotalStars;
		this.numberOfEarnedStars = numberOfEarnedStars;
	}

	/**
	 * Gets the star_pos_x_start.
	 *
	 * @return the star_pos_x_start
	 */
	public float getStar_pos_x_start() {
		return star_pos_x_start;
	}

	/**
	 * Sets the star_pos_x_start.
	 *
	 * @param star_pos_x_start the star_pos_x_start to set
	 */
	public void setStar_pos_x_start(float star_pos_x_start) {
		this.star_pos_x_start = star_pos_x_start;
	}

	/**
	 * Gets the star_pos_y_start.
	 *
	 * @return the star_pos_y_start
	 */
	public float getStar_pos_y_start() {
		return star_pos_y_start;
	}

	/**
	 * Sets the star_pos_y_start.
	 *
	 * @param star_pos_y_start the star_pos_y_start to set
	 */
	public void setStar_pos_y_start(float star_pos_y_start) {
		this.star_pos_y_start = star_pos_y_start;
	}

	/**
	 * Gets the level_number.
	 *
	 * @return the level_number
	 */
	public int getLevel_number() {
		return level_number;
	}

	/**
	 * Sets the level_number.
	 *
	 * @param level_number the level_number to set
	 * @param font the font
	 */
	public void setLevel_number(int level_number, BitmapFont font) {
		this.level_number = level_number;
		this.font = font;
	}
	
	/**
	 * Sets the level number change.
	 *
	 * @param levelNumber the new level number change
	 */
	public void setLevelNumberChange(int levelNumber){
		this.level_number = levelNumber;
	}

	/**
	 * Gets the texture_star_holder.
	 *
	 * @return the texture_star_holder
	 */
	public TextureRegion getTexture_star_holder() {
		return texture_star_holder;
	}

	/**
	 * Sets the texture_star_holder.
	 *
	 * @param texture_star_holder the texture_star_holder to set
	 */
	public void setTexture_star_holder(TextureRegion texture_star_holder) {
		this.texture_star_holder = texture_star_holder;
	}

	/**
	 * Gets the texture_star.
	 *
	 * @return the texture_star
	 */
	public TextureRegion getTexture_star() {
		return texture_star;
	}

	/**
	 * Sets the texture_star.
	 *
	 * @param texture_star the texture_star to set
	 */
	public void setTexture_star(TextureRegion texture_star) {
		this.texture_star = texture_star;
	}

	/**
	 * Gets the number of total stars.
	 *
	 * @return the numberOfTotalStars
	 */
	public int getNumberOfTotalStars() {
		return numberOfTotalStars;
	}

	/**
	 * Sets the number of total stars.
	 *
	 * @param numberOfTotalStars the numberOfTotalStars to set
	 */
	public void setNumberOfTotalStars(int numberOfTotalStars) {
		this.numberOfTotalStars = numberOfTotalStars;
	}

	/**
	 * Gets the number of earned stars.
	 *
	 * @return the numberOfEarnedStars
	 */
	public int getNumberOfEarnedStars() {
		return numberOfEarnedStars;
	}

	/**
	 * Sets the number of earned stars.
	 *
	 * @param numberOfEarnedStars the numberOfEarnedStars to set
	 */
	public void setNumberOfEarnedStars(int numberOfEarnedStars) {
		if(numberOfEarnedStars > numberOfTotalStars){
			numberOfEarnedStars = numberOfTotalStars;
		} else {
			this.numberOfEarnedStars = numberOfEarnedStars;
		}
	}
	
	
	
}
