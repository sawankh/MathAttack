package com.sawan.jungle.screens.helpers;

import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.sawan.jungle.assets.Assets;
import com.sawan.jungle.screens.JungleMainMenuScreen;
import com.sawan.mathattack.models.EmptyActorLight;
import com.sawan.mathattack.settings.AppSettings;


public class JungleMainMenuScreenInstructions {

	public void setUpInstructions(
			final JungleMainMenuScreen jungleMainMenuScreen) {
		jungleMainMenuScreen.instructions = new EmptyActorLight(
				AppSettings.SCREEN_W, AppSettings.SCREEN_H, false);
		jungleMainMenuScreen.instructions.setTextureRegion(
				Assets.img_obj_rectangle, true);
		jungleMainMenuScreen.instructions.setPosition(0 - AppSettings.SCREEN_W,
				0);

		//
		jungleMainMenuScreen.getStage().addActor(
				jungleMainMenuScreen.instructions);
	}

	//
	public void sendInInstructions(
			final JungleMainMenuScreen jungleMainMenuScreen) {
		//
		float widthAsX = jungleMainMenuScreen.btnSwipeForMenu.getWidth();
		jungleMainMenuScreen.instructions.addAction(Actions.moveTo(
				0 - widthAsX, 0, 0.5f));
	}

	public void sendAwayInstructions(
			final JungleMainMenuScreen jungleMainMenuScreen) {
		//
		jungleMainMenuScreen.instructions.addAction(Actions.moveTo(
				0 - AppSettings.SCREEN_W, 0, 0.5f));
	}
}
