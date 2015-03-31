/**
 * File name:	CollisionDetector.java
 * Version:		1.0
 * Date:		@date 13:08:15
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

package com.sawan.mathattack.collision;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.sawan.mathattack.settings.MtxLogger;
import com.sawan.mathattack.utils.UtilsActor;

// TODO: Auto-generated Javadoc
/**
 * The Class CollisionDetector.
 */
public class CollisionDetector {
	
	/** The Constant logTag. */
	protected static final String logTag = "MtxCollisionDetectorLog";
	
	/** The log active. */
	public static boolean logActive = true;

	/**
	 * Check collision from actor's rectangles.
	 *
	 * @param actor1 the actor1
	 * @param actor2 the actor2
	 * @return true, if is actors collide
	 */
	public static boolean isActorsCollide(Actor actor1, Actor actor2) {
		if (Intersector.overlaps(UtilsActor.getRectangleOfActor(actor1),
				UtilsActor.getRectangleOfActor(actor2))) {
			logCollision1(actor1, actor2);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Very precise point detection in a box, think as virtual box in the actual
	 * box with padding as precision amount.
	 *
	 * @param touchX the touch x
	 * @param touchY the touch y
	 * @param posX the pos x
	 * @param posY the pos y
	 * @param width the width
	 * @param height the height
	 * @param precisionAmount the precision amount
	 * @return true, if is touch point collide
	 */
	public static boolean isTouchPointCollide(float touchX, float touchY,
			float posX, float posY, float width, float height,
			float precisionAmount) {
		if (touchX > (posX + precisionAmount)
				&& touchX < (posX + width - precisionAmount)
				&& touchY > (posY + precisionAmount)
				&& touchY < (posY + height - precisionAmount)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Very precise point detection in an actor, think as virtual box in the
	 * actual box with margin as precision amount.
	 *
	 * @param touchX the touch x
	 * @param touchY the touch y
	 * @param actor the actor
	 * @param precisionAmount the precision amount
	 * @return true, if is touch point collide
	 */
	public static boolean isTouchPointCollide(float touchX, float touchY,
			Actor actor, float precisionAmount) {
		if (touchX > (actor.getX() + precisionAmount)
				&& touchX < (actor.getX() + actor.getWidth() - precisionAmount)
				&& touchY > (actor.getY() + precisionAmount)
				&& touchY < (actor.getY() + actor.getHeight() - precisionAmount)) {
			logCollision2(actor);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Log collision1.
	 *
	 * @param a1 the a1
	 * @param a2 the a2
	 */
	private static void logCollision1(Actor a1, Actor a2) {
		MtxLogger.log(logActive, true, logTag,
				"Collision detected: Actor (Name: " + a1.getName()
						+ ") and Actor (Name: " + a2.getName() + ")");
	}

	/**
	 * Log collision2.
	 *
	 * @param a1 the a1
	 */
	private static void logCollision2(Actor a1) {
		MtxLogger.log(
				logActive,
				true,
				logTag,
				"Collision detected on touch point: Actor (Name: "
						+ a1.getName() + ")");
	}
}
