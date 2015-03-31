/**
 * File name:	AbstractGameManager.java
 * Version:		1.0
 * Date:		@date 13:08:46
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

package com.sawan.mathattack.game;

import java.util.Random;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Timer;
import com.sawan.mathattack.screen.AbstractScreen;
import com.sawan.mathattack.settings.MtxLogger;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractGameManager.
 */
public abstract class AbstractGameManager {
	//
	/** The log tag. */
	protected final String logTag = "MtxGameManagerLog";
	
	/** The log active. */
	public static boolean logActive = true;

	// Game manager helpers
	/** The game state. */
	private GameState gameState;
	
	/** The stage. */
	private Stage stage;
	
	/** The screen. */
	private AbstractScreen screen;
	
	/** The random. */
	private Random random;
	
	/** The timer. */
	private Timer timer;

	/**
	 * Instantiates a new abstract game manager.
	 *
	 * @param stage the stage
	 * @param screen the screen
	 */
	public AbstractGameManager(Stage stage, AbstractScreen screen) {
		this.stage = stage;
		this.screen = screen;
		random = new Random();
		timer = new Timer();
	}

	/**
	 * Gets the game state.
	 *
	 * @return the game state
	 */
	public GameState getGameState() {
		return gameState;
	}

	/**
	 * Sets the game state.
	 *
	 * @param gameState the new game state
	 */
	public void setGameState(GameState gameState) {
		this.gameState = gameState;
		MtxLogger.log(logActive, true, logTag,
				"Game State: " + gameState.toString());
	}

	/**
	 * Gets the stage.
	 *
	 * @return the stage
	 */
	public Stage getStage() {
		return stage;
	}

	/**
	 * Sets the stage.
	 *
	 * @param stage the new stage
	 */
	public void setStage(Stage stage) {
		this.stage = stage;
	}

	/**
	 * Gets the screen.
	 *
	 * @return the screen
	 */
	public AbstractScreen getScreen() {
		return screen;
	}

	/**
	 * Sets the screen.
	 *
	 * @param screen the new screen
	 */
	public void setScreen(AbstractScreen screen) {
		this.screen = screen;
	}

	/**
	 * Gets the random.
	 *
	 * @return the random
	 */
	public Random getRandom() {
		return random;
	}

	/**
	 * Sets the random.
	 *
	 * @param random the new random
	 */
	public void setRandom(Random random) {
		this.random = random;
	}

	/**
	 * Gets the timer.
	 *
	 * @return the timer
	 */
	public Timer getTimer() {
		return timer;
	}

	/**
	 * Sets the timer.
	 *
	 * @param timer the new timer
	 */
	public void setTimer(Timer timer) {
		this.timer = timer;
	}
}
