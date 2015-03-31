/**
 * File name:	MtxLogger.java
 * Version:		1.0
 * Date:		@date 13:16:29
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

package com.sawan.mathattack.settings;

import com.badlogic.gdx.Gdx;
import com.sawan.mathattack.collision.CollisionDetector;
import com.sawan.mathattack.effects.EffectCreator;
import com.sawan.mathattack.game.AbstractGame;
import com.sawan.mathattack.game.AbstractGameManager;
import com.sawan.mathattack.input.InputIntent;
import com.sawan.mathattack.scene2d.AbstractActor;
import com.sawan.mathattack.scene2d.AbstractActorLight;
import com.sawan.mathattack.scene2d.AbstractGroup;
import com.sawan.mathattack.scene2d.AbstractGroupLight;
import com.sawan.mathattack.scene2d.AbstractWorldScene2d;
import com.sawan.mathattack.screen.AbstractScreen;
import com.sawan.mathattack.utils.UtilsDisposer;

// TODO: Auto-generated Javadoc
/**
 * The Class MtxLogger.
 */
public class MtxLogger {
	
	/** The is master logger active. */
	private static boolean isMasterLoggerActive = false;

	/**
	 * Set logs that you want to see, or kill all logs with master logger,
	 * default masterlog is false.
	 *
	 * @param isMasterLoggerActive the new logs
	 */
	public static void setLogs(boolean isMasterLoggerActive) {
		// Master log (To show or not to show any log)
		MtxLogger.isMasterLoggerActive = isMasterLoggerActive;

		// AppSettings
		AppSettings.Log_Active = true;

		// Game
		AbstractGame.logActive = true;
		AbstractScreen.logActive = true;
		AbstractGameManager.logActive = true;

		// Scene 2D
		AbstractActor.logActive = true;
		AbstractActorLight.logActive = true;
		AbstractGroup.logActive = true;
		AbstractGroupLight.logActive = true;
		AbstractWorldScene2d.logActive = true;

		// Input
		InputIntent.logActive = false;

		// Helpers
		EffectCreator.logActive = false;
		CollisionDetector.logActive = false;

		// Utilizers
		UtilsDisposer.logActive = true;
	}

	/**
	 * Log something.
	 *
	 * @param objectLoggerActive the object logger active
	 * @param methodLoggerActive the method logger active
	 * @param tag the tag
	 * @param log the log
	 */
	public static void log(boolean objectLoggerActive,
			boolean methodLoggerActive, String tag, String log) {
		// Log
		if (isMasterLoggerActive && objectLoggerActive && methodLoggerActive) {
			Gdx.app.log(tag, log);
		}
	}
}
