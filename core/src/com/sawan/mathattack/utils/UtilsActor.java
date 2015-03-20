/**
 * File name:	UtilsActor.java
 * Version:		1.0
 * Date:		@date 13:16:33
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

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;

public class UtilsActor {
	/**
	 * Get the rectangle of an actor from its current position and size
	 * */
	public static Rectangle getRectangleOfActor(Actor actor) {
		return new Rectangle(actor.getX(), actor.getY(), actor.getWidth(),
				actor.getHeight());
	}

	/**
	 * Set touchable for multiple actors at once
	 * */
	public static void setTouchable(Touchable touchable, Actor... actors) {
		for (Actor a : actors) {
			a.setTouchable(touchable);
		}
	}

	/**
	 * Set visible for multiple actors at once
	 * */
	public static void setVisible(boolean isVisible, Actor... actors) {
		for (Actor a : actors) {
			a.setVisible(isVisible);
		}
	}

	/**
	 * Set scale of multiple actors at once
	 * */
	public static void setScale(float sx, float sy, Actor... actors) {
		for (Actor a : actors) {
			a.setScale(sx, sy);
		}
	}

	/**
	 * Set size for multiple actors at once
	 * */
	public static void setSize(float w, float h, Actor... actors) {
		for (Actor a : actors) {
			a.setSize(w, h);
		}
	}
}
