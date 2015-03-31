/**
 * File name:	MAChapterScreen.java
 * Version:		1.0
 * Date:		31/03/2015 21:26:47
 * Author:		Sawan J. Kapai Harpalani
 * Copyright:	Copyright 200X Sawan J. Kapai Harpalani
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
package com.sawan.mathattack.game_screens.chapters;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.sawan.mathattack.asset.Backgrounds;
import com.sawan.mathattack.asset.ChaptersAssets;
import com.sawan.mathattack.asset.UIAssets;
import com.sawan.mathattack.buttons.MathAttackButton;
import com.sawan.mathattack.game.AbstractGame;
import com.sawan.mathattack.game_screens.levels.MALevelScreen;
import com.sawan.mathattack.game_screens.main.MAMainMenuScreen;
import com.sawan.mathattack.interfaces.IScreen;
import com.sawan.mathattack.models.EmptyActorLight;
import com.sawan.mathattack.scene2d.ui.MenuCreator;
import com.sawan.mathattack.screen.AbstractScreen;
import com.sawan.mathattack.settings.AppSettings;

/**
 * @author Sawan J. Kapai Harpalani
 *
 */
public class MAChapterScreen extends AbstractScreen implements IScreen {
Table chapters;
	
	
	/**
	 * @param game
	 * @param screenName
	 */
	public MAChapterScreen(AbstractGame game, String screenName) {
		super(game, screenName);
		setUpScreenElements();
		setUpChapters();
	}

	@Override
	public void setUpScreenElements() {
		// TODO Auto-generated method stub
		setBackgroundTexture(Backgrounds.image_credits_background);
		
		setBackButtonActive(true);
	}

	@Override
	public void setUpMenu() {
		// TODO Auto-generated method stub
		
	}
	
	public void setUpChapters() {
		chapters = MenuCreator.createTable(false, UIAssets.getSkin());
		chapters.setSize(1000f * AppSettings.getWorldSizeRatio(), 300f * AppSettings.getWorldSizeRatio());
	    chapters.setPosition((getStage().getWidth() / 2) - (chapters.getWidth() / 2), (getStage().getHeight() / 2) - (chapters.getHeight() / 2));
	    //level_table.align(Align.center);
	    //chapters.addAction(Actions.moveTo((getStage().getWidth() / 2) - (chapters.getWidth() / 2), (getStage().getHeight() / 2) - (chapters.getHeight() / 2), 2.5f));
		//level_table.top().left().pad(30, 30, 30, 30);
		//Drawable background = new TextureRegionDrawable(UIAssets.image_empty_bg);
		//chapters.setBackground(background);
		
	    EmptyActorLight add = new EmptyActorLight(300f, 279f, true);
	    EmptyActorLight sub = new EmptyActorLight(300f, 279, true);
	    EmptyActorLight mult = new EmptyActorLight(300f, 279f, true);
		
	    add.setTextureRegion(ChaptersAssets.image_chapter_add, true);
	    sub.setTextureRegion(ChaptersAssets.image_chapter_sub, true);
	    mult.setTextureRegion(ChaptersAssets.image_chapter_mult, true);
	    
	    chapters.add(add).pad(5f * AppSettings.getWorldPositionXRatio());
	    chapters.add(sub).pad(5f * AppSettings.getWorldPositionXRatio());
	    chapters.add(mult).pad(5f * AppSettings.getWorldPositionXRatio());
	    
	    add.addListener(new ActorGestureListener() {
			@Override
				public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
					super.touchUp(event, x, y, pointer, button);
					getGame().setScreen(new MALevelScreen(getGame(), "Main Menu"));
				}
			});
	    
	    sub.addListener(new ActorGestureListener() {
			@Override
				public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
					super.touchUp(event, x, y, pointer, button);
					getGame().setScreen(new MALevelScreen(getGame(), "Main Menu"));
				}
			});
	    
	    mult.addListener(new ActorGestureListener() {
			@Override
				public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
					super.touchUp(event, x, y, pointer, button);
					getGame().setScreen(new MALevelScreen(getGame(), "Main Menu"));
				}
			});
	    
		MathAttackButton home = new MathAttackButton(63f, 66f, null, true);
		home.setTextureRegion(UIAssets.image_home_icon, true);
		
		home.addListener(new ActorGestureListener() {
			@Override
				public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
					super.touchUp(event, x, y, pointer, button);
					getGame().setScreen(new MAMainMenuScreen(getGame(), "Main Menu"));
				}
			});
		
		chapters.row();
		chapters.add(home).padTop(25f * AppSettings.getWorldPositionYRatio()).colspan(3);
		
		getStage().addActor(chapters);
	}
	
	@Override
	public void keyBackPressed() {
		super.keyBackPressed();
		getGame().setScreen(new MAMainMenuScreen(getGame(), ""));
	}

}
