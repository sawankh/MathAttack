/**
 * File name:	MathAttackMainMenuScreen.java
 * Version:		1.0
 * Date:		01/03/2015 19:28:24
 * Author:		Sawan
 * Copyright:	Copyright 200X Sawan
 *
 *				This file is part of Foobar.
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
package com.sawan.mathattack.game_screens.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.sawan.mathattack.asset.Backgrounds;
import com.sawan.mathattack.asset.UIAssets;
import com.sawan.mathattack.buttons.MathAttackButton;
import com.sawan.mathattack.effects.EffectCreator;
import com.sawan.mathattack.game.AbstractGame;
import com.sawan.mathattack.game_screens.main.helpers.MAMainMenuButtons;
import com.sawan.mathattack.game_screens.main.helpers.MAMainMenuEnviroment;
import com.sawan.mathattack.interfaces.IScreen;
import com.sawan.mathattack.models.EmptyActorLight;
import com.sawan.mathattack.scene2d.ui.TableModel;
import com.sawan.mathattack.screen.AbstractScreen;
import com.sawan.mathattack.settings.AppSettings;

// TODO: Auto-generated Javadoc
/**
 * The Class MathAttackMainMenuScreen.
 *
 * @author Sawan
 */
public class MAMainMenuScreen extends AbstractScreen implements IScreen {

	
	/** The splash_loading. */
	public EmptyActorLight splash_loading;
	
	/** The Constant SPLASH_W. */
	private final static float SPLASH_W = 100f;
	
	/** The Constant SPLASH_H. */
	private final static float SPLASH_H = 100f;
	
	/** The Constant SPLASH_ROTATION_VALUE. */
	private final static float SPLASH_ROTATION_VALUE = -5f;
	
	/** The Constant SCALE_TITLE_RATIO. */
	private final static float SCALE_TITLE_RATIO = 1.1f;
	
	/** The Constant SHAKE_TITLE_ANGLE. */
	private final static float SHAKE_TITLE_ANGLE = 8f;
	
	/** The Constant SHAKE_DURATION. */
	private final static float SHAKE_DURATION = 0.11f;
	
	/** The menu_table. */
	public TableModel menu_table;
	
	/** The title. */
	public EmptyActorLight title;
	
	/** The background. */
	public EmptyActorLight background;
	
	/** The button_play. */
	public MathAttackButton button_play;
	
	/** The button_settings. */
	public MathAttackButton button_settings;
	
	/** The button_credits. */
	public MathAttackButton button_credits;
	
	/** The is splash completed. */
	private boolean isSplashCompleted;
	
	// Main menu elements
	/** The enviroment. */
	public MAMainMenuEnviroment enviroment;
	
	/** The buttons. */
	public MAMainMenuButtons buttons;
	
	// Timers
	/** The Constant SPLASH_TIMER. */
	private final static float SPLASH_TIMER = 6.0f;
	
	/** The Constant TITLE_LOOP_ANIMATION. */
	private final static float TITLE_LOOP_ANIMATION = 3.0f;
	
	/** The title_animation_timer. */
	private float title_animation_timer;
	
	/**
	 * Instantiates a new math attack main menu screen.
	 *
	 * @param game the game
	 * @param screenName the screen name
	 */
	public MAMainMenuScreen(AbstractGame game, String screenName) {
		super(game, screenName);
		
		setUpScreenElements();
		setUpMenu();
		
	}
	
	/* (non-Javadoc)
	 * @see com.sawan.mathattack.interfaces.IScreen#setUpScreenElements()
	 */
	@Override
	public void setUpScreenElements() {
		// Reset System
		setSecondsTime(0);
		isSplashCompleted = false;
		
		setBackButtonActive(true);
		
		// Set Background image
		setBackgroundTexture(Backgrounds.image_main_background);
		
		// Set title animation timer
		title_animation_timer = SPLASH_TIMER + TITLE_LOOP_ANIMATION;
		
		// Construct main menu elements
		buttons = new MAMainMenuButtons();
		enviroment = new MAMainMenuEnviroment();
		
		// Prepare splash
		splash_loading = new EmptyActorLight(SPLASH_W, SPLASH_H, true);
		splash_loading.setTextureRegion(UIAssets.image_main_loader, true);
		splash_loading.setOrigin(splash_loading.getWidth() / 2.0f, splash_loading.getHeight() / 2.0f);
		splash_loading.setPosition(AppSettings.SCREEN_W - splash_loading.getWidth(), AppSettings.SCREEN_H - splash_loading.getHeight());
		
		// Add splash to stage
		getStage().addActor(splash_loading);
		
	}
	
	/* (non-Javadoc)
	 * @see com.sawan.mathattack.interfaces.IScreen#setUpMenu()
	 */
	@Override
	public void setUpMenu() {
		
		// ---------- Main menu (Order is important) --------
		//
		// They are invisible or scaled to 0f until splash is completed
		// We will send the elements after splash is completed
		// Check the render() method
		enviroment.setUpGameName(this);
		buttons.setUpMainMenuButtons(this);
	}
	
	/* (non-Javadoc)
	 * @see com.sawan.mathattack.screen.AbstractScreen#render(float)
	 */
	@Override
	public void render(float delta) {
		super.render(delta);
		
		// -------------------- Splash --------------------------------
		//
		// When splash is completed, send main menu elements (Name, Buttons,
		// etc...), I faked the splash/loading here. Normally use assetmanager
		// and when its really completed the asset loading, send game elements
		if (!isSplashCompleted) {
			if (getSecondsTime() > SPLASH_TIMER) {
				buttons.sendInMainMenuButtons(this);
				
				enviroment.sendInTitle(this);
				
				isSplashCompleted = true;
			}
			
			if (getSecondsTime() > SPLASH_TIMER - 1.0f) {
				splash_loading.addAction(Actions.rotateBy(SPLASH_ROTATION_VALUE));
				EffectCreator.create_FO(splash_loading, 0.7f, 0, null, false);
			} else {
				splash_loading.addAction(Actions.rotateBy(SPLASH_ROTATION_VALUE));
			}
		}
		
		// ----------- Title animation ----------------------
		//
		// Every some specified seconds animate the game name
		// Shake effect
		if (getSecondsTime() > title_animation_timer) {
			if (title != null) {
				// Create Scale => Shake => BackToNormal effect
				EffectCreator.create_SC_SHK_BTN(title, SCALE_TITLE_RATIO, SCALE_TITLE_RATIO, SHAKE_TITLE_ANGLE, 0, SHAKE_DURATION, null, false);
				
				title_animation_timer = getSecondsTime() + TITLE_LOOP_ANIMATION;
			}
		}
	}
	
	@Override
	public void keyBackPressed() {
		super.keyBackPressed();
		Gdx.app.exit();
	}
	
}
