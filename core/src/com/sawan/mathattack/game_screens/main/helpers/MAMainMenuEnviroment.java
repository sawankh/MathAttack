/**
 * File name:	MathAttackMainMenuEnviroment.java
 * Version:		1.0
 * Date:		07/03/2015 23:49:10
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

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.sawan.mathattack.asset.UIAssets;
import com.sawan.mathattack.game_screens.main.MAMainMenuScreen;
import com.sawan.mathattack.models.EmptyActorLight;
import com.sawan.mathattack.settings.AppSettings;

// TODO: Auto-generated Javadoc
/**
 * The Class MathAttackMainMenuEnviroment.
 *
 * @author Sawan
 */
public class MAMainMenuEnviroment {
	
	/** The Constant TITLE_W. */
	protected final static int TITLE_W = 600;
	
	/** The Constant TITLE_H. */
	protected final static int TITLE_H = 374;
	
	/**
	 * Sets the up game name.
	 *
	 * @param menu_screen the new up game name
	 */
	public void setUpGameName(final MAMainMenuScreen menu_screen) {
		menu_screen.title = new EmptyActorLight(TITLE_W, TITLE_H, true);
		menu_screen.title.setTextureRegion(UIAssets.image_main_title, true);
		menu_screen.title.setOrigin( menu_screen.title.getWidth() / 2, menu_screen.title.getHeight() / 2);
		menu_screen.title.setPosition( AppSettings.SCREEN_W / 2 - menu_screen.title.getWidth() / 2,
				AppSettings.SCREEN_H + menu_screen.title.getHeight());
		
		if (Gdx.app.getType() == ApplicationType.Android) {
			menu_screen.title.setPosition( AppSettings.SCREEN_W / 2 - menu_screen.title.getWidth() / 2,
					AppSettings.SCREEN_H + menu_screen.title.getHeight() - 50);
		}
		
		//
		menu_screen.getStage().addActor(menu_screen.title);
	}
	
	/**
	 * Send in title.
	 *
	 * @param menu_screen the menu_screen
	 */
	public void sendInTitle(final MAMainMenuScreen menu_screen) {
		menu_screen.title.addAction(Actions.moveTo(
				AppSettings.SCREEN_W / 2
						- menu_screen.title.getWidth() / 2,
				AppSettings.SCREEN_H
						- menu_screen.title.getHeight(), 0.5f));

	}
	
}
