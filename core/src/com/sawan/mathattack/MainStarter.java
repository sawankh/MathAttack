/**
 * File name:	MainStarter.java
 * Version:		1.0
 * Date:		@date 13:28:20
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
package com.sawan.mathattack;

import com.sawan.mathattack.asset.Assets;
import com.sawan.mathattack.game.AbstractGame;
import com.sawan.mathattack.game_screens.main.MathAttackMainMenuScreen;
import com.sawan.mathattack.settings.AppSettings;

public class MainStarter extends AbstractGame {

	@Override
	public void create() {
        super.create();
		setScreen(new MathAttackMainMenuScreen(this, "Main Menu"));
	}
	
	@Override
	public void setUpAppSettings() {
		AppSettings.setUp();
	}

	@Override
	public void setUpAssets() {
		Assets.loadAll();
	}

	@Override
	public void setUpLoadingScreen() {

	}
}
