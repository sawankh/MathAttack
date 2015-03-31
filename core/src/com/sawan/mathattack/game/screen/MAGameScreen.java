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
import com.sawan.mathattack.game_screens.levels.MALevelScreen;
import com.sawan.mathattack.interfaces.IGameScreen;
import com.sawan.mathattack.interfaces.IScreen;
import com.sawan.mathattack.managers.FileManager;
import com.sawan.mathattack.managers.FileManager.FileType;
import com.sawan.mathattack.screen.AbstractScreen;

// TODO: Auto-generated Javadoc
/**
 * The Class MAGameScreen.
 *
 * @author Itop1
 */
public class MAGameScreen extends AbstractScreen implements IScreen, IGameScreen {
	
	/** The game_manager. */
	public MAGameManager game_manager;
	
	/** The game screen menu. */
	public MAGameScreenMenu gameScreenMenu;
	
	/** The game_over. */
	public boolean game_over;
	
	/** The game_win. */
	public boolean game_win;
	
	/** The level. */
	public int level;
	
	/**
	 * Instantiates a new MA game screen.
	 *
	 * @param game the game
	 * @param screenName the screen name
	 * @param level_number the level_number
	 */
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
	
	/* (non-Javadoc)
	 * @see com.sawan.mathattack.screen.AbstractScreen#render(float)
	 */
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
			
			String file = "";
			if (MALevelScreen.chapter == 1) {
				file = "add.data";
			} else if (MALevelScreen.chapter == 2) {
				file = "sub.data";
			} else if (MALevelScreen.chapter == 3) {
				file = "mult.data";
			}
			
			if (gameScreenMenu.number_stars > Integer.parseInt(FileManager.readLine(file, level - 1, FileType.LOCAL_FILE))) {
				FileManager.writeExistingLine(file, level - 1, Integer.toString(gameScreenMenu.number_stars), FileType.LOCAL_FILE);
			}
			
		}
			
	}

	/* (non-Javadoc)
	 * @see com.sawan.mathattack.interfaces.IScreen#setUpScreenElements()
	 */
	@Override
	public void setUpScreenElements() {
		
	}

	/* (non-Javadoc)
	 * @see com.sawan.mathattack.interfaces.IScreen#setUpMenu()
	 */
	@Override
	public void setUpMenu() {
		gameScreenMenu = new MAGameScreenMenu();
		gameScreenMenu.setUpGameScreenMenu(MAGameScreen.this);
	}

	/* (non-Javadoc)
	 * @see com.sawan.mathattack.interfaces.IGameScreen#setUpGameManager()
	 */
	@Override
	public void setUpGameManager() {
		game_manager = new MAGameManager(getStage(), this, level);
	}

	/* (non-Javadoc)
	 * @see com.sawan.mathattack.interfaces.IGameScreen#setUpGameMenu()
	 */
	@Override
	public void setUpGameMenu() {
		
	}
}
