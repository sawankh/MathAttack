/**
 * File name:	UtilsOrigin.java
 * Version:		1.0
 * Date:		@date 13:17:02
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

// TODO: Auto-generated Javadoc
/**
 * The Class UtilsOrigin.
 */
public class UtilsOrigin {
	
	/**
	 * The Enum Origin.
	 */
	public enum Origin {
		
		/** The center. */
		CENTER, 
 /** The top left. */
 TOP_LEFT, 
 /** The top right. */
 TOP_RIGHT, 
 /** The bottom left. */
 BOTTOM_LEFT, 
 /** The bottom right. */
 BOTTOM_RIGHT, 
 /** The left center. */
 LEFT_CENTER, 
 /** The top center. */
 TOP_CENTER, 
 /** The bottom center. */
 BOTTOM_CENTER, 
 /** The right center. */
 RIGHT_CENTER
	}

	/**
	 * Set origin of an actor, since actors are complex objects, its variables
	 * pointing same reference with copies, so the origin will be set in
	 * original object.
	 *
	 * @param actor            actor to set the origin
	 * @param origin            position of the origin, comes from Origin enum class
	 */
	public static void setActorOrigin(Actor actor, Origin origin) {
		setOrigin(actor, origin);
	}

	/**
	 * Set multiple actors origin at once.
	 *
	 * @param origin            position of the origin, comes from Origin enum class
	 * @param actors            multiple actors to set the origin
	 */
	public static void setActorsOrigin(Origin origin, Actor... actors) {
		for (Actor a : actors) {
			setOrigin(a, origin);
		}
	}

	/**
	 * Sets the origin.
	 *
	 * @param actor the actor
	 * @param origin the origin
	 */
	private static void setOrigin(Actor actor, Origin origin) {
		switch (origin) {
		case CENTER:
			actor.setOrigin(actor.getWidth() / 2.0f, actor.getHeight() / 2.0f);
			break;
		case TOP_LEFT:
			actor.setOrigin(0.0f, actor.getHeight());
			break;
		case TOP_RIGHT:
			actor.setOrigin(actor.getWidth(), actor.getHeight());
			break;
		case BOTTOM_LEFT:
			actor.setOrigin(0.0f, 0.0f);
			break;
		case BOTTOM_RIGHT:
			actor.setOrigin(actor.getWidth(), 0.0f);
			break;
		case LEFT_CENTER:
			actor.setOrigin(0.0f, actor.getHeight() / 2.0f);
			break;
		case TOP_CENTER:
			actor.setOrigin(actor.getWidth() / 2.0f, actor.getHeight());
			break;
		case BOTTOM_CENTER:
			actor.setOrigin(actor.getWidth() / 2.0f, 0.0f);
			break;
		case RIGHT_CENTER:
			actor.setOrigin(actor.getWidth(), actor.getHeight() / 2.0f);
			break;
		default:
			actor.setOrigin(actor.getOriginX(), actor.getOriginY());
			break;
		}
	}
}
