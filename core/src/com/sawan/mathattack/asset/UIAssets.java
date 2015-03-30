/**
 * File name:	Assets.java
 * Version:		1.0
 * Date:		01/03/2015 19:33:18
 * Author:		Sawan
 * Copyright:	Copyright 200X Sawan
 *
 *				This file is part of Foobar.
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
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

// TODO: Auto-generated Javadoc
/**
 * The Class Assets.
 *
 * @author Sawan
 */
public class UIAssets {

	/** The Constant FILE_IMAGE_ATLAS. */
	private final static String FILE_IMAGE_ATLAS = "data/ma/game/ui/UI_assets.atlas";
	
	/** The Constant FILE_UI_SKIN. */
	private final static String FILE_UI_SKIN = "skin/uiskin.json";
	
	/** The Constant CARTWHEEL_FONT_FILE. */
	private final static String CARTWHEEL_FONT_FILE = "skin/cartwheel.fnt";
	
	/** The Constant FILE_IMAGE_BACKGROUND_MAIN. */
	//private final static String FILE_IMAGE_BACKGROUND_MAIN = "data/ma/game/menu_background.png";
	
	/** The atlas. */
	public static TextureAtlas atlas;
	
	/** The skin. */
	public static Skin skin;
	
	// Assets
	
	/** The image_main_button_play. */
	public static TextureRegion image_main_button_play;
	
	/** The image_main_button_settings. */
	public static TextureRegion image_main_button_settings;
	
	/** The image_main_button_credits. */
	public static TextureRegion image_main_button_credits;
	
	/** The image_main_loader. */
	public static TextureRegion image_main_loader;
	
	/** The image_main_title. */
	public static TextureRegion image_main_title;
	
	/** The button_level. */
	public static TextureRegion button_level;
	
	/** The image_level_table. */
	public  static TextureRegion image_level_table;
	
	/** The image_level_star. */
	public static TextureRegion image_level_star;
	
	/** The image_level_no_star. */
	public static TextureRegion image_level_no_star;
	
	/** The cartwheel_font. */
	public static BitmapFont cartwheel_font;
	
	public static TextureRegion image_empty_bg;
	
	public static TextureRegion image_pause_bg;
	
	public static TextureRegion button_restart;
	
	public static TextureRegion button_resume;
	
	public static TextureRegion button_exit;
	
	public static TextureRegion button_back_levels;
	
	public static TextureRegion image_level_complete_bg;
	
	public static TextureRegion image_star_right_completed;
	
	public static TextureRegion image_star_central_completed;
	
	public static TextureRegion image_star_left_completed;

	public static TextureRegion image_star_right_incompleted;
	
	public static TextureRegion image_star_central_incompleted;
	
	public static TextureRegion image_star_left_incompleted;
	
	public static TextureRegion image_home_icon;

	
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
		image_main_button_play = getAtlas().findRegion("play_button");
		image_main_button_credits = getAtlas().findRegion("credits_button");
		image_main_button_settings = getAtlas().findRegion("settings_button");
		image_main_loader = getAtlas().findRegion("loader");
		image_main_title = getAtlas().findRegion("title");
		image_level_table = getAtlas().findRegion("levels_bg");
		image_level_star = getAtlas().findRegion("star_level");
		image_level_no_star = getAtlas().findRegion("no_star_level");
		image_empty_bg = getAtlas().findRegion("empty_bg");
		image_pause_bg = getAtlas().findRegion("pause_bg");
		image_level_complete_bg = getAtlas().findRegion("level_completed_bg");
		image_star_right_completed = getAtlas().findRegion("star_right_completed");
		image_star_central_completed = getAtlas().findRegion("star_middle_completed");
		image_star_left_completed = getAtlas().findRegion("star_left_completed");
		image_star_right_incompleted = getAtlas().findRegion("right_no_star");
		image_star_central_incompleted = getAtlas().findRegion("central_no_star");
		image_star_left_incompleted = getAtlas().findRegion("left_no_star");
		image_home_icon = getAtlas().findRegion("home_icon");
	}

	/**
	 * Load buttons.
	 */
	public static void loadButtons() {
		button_level = getAtlas().findRegion("level_button");
		button_restart = getAtlas().findRegion("restart_button");
		button_resume = getAtlas().findRegion("resume_button");
		button_exit = getAtlas().findRegion("exit_button");
		button_back_levels = getAtlas().findRegion("levels_button");
	}

	/**
	 * Load fonts.
	 */
	public static void loadFonts() {
		cartwheel_font = new BitmapFont(Gdx.files.internal(CARTWHEEL_FONT_FILE));
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
