/**
 * File name:	MathAttackMainMenuButtons.java
 * Version:		1.0
 * Date:		07/03/2015 20:33:47
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
package com.sawan.mathattack.game_screens.main.helpers;

import java.util.Random;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.sawan.mathattack.asset.UIAssets;
import com.sawan.mathattack.buttons.MathAttackButton;
import com.sawan.mathattack.effects.EffectCreator;
import com.sawan.mathattack.game_screens.levels.MALevelScreen;
import com.sawan.mathattack.game_screens.main.MAMainMenuScreen;
import com.sawan.mathattack.scene2d.ui.TableModel;
import com.sawan.mathattack.settings.AppSettings;

// TODO: Auto-generated Javadoc
/**
 * The Class MathAttackMainMenuButtons.
 *
 * @author Sawan
 */
public class MAMainMenuButtons {
	
	/** The Constant Y_POSITION. */
	protected final static int Y_POSITION = -120;
	
	/** The Constant BUTTON_W. */
	protected final static float BUTTON_W = 270f;
	
	/** The Constant BUTTON_H. */
	protected final static float BUTTON_H = 90f;
	
	/**
	 * Sets the up main menu buttons.
	 *
	 * @param menuScreen the new up main menu buttons
	 */
	public void setUpMainMenuButtons(final MAMainMenuScreen menuScreen) {
		
		// Menu table for the following buttons (play. settings, credits)
		menuScreen.menu_table = new TableModel(null, AppSettings.SCREEN_W, AppSettings.SCREEN_H);
		menuScreen.menu_table.setPosition(0, Y_POSITION * AppSettings.getWorldPositionYRatio());
		
		// Button settings
		Random rnd = new Random();
		
		//--------- Button Play ---------//
		menuScreen.button_play = new MathAttackButton(BUTTON_W, BUTTON_H, rnd, true);
		menuScreen.button_play.setTextureRegion(UIAssets.image_main_button_play, true);
		menuScreen.button_play.setOrigin(menuScreen.button_play.getWidth() / 2.0f, menuScreen.button_play.getHeight() / 2.0f);
		menuScreen.button_play.addListener(new ActorGestureListener() {
			
			@Override
			public void touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				super.touchDown(event, x, y, pointer, button);
				//
				menuScreen.button_play.clearActions();
				EffectCreator.create_SC_SHK_BTN(menuScreen.button_play,
                        1.3f, 1.3f, 5f, 0, 0.05f, null, false);
				menuScreen.getGame().setScreen(new MALevelScreen(menuScreen.getGame(), "Level Selection"));
			}
		});
		
		//--------- Button Settings ---------//
		menuScreen.button_settings = new MathAttackButton(BUTTON_W, BUTTON_H, rnd, true);
		menuScreen.button_settings.setTextureRegion(UIAssets.image_main_button_settings, true);
		menuScreen.button_settings.setOrigin(menuScreen.button_settings.getWidth() / 2.0f, menuScreen.button_settings.getHeight() / 2.0f);
		menuScreen.button_settings.addListener(new ActorGestureListener() {
			
			@Override
			public void touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				super.touchDown(event, x, y, pointer, button);
				//
				menuScreen.button_settings.clearActions();
				EffectCreator.create_SC_SHK_BTN(menuScreen.button_settings,
                        1.3f, 1.3f, 5f, 0, 0.05f, null, false);
			}
		});
		
		
		//--------- Button Credits ---------//
		menuScreen.button_credits = new MathAttackButton(BUTTON_W, BUTTON_H, rnd, true);
		menuScreen.button_credits.setTextureRegion(UIAssets.image_main_button_credits, true);
		menuScreen.button_credits.setOrigin(menuScreen.button_credits.getWidth() / 2.0f, menuScreen.button_credits.getHeight() / 2.0f);
		menuScreen.button_credits.addListener(new ActorGestureListener() {
			
			@Override
			public void touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				super.touchDown(event, x, y, pointer, button);
				//
				menuScreen.button_credits.clearActions();
				EffectCreator.create_SC_SHK_BTN(menuScreen.button_credits,
                        1.3f, 1.3f, 5f, 0, 0.05f, null, false);
			}
		});
		
		
		// Scale the buttons to 0, so they appear after the splash screen
		menuScreen.button_play.setScale(0f);
		menuScreen.button_settings.setScale(0f);
		menuScreen.button_credits.setScale(0f);
		
		// Add to the table
		menuScreen.menu_table.add(menuScreen.button_play).pad(10);
		menuScreen.menu_table.row();
		
		menuScreen.menu_table.add(menuScreen.button_settings).pad(10);
		menuScreen.menu_table.row();
		
		menuScreen.menu_table.add(menuScreen.button_credits).pad(10);
		
		menuScreen.getStage().addActor(menuScreen.menu_table);
	}
	
	/**
	 * Send in main menu buttons.
	 *
	 * @param menu_screen the menu_screen
	 */
	public void sendInMainMenuButtons(
			final MAMainMenuScreen menu_screen) {
		EffectCreator.create_SC_BTO(menu_screen.button_play, 1.3f, 1.3f,
				0.4f, null, false);

		EffectCreator.create_SC_BTO(menu_screen.button_settings, 1.3f, 1.3f,
				0.6f, null, false);

		EffectCreator.create_SC_BTO(menu_screen.button_credits, 1.3f,
				1.3f, 0.8f, null, false);
		//
		menu_screen.button_play.setTouchable(Touchable.enabled);
		menu_screen.button_settings.setTouchable(Touchable.enabled);
		menu_screen.button_credits.setTouchable(Touchable.enabled);
	}

	/**
	 * Send away main menu buttons.
	 *
	 * @param menu_screen the menu_screen
	 */
	public void sendAwayMainMenuButtons(
			final MAMainMenuScreen menu_screen) {
		EffectCreator.create_SC(menu_screen.button_play, 0f, 0f, 0.4f,
				null, false);
		EffectCreator.create_SC(menu_screen.button_settings, 0f, 0f, 0.6f,
				null, false);

		EffectCreator.create_SC(menu_screen.button_credits, 0f, 0f, 0.8f,
				null, false);
		//
		menu_screen.button_play.setTouchable(Touchable.disabled);
		menu_screen.button_settings.setTouchable(Touchable.disabled);
		menu_screen.button_credits.setTouchable(Touchable.disabled);
	}
	
}
