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

import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.sawan.mathattack.asset.UIAssets;
import com.sawan.mathattack.game_screens.levels.MALevelScreen;
import com.sawan.mathattack.scene2d.ui.MenuCreator;

/**
 * @author Sawan
 *
 */
public class MALevelTable {

	private final static int PADDING_VALUE = 30;
	
	private final static int NUM_LEVELS = 8;
	
	private void levelTable(final MALevelScreen levelScreen) {
		levelScreen.level_table = MenuCreator.createTable(true, UIAssets.getSkin());
		levelScreen.level_table.setPosition(-999, 0);
		levelScreen.level_table.addAction(Actions.moveTo(0, 0, 0.7f));
		levelScreen.level_table.top().left().pad(PADDING_VALUE, PADDING_VALUE, PADDING_VALUE, PADDING_VALUE);
		levelScreen.getStage().addActor(levelScreen.level_table);
		
		for (int i = 0; i < NUM_LEVELS; i++) {
			Drawable drawable_up;
			Drawable drawable_down;
		}
		
	}
}
