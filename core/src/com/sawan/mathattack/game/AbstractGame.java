/**
 * File name:	AbstractGame.java
 * Version:		1.0
 * Date:		@date 13:08:41
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

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.sawan.mathattack.android.IAndroidObject;
import com.sawan.mathattack.asset.AbstractAssets;
import com.sawan.mathattack.interfaces.IGame;
import com.sawan.mathattack.managers.MusicManager;
import com.sawan.mathattack.managers.SettingsManager;
import com.sawan.mathattack.screen.AbstractScreen;
import com.sawan.mathattack.settings.MtxLogger;
import com.sawan.mathattack.utils.UtilsDisposer;

// TODO: Auto-generated Javadoc
/**
 * Extends Game, implements IGame.
 */
public abstract class AbstractGame extends Game implements IGame {
	//
	/** The log tag. */
	protected final String logTag = "MtxAbstractGame";
	
	/** The log active. */
	public static boolean logActive = true;

	//
	/** The assets. */
	private AbstractAssets assets;
	
	/** The music manager. */
	private MusicManager musicManager;
	
	/** The android object. */
	private IAndroidObject androidObject;

	//
	/** The is initial screen set. */
	private boolean isInitialScreenSet;
	
	/** The previous screen to dispose. */
	private AbstractScreen previousScreenToDispose;
	
	/** The is dispose screen. */
	private boolean isDisposeScreen = false;

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.ApplicationListener#create()
	 */
	@Override
	public void create() {
		isInitialScreenSet = false;
		musicManager = new MusicManager();
		//
		setUpAppSettings();
		setUpAssets();
		setUpLoadingScreen();
		//
		SettingsManager.setSettings();
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.Game#resume()
	 */
	@Override
	public void resume() {
		super.resume();
		SettingsManager.setSettings();
	}

	/**
	 * Get android object from android backend.
	 *
	 * @return the android object
	 */
	public IAndroidObject getAndroidObject() {
		return androidObject;
	}

	/**
	 * Set android object from android backend.
	 *
	 * @param androidObject the new android object
	 */
	public void setAndroidObject(IAndroidObject androidObject) {
		this.androidObject = androidObject;
	}

	/**
	 * Get assets.
	 *
	 * @return the assets
	 */
	public AbstractAssets getAssets() {
		return assets;
	}

	/**
	 * Set assets.
	 *
	 * @param assets the new assets
	 */
	public void setAssets(AbstractAssets assets) {
		this.assets = assets;
	}

	/**
	 * Get true/false if initial screen is set.
	 *
	 * @return true, if is initial screen set
	 */
	public boolean isInitialScreenSet() {
		return isInitialScreenSet;
	}

	/**
	 * Set true/false if initial screen is set.
	 *
	 * @param isInitialScreenSet the new initial screen set
	 */
	public void setInitialScreenSet(boolean isInitialScreenSet) {
		this.isInitialScreenSet = isInitialScreenSet;
	}

	/**
	 * Get music manager, it uses "AudioManager" and communicates with
	 * "SettingsManager".
	 *
	 * @return the music manager
	 */
	public MusicManager getMusicManager() {
		return musicManager;
	}

	/**
	 * BETA method (Works fine, but need lots of test) <br>
	 * Screen to screen transition, only works for Scene2D Stage based game,
	 * actionCurrent is applied to current stage when it is completed
	 * (Sequence), actionNext is applied to new screens stage as intro for next
	 * screen
	 * <p>
	 * 
	 * WARNING! Do not use dispose anywhere else for stage/screen, if dispose
	 * true here.
	 *
	 * @param currentScreen            the screen currently set
	 * @param actionCurrent            Scene2D action to be applied to current screen stage
	 * @param nextScreen            the next screen to be set
	 * @param actionNext            Scene2D action to be applied to next screen stage
	 * @param disposeScreen            dispose current screen after transition completed
	 */
	public void setScreenWithTransition(final AbstractScreen currentScreen,
			final Action actionCurrent, final AbstractScreen nextScreen,
			final Action actionNext, final boolean disposeScreen) {
		//
		currentScreen.getStage().getRoot().setTouchable(Touchable.disabled);
		nextScreen.getStage().getRoot().setTouchable(Touchable.disabled);
		//
		previousScreenToDispose = currentScreen;
		if (actionCurrent != null && currentScreen != null) {
			currentScreen.getStage().addAction(
					Actions.sequence(actionCurrent, new Action() {
						@Override
						public boolean act(float delta) {
							if (actionNext != null) {
								setScreen(nextScreen);
								nextScreen.getStage().addAction(actionNext);
								nextScreen.getStage().getRoot()
										.setTouchable(Touchable.enabled);
								isDisposeScreen = disposeScreen;
							} else {
								setScreen(nextScreen);
								nextScreen.getStage().getRoot()
										.setTouchable(Touchable.enabled);
								isDisposeScreen = disposeScreen;
							}
							return true;
						}
					}));
		} else {
			if (actionNext != null) {
				setScreen(nextScreen);
				nextScreen.getStage().getRoot().setTouchable(Touchable.enabled);
				nextScreen.getStage().addAction(actionNext);
				isDisposeScreen = disposeScreen;
			} else {
				setScreen(nextScreen);
				nextScreen.getStage().getRoot().setTouchable(Touchable.enabled);
				isDisposeScreen = disposeScreen;
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.Game#render()
	 */
	@Override
	public void render() {
		super.render();

		// FIXME
		// Not very happy with this solution, look for better one
		if (isDisposeScreen) {
			if (previousScreenToDispose != null) {
				try {
					UtilsDisposer.disposeScreen(previousScreenToDispose);
					previousScreenToDispose = null;
					isDisposeScreen = false;
				} catch (Exception e) {
					// Worst case scenario, continue without disposing screen
					MtxLogger
							.log(logActive,
									true,
									logTag,
									"Failed to dispose previous screen after transition. DO NOT USE DISPOSE ANYWHERE ELSE");
					Gdx.app.log("MtxImportant", e.getMessage());
					previousScreenToDispose = null;
					isDisposeScreen = false;
				}
			}
		}

		// FIXME
		// Think about this solution later, not satisfied
		musicManager.checkShuffleMusicFinished();
	}
}
