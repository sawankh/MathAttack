/**
 * File name:	MAGameScreen.java
 * Version:		1.0
 * Date:		20/3/2015 12:23:27
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
package com.sawan.mathattack.game.screen;

import com.sawan.mathattack.game.AbstractGame;
import com.sawan.mathattack.game.GameState;
import com.sawan.mathattack.game.helpers.MAGameScreenMenu;
import com.sawan.mathattack.game.managers.MAGameManager;
import com.sawan.mathattack.interfaces.IGameScreen;
import com.sawan.mathattack.interfaces.IScreen;
import com.sawan.mathattack.managers.FileManager;
import com.sawan.mathattack.managers.FileManager.FileType;
import com.sawan.mathattack.screen.AbstractScreen;

/**
 * @author Itop1
 *
 */
public class MAGameScreen extends AbstractScreen implements IScreen, IGameScreen {
	public MAGameManager game_manager;
	public MAGameScreenMenu gameScreenMenu;
	public boolean game_over;
	public boolean game_win;
	public int level;
	
	public MAGameScreen(AbstractGame game, String screenName, int level_number) {
		super(game, screenName);
		game_over = true;
		game_win = true;
		level = level_number;
		//
		setUpGameManager();
		setUpMenu();
		
		game_manager.setGameState(GameState.GAME_RUNNING);
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
		
		//
		// Update game manager, (Useful for checking game condition)
		// ######################################################
		if(game_manager != null){
			game_manager.update(delta);
		}
		
		if (game_manager.getGameState() == GameState.GAME_OVER && game_over == true) {
			gameScreenMenu.showGameOver(this);
			game_over = false;
		}
		
		if (game_manager.getGameState() == GameState.GAME_LEVELWIN && game_win == true) {
			gameScreenMenu.showGameWin(this);
			game_win = false;
			FileManager.writeExistingLine("profile.data", level - 1, Integer.toString(gameScreenMenu.number_stars), FileType.LOCAL_FILE);
		}
			
	}

	@Override
	public void setUpScreenElements() {
		
	}

	@Override
	public void setUpMenu() {
		gameScreenMenu = new MAGameScreenMenu();
		gameScreenMenu.setUpGameScreenMenu(MAGameScreen.this);
	}

	@Override
	public void setUpGameManager() {
		game_manager = new MAGameManager(getStage(), this, level);
	}

	@Override
	public void setUpGameMenu() {
		
	}
}
