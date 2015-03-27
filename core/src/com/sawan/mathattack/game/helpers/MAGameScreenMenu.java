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
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.sawan.mathattack.asset.UIAssets;
import com.sawan.mathattack.buttons.GameButton;
import com.sawan.mathattack.game.GameState;
import com.sawan.mathattack.game.screen.MAGameScreen;
import com.sawan.mathattack.math.Addition;
import com.sawan.mathattack.math.QuestionsSettings;
import com.sawan.mathattack.math.QuestionsUtils;
import com.sawan.mathattack.scene2d.ui.ButtonToggle;
import com.sawan.mathattack.scene2d.ui.MenuCreator;
import com.sawan.mathattack.settings.AppSettings;

/**
 * @author Itop1
 *
 */
public class MAGameScreenMenu {
	public ButtonToggle btnPlayStop;
	public Table quiz_table;
	public int user_answer;
	
	public void setUpGameScreenMenu(final MAGameScreen gameScreen) {
		btnPlayStop = MenuCreator.createCustomToggleButton(null,
                UIAssets.image_main_button_play, UIAssets.image_main_button_settings, false, 100, 100,
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
				} else{
					gameScreen.game_manager.setGameState(GameState.GAME_RUNNING);
				}
			}
		});
		//
		gameScreen.getStage().addActor(btnPlayStop);
	}
	
	public void setUpMathQuiz(final MAGameScreen gameScreen) {
		quiz_table = MenuCreator.createTable(false, UIAssets.getSkin());
		quiz_table.debug();
		final Addition addition = new Addition(QuestionsUtils.randomNumber(QuestionsSettings.MIN_QUIZ_VALUE, QuestionsSettings.MAX_QUIZ_VALUE), QuestionsUtils.randomNumber(QuestionsSettings.MIN_QUIZ_VALUE, QuestionsSettings.MAX_QUIZ_VALUE));
		Label question = new Label("", UIAssets.getSkin());
		question.setText(addition.getQuestion());
		question.setFontScale(2);
		
		
		float table_width = 251f;
		float table_height = 391f;
		quiz_table.size(table_height * AppSettings.getWorldSizeRatio(), table_width * AppSettings.getWorldSizeRatio());
		
		quiz_table.setPosition(gameScreen.getStage().getWidth() / 2 - (quiz_table.getWidth() / 2), gameScreen.getStage().getHeight());
		quiz_table.addAction(Actions.moveTo(gameScreen.getStage().getWidth() / 2 - (quiz_table.getWidth() / 2), gameScreen.getStage().getHeight() - quiz_table.getHeight(), 0.5f));
		//quiz_table.setPosition(gameScreen.getStage().getWidth() / 2 - (quiz_table.getWidth() / 2), gameScreen.getStage().getHeight() - quiz_table.getHeight());
		
		//Drawable background_table =  new TextureRegionDrawable(UIAssets.image_empty_bg);
		//quiz_table.setBackground(background_table);
		quiz_table.add(question);
		quiz_table.row();
		for (int i = 0; i < addition.getAnswers().length; i++) {
			/**Label answer = new Label("", UIAssets.getSkin());
			answer.setText(Integer.toString(addition.getAnswers()[i]));
			
			quiz_table.add(answer);**/
			Drawable up = new TextureRegionDrawable(UIAssets.button_level);
			Drawable down = new TextureRegionDrawable(UIAssets.button_level);
			final GameButton answer_button = new GameButton(up, down);
			
			
			answer_button.setDIPActive(true);
			answer_button.setAnswer(addition.getAnswers()[i], UIAssets.cartwheel_font);
			
			answer_button.addListener(new ActorGestureListener() {
				@Override
				public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
					super.touchUp(event, x, y, pointer, button);
					user_answer = answer_button.getAnswer();
					if (user_answer == addition.getCorrect_answer()) {
						System.out.println("Correcto!");
						quiz_table.addAction(Actions.moveTo(gameScreen.getStage().getWidth() / 2 - (quiz_table.getWidth() / 2), gameScreen.getStage().getHeight(), 0.5f));
						gameScreen.game_manager.worldLayer_actors.addBullet();
						Timer.schedule(new Task() {
							@Override
							public void run() {
								setUpMathQuiz(gameScreen);
							}
						}, 0.6f);
			
					} else {
						System.out.println("Incorrecto");
						quiz_table.addAction(Actions.moveTo(gameScreen.getStage().getWidth() / 2 - (quiz_table.getWidth() / 2), gameScreen.getStage().getHeight(), 0.5f));
						Timer.schedule(new Task() {
							@Override
							public void run() {
								setUpMathQuiz(gameScreen);
							}
						}, 0.6f);
			
					}
				}
			});
			
			quiz_table.add(answer_button);
		}
		
		gameScreen.getStage().addActor(quiz_table);
	}
}
