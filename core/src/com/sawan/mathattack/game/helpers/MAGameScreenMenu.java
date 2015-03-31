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
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.sawan.mathattack.asset.GameAssets;
import com.sawan.mathattack.asset.UIAssets;
import com.sawan.mathattack.buttons.MathAttackButton;
import com.sawan.mathattack.game.GameState;
import com.sawan.mathattack.game.screen.MAGameScreen;
import com.sawan.mathattack.game_screens.levels.MALevelScreen;
import com.sawan.mathattack.game_screens.main.MAMainMenuScreen;
import com.sawan.mathattack.models.SmartActor;
import com.sawan.mathattack.scene2d.ui.ButtonToggle;
import com.sawan.mathattack.scene2d.ui.MenuCreator;
import com.sawan.mathattack.scene2d.ui.Text;
import com.sawan.mathattack.settings.AppSettings;

// TODO: Auto-generated Javadoc
/**
 * The Class MAGameScreenMenu.
 *
 * @author Itop1
 */
public class MAGameScreenMenu {
	
	/** The btn play stop. */
	public ButtonToggle btnPlayStop;
	
	/** The pause_table. */
	public Table pause_table;
	
	/** The game_over. */
	public Table game_over;
	
	/** The level_complete. */
	public Table level_complete;
	
	/** The number_stars. */
	public int number_stars;
	
	/** The Constant PAUSE_SIZE. */
	protected final static float PAUSE_SIZE = 64f;
	
	/**
	 * Sets the up game screen menu.
	 *
	 * @param gameScreen the new up game screen menu
	 */
	public void setUpGameScreenMenu(final MAGameScreen gameScreen) {
		btnPlayStop = MenuCreator.createCustomToggleButton(null,
                GameAssets.pause, GameAssets.pause, false, PAUSE_SIZE, PAUSE_SIZE,
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
				} 
			}
		});
		//
		gameScreen.getStage().addActor(btnPlayStop);
	}
	
	/**
	 * Show pause table.
	 *
	 * @param gameScreen the game screen
	 */
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
		
		
		button_restart.addListener(new ActorGestureListener() {
				@Override
				public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
					super.touchUp(event, x, y, pointer, button);
					gameScreen.getGame().setScreen(new MAGameScreen(gameScreen.getGame(), "", gameScreen.level));
					gameScreen.game_manager.setGameState(GameState.GAME_RUNNING);
				}
			});
		
		button_resume.addListener(new ActorGestureListener() {
			@Override
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);
				hidePauseTable(gameScreen);
				Timer.schedule(new Task() {
					@Override
					public void run() {
						gameScreen.game_manager.setGameState(GameState.GAME_RUNNING);
					}
				}, 0.5f);
				
			}
		});
		
		button_levels.addListener(new ActorGestureListener() {
			@Override
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);
				gameScreen.getGame().setScreen(new MALevelScreen(gameScreen.getGame(), "", MALevelScreen.chapter));
				gameScreen.game_manager.setGameState(GameState.GAME_RUNNING);
			}
		});
		
		button_exit.addListener(new ActorGestureListener() {
			@Override
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);
				gameScreen.getGame().setScreen(new MAMainMenuScreen(gameScreen.getGame(), ""));
				gameScreen.game_manager.setGameState(GameState.GAME_RUNNING);
			}
		});
		
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
	
	/**
	 * Hide pause table.
	 *
	 * @param gameScreen the game screen
	 */
	public void hidePauseTable(final MAGameScreen gameScreen) {
		pause_table.addAction(Actions.moveTo(-999f, (gameScreen.getStage().getHeight() / 2) - (pause_table.getHeight() / 2), 0.5f));
		
		btnPlayStop.setToggleSwitch();
		btnPlayStop.setVisible(true);
		
		//pause_table.setPosition(-999f, gameScreen.getStage().getHeight());
	}
	
	/**
	 * Show game over.
	 *
	 * @param gameScreen the game screen
	 */
	public void showGameOver(final MAGameScreen gameScreen) {
		game_over = MenuCreator.createTable(false, UIAssets.getSkin());
		
		//LabelStyle style = new LabelStyle(UIAssets.cartwheel_font, null);
		
		//Label question = new Label("", style);
		Text game_over_message = new Text(UIAssets.cartwheel_font, 10f, 10f, true);
		game_over_message.setText("GAME OVER");
		//question.setFontScale(1.25f);
		//game_over_message.getBitMapFont().setScale(game_over_message.getWidth(), game_over_message.getHeight());
		
		//game_over.debug();
		
		float table_width = 251f;
		float table_height = 391f;
		game_over.size(table_height * AppSettings.getWorldSizeRatio(), table_width * AppSettings.getWorldSizeRatio());
		
		game_over.setPosition(-999f, (gameScreen.getStage().getHeight() / 2) - (game_over.getHeight() / 2));
		game_over.addAction(Actions.moveTo(gameScreen.getStage().getWidth() / 2 - (game_over.getWidth() / 2), (gameScreen.getStage().getHeight() / 2) - (game_over.getHeight() / 2), 0.5f));
		//quiz_table.setPosition(gameScreen.getStage().getWidth() / 2 - (quiz_table.getWidth() / 2), gameScreen.getStage().getHeight() - quiz_table.getHeight());
		
		Drawable background_table =  new TextureRegionDrawable(UIAssets.image_empty_bg);
		game_over.setBackground(background_table);
		game_over.add(game_over_message).padBottom(50f * AppSettings.getWorldPositionYRatio()).padRight(200f * AppSettings.getWorldPositionXRatio()).colspan(3);
		game_over.row();
		
		float button_width = 159.3f;
		float button_height = 49.5f;
		
		MathAttackButton button_restart = new MathAttackButton(button_width, button_height, null, true);
		MathAttackButton button_levels = new MathAttackButton(button_width, button_height, null, true);
		
		button_restart.setTextureRegion(UIAssets.button_restart, true);
		button_levels.setTextureRegion(UIAssets.button_back_levels, true);
		
		
		button_restart.addListener(new ActorGestureListener() {
				@Override
				public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
					super.touchUp(event, x, y, pointer, button);
					gameScreen.getGame().setScreen(new MAGameScreen(gameScreen.getGame(), "", gameScreen.level));
				}
			});
		
		
		button_levels.addListener(new ActorGestureListener() {
			@Override
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);
				gameScreen.getGame().setScreen(new MALevelScreen(gameScreen.getGame(), "", MALevelScreen.chapter));
			}
		});
		
		
		game_over.add(button_restart).padBottom(12f * AppSettings.getWorldPositionYRatio()).padRight(23f * AppSettings.getWorldPositionXRatio());
		game_over.add(button_levels).padBottom(12f * AppSettings.getWorldPositionYRatio());
		
		gameScreen.game_manager.worldLayer_other.quiz_table.setVisible(false);
		btnPlayStop.setVisible(false);
		
		gameScreen.getStage().addActor(game_over);
	}
	
	/**
	 * Show game win.
	 *
	 * @param gameScreen the game screen
	 */
	public void showGameWin(final MAGameScreen gameScreen) {
		level_complete = MenuCreator.createTable(false, UIAssets.getSkin());
		
		float table_width = 357f;
		float table_height = 426f;
		level_complete.size(table_height * AppSettings.getWorldSizeRatio(), table_width * AppSettings.getWorldSizeRatio());
		
		level_complete.setPosition(-999f, (gameScreen.getStage().getHeight() / 2) - (level_complete.getHeight() / 2));
		level_complete.addAction(Actions.moveTo(gameScreen.getStage().getWidth() / 2 - (level_complete.getWidth() / 2), (gameScreen.getStage().getHeight() / 2) - (level_complete.getHeight() / 2), 0.5f));
		
		Drawable background_table =  new TextureRegionDrawable(UIAssets.image_level_complete_bg);
		level_complete.setBackground(background_table);
		
		final SmartActor star_right = new SmartActor(74, 70, null, true);
		final SmartActor star_central = new SmartActor(87, 82, null, true);
		final SmartActor star_left = new SmartActor(74, 70, null, true);
		
		
		float button_width = 159.3f;
		float button_height = 49.5f;
		
		MathAttackButton button_restart = new MathAttackButton(button_width, button_height, null, true);
		MathAttackButton button_levels = new MathAttackButton(button_width, button_height, null, true);
		
		button_restart.setTextureRegion(UIAssets.button_restart, true);
		button_levels.setTextureRegion(UIAssets.button_back_levels, true);
		
		
		button_restart.addListener(new ActorGestureListener() {
				@Override
				public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
					super.touchUp(event, x, y, pointer, button);
					gameScreen.getGame().setScreen(new MAGameScreen(gameScreen.getGame(), "", gameScreen.level));
				}
			});
		
		
		button_levels.addListener(new ActorGestureListener() {
			@Override
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);
				gameScreen.getGame().setScreen(new MALevelScreen(gameScreen.getGame(), "", MALevelScreen.chapter));
			}
		});
		
		if (gameScreen.game_manager.worldLayer_actors.hero.getLifes() == 5) {
			star_right.setTextureRegion(UIAssets.image_star_right_completed, true);
			star_central.setTextureRegion(UIAssets.image_star_central_completed, true);
			star_left.setTextureRegion(UIAssets.image_star_left_completed, true);
			number_stars = 3;
		} else if (gameScreen.game_manager.worldLayer_actors.hero.getLifes() < 5 && gameScreen.game_manager.worldLayer_actors.hero.getLifes() > 2) {
			star_right.setTextureRegion(UIAssets.image_star_right_incompleted, true);
			star_central.setTextureRegion(UIAssets.image_star_central_completed, true);
			star_left.setTextureRegion(UIAssets.image_star_left_completed, true);
			number_stars = 2;
		} else {
			star_right.setTextureRegion(UIAssets.image_star_right_incompleted, true);
			star_central.setTextureRegion(UIAssets.image_star_central_incompleted, true);
			star_left.setTextureRegion(UIAssets.image_star_left_completed, true);
			number_stars = 1;
		}
				
		level_complete.add(star_left).padBottom(35f * AppSettings.getWorldPositionYRatio()).spaceRight(7f * AppSettings.getWorldPositionXRatio());				
		level_complete.add(star_central).padBottom(45f * AppSettings.getWorldPositionYRatio()).spaceRight(7f * AppSettings.getWorldPositionXRatio()).spaceLeft(7f * AppSettings.getWorldPositionXRatio());
		level_complete.add(star_right).padBottom(35f * AppSettings.getWorldPositionYRatio()).spaceLeft(7f * AppSettings.getWorldPositionXRatio());
		level_complete.row();
		level_complete.add(button_restart).colspan(3);
		level_complete.row();
		level_complete.add(button_levels).colspan(3);
		
		gameScreen.game_manager.worldLayer_other.quiz_table.setVisible(false);
		btnPlayStop.setVisible(false);
		
		gameScreen.getStage().addActor(level_complete);
	}
}
