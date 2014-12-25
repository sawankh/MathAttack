/**
 * File name:	VirtualViewport.java
 * Version:		1.0
 * Date:		@date 16:06:41
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
package com.sawan.mathattack.camera;

import com.badlogic.gdx.Gdx;

/**
 * The Class VirtualViewport.
 */
public class VirtualViewport {  
	  
    /** The virtual width. */
    float virtualWidth;  
    
    /** The virtual height. */
    float virtualHeight;  
  
    /**
     * Gets the virtual width.
     *
     * @return the virtual width
     */
    public float getVirtualWidth() {  
        return virtualWidth;  
    }  
  
    /**
     * Gets the virtual height.
     *
     * @return the virtual height
     */
    public float getVirtualHeight() {  
        return virtualHeight;  
    }  
  
    /**
     * Instantiates a new virtual viewport.
     *
     * @param virtualWidth the virtual width
     * @param virtualHeight the virtual height
     */
    public VirtualViewport(float virtualWidth, float virtualHeight) {  
        this(virtualWidth, virtualHeight, false);  
    }  
  
    /**
     * Instantiates a new virtual viewport.
     *
     * @param virtualWidth the virtual width
     * @param virtualHeight the virtual height
     * @param shrink the shrink
     */
    public VirtualViewport(float virtualWidth, float virtualHeight, boolean shrink) {  
        this.virtualWidth = virtualWidth;  
        this.virtualHeight = virtualHeight;  
    }  
  
    /**
     * Gets the width.
     *
     * @return the width
     */
    public float getWidth() {  
        return getWidth(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());  
    }  
  
    /**
     * Gets the height.
     *
     * @return the height
     */
    public float getHeight() {  
        return getHeight(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());  
    }  
  
    /**
     *  
     * Returns the view port width to let all the virtual view port to be shown on the screen. 
     *  
     *
     * @param screenWidth            The screen width. 
     * @param screenHeight            The screen Height.
     * @return the width
     */  
    public float getWidth(float screenWidth, float screenHeight) {  
        float virtualAspect = virtualWidth / virtualHeight;  
        float aspect = screenWidth / screenHeight;  
        if (aspect > virtualAspect || (Math.abs(aspect - virtualAspect) < 0.01f)) {  
            return virtualHeight * aspect;  
        } else {  
            return virtualWidth;  
        }  
    }  
  
    /**
     *  
     * Returns the view port height to let all the virtual view port to be shown on the screen. 
     *  
     *
     * @param screenWidth            The screen width. 
     * @param screenHeight            The screen Height.
     * @return the height
     */  
    public float getHeight(float screenWidth, float screenHeight) {  
        float virtualAspect = virtualWidth / virtualHeight;  
        float aspect = screenWidth / screenHeight;  
        if (aspect > virtualAspect || (Math.abs(aspect - virtualAspect) < 0.01f)) {  
            return virtualHeight;  
        } else {  
            return virtualWidth / aspect;  
        }  
    }  
  
}  