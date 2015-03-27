/**
 * File name:	GameButton.java
 * Version:		1.0
 * Date:		26/3/2015 11:08:47
 * Author:		Itop1
 * Copyright:	Copyright 200X Itop1
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
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.sawan.mathattack.asset.UIAssets;
import com.sawan.mathattack.scene2d.ui.AbstractButton;
import com.sawan.mathattack.settings.AppSettings;

/**
 * @author Itop1
 *
 */
public class GameButton extends AbstractButton {
	
	// Font(for writting levels)
	/** The font. */
	private BitmapFont font;
	
	/** The level_number. */
	private int answer;
	
	/**
	 * Instantiates a new button level.
	 *
	 * @param up the up
	 * @param down the down
	 */
	public GameButton(Drawable up, Drawable down) {
		super(UIAssets.cartwheel_font, up, down);
	}
	
	/* (non-Javadoc)
	 * @see com.sawan.mathattack.scene2d.ui.AbstractButton#draw(com.badlogic.gdx.graphics.g2d.SpriteBatch, float)
	 */
	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		drawAnswer(batch);
		drawText(batch);
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
	
	private void drawAnswer(SpriteBatch batch) {
		// there i single numbers ( < 10) 
		// there is double numbers (9 >)
		float singePositionArranger = 2.5f;
		float doublePositionArranger = 2.8f;
		
		if (answer < 10) {
			bitMapFont.draw(batch, "" + answer, ((getX() + 3 * AppSettings.getWorldSizeRatio())) + (getWidth() / singePositionArranger) - 15 * AppSettings.getWorldSizeRatio(),
							getY() + getHeight() / 1.3f);
		} else {
			bitMapFont.draw(batch, "" + answer,  ((getX() + 3 * AppSettings.getWorldSizeRatio())) + (getWidth() / doublePositionArranger) - 15 * AppSettings.getWorldSizeRatio(), 
							(getY() ) + getHeight() / 1.3f);
				}
		
	}
	
	public void setAnswer(int level_number, BitmapFont font) {
		this.answer = level_number;
		this.font = font;
	}
	
	public int getAnswer() {
		return answer;
	}
}
