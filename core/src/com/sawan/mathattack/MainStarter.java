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

import com.sawan.mathattack.asset.Backgrounds;
import com.sawan.mathattack.asset.ChaptersAssets;
import com.sawan.mathattack.asset.GameAssets;
import com.sawan.mathattack.asset.HeroAssests;
import com.sawan.mathattack.asset.MonsterAssets;
import com.sawan.mathattack.asset.UIAssets;
import com.sawan.mathattack.asset.levels.MALevelAssets;
import com.sawan.mathattack.game.AbstractGame;
import com.sawan.mathattack.game_screens.chapters.MAChapterScreen;
import com.sawan.mathattack.game_screens.main.MAMainMenuScreen;
import com.sawan.mathattack.managers.FileManager;
import com.sawan.mathattack.managers.FileManager.FileType;
import com.sawan.mathattack.managers.SettingsManager;
import com.sawan.mathattack.settings.AppSettings;

public class MainStarter extends AbstractGame {

	@Override
	public void create() {
        super.create();
		setScreen(new MAChapterScreen(this, "Main Menu"));
	}
	
	@Override
	public void setUpAppSettings() {
		AppSettings.setUp();
		if (!SettingsManager.isFirstLaunchDone()) {
			SettingsManager.setFirstLaunchDone(true);
			FileManager.createTextFileInLocalStorage("add.data");
			FileManager.createTextFileInLocalStorage("sub.data");
			FileManager.createTextFileInLocalStorage("mult.data");
			FileManager.initiateMAFile("add.data", FileType.LOCAL_FILE);
			FileManager.initiateMAFile("sub.data", FileType.LOCAL_FILE);
			FileManager.initiateMAFile("mult.data", FileType.LOCAL_FILE);
		}
		//FileManager.getFile("profile.data", FileType.LOCAL_FILE).delete();
		//SettingsManager.setFirstLaunchDone(false);
	}

	@Override
	public void setUpAssets() {
		UIAssets.loadAll();
		Backgrounds.loadAll();
		MALevelAssets.loadAll();
		HeroAssests.loadAll();
		MonsterAssets.loadAll();
		GameAssets.loadAll();
		ChaptersAssets.loadAll();
	}

	@Override
	public void setUpLoadingScreen() {

	}
}
