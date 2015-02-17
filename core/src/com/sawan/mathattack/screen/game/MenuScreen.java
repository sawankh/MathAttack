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
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.sawan.mathattack.camera.MultipleVirtualViewportBuilder;
import com.sawan.mathattack.camera.OrthoCamera;
import com.sawan.mathattack.camera.VirtualViewport;
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

	private Stage menu_screen_stage;

	private Skin skin;

	private MultipleVirtualViewportBuilder viewportBuilder;

	private void createBasicSkin() {
		// Create a font
		BitmapFont font = new BitmapFont();
		skin = new Skin();
		skin.add("default", font);

		// Create a texture
		Pixmap pixmap = new Pixmap((int) Gdx.graphics.getWidth() / 4,
				(int) Gdx.graphics.getHeight() / 10, Pixmap.Format.RGB888);
		pixmap.setColor(Color.WHITE);
		pixmap.fill();
		skin.add("background", new Texture(pixmap));

		// Create a button style
		TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
		textButtonStyle.up = skin.newDrawable("background", Color.GRAY);
		textButtonStyle.down = skin.newDrawable("background", Color.DARK_GRAY);
		textButtonStyle.checked = skin.newDrawable("background",
				Color.DARK_GRAY);
		textButtonStyle.over = skin.newDrawable("background", Color.LIGHT_GRAY);
		textButtonStyle.font = skin.getFont("default");
		skin.add("default", textButtonStyle);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sawan.mathattack.screen.Screen#create()
	 */
	@Override
	public void create() {

		viewportBuilder = new MultipleVirtualViewportBuilder(800, 480, 854, 600);
		VirtualViewport virtualViewport = viewportBuilder.getVirtualViewport(
				Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		camera = new OrthoCamera(virtualViewport);

		camera.position.set(0f, 0f, 0f);

		background_image = new Texture(BACKGROUND);
		sprite_background = new Sprite(background_image);
		menu_screen_stage = new Stage();

		createBasicSkin();

		final TextButton play_button = new TextButton("Play", skin);
		final TextButton about_button = new TextButton("About", skin);

		play_button.setWidth(200f);
		play_button.setHeight(20f);
		play_button.setPosition(Gdx.graphics.getWidth() / 2 - 100f,
				Gdx.graphics.getHeight() / 2 - 10f);

		about_button.setWidth(200f);
		about_button.setHeight(20f);
		about_button.setPosition(Gdx.graphics.getWidth() / 2 - 100f,
				Gdx.graphics.getHeight() / 2 - 50f);

		play_button.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// ScreenManager.setCurrentScreen(new MenuScreen());
			}
		});

		menu_screen_stage.addActor(play_button);
		menu_screen_stage.addActor(about_button);

		Gdx.input.setInputProcessor(menu_screen_stage);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sawan.mathattack.screen.Screen#render(com.badlogic.gdx.graphics.g2d
	 * .SpriteBatch)
	 */
	@Override
	public void render(SpriteBatch sprite_batch) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		menu_screen_stage.act(Gdx.graphics.getDeltaTime());

		sprite_batch.begin();
		sprite_batch.draw(sprite_background, 0, 0, camera.viewportWidth,
				camera.viewportHeight);
		sprite_batch.end();

		menu_screen_stage.draw();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sawan.mathattack.screen.Screen#resize(int, int)
	 */
	@Override
	public void resize(int width, int height) {
		VirtualViewport virtualViewport = viewportBuilder
				.getVirtualViewport(Gdx.graphics.getWidth(),
						Gdx.graphics.getHeight());
		camera.setVirtualViewport(virtualViewport);

		camera.updateViewport();
		// centers the camera at 0, 0 (the center of the virtual viewport)
		camera.position.set(0f, 0f, 0f);

		}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sawan.mathattack.screen.Screen#dispose()
	 */
	@Override
	public void dispose() {
		menu_screen_stage.dispose();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sawan.mathattack.screen.Screen#hide()
	 */
	@Override
	public void hide() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sawan.mathattack.screen.Screen#pause()
	 */
	@Override
	public void pause() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sawan.mathattack.screen.Screen#resume()
	 */
	@Override
	public void resume() {

	}

	@Override
	public void update() {
		// camera.update();
	}

}
