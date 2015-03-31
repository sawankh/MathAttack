/**
 * File name:	GameAssets.java
 * Version:		1.0
 * Date:		28/03/2015 16:16:01
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

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.sawan.mathattack.animation.AnimationCreator;

// TODO: Auto-generated Javadoc
/**
 * The Class GameAssets.
 *
 * @author Sawan
 */
public class GameAssets {
	
	/** The Constant FILE_IMAGE_ATLAS. */
	private final static String FILE_IMAGE_ATLAS = "data/ma/game/game/Game_assets.atlas";
	
	/** The Constant FILE_UI_SKIN. */
	private final static String FILE_UI_SKIN = "skin/uiskin.json";
	
	/** The atlas. */
	public static TextureAtlas atlas;
	
	/** The skin. */
	public static Skin skin;
	
	// Assets
	/** The heart. */
	public static Animation heart;
	
	/** The eraser. */
	public static TextureRegion eraser;
	
	/** The scissors. */
	public static TextureRegion scissors;
	
	/** The pencil. */
	public static TextureRegion pencil;
	
	/** The ruler. */
	public static TextureRegion ruler;
	
	/** The semicircle. */
	public static TextureRegion semicircle;
	
	/** The trianguler. */
	public static TextureRegion trianguler;
	
	/** The pause. */
	public static TextureRegion pause;
	
	/** The projectiles. */
	public static ArrayList<TextureRegion> projectiles;
	
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
		projectiles = new ArrayList<TextureRegion>();
		
		eraser = getAtlas().findRegion("eraser");
		pencil = getAtlas().findRegion("pencil");
		ruler = getAtlas().findRegion("ruler");
		scissors = getAtlas().findRegion("scissors");
		trianguler = getAtlas().findRegion("trianguler");
		semicircle = getAtlas().findRegion("semicircle");
		
		projectiles.add(eraser);
		projectiles.add(pencil);
		projectiles.add(ruler);
		projectiles.add(scissors);
		projectiles.add(trianguler);
		projectiles.add(semicircle);
	}

	/**
	 * Load buttons.
	 */
	public static void loadButtons() {
		pause = getAtlas().findRegion("pause");
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
		heart = AnimationCreator.getAnimationFromMultiTextures(getAtlas(), "heart", 8, 0.3f, false, false);
	}

	/**
	 * Load sounds and musics.
	 */
	public static void loadSoundsAndMusics() {
	
	}
	
	/**
	 * Load random projectile.
	 *
	 * @return the texture region
	 */
	public static TextureRegion loadRandomProjectile() {
		Random rnd = new Random();
		
		int index = rnd.nextInt(projectiles.size());
		TextureRegion projectile = projectiles.get(index);
		
		return projectile;
	}
}
