/**
 * File name:	AbstractScreen.java
 * Version:		1.0
 * Date:		@date 13:16:13
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

package com.sawan.mathattack.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;
import com.sawan.mathattack.game.AbstractGame;
import com.sawan.mathattack.settings.AppSettings;
import com.sawan.mathattack.settings.MtxLogger;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractScreen.
 */
public abstract class AbstractScreen implements Screen {
	//
	/** The Constant logTag. */
	protected static final String logTag = "MtxScreenLog";
	
	/** The log active. */
	public static boolean logActive = true;

	// Game reference
	/** The game. */
	private AbstractGame game;

	// Initial
	/** The screen name. */
	private String screenName = "Untitled Screen";
	
	/** The stage. */
	private final Stage stage;

	// Screen second counter (1 second tick)
	/** The start time. */
	private long startTime = System.nanoTime();
	
	/** The seconds time. */
	private long secondsTime = 0L;

	// Animation timer (If any animation is used)
	/** The state time. */
	private float stateTime = 0.0f;

	// Custom back button
	/** The is back button active. */
	private boolean isBackButtonActive = false;

	// Bg color
	/** The color r. */
	private float colorR = 0.0f;
	
	/** The color g. */
	private float colorG = 0.0f;
	
	/** The color b. */
	private float colorB = 0.0f;
	
	/** The alpha. */
	private float alpha = 1.0f;

	/**
	 * Construct the screen
	 * <p>
	 * -Gives reference to game<br>
	 * -Creates stage<br>
	 * -Centers camera of stage<br>
	 * -Sets Input processor for stage (Gdx.input.setInputProcessor(stage))<br>
	 * -Calls setUpScreenElements (Good place the set views and iniatial
	 * elements)
	 * 
	 * @param game
	 *            the main game class
	 * @param screenName
	 *            the name of the screen
	 * */
	public AbstractScreen(AbstractGame game, String screenName) {
		super();
		//
		this.game = game;
		this.screenName = screenName;
		//
		if (!AppSettings.isAppSettingSet) {
			MtxLogger
					.log(logActive,
							true,
							logTag,
							"WARNING!: "
									+ "AppSettings.setUp() not called anywhere, Stage size will be 0,0");
		}
		//
		stage = new Stage(AppSettings.SCREEN_W, AppSettings.SCREEN_H, false);
		stage.getCamera().position.set(AppSettings.SCREEN_W / 2,
				AppSettings.SCREEN_H / 2, 0);

		// Receive inputs from stage
		Gdx.input.setInputProcessor(stage);

		// INFO LOG
		MtxLogger.log(logActive, true, logTag, "Scene2D Stage Constructed: "
				+ AppSettings.SCREEN_W + " - " + AppSettings.SCREEN_H);
		MtxLogger.log(logActive, true, logTag, "SCREEN CONSTRUCTED: "
				+ getScreenName());
		//
		setOpenGLClearColor(1, 0, 0, 1);
		setBackBackButton();
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.Screen#render(float)
	 */
	@Override
	public void render(float delta) {
		// Update screen clock (1 second tick)
		// ############################################################
		if (System.nanoTime() - startTime >= 1000000000) {
			secondsTime++;
			startTime = System.nanoTime();
		}

		// Update animation times
		// ############################################################
		stateTime += delta;

		// Snippet
		// ############################################################
		Gdx.gl.glClearColor(colorR, colorG, colorB, alpha);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// Update stage/actors logic (update() method in previous games)
		// ############################################################
		stage.act(delta);

		// Render drawings (draw()/render() methods in previous games)
		// ############################################################
		stage.draw();
		Table.drawDebug(stage);
	}

	/**
	 * Set stage background. Sets the image (Adds to stage as image)
	 *
	 * @param textureBackground the new background texture
	 */
	public void setBackgroundTexture(TextureRegion textureBackground) {
		Drawable tBg = new TextureRegionDrawable(textureBackground);
		Image imgbg = new Image(tBg, Scaling.stretch);
		imgbg.setFillParent(true);
		stage.addActor(imgbg);
		//
		MtxLogger.log(logActive, true, logTag, "SCREEN BG IMAGE SET: "
				+ getScreenName());
	}

	/**
	 * Set the back button active for the screen. Sets
	 * "Gdx.input.setCatchBackKey(true)" and override the method
	 * "keyBackPressed" to add desired functionality to back button
	 * 
	 * @param isBackButtonActive
	 *            to use or not to use the back button
	 * @see keyBackPressed
	 * 
	 * */
	public void setBackButtonActive(boolean isBackButtonActive) {
		Gdx.input.setCatchBackKey(isBackButtonActive);
		this.isBackButtonActive = isBackButtonActive;
		//
		MtxLogger.log(logActive, true, logTag, "SCREEN BACK BUTTON SET: "
				+ getScreenName());
	}

	/**
	 * Back button.
	 */
	private void setBackBackButton() {
		stage.addListener(new InputListener() {
			@Override
			public boolean keyUp(InputEvent event, int keycode) {
				if (keycode == Keys.BACK || keycode == Keys.ESCAPE) {
					if (isBackButtonActive) {
						keyBackPressed();
					}
				}
				return false;
			}
		});
	}

	/**
	 * Override this method to do some function when back button pressed, only
	 * works if setBackButtonActive(true).
	 */
	public void keyBackPressed() {

	}

	/**
	 * Get the game class.
	 *
	 * @return the game
	 */
	public AbstractGame getGame() {
		return game;
	}

	/**
	 * Set the game class.
	 *
	 * @param game the new game
	 */
	public void setGame(AbstractGame game) {
		this.game = game;
	}

	/**
	 * Get screen name.
	 *
	 * @return the screen name
	 */
	public String getScreenName() {
		return screenName;
	}

	/**
	 * Set screen name.
	 *
	 * @param screenName the new screen name
	 */
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	/**
	 * Get screen name.
	 *
	 * @return the start time
	 */
	public float getStartTime() {
		return startTime;
	}

	/**
	 * Get seconds since this screen constructed (EX: 3345 seconds).
	 *
	 * @return the seconds time
	 */
	public long getSecondsTime() {
		return secondsTime;
	}

	/**
	 * Set or reset sceconds.
	 *
	 * @param secondsTime the new seconds time
	 */
	public void setSecondsTime(long secondsTime) {
		this.secondsTime = secondsTime;
	}

	/**
	 * Get delta added state time (Generally used for animations).
	 *
	 * @return the state time
	 */
	public float getStateTime() {
		return stateTime;
	}

	/**
	 * Set state time.
	 *
	 * @param stateTime the new state time
	 */
	public void setStateTime(float stateTime) {
		this.stateTime = stateTime;
	}

	/**
	 * Get if back button active.
	 *
	 * @return true, if is back button active
	 */
	public boolean isBackButtonActive() {
		return isBackButtonActive;
	}

	/**
	 * Get stage of the screen.
	 *
	 * @return the stage
	 */
	public Stage getStage() {
		return stage;
	}

	/**
	 * Get screen time from start in format of HH:MM:SS. It is calculated from
	 * "secondsTime" parameter, reset that to get resetted time.
	 *
	 * @return the screen time
	 */
	public String getScreenTime() {
		int seconds = (int) (secondsTime % 60);
		int minutes = (int) ((secondsTime / 60) % 60);
		int hours = (int) ((secondsTime / 3600) % 24);
		String secondsStr = (seconds < 10 ? "0" : "") + seconds;
		String minutesStr = (minutes < 10 ? "0" : "") + minutes;
		String hoursStr = (hours < 10 ? "0" : "") + hours;
		return new String(hoursStr + ":" + minutesStr + ":" + secondsStr);
	}

	/**
	 * Gets the asset manager.
	 *
	 * @return the asset manager
	 */
	public AssetManager getAssetManager() {
		return game.getAssets().getAssetManager();
	}

	/**
	 * Set background color with OpenGL.
	 *
	 * @param r the r
	 * @param g the g
	 * @param b the b
	 * @param alpha the alpha
	 */
	public void setOpenGLClearColor(float r, float g, float b, float alpha) {
		this.colorR = r;
		this.colorG = g;
		this.colorB = b;
		this.alpha = alpha;
	}

	/**
	 * Gets the color r.
	 *
	 * @return the color r
	 */
	public float getColorR() {
		return colorR;
	}

	/**
	 * Sets the color r.
	 *
	 * @param colorR the new color r
	 */
	public void setColorR(float colorR) {
		this.colorR = colorR;
	}

	/**
	 * Gets the color g.
	 *
	 * @return the color g
	 */
	public float getColorG() {
		return colorG;
	}

	/**
	 * Sets the color g.
	 *
	 * @param colorG the new color g
	 */
	public void setColorG(float colorG) {
		this.colorG = colorG;
	}

	/**
	 * Gets the color b.
	 *
	 * @return the color b
	 */
	public float getColorB() {
		return colorB;
	}

	/**
	 * Sets the color b.
	 *
	 * @param colorB the new color b
	 */
	public void setColorB(float colorB) {
		this.colorB = colorB;
	}

	/**
	 * Gets the alpha.
	 *
	 * @return the alpha
	 */
	public float getAlpha() {
		return alpha;
	}

	/**
	 * Sets the alpha.
	 *
	 * @param alpha the new alpha
	 */
	public void setAlpha(float alpha) {
		this.alpha = alpha;
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.Screen#resize(int, int)
	 */
	@Override
	public void resize(int width, int height) {
		MtxLogger.log(logActive, true, logTag, "SCREEN RESIZE: "
				+ getScreenName());
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.Screen#show()
	 */
	@Override
	public void show() {
		MtxLogger.log(logActive, true, logTag, "SCREEN SHOW: "
				+ getScreenName());
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.Screen#hide()
	 */
	@Override
	public void hide() {
		MtxLogger.log(logActive, true, logTag, "SCREEN HIDE: "
				+ getScreenName());
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.Screen#pause()
	 */
	@Override
	public void pause() {
		MtxLogger.log(logActive, true, logTag, "SCREEN PAUSE: "
				+ getScreenName());
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.Screen#resume()
	 */
	@Override
	public void resume() {
		MtxLogger.log(logActive, true, logTag, "SCREEN RESUME: "
				+ getScreenName());
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.Screen#dispose()
	 */
	@Override
	public void dispose() {
		MtxLogger.log(logActive, true, logTag, "SCREEN DISPOSE: "
				+ getScreenName());
	}
}
