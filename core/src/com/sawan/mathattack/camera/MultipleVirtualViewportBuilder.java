/**
 * File name:	MultipleVirtualViewportBuilder.java
 * Version:		1.0
 * Date:		17/02/2015 15:14:52
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
package com.sawan.mathattack.camera;

// TODO: Auto-generated Javadoc
/**
 * The Class MultipleVirtualViewportBuilder.
 *
 * @author Sawan
 */
public class MultipleVirtualViewportBuilder {  
	  
    /** The min width. */
    private final float minWidth;  
    
    /** The min height. */
    private final float minHeight;  
    
    /** The max width. */
    private final float maxWidth;  
    
    /** The max height. */
    private final float maxHeight;  
  
    /**
     * Instantiates a new multiple virtual viewport builder.
     *
     * @param minWidth the min width
     * @param minHeight the min height
     * @param maxWidth the max width
     * @param maxHeight the max height
     */
    public MultipleVirtualViewportBuilder(float minWidth, float minHeight, float maxWidth, float maxHeight) {  
        this.minWidth = minWidth;  
        this.minHeight = minHeight;  
        this.maxWidth = maxWidth;  
        this.maxHeight = maxHeight;  
    }  
  
    /**
     * Gets the virtual viewport.
     *
     * @param width the width
     * @param height the height
     * @return the virtual viewport
     */
    public VirtualViewport getVirtualViewport(float width, float height) {  
        if (width >= minWidth && width <= maxWidth && height >= minHeight && height <= maxHeight)  
            return new VirtualViewport(width, height, true);  
  
        float aspect = width / height;  
  
        float scaleForMinSize = minWidth / width;  
        float scaleForMaxSize = maxWidth / width;  
  
        float virtualViewportWidth = width * scaleForMaxSize;  
        float virtualViewportHeight = virtualViewportWidth / aspect;  
  
        if (insideBounds(virtualViewportWidth, virtualViewportHeight))  
            return new VirtualViewport(virtualViewportWidth, virtualViewportHeight, false);  
  
        virtualViewportWidth = width * scaleForMinSize;  
        virtualViewportHeight = virtualViewportWidth / aspect;  
  
        if (insideBounds(virtualViewportWidth, virtualViewportHeight))  
            return new VirtualViewport(virtualViewportWidth, virtualViewportHeight, false);  
          
        return new VirtualViewport(minWidth, minHeight, true);  
    }  
      
    /**
     * Inside bounds.
     *
     * @param width the width
     * @param height the height
     * @return true, if successful
     */
    private boolean insideBounds(float width, float height) {  
        if (width < minWidth || width > maxWidth)  
            return false;  
        if (height < minHeight || height > maxHeight)  
            return false;  
        return true;  
    }  
  
}  
