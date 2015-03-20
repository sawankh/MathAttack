/**
 * File name:	UtilsPositioner.java
 * Version:		1.0
 * Date:		@date 13:17:10
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

import com.badlogic.gdx.scenes.scene2d.Actor;

public class UtilsPositioner {
	public enum Position {
		SAME, CENTER, LEFT, TOP_LEFT, TOP_LEFT_CENTER, TOP_RIGHT, TOP_RIGHT_CENTER, BOTTOM_CENTER, BOTTOM_LEFT, BOTTOM_LEFT_CENTER, BOTTOM_RIGHT, BOTTOM_RIGHT_CENTER, RIGHT_CENTER, TOP_CENTER
	}

	/**
	 * Set position of an actor due to another actor's position, , since actors
	 * are complex objects, its variables pointing same reference with copies,
	 * so the position will be set in original object
	 * 
	 * 
	 * @param actorToBePositioned
	 *            actor to be positioned
	 * @param actorStable
	 *            actor to get position data
	 * @param position
	 *            the position to set, comes from Position enum class
	 * */
	public static void setActorPoisiton(Actor actorToBePositioned,
			Actor actorStable, Position position) {

		float atp_W = actorToBePositioned.getWidth();
		float atp_H = actorToBePositioned.getHeight();
		float as_X = actorStable.getX();
		float as_Y = actorStable.getY();
		float as_XW = actorStable.getWidth() + as_X;
		float as_YH = actorStable.getHeight() + as_Y;

		setPosition(actorToBePositioned, atp_W, atp_H, as_X, as_Y, as_XW,
				as_YH, position);
	}

	/**
	 * Set actor position in a world/screen/stage/viewport etc...
	 * 
	 * @param actorToBePositioned
	 *            actor to be positioned
	 * @param x
	 *            world x position
	 * @param y
	 *            world y position
	 * @param width
	 *            world width
	 * @param height
	 *            world height
	 * @param position
	 *            the position to set, comes from Position enum class
	 * */
	public static void setActorPoisiton(Actor actorToBePositioned, float x,
			float y, float width, float height, Position position) {

		float atp_W = actorToBePositioned.getWidth();
		float atp_H = actorToBePositioned.getHeight();
		float as_X = x;
		float as_Y = y;
		float as_XW = width + as_X;
		float as_YH = height + as_Y;

		setPosition(actorToBePositioned, atp_W, atp_H, as_X, as_Y, as_XW,
				as_YH, position);
	}

	/** Advanced positioner */
	private static void setPosition(Actor actorToBePositioned, float atp_W,
			float atp_H, float as_X, float as_Y, float as_XW, float as_YH,
			Position position) {

		// FIXME
		// No 0.0 should be used, use as_xw and others
		// Test all position later IMPORTANT !!!

		switch (position) {
		case CENTER:
			actorToBePositioned.setX((as_XW / 2.0f) - atp_W / 2.0f);
			actorToBePositioned.setY((as_YH / 2.0f) - atp_H / 2.0f);
			break;
		case SAME:
			actorToBePositioned.setPosition(as_X, as_Y);
			break;
		case LEFT:
			actorToBePositioned.setPosition(as_X, as_YH / 2.0f - atp_H / 2.0f);
			break;
		case TOP_LEFT:
			actorToBePositioned.setPosition(as_X, as_YH - atp_H);
			break;
		case TOP_LEFT_CENTER:
			actorToBePositioned.setPosition(as_X - atp_W / 2.0f, as_YH - atp_H
					/ 2.0f);
			break;
		case TOP_RIGHT:
			actorToBePositioned.setPosition(as_XW - atp_W, as_YH - atp_H);
			break;
		case TOP_RIGHT_CENTER:
			actorToBePositioned.setPosition(as_XW - atp_W / 2.0f, as_YH - atp_H
					/ 2.0f);
			break;
		case TOP_CENTER:
			actorToBePositioned.setPosition(as_XW / 2.0f - atp_W / 2.0f, as_YH
					- atp_H);
			break;
		case BOTTOM_LEFT:
			actorToBePositioned.setPosition(as_X, as_Y);
			break;
		case BOTTOM_LEFT_CENTER:
			actorToBePositioned.setPosition(as_X - atp_W / 2.0f, as_Y - atp_H
					/ 2.0f);
			break;
		case BOTTOM_RIGHT:
			actorToBePositioned.setPosition(as_XW - atp_W, as_Y);
			break;
		case BOTTOM_RIGHT_CENTER:
			actorToBePositioned.setPosition(as_XW - atp_W / 2.0f, as_Y - atp_H
					/ 2.0f);
			break;
		case BOTTOM_CENTER:
			actorToBePositioned.setPosition(as_XW / 2.0f - atp_W / 2.0f, as_Y);
			break;
		case RIGHT_CENTER:
			actorToBePositioned.setPosition(as_XW - atp_W, as_YH / 2.0f - atp_H
					/ 2.0f);
			break;
		default:
			actorToBePositioned.setPosition(actorToBePositioned.getX(),
					actorToBePositioned.getY());
			break;
		}
	}
}
