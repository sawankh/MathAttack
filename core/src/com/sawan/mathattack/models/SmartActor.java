/**
 * File name:	SmartActor.java
 * Version:		1.0
 * Date:		@date 13:12:28
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

package com.sawan.mathattack.models;

import java.util.Random;

import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.sawan.mathattack.effects.EffectCreator;
import com.sawan.mathattack.scene2d.AbstractActor;

// TODO: Auto-generated Javadoc
/**
 * The Class SmartActor.
 */
public class SmartActor extends AbstractActor {
	
	/** The rnd. */
	private Random rnd;
	
	/** The is found. */
	private boolean isFound;

	// Smart model actions
	/** The is action move freely. */
	private boolean isActionMoveFreely;
	
	/** The is action move to direction. */
	private boolean isActionMoveToDirection;
	
	/** The is action fade in out. */
	private boolean isActionFadeInOut;
	
	/** The is action rotate. */
	private boolean isActionRotate;
	
	/** The is action scale. */
	private boolean isActionScale;
	
	/** The is action move side to side. */
	private boolean isActionMoveSideToSide;

	// Action move freely
	/** The timer range new move decision. */
	private int timerRangeNewMoveDecision;
	
	/** The time left for new move decision. */
	private int timeLeftForNewMoveDecision;
	
	/** The move range x. */
	private int moveRangeX;
	
	/** The move range y. */
	private int moveRangeY;
	
	/** The duration speed move freely. */
	private float durationSpeedMoveFreely;

	// Action fadeInOut
	/** The timer range new fade in out decision. */
	private int timerRangeNewFadeInOutDecision;
	
	/** The time left for new fade in out decision. */
	private int timeLeftForNewFadeInOutDecision;
	
	/** The duration speed fade in out. */
	private float durationSpeedFadeInOut;
	
	/** The is fade out. */
	private boolean isFadeOut;
	
	/** The is action fade in ou using random time range. */
	private boolean isActionFadeInOuUsingRandomTimeRange;

	// Action move to direction
	/** The is mtd random x. */
	private boolean isMTDRandomX;
	
	/** The top left x. */
	private int topLeftX;
	
	/** The top right x. */
	private int topRightX;
	
	/** The bottom left x. */
	private int bottomLeftX;
	
	/** The bottom right x. */
	private int bottomRightX;
	
	/** The bottom left y. */
	private int bottomLeftY;
	
	/** The speed mtd. */
	private int speedMTD;
	
	/** The is top down. */
	private boolean isTopDown;
	
	/** The speed mtd minimum. */
	private int speedMTDMinimum;
	
	/** The top y. */
	private int topY;
	
	/** The bottom y. */
	private int bottomY;

	// Action rotate
	/** The rotate angle range start. */
	private int rotateAngleRangeStart;
	
	/** The rotate angle range end. */
	private int rotateAngleRangeEnd;
	
	/** The duration speed rotate. */
	private int durationSpeedRotate;
	
	/** The timer range new rotate decision. */
	private int timerRangeNewRotateDecision;
	
	/** The time left for new rotate decision. */
	private int timeLeftForNewRotateDecision;
	
	/** The is action rotate random time. */
	private boolean isActionRotateRandomTime;

	// Action scale
	/** The timer range for sclae. */
	private int timerRangeForSclae;
	
	/** The time left for new r scale decision. */
	private int timeLeftForNewRScaleDecision;
	
	/** The scale ratio width. */
	private float scaleRatioWidth;
	
	/** The scale ratio height. */
	private float scaleRatioHeight;
	
	/** The duration speed scale. */
	private float durationSpeedScale;
	
	/** The is action scale random time. */
	private boolean isActionScaleRandomTime;

	// Action move side to side
	/** The timer range new move side to side decision. */
	private int timerRangeNewMoveSideToSideDecision;
	
	/** The time left for new move sts decision. */
	private int timeLeftForNewMoveSTSDecision;
	
	/** The speed move sts freely. */
	private float speedMoveSTSFreely;
	
	/** The rnd stsy. */
	private int rndSTSY;
	
	/** The move sts start x. */
	private int moveSTSStartX;
	
	/** The move sts end x. */
	private int moveSTSEndX;

	/**
	 * Instantiates a new smart actor.
	 *
	 * @param posX the pos x
	 * @param posY the pos y
	 * @param width the width
	 * @param height the height
	 * @param rnd the rnd
	 */
	public SmartActor(float posX, float posY, float width, float height,
			Random rnd) {
		super(posX, posY, width, height);
		// Reset settings;
		reset();

		//
		this.rnd = rnd;
	}

	/**
	 * Instantiates a new smart actor.
	 *
	 * @param width the width
	 * @param height the height
	 * @param rnd the rnd
	 * @param DIPActive the DIP active
	 */
	public SmartActor(float width, float height, Random rnd, boolean DIPActive) {
		super(width, height, DIPActive);
		// Reset settings;
		reset();

		//
		this.rnd = rnd;
	}

	/* (non-Javadoc)
	 * @see com.sawan.mathattack.scene2d.AbstractActor#act(float)
	 */
	@Override
	public void act(float delta) {
		super.act(delta);

		if (isActionMoveFreely) {
			if (getSecondsTime() > timeLeftForNewMoveDecision) {
				makeNewMoveFreelyDecision();
			}
		}

		if (isActionMoveSideToSide) {
			if (getSecondsTime() > timeLeftForNewMoveSTSDecision) {
				makeNewMoveSTSDecision();
			}
		}

		if (isActionFadeInOut) {
			if (getSecondsTime() > timeLeftForNewFadeInOutDecision) {
				if (isFadeOut) {
					fadeIn();
				} else {
					fadeOut();
				}
			}
		}

		if (isActionMoveToDirection) {
			if (isActionMoveToDirectionCompleted()) {
				makeNewMoveToDirectionDecision();
			}
		}

		if (isActionRotate) {
			if (getSecondsTime() > timeLeftForNewRotateDecision) {
				makeNewRotateDecision();
			}
		}

		if (isActionScale) {
			if (getSecondsTime() > timeLeftForNewRScaleDecision) {
				makeNewScaleDecision();
			}
		}
	}

	// ACTION SCALE
	// ###################################################################################
	/**
	 * Start Action Scale
	 * <p>
	 * 
	 * EXAMPLE:
	 * <p>
	 * startActionScale(10,1.5f,1.5f,3.0f,true)<br>
	 * Every random number of seconds (10), scale actor by 1.5f (WidthxHeight)
	 * and back to normal, scale will be done in 3.0f seconds
	 *
	 * @param timerRangeForScale the timer range for scale
	 * @param scaleRatioWidth the scale ratio width
	 * @param scaleRatioHeight the scale ratio height
	 * @param durationSpeedScale the duration speed scale
	 * @param isActionScaleRandomTime the is action scale random time
	 */
	public void startActionScale(int timerRangeForScale, float scaleRatioWidth,
			float scaleRatioHeight, float durationSpeedScale,
			boolean isActionScaleRandomTime) {
		//
		isActionScale = true;
		//
		this.timerRangeForSclae = timerRangeForScale;
		this.scaleRatioWidth = scaleRatioWidth;
		this.scaleRatioHeight = scaleRatioHeight;
		this.durationSpeedScale = durationSpeedScale;
		this.isActionScaleRandomTime = isActionScaleRandomTime;
		//
		makeNewScaleDecision();
	}

	/**
	 * Force actor to make action decision, Normally done after this action's
	 * time is up with paradox/looping.
	 */
	public void makeNewScaleDecision() {
		if (isActionScaleRandomTime) {
			timeLeftForNewRScaleDecision = rnd.nextInt(timerRangeForSclae);
		} else {
			timeLeftForNewRScaleDecision = timerRangeForSclae;
		}
		timeLeftForNewRScaleDecision = (int) ((int) getSecondsTime()
				+ timeLeftForNewRScaleDecision + durationSpeedScale);

		EffectCreator.create_SC_BTN(this, scaleRatioWidth, scaleRatioHeight,
				durationSpeedScale, null, false);
	}

	// ACTION ROTATE
	// ###################################################################################
	/**
	 * Start Action Rotate
	 * <p>
	 * 
	 * EXAMPLE:
	 * <p>
	 * startActionRotate(15,360,2.0f,true)<br>
	 * Every random number of seconds (15), rotate actor by randomly in range
	 * 360 degrees, rotate will be done in 2.0f seconds
	 *
	 * @param timerRangeNewRotateDecision the timer range new rotate decision
	 * @param rotateAngleRangeStart the rotate angle range start
	 * @param rotateAngleRangeEnd the rotate angle range end
	 * @param durationSpeedRotate the duration speed rotate
	 * @param isActionRotateRandomTime the is action rotate random time
	 */
	public void startActionRotate(int timerRangeNewRotateDecision,
			int rotateAngleRangeStart, int rotateAngleRangeEnd,
			int durationSpeedRotate, boolean isActionRotateRandomTime) {
		//
		isActionRotate = true;
		//
		this.timerRangeNewRotateDecision = timerRangeNewRotateDecision;
		this.rotateAngleRangeStart = rotateAngleRangeStart;
		this.rotateAngleRangeEnd = rotateAngleRangeEnd;
		this.durationSpeedRotate = durationSpeedRotate;
		this.isActionRotateRandomTime = isActionRotateRandomTime;
		//
		makeNewRotateDecision();
	}

	/**
	 * Force actor to make action decision, Normally done after this action's
	 * time is up with paradox/looping.
	 */
	public void makeNewRotateDecision() {
		if (isActionRotateRandomTime) {
			timeLeftForNewRotateDecision = rnd
					.nextInt(timerRangeNewRotateDecision);
		} else {
			timeLeftForNewRotateDecision = timerRangeNewRotateDecision;
		}
		timeLeftForNewRotateDecision = (int) getSecondsTime()
				+ timeLeftForNewRotateDecision + durationSpeedRotate;

		// FIXME
		// RANDOM FUCKS THE EFFECT
		// int rndDuration = rnd.nextInt(durationSpeedRotate) +
		// durationSpeedRotateMinimum;
		int rndAngele = getRandomNumber(rnd, rotateAngleRangeStart,
				rotateAngleRangeEnd);
		addAction(Actions.rotateTo(rndAngele, durationSpeedRotate));
	}

	// ACTION MOVE TO DIRECTION
	// ###################################################################################
	/**
	 * Start Action Move To Direction (NEGATIVE RANGE IS USABLE)
	 * <p>
	 * EXAMPLES <br>
	 * - startActionMoveToDirection(int[0,800], int[0,400], 900, -100, 10, 5,
	 * false, true): start from in a range (0-800) X-axis from 900 Y-axis and
	 * move to in a range (0,400) X-axis and -100 Y-axis, when direction
	 * complete repeat again (paradox/looping), speed duration 10 seconds and
	 * minimum speed duration 5 seconds, move top down (snow effect), use X-axis
	 * randomizer.
	 *
	 * @param topRangeX the top range x
	 * @param bottomRangeX the bottom range x
	 * @param topY the top y
	 * @param bottomY the bottom y
	 * @param speedMTD the speed mtd
	 * @param speedMTDMinimum the speed mtd minimum
	 * @param isTopDown the is top down
	 * @param isMTDRandomX the is mtd random x
	 */
	public void startActionMoveToDirection(int[] topRangeX, int[] bottomRangeX,
			int topY, int bottomY, int speedMTD, int speedMTDMinimum,
			boolean isTopDown, boolean isMTDRandomX) {
		//
		isActionMoveToDirection = true;
		//
		this.topLeftX = topRangeX[0];
		this.topRightX = topRangeX[1];
		this.bottomLeftX = bottomRangeX[0];
		this.bottomRightX = bottomRangeX[1];
		//
		this.topY = topY;
		this.bottomY = bottomY;
		//
		this.speedMTD = speedMTD;
		this.speedMTDMinimum = speedMTDMinimum;
		this.isTopDown = isTopDown;
		this.isMTDRandomX = isMTDRandomX;
		// =
		makeNewMoveToDirectionDecision();
	}

	/**
	 * Force actor to make action decision, Normally done after this action's
	 * time is up with paradox/looping.
	 */
	private void makeNewMoveToDirectionDecision() {
		int topX;
		int bottomX;

		if (isMTDRandomX) {
			topX = getRandomNumber(rnd, topLeftX, topRightX);
			bottomX = getRandomNumber(rnd, bottomLeftX, bottomRightX);
		} else {
			topX = topLeftX;
			bottomX = bottomLeftY;
		}

		int rndSpeed = rnd.nextInt(speedMTD) + speedMTDMinimum;
		if (isTopDown) {
			setPosition(topX, topY);
			addAction(Actions.moveTo(bottomX, bottomY, rndSpeed));
		} else {
			setPosition(bottomX, bottomY);
			addAction(Actions.moveTo(topX, topY, rndSpeed));
		}
	}

	/**
	 * Gets the random number.
	 *
	 * @param rndGen the rnd gen
	 * @param min the min
	 * @param max the max
	 * @return the random number
	 */
	private int getRandomNumber(Random rndGen, int min, int max) {
		if (min < 0 && max <= 0) {
			min *= -1;
			max *= -1;
			int rndNumber = rnd.nextInt(min - max + 1) + max;
			return rndNumber * -1;
		} else if (min < 0 && max >= 0) {
			min *= -1;
			int totalRange = min + max;
			int rndNumber = rnd.nextInt(totalRange) + (min * -1);
			return rndNumber;
		} else if (min > 0 && max <= 0) {
			// IMPOSSIBLE CALCULATION
			min *= -1;
			max *= -1;
			int rndNumber = rnd.nextInt(min - max + 1) + max;
			return rndNumber * -1;
		} else {
			int rndNumber = rnd.nextInt(max - min + 1) + min;
			return rndNumber;
		}
	}

	/**
	 * Checks if is action move to direction completed.
	 *
	 * @return true, if is action move to direction completed
	 */
	private boolean isActionMoveToDirectionCompleted() {
		if (isTopDown) {
			if (getY() <= bottomY) {
				return true;
			} else {
				return false;
			}
		} else {
			if (getY() >= topY) {
				return true;
			} else {
				return false;
			}
		}
	}

	// ACTION FADE IN OUT
	// ###################################################################################
	/**
	 * Start Fade IN/OUT action
	 * <p>
	 * EXAMPLES <br>
	 * - startActionFadeInOut(1,1,false): fading in and out every second without
	 * random time<br>
	 * - startActionFadeInOut(10,1,false): fading in and out every 10 seconds
	 * without random time<br>
	 * - startActionFadeInOut(10,1,true): fading in and out randomly in 10
	 * seconds range<br>.
	 *
	 * @param timerRangeNewFadeInOutDecision the timer range new fade in out decision
	 * @param durationSpeedFadeInOut the duration speed fade in out
	 * @param isActionFadeInOuUsingRandomTimeRange the is action fade in ou using random time range
	 */
	public void startActionFadeInOut(int timerRangeNewFadeInOutDecision,
			int durationSpeedFadeInOut,
			boolean isActionFadeInOuUsingRandomTimeRange) {
		isActionFadeInOut = true;
		//
		this.timerRangeNewFadeInOutDecision = timerRangeNewFadeInOutDecision;
		this.durationSpeedFadeInOut = durationSpeedFadeInOut;
		this.isActionFadeInOuUsingRandomTimeRange = isActionFadeInOuUsingRandomTimeRange;
		//
		fadeOut();
	}

	/**
	 * Fade out.
	 */
	public void fadeOut() {
		if (isActionFadeInOuUsingRandomTimeRange) {
			timeLeftForNewFadeInOutDecision = (int) (rnd
					.nextInt(timerRangeNewFadeInOutDecision) + durationSpeedFadeInOut);
		} else {
			timeLeftForNewFadeInOutDecision = (int) (timerRangeNewFadeInOutDecision + durationSpeedFadeInOut);
		}
		timeLeftForNewFadeInOutDecision = (int) getSecondsTime()
				+ timeLeftForNewFadeInOutDecision;
		addAction(Actions.fadeOut(durationSpeedFadeInOut));
		isFadeOut = true;
	}

	/**
	 * Fade in.
	 */
	public void fadeIn() {
		if (isActionFadeInOuUsingRandomTimeRange) {
			timeLeftForNewFadeInOutDecision = rnd
					.nextInt(timerRangeNewFadeInOutDecision);
		} else {
			timeLeftForNewFadeInOutDecision = timerRangeNewFadeInOutDecision;
		}
		timeLeftForNewFadeInOutDecision = rnd
				.nextInt(timerRangeNewFadeInOutDecision);
		timeLeftForNewFadeInOutDecision = (int) getSecondsTime()
				+ timeLeftForNewFadeInOutDecision;
		addAction(Actions.fadeIn(durationSpeedFadeInOut));
		isFadeOut = false;
	}

	// ACTION MOVE FREELY
	// ###################################################################################
	/**
	 * Start Action Move Freely (NEGATIVE RANGE ARE NOT ACCEPTED IN THIS METHOD)
	 * <p>
	 * EXAMPLES <br>
	 * - startActionMoveFreely(10,480,800,10): move freely within 480,800
	 * randomly in 10 seconds range, after time is up actor will make new
	 * decision <br>.
	 *
	 * @param timerRangeNewMoveDecision the timer range new move decision
	 * @param moveRangeX the move range x
	 * @param moveRangeY the move range y
	 * @param durationSpeedMoveFreely the duration speed move freely
	 */
	public void startActionMoveFreely(int timerRangeNewMoveDecision,
			int moveRangeX, int moveRangeY, float durationSpeedMoveFreely) {
		isActionMoveFreely = true;
		//
		this.timerRangeNewMoveDecision = timerRangeNewMoveDecision;
		this.moveRangeX = moveRangeX;
		this.moveRangeY = moveRangeY;
		this.durationSpeedMoveFreely = durationSpeedMoveFreely;
		//
		makeNewMoveFreelyDecision();
	}

	/**
	 * Force actor to make action decision, Normally done after this action's
	 * time is up with paradox/looping.
	 */
	private void makeNewMoveFreelyDecision() {
		timeLeftForNewMoveDecision = rnd.nextInt(timerRangeNewMoveDecision);
		timeLeftForNewMoveDecision = (int) ((int) getSecondsTime()
				+ timeLeftForNewMoveDecision + durationSpeedMoveFreely);
		//
		if (moveRangeX > 0 && moveRangeY > 0) {
			addAction(Actions.moveTo(rnd.nextInt(moveRangeX),
					rnd.nextInt(moveRangeY), durationSpeedMoveFreely));
		} else if (moveRangeX > 0 && moveRangeY <= 0) {
			addAction(Actions.moveTo(rnd.nextInt(moveRangeX), 0,
					durationSpeedMoveFreely));
		} else if (moveRangeX <= 0 && moveRangeY > 0) {
			addAction(Actions.moveTo(0, rnd.nextInt(moveRangeY),
					durationSpeedMoveFreely));
		} else {
			// NOT MOVING
		}
	}

	// ACTION MOVE SIDE TO SIDE
	// ###################################################################################
	/**
	 * Start Action Side To Side
	 * 
	 * <p>
	 * EXAMPLES <br>
	 * - startActionMoveSiteToSide(10,0,800,500,10): Move one side and then move
	 * to other side in 10 seconds range, start form 0 X-axis, move to an X-axis
	 * in (0,800) range Y-axis is stable, 500. <br>
	 *
	 * @param timerRangeNewMoveSideToSideDecision the timer range new move side to side decision
	 * @param moveSTSStartX the move sts start x
	 * @param moveSTSEndX the move sts end x
	 * @param rndSTSY the rnd stsy
	 * @param speedMoveSTSFreely the speed move sts freely
	 */
	public void startActionMoveSideToSideFreely(
			int timerRangeNewMoveSideToSideDecision, int moveSTSStartX,
			int moveSTSEndX, int rndSTSY, float speedMoveSTSFreely) {
		isActionMoveSideToSide = true;
		//
		this.rndSTSY = rndSTSY;
		this.timerRangeNewMoveSideToSideDecision = timerRangeNewMoveSideToSideDecision;
		this.moveSTSStartX = moveSTSStartX;
		this.moveSTSEndX = moveSTSEndX;
		this.speedMoveSTSFreely = speedMoveSTSFreely;
		//
		makeNewMoveSTSDecision();
	}

	/**
	 * Force actor to make action decision, Normally done after this action's
	 * time is up with paradox/looping.
	 */
	private void makeNewMoveSTSDecision() {
		timeLeftForNewMoveSTSDecision = rnd
				.nextInt(timerRangeNewMoveSideToSideDecision);
		timeLeftForNewMoveSTSDecision = (int) ((int) getSecondsTime()
				+ timeLeftForNewMoveSTSDecision + speedMoveSTSFreely);
		//
		int rndNumber = rnd.nextInt(10);
		int finalSTSX = 0;
		//
		if (rndNumber <= 5) {
			// minus condition
			if (moveSTSStartX < 0) {
				moveSTSStartX *= -1;
				finalSTSX = rnd.nextInt(moveSTSStartX);
				finalSTSX *= -1;
			} else {
				finalSTSX = rnd.nextInt(moveSTSStartX);
			}
		} else {
			finalSTSX = rnd.nextInt(moveSTSEndX);
		}

		addAction(Actions.moveTo(finalSTSX, rndSTSY, speedMoveSTSFreely));
	}

	// SETTER and GETTERS and OTHER HELPERS
	// ###################################################################################
	/**
	 * Reset.
	 */
	public void reset() {
		clearActions();
		//
		isActionMoveFreely = false;
		isActionMoveToDirection = false;
		isActionFadeInOut = false;
		isActionRotate = false;
		isActionScale = false;
		isActionMoveSideToSide = false;
		//
		durationSpeedMoveFreely = 10.0f;
		durationSpeedFadeInOut = 1.0f;
	}

	/**
	 * Gets the timer range new move decision.
	 *
	 * @return the timer range new move decision
	 */
	public int getTimerRangeNewMoveDecision() {
		return timerRangeNewMoveDecision;
	}

	/**
	 * Sets the timer range new move decision.
	 *
	 * @param timerRangeNewMoveDecision the new timer range new move decision
	 */
	public void setTimerRangeNewMoveDecision(int timerRangeNewMoveDecision) {
		this.timerRangeNewMoveDecision = timerRangeNewMoveDecision;
	}

	/**
	 * Gets the move range x.
	 *
	 * @return the move range x
	 */
	public int getMoveRangeX() {
		return moveRangeX;
	}

	/**
	 * Sets the move range x.
	 *
	 * @param moveRangeX the new move range x
	 */
	public void setMoveRangeX(int moveRangeX) {
		this.moveRangeX = moveRangeX;
	}

	/**
	 * Gets the move range y.
	 *
	 * @return the move range y
	 */
	public int getMoveRangeY() {
		return moveRangeY;
	}

	/**
	 * Sets the move range y.
	 *
	 * @param moveRangeY the new move range y
	 */
	public void setMoveRangeY(int moveRangeY) {
		this.moveRangeY = moveRangeY;
	}

	/**
	 * Gets the duration speed move freely.
	 *
	 * @return the duration speed move freely
	 */
	public float getdurationSpeedMoveFreely() {
		return durationSpeedMoveFreely;
	}

	/**
	 * Sets the duration speed move freely.
	 *
	 * @param durationSpeedMoveFreely the new duration speed move freely
	 */
	public void setdurationSpeedMoveFreely(float durationSpeedMoveFreely) {
		this.durationSpeedMoveFreely = durationSpeedMoveFreely;
	}

	/**
	 * Gets the time left for new move decision.
	 *
	 * @return the time left for new move decision
	 */
	public int getTimeLeftForNewMoveDecision() {
		return timeLeftForNewMoveDecision;
	}

	/**
	 * Sets the time left for new move decision.
	 *
	 * @param timeLeftForNewMoveDecision the new time left for new move decision
	 */
	public void setTimeLeftForNewMoveDecision(int timeLeftForNewMoveDecision) {
		this.timeLeftForNewMoveDecision = timeLeftForNewMoveDecision;
	}

	/**
	 * Checks if is action move freely.
	 *
	 * @return true, if is action move freely
	 */
	public boolean isActionMoveFreely() {
		return isActionMoveFreely;
	}

	/**
	 * Sets the action move freely.
	 *
	 * @param isActionMoveFreely the new action move freely
	 */
	public void setActionMoveFreely(boolean isActionMoveFreely) {
		this.isActionMoveFreely = isActionMoveFreely;
	}

	/**
	 * Checks if is action fade in out.
	 *
	 * @return true, if is action fade in out
	 */
	public boolean isActionFadeInOut() {
		return isActionFadeInOut;
	}

	/**
	 * Sets the action fade in out.
	 *
	 * @param isActionFadeInOut the new action fade in out
	 */
	public void setActionFadeInOut(boolean isActionFadeInOut) {
		this.isActionFadeInOut = isActionFadeInOut;
	}

	/**
	 * Gets the speed mtd.
	 *
	 * @return the speed mtd
	 */
	public int getSpeedMTD() {
		return speedMTD;
	}

	/**
	 * Sets the speed mtd.
	 *
	 * @param speedMTD the new speed mtd
	 */
	public void setSpeedMTD(int speedMTD) {
		this.speedMTD = speedMTD;
	}

	/**
	 * Gets the speed mtd minimum.
	 *
	 * @return the speed mtd minimum
	 */
	public int getSpeedMTDMinimum() {
		return speedMTDMinimum;
	}

	/**
	 * Sets the speed mtd minimum.
	 *
	 * @param speedMTDMinimum the new speed mtd minimum
	 */
	public void setSpeedMTDMinimum(int speedMTDMinimum) {
		this.speedMTDMinimum = speedMTDMinimum;
	}

	/**
	 * Checks if is found.
	 *
	 * @return true, if is found
	 */
	public boolean isFound() {
		return isFound;
	}

	/**
	 * Sets the found.
	 *
	 * @param isFound the new found
	 */
	public void setFound(boolean isFound) {
		this.isFound = isFound;
	}

	/**
	 * Gets the speed move sts freely.
	 *
	 * @return the speed move sts freely
	 */
	public float getSpeedMoveSTSFreely() {
		return speedMoveSTSFreely;
	}

	/**
	 * Sets the speed move sts freely.
	 *
	 * @param speedMoveSTSFreely the new speed move sts freely
	 */
	public void setSpeedMoveSTSFreely(float speedMoveSTSFreely) {
		this.speedMoveSTSFreely = speedMoveSTSFreely;
	}
}
