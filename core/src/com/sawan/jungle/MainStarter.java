package com.sawan.jungle;

import com.sawan.jungle.assets.Assets;
import com.sawan.jungle.screens.JungleMainMenuScreen;
import com.sawan.mathattack.game.AbstractGame;
import com.sawan.mathattack.settings.AppSettings;


public class MainStarter extends AbstractGame {

	@Override
	public void create() {
        super.create();
		//
		// Set the tests screen
		// #####################################
		setScreen(new JungleMainMenuScreen(this, "Main Menu"));
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
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
