/**
 * File name:	WorldLayerOther.java
 * Version:		1.0
 * Date:		20/3/2015 10:06:46
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
package com.sawan.mathattack.game.layers;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.sawan.mathattack.asset.UIAssets;
import com.sawan.mathattack.buttons.GameButton;
import com.sawan.mathattack.constants.MAConstants;
import com.sawan.mathattack.game.managers.MAGameManager;
import com.sawan.mathattack.game_screens.levels.MALevelScreen;
import com.sawan.mathattack.math.Addition;
import com.sawan.mathattack.math.IQuestion;
import com.sawan.mathattack.math.Multiplication;
import com.sawan.mathattack.math.QuestionsSettings;
import com.sawan.mathattack.math.QuestionsUtils;
import com.sawan.mathattack.math.Subtraction;
import com.sawan.mathattack.scene2d.AbstractWorldScene2d;
import com.sawan.mathattack.scene2d.ui.MenuCreator;
import com.sawan.mathattack.scene2d.ui.Text;
import com.sawan.mathattack.settings.AppSettings;

// TODO: Auto-generated Javadoc
/**
 * The Class WorldLayerOther.
 *
 * @author Itop1
 */
public class WorldLayerOther extends AbstractWorldScene2d {
	
	/** The game manager. */
	public MAGameManager gameManager;
	
	/** The user_answer. */
	public int user_answer;
	
	/** The quiz_table. */
	public Table quiz_table;

	
	/**
	 * Instantiates a new world layer other.
	 *
	 * @param gameManager the game manager
	 * @param posX the pos x
	 * @param posY the pos y
	 * @param worldWidth the world width
	 * @param worldHeight the world height
	 */
	public WorldLayerOther(MAGameManager gameManager, float posX, float posY, float worldWidth, float worldHeight) {
		super(posX, posY, worldWidth, worldHeight);
		this.gameManager =  gameManager;
	
		setUpMathQuiz();
	}
	
	/**
	 * Sets the up math quiz.
	 */
	public void setUpMathQuiz() {
		quiz_table = MenuCreator.createTable(false, UIAssets.getSkin());
		//quiz_table.debug();
		
		final IQuestion question_type;
		//final Addition question_type = new Addition(QuestionsUtils.randomNumber(QuestionsSettings.MIN_QUIZ_VALUE, QuestionsSettings.MAX_QUIZ_VALUE), QuestionsUtils.randomNumber(QuestionsSettings.MIN_QUIZ_VALUE, QuestionsSettings.MAX_QUIZ_VALUE));
		if (MALevelScreen.chapter == MAConstants.CHAPTER_ADDITION) {
			question_type = new Addition(QuestionsUtils.randomNumber(QuestionsSettings.MIN_QUIZ_VALUE, QuestionsSettings.MAX_QUIZ_VALUE), QuestionsUtils.randomNumber(QuestionsSettings.MIN_QUIZ_VALUE, QuestionsSettings.MAX_QUIZ_VALUE));
		} else if (MALevelScreen.chapter == MAConstants.CHAPTER_SUBTRACTION) {
			question_type = new Subtraction(QuestionsUtils.randomNumber(QuestionsSettings.MIN_QUIZ_VALUE, QuestionsSettings.MAX_QUIZ_VALUE), QuestionsUtils.randomNumber(QuestionsSettings.MIN_QUIZ_VALUE, QuestionsSettings.MAX_QUIZ_VALUE));
		} else if (MALevelScreen.chapter == MAConstants.CHAPTER_MULTIPLICATION) {
			question_type = new Multiplication(QuestionsUtils.randomNumber(0, 11), QuestionsUtils.randomNumber(1, 9));
		} else {
			question_type = null;
		}
		
		//LabelStyle style = new LabelStyle(UIAssets.cartwheel_font, null);
		
		//Label question = new Label("", style);
		Text question = new Text(UIAssets.cartwheel_font, 90f * 3, 20f, true);
		question.setText(question_type.getQuestion());
		//question.setFontScale(1.25f);
		question.getBitMapFont().setScale(question.getWidth(), question.getHeight());
		
		
		float table_width = 251f;
		float table_height = 391f;
		quiz_table.size(table_height * AppSettings.getWorldSizeRatio(), table_width * AppSettings.getWorldSizeRatio());
		
		quiz_table.setPosition(gameManager.getStage().getWidth() / 2 - (quiz_table.getWidth() / 2), gameManager.getStage().getHeight());
		quiz_table.addAction(Actions.moveTo(gameManager.getStage().getWidth() / 2 - (quiz_table.getWidth() / 2), gameManager.getStage().getHeight() - quiz_table.getHeight(), 0.5f));
		//quiz_table.setPosition(gameScreen.getStage().getWidth() / 2 - (quiz_table.getWidth() / 2), gameScreen.getStage().getHeight() - quiz_table.getHeight());
		
		Drawable background_table =  new TextureRegionDrawable(UIAssets.image_empty_bg);
		quiz_table.setBackground(background_table);
		quiz_table.add(question).padBottom(50f * AppSettings.getWorldPositionYRatio()).padLeft(67.5f * AppSettings.getWorldPositionXRatio()).colspan(3);
		quiz_table.row();
		for (int i = 0; i < question_type.getAnswers().length; i++) {
			/**Label answer = new Label("", UIAssets.getSkin());
			answer.setText(Integer.toString(addition.getAnswers()[i]));
			
			quiz_table.add(answer);**/
			Drawable up = new TextureRegionDrawable(UIAssets.button_level);
			Drawable down = new TextureRegionDrawable(UIAssets.button_level);
			final GameButton answer_button = new GameButton(UIAssets.cartwheel_font, up, down, 63f, 66f, true);
			
			//answer_button.setDIPActive(true);
			//answer_button.setWidth(25f * AppSettings.getWorldSizeRatio());
			//answer_button.setHeight(28f * AppSettings.getWorldSizeRatio());
			//answer_button.size(10f * AppSettings.getWorldSizeRatio(), 13f * AppSettings.getWorldSizeRatio());
			
			/**Gdx.app.log("Table_w", Float.toString(quiz_table.getWidth()));
			Gdx.app.log("Table_h", Float.toString(quiz_table.getHeight()));
			Gdx.app.log("Button_w", Float.toString(answer_button.getWidth()));
			Gdx.app.log("Button_h", Float.toString(answer_button.getHeight()));
			**/
			
			answer_button.setAnswer(question_type.getAnswers()[i], UIAssets.cartwheel_font);
			
			answer_button.addListener(new ActorGestureListener() {
				@Override
				public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
					super.touchUp(event, x, y, pointer, button);
					user_answer = answer_button.getAnswer();
					if (user_answer == question_type.getCorrect_answer()) {
						System.out.println("Correcto!");
						hideTable();
						gameManager.worldLayer_actors.addBullet();
						Timer.schedule(new Task() {
							@Override
							public void run() {
								setUpMathQuiz();
							}
						}, 0.6f);
			
					} else {
						System.out.println("Incorrecto");
						hideTable();
						Timer.schedule(new Task() {
							@Override
							public void run() {
								setUpMathQuiz();
							}
						}, 0.6f);
			
					}
				}
			});
			
			quiz_table.add(answer_button).size(answer_button.getWidth(), answer_button.getHeight());
		}
		
		addActor(quiz_table);
	}
	
	/**
	 * Hide table.
	 */
	public void hideTable() {
		quiz_table.addAction(Actions.moveTo(gameManager.getStage().getWidth() / 2 - (quiz_table.getWidth() / 2), gameManager.getStage().getHeight(), 0.5f));
	}
	
	
}
