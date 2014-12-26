/**
 * File name:	MenuScreen.java
 * Version:		1.0
 * Date:		25/12/2014 17:02:27
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
package com.sawan.mathattack.screen.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sawan.mathattack.camera.OrthoCamera;
import com.sawan.mathattack.screen.Screen;

/**
 * The Class MenuScreen.
 *
 * @author Sawan J. Kapai Harpalani
 */
public class MenuScreen extends Screen {
	
	private OrthoCamera camera;

	private final static String BACKGROUND = "menu_back.jpg";
	
	private Texture background_image;
	
	private Sprite sprite_background;
	
	private BitmapFont font;
	
	/* (non-Javadoc)
	 * @see com.sawan.mathattack.screen.Screen#create()
	 */
	@Override
	public void create() {
		camera = new OrthoCamera();
		background_image = new Texture(BACKGROUND);
		sprite_background = new Sprite(background_image);
		font = new BitmapFont();
	}

	/* (non-Javadoc)
	 * @see com.sawan.mathattack.screen.Screen#render(com.badlogic.gdx.graphics.g2d.SpriteBatch)
	 */
	@Override
	public void render(SpriteBatch sprite_batch) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sprite_batch.begin();
		sprite_batch.draw(sprite_background, 0, 0, camera.viewportWidth, camera.viewportHeight);
		font.draw(sprite_batch, "Hello World!", 100, 150);
		sprite_batch.end();
	}

	/* (non-Javadoc)
	 * @see com.sawan.mathattack.screen.Screen#resize(int, int)
	 */
	@Override
	public void resize(int width, int height) {
		camera.resize();
	}

	/* (non-Javadoc)
	 * @see com.sawan.mathattack.screen.Screen#dispose()
	 */
	@Override
	public void dispose() {
		
	}

	/* (non-Javadoc)
	 * @see com.sawan.mathattack.screen.Screen#hide()
	 */
	@Override
	public void hide() {
		
	}

	/* (non-Javadoc)
	 * @see com.sawan.mathattack.screen.Screen#pause()
	 */
	@Override
	public void pause() {
		
	}

	/* (non-Javadoc)
	 * @see com.sawan.mathattack.screen.Screen#resume()
	 */
	@Override
	public void resume() {
		
	}

	@Override
	public void update() {
		//camera.update();
	}

}
