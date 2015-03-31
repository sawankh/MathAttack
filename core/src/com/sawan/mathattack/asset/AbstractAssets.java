/**
 * File name:	AbstractAssets.java
 * Version:		1.0
 * Date:		@date 13:08:09
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

package com.sawan.mathattack.asset;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.sawan.mathattack.settings.MtxLogger;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractAssets.
 */
public abstract class AbstractAssets implements AssetErrorListener {
	//
	/** The log tag. */
	protected final String logTag = "MtxAssetsLog";
	
	/** The log active. */
	public static boolean logActive = true;
	//
	/** The asset manager. */
	private AssetManager assetManager;
	
	/** The texture atlas. */
	private TextureAtlas textureAtlas;
	
	/** The skin. */
	private Skin skin;

	/**
	 * Instantiates a new abstract assets.
	 */
	public AbstractAssets() {
		assetManager = new AssetManager();
		skin = new Skin();
	}

	/**
	 * Gets the asset manager.
	 *
	 * @return the asset manager
	 */
	public AssetManager getAssetManager() {
		return assetManager;
	}

	/**
	 * Sets the asset manager.
	 *
	 * @param assetManager the new asset manager
	 */
	public void setAssetManager(AssetManager assetManager) {
		this.assetManager = assetManager;
	}

	/**
	 * Gets the texture atlas.
	 *
	 * @return the texture atlas
	 */
	public TextureAtlas getTextureAtlas() {
		return textureAtlas;
	}

	/**
	 * Sets the texture atlas.
	 *
	 * @param textureAtlas the new texture atlas
	 */
	public void setTextureAtlas(TextureAtlas textureAtlas) {
		this.textureAtlas = textureAtlas;
	}

	/**
	 * Gets the skin.
	 *
	 * @return the skin
	 */
	public Skin getSkin() {
		return skin;
	}

	/**
	 * Sets the skin.
	 *
	 * @param skin the new skin
	 */
	public void setSkin(Skin skin) {
		this.skin = skin;
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.assets.AssetErrorListener#error(com.badlogic.gdx.assets.AssetDescriptor, java.lang.Throwable)
	 */
	@Override
    public void error (AssetDescriptor asset, Throwable throwable) {
		Gdx.app.error("AssetManager", "couldn't load asset '" + asset.fileName);
	}

	/**
	 * Log asset manager progress.
	 */
	public void logAssetManagerProgress() {
		MtxLogger.log(logActive, true, logTag, "Assets Loading: "
				+ getAssetManager().getProgress());
	}
}
