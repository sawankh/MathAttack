/**
 * File name:	MAGame.java
 * Version:		1.0
 * Date:		@date 15:35:56
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

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sawan.mathattack.screen.ScreenManager;
import com.sawan.mathattack.screen.game.MenuScreen;

/**
 * The Class MAGame.
 */
public class MAGame extends ApplicationAdapter {
	
	
	/** The Constant WIDTH. */
	public final static int WIDTH = 800;
	
	
	/** The Constant HEIGHT. */
	public final static int HEIGHT = 480;
	
	/** The batch. */
	SpriteBatch batch;
	
	/* (non-Javadoc)
	 * @see com.badlogic.gdx.ApplicationAdapter#create()
	 */
	@Override
	public void create () {
		batch = new SpriteBatch();
		ScreenManager.setCurrentScreen(new MenuScreen());
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.ApplicationAdapter#render()
	 */
	@Override
	public void render () {
		Gdx.gl.glClearColor(255, 255, 255, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		if (ScreenManager.getCurrentScreen() != null) {
			ScreenManager.getCurrentScreen().update();
		}
		
		if (ScreenManager.getCurrentScreen() != null) {
			ScreenManager.getCurrentScreen().render(batch);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.badlogic.gdx.ApplicationAdapter#dispose()
	 */
	@Override
	public void dispose() {
		if (ScreenManager.getCurrentScreen() != null) {
			ScreenManager.getCurrentScreen().dispose();
		}
		batch.dispose();
	}
	
	/* (non-Javadoc)
	 * @see com.badlogic.gdx.ApplicationAdapter#pause()
	 */
	@Override
	public void pause() {
		if (ScreenManager.getCurrentScreen() != null) {
			ScreenManager.getCurrentScreen().pause();
		}
	}
	
	/* (non-Javadoc)
	 * @see com.badlogic.gdx.ApplicationAdapter#resume()
	 */
	@Override
	public void resume() {
		if (ScreenManager.getCurrentScreen() != null) {
			ScreenManager.getCurrentScreen().resume();
		}
	}
	
	@Override
	public void resize(int width, int height) {
		if (ScreenManager.getCurrentScreen() != null) {
			ScreenManager.getCurrentScreen().resize(width, height);
		}
	}
	
	
}
