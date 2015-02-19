/**
 * File name:	InputIntent.java
 * Version:		1.0
 * Date:		@date 13:09:12
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

package com.sawan.mathattack.input;

// TODO: Auto-generated Javadoc
/**
 * The Class InputIntent.
 */
public class InputIntent {
	//
	/** The Constant logTag. */
	protected final static String logTag = "MtxInputIntentLog";
	
	/** The log active. */
	public static boolean logActive = true;
	//
	/** The touch initial y. */
	private float touchInitialX = 0.0f, touchInitialY = 0.0f;
	
	/** The touch current y. */
	private float touchCurrentX = 0.0f, touchCurrentY = 0.0f;
	//
	/** The touch drag interval range. */
	private float touchDragIntervalRange = 0.0f;
	//
	/** The dif x. */
	private float difX;
	
	/** The dif y. */
	private float difY;
	
	/** The prev dif x. */
	private float prevDifX;
	
	/** The prev dif y. */
	private float prevDifY;
	//
	/** The touch dif x. */
	private float touchDifX;
	
	/** The touch dif y. */
	private float touchDifY;

	/**
	 * The Enum DirectionIntent.
	 */
	public enum DirectionIntent {
		
		/** The touch idle. */
		TOUCH_IDLE, 
 /** The touch d up. */
 TOUCH_D_UP, 
 /** The touch d down. */
 TOUCH_D_DOWN, 
 /** The touch d left. */
 TOUCH_D_LEFT, 
 /** The touch d right. */
 TOUCH_D_RIGHT
	}

	/**
	 * The Enum InputAreaTopBottom.
	 */
	public enum InputAreaTopBottom {
		
		/** The top half. */
		TOP_HALF, 
 /** The bottom half. */
 BOTTOM_HALF
	}

	/**
	 * The Enum InputAreaLeftRight.
	 */
	public enum InputAreaLeftRight {
		
		/** The left half. */
		LEFT_HALF, 
 /** The right half. */
 RIGHT_HALF
	}

	/**
	 * Instantiates a new input intent.
	 */
	public InputIntent() {
		reset();
	}

	/**
	 * if touch drag interval is set, by using this check method, a range of
	 * drag can be detected
	 * <p>
	 * 
	 * EXAMPLE:<br>
	 * touchDragIntervalRange is 100px, user puts finger on screen and drags his
	 * finger, after 100px dragging, this method will return true. This can be
	 * very handy for real swipe intentions. For example, user swipe down to get
	 * notification center, but you would not want to get notification center,
	 * for very little swipe downs like 2, 3px
	 *
	 * @return true, if is touch drag interval
	 */
	public boolean isTouchDragInterval() {
		difX = Math.abs(touchInitialX - touchCurrentX);
		difY = Math.abs(touchInitialY - touchCurrentY);
		//
		if (difX > touchDragIntervalRange || difY > touchDragIntervalRange) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Get drag intention
	 * <p>
	 * 
	 * TOUCH_IDLE, TOUCH_D_UP, TOUCH_D_DOWN, TOUCH_D_LEFT, TOUCH_D_RIGHT.
	 *
	 * @return the direction intent
	 */
	public DirectionIntent getDirectionIntent() {
		storePrevDiffs();
		//
		difX = Math.abs(touchInitialX - touchCurrentX);
		difY = Math.abs(touchInitialY - touchCurrentY);
		//
		checkMomentumChange();
		//
		if (touchInitialY < touchCurrentY && difY > difX) {
			return DirectionIntent.TOUCH_D_UP;
		} else if (touchInitialY > touchCurrentY && difY > difX) {
			return DirectionIntent.TOUCH_D_DOWN;
		} else if (touchInitialX < touchCurrentX && difY < difX) {
			return DirectionIntent.TOUCH_D_RIGHT;
		} else if (touchInitialX > touchCurrentX && difY < difX) {
			return DirectionIntent.TOUCH_D_LEFT;
		} else {
			return DirectionIntent.TOUCH_IDLE;
		}
	}

	/**
	 * Store for momentum change.
	 */
	private void storePrevDiffs() {
		prevDifX = difX;
		prevDifY = difY;
	}

	/**
	 * Get minimal changes on drag
	 * <p>
	 * 
	 * EXAMPLE<br>
	 * User drags finger to left, suddenly dragging to right without removing
	 * his finger from the screen.
	 */
	private void checkMomentumChange() {
		if (prevDifX > difX || prevDifY > difY) {
			touchInitialX = touchCurrentX;
			touchInitialY = touchCurrentY;
			//
			difX = 0.0f;
			difY = 0.0f;
			prevDifX = 0.0f;
			prevDifY = 0.0f;
			//
			setTouchDifferences();
		}
	}

	/**
	 * Reset everything. USE THIS: on touchUp methods
	 * 
	 * */
	public void reset() {
		difX = 0.0f;
		difY = 0.0f;
		touchInitialX = 0.0f;
		touchInitialY = 0.0f;
		touchCurrentX = 0.0f;
		touchCurrentY = 0.0f;
		touchDifX = 0.0f;
		touchDifY = 0.0f;
		prevDifX = 0.0f;
		prevDifY = 0.0f;
	}

	/**
	 * Set initial touches. USE THIS: on touchDown method
	 *
	 * @param x the x
	 * @param y the y
	 */
	public void setTouchInitials(float x, float y) {
		touchInitialX = x;
		touchInitialY = y;
	}

	/**
	 * Set current touches, draggings. USE THIS: on touchDrag, pan, or similar
	 * methods
	 *
	 * @param x the x
	 * @param y the y
	 */
	public void setTouchCurrents(float x, float y) {
		touchCurrentX = x;
		touchCurrentY = y;
	}

	/**
	 * Gets the touch initial x.
	 *
	 * @return the touch initial x
	 */
	public float getTouchInitialX() {
		return touchInitialX;
	}

	/**
	 * Sets the touch initial x.
	 *
	 * @param touchInitialX the new touch initial x
	 */
	public void setTouchInitialX(float touchInitialX) {
		this.touchInitialX = touchInitialX;
	}

	/**
	 * Gets the touch initial y.
	 *
	 * @return the touch initial y
	 */
	public float getTouchInitialY() {
		return touchInitialY;
	}

	/**
	 * Sets the touch initial y.
	 *
	 * @param touchInitialY the new touch initial y
	 */
	public void setTouchInitialY(float touchInitialY) {
		this.touchInitialY = touchInitialY;
	}

	/**
	 * Gets the touch current x.
	 *
	 * @return the touch current x
	 */
	public float getTouchCurrentX() {
		return touchCurrentX;
	}

	/**
	 * Sets the touch current x.
	 *
	 * @param touchCurrentX the new touch current x
	 */
	public void setTouchCurrentX(float touchCurrentX) {
		this.touchCurrentX = touchCurrentX;
	}

	/**
	 * Gets the touch current y.
	 *
	 * @return the touch current y
	 */
	public float getTouchCurrentY() {
		return touchCurrentY;
	}

	/**
	 * Sets the touch current y.
	 *
	 * @param touchCurrentY the new touch current y
	 */
	public void setTouchCurrentY(float touchCurrentY) {
		this.touchCurrentY = touchCurrentY;
	}

	/**
	 * Get tuch drag interval range.
	 *
	 * @return the touch drag interval range
	 */
	public float getTouchDragIntervalRange() {
		return touchDragIntervalRange;
	}

	/**
	 * if touch drag interval is set, by using this check method, a range of
	 * drag can be detected
	 * <p>
	 * 
	 * EXAMPLE:<br>
	 * User swipe down to get notification center, but you would not want to get
	 * notification center, for very little swipe downs like 2, 3px. Set this as
	 * 100px, so by using isTouchDragInterval() method, you can confirm swipe
	 * down, after 100px.
	 *
	 * @param touchDragIntervalRange the new touch drag interval range
	 */
	public void setTouchDragIntervalRange(float touchDragIntervalRange) {
		this.touchDragIntervalRange = touchDragIntervalRange;
	}

	/**
	 * Set touch differences, optional, if you need amount of change from
	 * initial touch to drag, USE THIS: on touchDrag, pan or similar mthods.
	 */
	public void setTouchDifferences() {
		touchDifX = Math.abs(touchInitialX - touchCurrentX);
		touchDifY = Math.abs(touchInitialY - touchCurrentY);
	}

	/**
	 * Get touch difference on X-axis from initial point, if you change your
	 * drag direction without removing finger from screen, inital touch will be
	 * the point of direction change.
	 *
	 * @return the touch dif x
	 */
	public float getTouchDifX() {
		return touchDifX;
	}

	/**
	 * Set touch diff X.
	 *
	 * @param touchDifX the new touch dif x
	 */
	public void setTouchDifX(float touchDifX) {
		this.touchDifX = touchDifX;
	}

	/**
	 * Get touch difference on Y-axis from initial point, if you change your
	 * drag direction without removing finger from screen, inital touch will be
	 * the point of direction change.
	 *
	 * @return the touch dif y
	 */
	public float getTouchDifY() {
		return touchDifY;
	}

	/**
	 * Set touch diff Y.
	 *
	 * @param touchDifY the new touch dif y
	 */
	public void setTouchDifY(float touchDifY) {
		this.touchDifY = touchDifY;
	}

	/**
	 * Check which top or bottom part of screen currently being touched.
	 *
	 * @param screenHeight the screen height
	 * @return the input area top bottom
	 */
	public InputAreaTopBottom getInputAreaTopBottom(float screenHeight) {
		if (touchCurrentY > screenHeight / 2.0f) {
			return InputAreaTopBottom.TOP_HALF;
		} else {
			return InputAreaTopBottom.BOTTOM_HALF;
		}
	}

	/**
	 * Check which left or right part of screen currently being touched.
	 *
	 * @param screenWidth the screen width
	 * @return the input area left right
	 */
	public InputAreaLeftRight getInputAreaLeftRight(float screenWidth) {
		if (touchCurrentX > screenWidth / 2.0f) {
			return InputAreaLeftRight.RIGHT_HALF;
		} else {
			return InputAreaLeftRight.LEFT_HALF;
		}
	}
}
