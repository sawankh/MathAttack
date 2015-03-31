/**
 * File name:	MACreditsScreen.java
 * Version:		1.0
 * Date:		31/03/2015 00:34:14
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
package com.sawan.mathattack.game_screens.credits;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.sawan.mathattack.asset.Backgrounds;
import com.sawan.mathattack.asset.UIAssets;
import com.sawan.mathattack.buttons.MathAttackButton;
import com.sawan.mathattack.constants.MAConstants;
import com.sawan.mathattack.game.AbstractGame;
import com.sawan.mathattack.game_screens.main.MAMainMenuScreen;
import com.sawan.mathattack.interfaces.IScreen;
import com.sawan.mathattack.scene2d.ui.MenuCreator;
import com.sawan.mathattack.scene2d.ui.Text;
import com.sawan.mathattack.screen.AbstractScreen;
import com.sawan.mathattack.settings.AppSettings;

// TODO: Auto-generated Javadoc
/**
 * The Class MACreditsScreen.
 *
 * @author Sawan J. Kapai Harpalani
 */
public class MACreditsScreen extends AbstractScreen implements IScreen {

	/** The credits. */
	Table credits;
	
	/** The Constant TEXT_WIDTH. */
	protected final static float TEXT_WIDTH = 270f;
	
	/** The Constant TEXT_HEIGHT. */
	protected final static float TEXT_HEIGHT = 90f;
	
	/**
	 * Instantiates a new MA credits screen.
	 *
	 * @param game the game
	 * @param screenName the screen name
	 */
	public MACreditsScreen(AbstractGame game, String screenName) {
		super(game, screenName);
		setUpScreenElements();
		setUpcredits();
	}

	/* (non-Javadoc)
	 * @see com.sawan.mathattack.interfaces.IScreen#setUpScreenElements()
	 */
	@Override
	public void setUpScreenElements() {
		// TODO Auto-generated method stub
		setBackgroundTexture(Backgrounds.image_credits_background);
		
		setBackButtonActive(true);
	}

	/* (non-Javadoc)
	 * @see com.sawan.mathattack.interfaces.IScreen#setUpMenu()
	 */
	@Override
	public void setUpMenu() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Sets the upcredits.
	 */
	public void setUpcredits() {
		credits = MenuCreator.createTable(false, UIAssets.getSkin());
		credits.setSize(MAConstants.CREDITS_WIDTH * AppSettings.getWorldSizeRatio(), MAConstants.CREDITS_HEIGHT * AppSettings.getWorldSizeRatio());
	    credits.setPosition((getStage().getWidth() / 2) - (credits.getWidth() / 2), -credits.getHeight());
	    //credits.debug();
	    credits.addAction(Actions.moveTo((getStage().getWidth() / 2) - (credits.getWidth() / 2), (getStage().getHeight() / 2) - (credits.getHeight() / 2), 2.5f));
		//level_table.top().left().pad(30, 30, 30, 30);
		Drawable background = new TextureRegionDrawable(UIAssets.image_empty_bg);
		credits.setBackground(background);
		
		Text credits_text = new Text(UIAssets.cartwheel_font, TEXT_WIDTH, TEXT_HEIGHT, true);
		credits_text.setText("Game made by:");
		
		Text credits_text_name = new Text(UIAssets.cartwheel_font, TEXT_WIDTH, TEXT_HEIGHT, true);
		credits_text_name.setText("Sawan J. Kapai Harpalani");
		
		
		credits.add(credits_text).padBottom(50f * AppSettings.getWorldPositionYRatio()).padRight(400f * AppSettings.getWorldPositionXRatio());
		credits.row();
		credits.add(credits_text_name).padBottom(50f * AppSettings.getWorldPositionYRatio()).padRight(400f * AppSettings.getWorldPositionXRatio());
		
		MathAttackButton home = new MathAttackButton(MAConstants.SMALL_BUTTON_WIDTH, MAConstants.SMALL_BUTTON_HEIGHT, null, true);
		home.setTextureRegion(UIAssets.image_home_icon, true);
		
		home.addListener(new ActorGestureListener() {
			@Override
				public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
					super.touchUp(event, x, y, pointer, button);
					getGame().setScreen(new MAMainMenuScreen(getGame(), "Main Menu"));
				}
			});
		
		credits.row();
		credits.add(home);
		
		getStage().addActor(credits);
	}
	
	/* (non-Javadoc)
	 * @see com.sawan.mathattack.screen.AbstractScreen#keyBackPressed()
	 */
	@Override
	public void keyBackPressed() {
		super.keyBackPressed();
		getGame().setScreen(new MAMainMenuScreen(getGame(), ""));
	}

}
