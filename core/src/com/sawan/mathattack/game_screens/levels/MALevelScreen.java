/**
 * File name:	MathAttackLevelSelectionScreen.java
 * Version:		1.0
 * Date:		13/03/2015 17:42:21
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
package com.sawan.mathattack.game_screens.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.sawan.mathattack.asset.Backgrounds;
import com.sawan.mathattack.asset.UIAssets;
import com.sawan.mathattack.buttons.ButtonLevel;
import com.sawan.mathattack.buttons.MathAttackButton;
import com.sawan.mathattack.game.AbstractGame;
import com.sawan.mathattack.game.screen.MAGameScreen;
import com.sawan.mathattack.game_screens.main.MAMainMenuScreen;
import com.sawan.mathattack.interfaces.IScreen;
import com.sawan.mathattack.managers.FileManager;
import com.sawan.mathattack.managers.FileManager.FileType;
import com.sawan.mathattack.scene2d.ui.MenuCreator;
import com.sawan.mathattack.screen.AbstractScreen;
import com.sawan.mathattack.settings.AppSettings;

/**
 * @author Sawan
 *
 */
public class MALevelScreen extends AbstractScreen implements IScreen {
	private Label lblFps;
	private Label lblScreenTime;
	public static int chapter;
	
	
	//
	Table level_table;
	
	public MALevelScreen(AbstractGame game, String screenName, int chapter) {
		super(game, screenName);
		this.chapter = chapter;
        setUpScreenElements();
		setUpLevelsScreen();
	}

	public void setUpScreenElements() {
		// #1.1 TEST
		// Set background texture
		// #########################################################
		setBackgroundTexture(Backgrounds.image_level_background);
			
		// #1.2 TEST
		// Set back button
		// (Override keyBackPressed to do some action see very below)
		// #########################################################
		setBackButtonActive(true);
		
		// #1.3 TEST
		// Screen time / Fps
		// Update by overriding render
		// #########################################################
		lblScreenTime = new Label("", UIAssets.getSkin());
		lblFps = new Label("", UIAssets.getSkin());
		lblScreenTime.setPosition(getStage().getWidth() - 80, getStage().getHeight() - 40);
		lblFps.setPosition(getStage().getWidth() - 80, getStage().getHeight() - 60);
		getStage().addActor(lblScreenTime);
		getStage().addActor(lblFps);
	}
	
	private void setUpLevelsScreen() {
		// Create levels table
		// ######################################################################
	    level_table = MenuCreator.createTable(false, UIAssets.getSkin());
	    level_table.setSize(489 * AppSettings.getWorldSizeRatio(), 429 * AppSettings.getWorldSizeRatio());
	    level_table.setPosition(-999, 0);
	    //level_table.align(Align.center);
	    level_table.addAction(Actions.moveTo((getStage().getWidth() / 2) - (level_table.getWidth() / 2), (getStage().getHeight() / 2) - (level_table.getHeight() / 2), 0.7f));
		//level_table.top().left().pad(30, 30, 30, 30);
		Drawable background = new TextureRegionDrawable(UIAssets.image_level_table);
		//level_table.debug();
		
		
		// Add to stage
		// ######################################################################
		getStage().addActor(level_table);
		
		// Add levels buttons
		// Normally get this number from textfiles or database
		// ######################################################################
		int numberOfLevels = 8;
		
		
		// Create buttons with a loop
		for (int i = 0; i < numberOfLevels; i++){
			//1. Create level button
            Drawable dUp = new TextureRegionDrawable(UIAssets.button_level);
            Drawable dDown = new TextureRegionDrawable(UIAssets.button_level);
            final ButtonLevel levelButton = new ButtonLevel(dUp, dDown);
            
            levelButton.setSize(63 * AppSettings.getWorldSizeRatio(), 66 * AppSettings.getWorldSizeRatio());

			//2. Set level number
			levelButton.setLevelNumber(i + 1, UIAssets.cartwheel_font);
			
			//3. Set lock condition (get from database if it is locked or not and lock it)
			// use if/else here to lock or not
			// levelButton.setTextureLocked(Assets.btnBatLocked, true);
			
			//4. Set stars or any other achievements (get from database or text files here)
			// I just made a random number of earned stars 
			//Random rnd = new Random();
			if (chapter == 1) {
				levelButton.setLevelStars(UIAssets.image_level_no_star, UIAssets.image_level_star, 3, Integer.parseInt(FileManager.readLine("add.data", i, FileType.LOCAL_FILE)));
			} else if (chapter == 2) {
				levelButton.setLevelStars(UIAssets.image_level_no_star, UIAssets.image_level_star, 3, Integer.parseInt(FileManager.readLine("sub.data", i, FileType.LOCAL_FILE)));
			} else if (chapter == 3) {
				levelButton.setLevelStars(UIAssets.image_level_no_star, UIAssets.image_level_star, 3, Integer.parseInt(FileManager.readLine("mult.data", i, FileType.LOCAL_FILE)));
			}
			
			//5. Add  listener
			//Add button listener to go to a level (gamascreen)
			levelButton.addListener(new ActorGestureListener() {
			@Override
				public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
					super.touchUp(event, x, y, pointer, button);
					getGame().setScreen(new MAGameScreen(getGame(), "Game Screen", levelButton.getLevelNumber()));
				}
			});

			//6. Add row after each 5 level button to go down or how many do you need
			if(i % 4 == 0){
				level_table.row();
			}
			
			
			level_table.add(levelButton).padBottom(43f * AppSettings.getWorldPositionYRatio()).padRight(16f * AppSettings.getWorldPositionXRatio()).padLeft(12f * AppSettings.getWorldPositionXRatio());
			
			
		}
		
		MathAttackButton home = new MathAttackButton(63f, 66f, null, true);
		home.setTextureRegion(UIAssets.image_home_icon, true);
		
		home.addListener(new ActorGestureListener() {
			@Override
				public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
					super.touchUp(event, x, y, pointer, button);
					getGame().setScreen(new MAMainMenuScreen(getGame(), "Main Menu"));
				}
			});
		
		level_table.row();
		level_table.add(home).padTop(-50f * AppSettings.getWorldPositionYRatio()).padBottom(-70f * AppSettings.getWorldPositionYRatio()).colspan(4);
		level_table.setBackground(background);
	}
	
	@Override
	public void keyBackPressed() {
		super.keyBackPressed();
		getGame().setScreen(new MAMainMenuScreen(getGame(), ""));
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
		lblScreenTime.setText(getScreenTime());
		lblFps.setText("Fps: " + Gdx.graphics.getFramesPerSecond());
	}

	@Override
	public void setUpMenu() {
		
	}

	
}
