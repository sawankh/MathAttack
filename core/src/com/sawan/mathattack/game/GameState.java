/**
 * File name:	GameState.java
 * Version:		1.0
 * Date:		@date 13:09:02
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

/**
 * Common game states to be used in game logics
 */
public enum GameState {
	GAME_RUNNING,
	GAME_PAUSED,
	GAME_UPDATE,
	GAME_OVER,
	GAME_WIN,
	GAME_LEVELWIN,
	GAME_IDLE,
	GAME_SLOWMOTION
}
