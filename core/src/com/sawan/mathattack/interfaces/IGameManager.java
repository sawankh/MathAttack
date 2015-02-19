/**
 * File name:	IGameManager.java
 * Version:		1.0
 * Date:		@date 13:09:55
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

package com.sawan.mathattack.interfaces;

// TODO: Auto-generated Javadoc
/**
 * The Interface IGameManager.
 */
public interface IGameManager {

	/**
	 * Set up data that gathered from database (Server/TextFiles/SQLDB/Json/Xml
	 * etc...)
	 * */
	public void setUpData();

	/**
	 * Set up pre-sub-managers that needs to be constructed before world
	 * creation.
	 */
	public void setUpPreManagers();

	/**
	 * Set up post-sub-managers that needs to be constructed after world
	 * creation.
	 */
	public void setUpPostManagers();

	/**
	 * Set up world and layers.
	 */
	public void setUpWorld();

	/**
	 * Start a level
	 * *.
	 *
	 * @param levelNumber the level number
	 */
	public void startLevel(int levelNumber);

	/**
	 * Use this in GameManager's updater(), check the game state for win, lose,
	 * idle, over etc...
	 * */
	public void checkGameCondition();

	/**
	 * Use this method in SCREEN's render(). This can be used updating world,
	 * game condition, chracters and many others, it can be also used for MVC
	 * style development
	 *
	 * @param delta the delta
	 */
	public void update(float delta);

	/**
	 * Save game, suggested use in Hide() and Pause() methods of Screen class.
	 */
	public void saveGame();
}
