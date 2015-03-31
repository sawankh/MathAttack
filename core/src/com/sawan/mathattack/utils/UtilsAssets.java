/**
 * File name:	UtilsAssets.java
 * Version:		1.0
 * Date:		@date 13:16:37
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
package com.sawan.mathattack.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;

// TODO: Auto-generated Javadoc
/**
 * The Class UtilsAssets.
 */
public class UtilsAssets {

	/**
	 * LinearLinear - Smooth edges (Avoid pixelation as much as possible) </br>
	 * NearestNeatrest - For pixel perfect games </br> MipMapping - requires
	 * power of 2 textures/texture atlas, however it is the best quality at
	 * performace cost </br>.
	 */
	public enum Filter {
		
		/** The Linear_ linear. */
		Linear_Linear, 
 /** The Linear_ nearest. */
 Linear_Nearest, 
 /** The Nearest_ nearest. */
 Nearest_Nearest, 
 /** The Nearest_ linear. */
 Nearest_Linear, 
 /** The Mip map l n_ l. */
 MipMapLN_L
	}

	/**
	 * Load/Get a texture from internal file (Leave filter null if no filter
	 * needed).
	 *
	 * @param file            internal file location
	 * @param filter            quick filter apply (leave null if no filter needed)
	 * @return the texture
	 */
	public static Texture loadTexture(String file, Filter filter) {
		Texture t = new Texture(Gdx.files.internal(file));
		if (filter != null)
			addFilter(t, filter);
		return t;
	}

	/**
	 * Load a font. Input file path without format type. Works only with ".png"
	 * and ".fnt". (Leave filter null if no filter needed).
	 * <p>
	 * 
	 * EXAMPLE:</br> User input for file: "data/font" </br> Auto fill will
	 * perform "font.png" and "font.fnt" for user.
	 *
	 * @param file the file
	 * @param flip the flip
	 * @param filter the filter
	 * @return the bitmap font
	 */
	public static BitmapFont loadFont(String file, boolean flip, Filter filter) {
		BitmapFont f = new BitmapFont(Gdx.files.internal(file + ".fnt"),
				Gdx.files.internal(file + ".png"), flip);
		if (filter != null)
			addFilter(f.getRegion().getTexture(), filter);
		return f;
	}

	/**
	 * Load a particle.
	 *
	 * @param file the file
	 * @param imageMainDir the image main dir
	 * @return the particle effect
	 */
	public static ParticleEffect loadParticle(String file, String imageMainDir) {
		ParticleEffect pe = new ParticleEffect();
		pe.load(Gdx.files.internal(file + ".p"),
				Gdx.files.internal(imageMainDir));
		return pe;
	}

	/**
	 *  Apply a filter to a texture.
	 *
	 * @param t the t
	 * @param filter the filter
	 */
	public static void addFilter(Texture t, Filter filter) {
		switch (filter) {
		case Linear_Linear:
			t.setFilter(TextureFilter.Linear, TextureFilter.Linear);
			break;
		case Linear_Nearest:
			t.setFilter(TextureFilter.Linear, TextureFilter.Nearest);
			break;
		case Nearest_Nearest:
			t.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
			break;
		case Nearest_Linear:
			t.setFilter(TextureFilter.Nearest, TextureFilter.Linear);
			break;
		case MipMapLN_L:
			t.setFilter(TextureFilter.MipMapLinearNearest, TextureFilter.Linear);
			break;
		default:
			t.setFilter(TextureFilter.Linear, TextureFilter.Nearest);
			break;
		}
	}
}
