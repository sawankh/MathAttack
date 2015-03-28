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
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.sawan.mathattack.asset.GameAssets;
import com.sawan.mathattack.game.GameState;
import com.sawan.mathattack.game.screen.MAGameScreen;
import com.sawan.mathattack.scene2d.ui.ButtonToggle;
import com.sawan.mathattack.scene2d.ui.MenuCreator;

/**
 * @author Itop1
 *
 */
public class MAGameScreenMenu {
	public ButtonToggle btnPlayStop;
	
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
				} else{
					gameScreen.game_manager.setGameState(GameState.GAME_RUNNING);
				}
			}
		});
		//
		gameScreen.getStage().addActor(btnPlayStop);
	}
}
