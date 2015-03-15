/**
 * File name:	MALevelTable.java
 * Version:		1.0
 * Date:		14/03/2015 21:41:58
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
package com.sawan.mathattack.game_screens.levels.helpers;

import java.util.Random;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.sawan.mathattack.asset.UIAssets;
import com.sawan.mathattack.buttons.ButtonLevel;
import com.sawan.mathattack.game_screens.levels.MALevelScreen;
import com.sawan.mathattack.scene2d.ui.MenuCreator;

/**
 * The Class MALevelTable.
 *
 * @author Sawan
 */
public class MALevelTable {

	/** The Constant PADDING_VALUE. */
	private final static int PADDING_VALUE = 30;
	
	/** The Constant NUM_LEVELS. */
	private final static int NUM_LEVELS = 8;
	
	/** The Constant NUM_MAX_STARS. */
	private final static int NUM_MAX_STARS = 3;
	
	/** The Constant MAX_LEVELS_PER_ROW. */
	private final static int MAX_LEVELS_PER_ROW = 4;
	
	/**
	 * Level table.
	 *
	 * @param levelScreen the level screen
	 */
	@SuppressWarnings("unused")
	private void levelTable(final MALevelScreen levelScreen) {
		levelScreen.level_table = MenuCreator.createTable(true, UIAssets.getSkin());
		levelScreen.level_table.setPosition(-999, 0);
		levelScreen.level_table.addAction(Actions.moveTo(0, 0, 0.7f));
		levelScreen.level_table.top().left().pad(PADDING_VALUE, PADDING_VALUE, PADDING_VALUE, PADDING_VALUE);
		levelScreen.getStage().addActor(levelScreen.level_table);
		
		for (int level_number = 0; level_number < NUM_LEVELS; level_number++) {
			// Create the button
			Drawable drawable_up = new TextureRegionDrawable(UIAssets.button_level);
			Drawable drawable_down = new TextureRegionDrawable(UIAssets.button_level);
			final ButtonLevel button_level = new ButtonLevel(drawable_up, drawable_down);
			
			// Set button level
			button_level.setLevel_number(level_number, UIAssets.cartwheel_font);
			
			// Set stars (get from database or text files here)
			// Random number of stars just for testing 
			Random random =  new Random();
			button_level.setLevelStars(UIAssets.image_level_no_star, UIAssets.image_level_star, NUM_MAX_STARS, random.nextInt(NUM_MAX_STARS) + 1);
			
			// Add listener
			button_level.addListener(new ActorGestureListener() {
				@Override
				public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
					super.touchUp(event, x, y, pointer, button);
				}
			});

			// Limit max number of levels per row to 4
			if (level_number % MAX_LEVELS_PER_ROW == 0) {
				levelScreen.level_table.row();
			}
			
			// Add to table
			levelScreen.level_table.add(button_level).size(50, 50).pad(5, 5, 5, 5).expand();
		}
		
	}
}
