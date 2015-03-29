/**
 * File name:	MAGameScreenMenu.java
 * Version:		1.0
 * Date:		20/3/2015 12:25:34
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
package com.sawan.mathattack.game.helpers;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.sawan.mathattack.asset.GameAssets;
import com.sawan.mathattack.asset.UIAssets;
import com.sawan.mathattack.buttons.MathAttackButton;
import com.sawan.mathattack.game.GameState;
import com.sawan.mathattack.game.screen.MAGameScreen;
import com.sawan.mathattack.scene2d.ui.ButtonToggle;
import com.sawan.mathattack.scene2d.ui.MenuCreator;
import com.sawan.mathattack.settings.AppSettings;

/**
 * @author Itop1
 *
 */
public class MAGameScreenMenu {
	public ButtonToggle btnPlayStop;
	public Table pause_table;
	
	public void setUpGameScreenMenu(final MAGameScreen gameScreen) {
		btnPlayStop = MenuCreator.createCustomToggleButton(null,
                GameAssets.pause, GameAssets.pause, false, 64, 64,
                true);
		btnPlayStop.setPosition(gameScreen.getStage().getWidth() - btnPlayStop.getWidth(), 
				gameScreen.getStage().getHeight() - btnPlayStop.getHeight());
		btnPlayStop.addListener(new ActorGestureListener() {
			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);
				//
				btnPlayStop.setToggleSwitch();
				//
				if(btnPlayStop.isToggleActive()){
					gameScreen.game_manager.setGameState(GameState.GAME_PAUSED);
					showPauseTable(gameScreen);
				} else{
					gameScreen.game_manager.setGameState(GameState.GAME_RUNNING);
					hidePauseTable(gameScreen);
				}
			}
		});
		//
		gameScreen.getStage().addActor(btnPlayStop);
	}
	
	public void showPauseTable(final MAGameScreen gameScreen) {
		pause_table = MenuCreator.createTable(false, UIAssets.getSkin());
		
		float table_width = 489f;
		float table_height = 429f;
		pause_table.size(table_height * AppSettings.getWorldSizeRatio(), table_width * AppSettings.getWorldSizeRatio());
		
		pause_table.setPosition(-999f, (gameScreen.getStage().getHeight() / 2) - (pause_table.getHeight() / 2));
		pause_table.addAction(Actions.moveTo(gameScreen.getStage().getWidth() / 2 - (pause_table.getWidth() / 2), (gameScreen.getStage().getHeight() / 2) - (pause_table.getHeight() / 2), 0.5f));
		
		Drawable background_table =  new TextureRegionDrawable(UIAssets.image_pause_bg);
		pause_table.setBackground(background_table);
		
		float button_width = 177f;
		float button_height = 55f;
		
		MathAttackButton button_restart = new MathAttackButton(button_width, button_height, null, true);
		MathAttackButton button_resume = new MathAttackButton(button_width, button_height, null, true);
		MathAttackButton button_levels = new MathAttackButton(button_width, button_height, null, true);
		MathAttackButton button_exit = new MathAttackButton(button_width, button_height, null, true);
		
		button_restart.setTextureRegion(UIAssets.button_restart, true);
		button_resume.setTextureRegion(UIAssets.button_resume, true);
		button_levels.setTextureRegion(UIAssets.button_back_levels, true);
		button_exit.setTextureRegion(UIAssets.button_exit, true);
		
		
		pause_table.add(button_restart).padBottom(12f * AppSettings.getWorldPositionYRatio());
		pause_table.row();
		pause_table.add(button_resume).padBottom(12f * AppSettings.getWorldPositionYRatio());
		pause_table.row();
		pause_table.add(button_levels).padBottom(12f * AppSettings.getWorldPositionYRatio());
		pause_table.row();
		pause_table.add(button_exit).padBottom(12f * AppSettings.getWorldPositionYRatio());
		
		btnPlayStop.setVisible(false);
		
		gameScreen.getStage().addActor(pause_table);
	}
	
	public void hidePauseTable(final MAGameScreen gameScreen) {
		pause_table.addAction(Actions.moveTo(-999f, (gameScreen.getStage().getHeight() / 2) - (pause_table.getHeight() / 2), 0.5f));
		
		btnPlayStop.setVisible(true);
		
		//pause_table.setPosition(-999f, gameScreen.getStage().getHeight());
	}
}
