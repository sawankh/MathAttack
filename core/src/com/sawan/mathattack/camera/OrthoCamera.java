/**
 * File name:	OrthoCamera.java
 * Version:		1.0
 * Date:		@date 16:05:26
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

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.sawan.mathattack.MAGame;

/**
 * The Class OrthoCamera.
 */
public class OrthoCamera extends OrthographicCamera {

	/** The tmp. */
	Vector3 tmp = new Vector3();
	
	/** The origin. */
	Vector2 origin = new Vector2();
	
	/** The virtual viewport. */
	VirtualViewport virtualViewport;
	
	/** The pos. */
	Vector2 pos = new Vector2();

	/**
	 * Instantiates a new ortho camera.
	 */
	public OrthoCamera() {
		this(new VirtualViewport(MAGame.WIDTH, MAGame.HEIGHT));
	}
	
	/**
	 * Instantiates a new ortho camera.
	 *
	 * @param virtualViewport the virtual viewport
	 */
	public OrthoCamera(VirtualViewport virtualViewport) {
		this(virtualViewport, 0f, 0f);
	}

	/**
	 * Instantiates a new ortho camera.
	 *
	 * @param virtualViewport the virtual viewport
	 * @param cx the cx
	 * @param cy the cy
	 */
	public OrthoCamera(VirtualViewport virtualViewport, float cx, float cy) {
		this.virtualViewport = virtualViewport;
		this.origin.set(cx, cy);
	}

	/**
	 * Sets the virtual viewport.
	 *
	 * @param virtualViewport the new virtual viewport
	 */
	public void setVirtualViewport(VirtualViewport virtualViewport) {
		this.virtualViewport = virtualViewport;
	}
	
	/**
	 * Sets the position.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public void setPosition(float x, float y) {
		position.set(x - viewportWidth * origin.x, y - viewportHeight * origin.y, 0f);
		pos.set(x, y);
	}
	
	/**
	 * Gets the pos.
	 *
	 * @return the pos
	 */
	public Vector2 getPos() {
		return pos;
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.graphics.OrthographicCamera#update()
	 */
	@Override
	public void update() {
		float left = zoom * -viewportWidth / 2 + virtualViewport.getVirtualWidth() * origin.x;
		float right = zoom * viewportWidth / 2 + virtualViewport.getVirtualWidth() * origin.x;
		float top = zoom * viewportHeight / 2 + virtualViewport.getVirtualHeight() * origin.y;
		float bottom = zoom * -viewportHeight / 2 + virtualViewport.getVirtualHeight() * origin.y;

		projection.setToOrtho(left, right, bottom, top, Math.abs(near), Math.abs(far));
		view.setToLookAt(position, tmp.set(position).add(direction), up);
		combined.set(projection);
		Matrix4.mul(combined.val, view.val);
		invProjectionView.set(combined);
		Matrix4.inv(invProjectionView.val);
		frustum.update(invProjectionView);
	}

	/**
	 * This must be called in ApplicationListener.resize() in order to correctly update the camera viewport. 
	 */
	public void updateViewport() {
		setToOrtho(false, virtualViewport.getWidth(), virtualViewport.getHeight());
	}
	
	/**
	 * Unproject coordinates.
	 *
	 * @param x the x
	 * @param y the y
	 * @return the vector2
	 */
	public Vector2 unprojectCoordinates(float x, float y) {
        Vector3 rawtouch = new Vector3(x, y,0);
        unproject(rawtouch); 
        return new Vector2(rawtouch.x, rawtouch.y);
    }
	
	/**
	 * Resize.
	 */
	public void resize() {
		VirtualViewport virtualViewport = new VirtualViewport(MAGame.WIDTH, MAGame.HEIGHT);  
		setVirtualViewport(virtualViewport);  
		updateViewport();
	}
}
