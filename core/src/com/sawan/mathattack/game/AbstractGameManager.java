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

public abstract class AbstractGameManager {
	//
	protected final String logTag = "MtxGameManagerLog";
	public static boolean logActive = true;

	// Game manager helpers
	private GameState gameState;
	private Stage stage;
	private AbstractScreen screen;
	private Random random;
	private Timer timer;

	public AbstractGameManager(Stage stage, AbstractScreen screen) {
		this.stage = stage;
		this.screen = screen;
		random = new Random();
		timer = new Timer();
	}

	public GameState getGameState() {
		return gameState;
	}

	public void setGameState(GameState gameState) {
		this.gameState = gameState;
		MtxLogger.log(logActive, true, logTag,
				"Game State: " + gameState.toString());
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public AbstractScreen getScreen() {
		return screen;
	}

	public void setScreen(AbstractScreen screen) {
		this.screen = screen;
	}

	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}
}
