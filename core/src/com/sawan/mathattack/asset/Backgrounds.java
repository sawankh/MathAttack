/**
 * File name:	Backgrounds.java
 * Version:		1.0
 * Date:		14/03/2015 17:26:37
 * Author:		Sawan
 * Copyright:	Copyright 200X Sawan
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
package com.sawan.mathattack.asset;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/**
 * @author Sawan
 *
 */
public class Backgrounds {
	/** The Constant FILE_IMAGE_ATLAS. */
	private final static String FILE_IMAGE_ATLAS = "data/ma/game/backgrounds/backgrounds.atlas";
	
	/** The Constant FILE_UI_SKIN. */
	private final static String FILE_UI_SKIN = "skin/uiskin.json";
	
	/** The Constant FILE_IMAGE_BACKGROUND_MAIN. */
	//private final static String FILE_IMAGE_BACKGROUND_MAIN = "data/ma/game/menu_background.png";
	
	/** The atlas. */
	public static TextureAtlas atlas;
	
	/** The skin. */
	public static Skin skin;
	
	// Assets
	/** The image_main_background. */
	public static TextureRegion image_main_background;
	
	/** The image_level_background. */
	public static TextureRegion image_level_background;

	
	
	/**
	 * Loads texture file.
	 *
	 * @param file the file
	 * @return the texture
	 */
	public static Texture loadTexture(String file) {
		return new Texture(Gdx.files.internal(file));
	}
	
	/**
	 * Gets the atlas. Creates a texture atlas if is not created. 
	 *
	 * @return the atlas
	 */
	public static TextureAtlas getAtlas() {
		if (atlas == null) { 
			atlas =  new TextureAtlas(Gdx.files.internal(FILE_IMAGE_ATLAS));
		}
	
		return atlas;
	}
	
	/**
	 * Gets the skin.
	 *
	 * @return the skin
	 */
	public static Skin getSkin() {
		if (skin == null) {
			FileHandle skinFile = Gdx.files.internal(FILE_UI_SKIN);
			skin = new Skin(skinFile);
		}
		
		return skin;
	}
	
	/**
	 * Load all. Loads all the resources.
	 */
	public static void loadAll() {
		relaseResources();
		loadImages();
		loadButtons();
		loadFonts();
		loadAnimations();
		loadSoundsAndMusics();
	}

	/**
	 * Relase resources.
	 */
	private static void relaseResources() {
		skin = null;
		atlas = null;
	}

	/**
	 * Load images.
	 */
	public static void loadImages() {
		image_main_background = getAtlas().findRegion("menu_background");
		image_level_background = getAtlas().findRegion("backgrounds2");
	}

	/**
	 * Load buttons.
	 */
	public static void loadButtons() {

	}

	/**
	 * Load fonts.
	 */
	public static void loadFonts() {

	}

	/**
	 * Load animations.
	 */
	public static void loadAnimations() {

	}

	/**
	 * Load sounds and musics.
	 */
	public static void loadSoundsAndMusics() {
	
	}
	
}
