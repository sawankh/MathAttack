/**
 * File name:	EffectCreator.java
 * Version:		1.0
 * Date:		@date 13:08:26
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

package com.sawan.mathattack.effects;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.sawan.mathattack.settings.MtxLogger;

// TODO: Auto-generated Javadoc
/**
 * The Class EffectCreator.
 */
public class EffectCreator {
	
	/** The Constant logTag. */
	private static final String logTag = "MtxEffectCreator";
	
	/** The log active. */
	public static boolean logActive = true;

	//
	// COMMAND SHORTCUTS
	// ################################################################
	//
	// SC - Scale
	// BTN - Back To Normal
	// FI - Fade In
	// FO - Fade Out
	// SHK - Shake
	// MT - Move To

	//
	// SINGLE EFFECTS
	// ################################################################
	/**
	 * Scale effect (SC).
	 *
	 * @param actor the actor
	 * @param scaleRatioX the scale ratio x
	 * @param scaleRatioY the scale ratio y
	 * @param duration the duration
	 * @param group the group
	 * @param removeActor the remove actor
	 */
	public static void create_SC(Actor actor, float scaleRatioX,
			float scaleRatioY, float duration, final Group group,
			final boolean removeActor) {
		if (actor != null) {
			actor.addAction(Actions.sequence(
					Actions.scaleTo(scaleRatioX, scaleRatioY, duration),
					new Action() {
						@Override
						public boolean act(float delta) {
							if (removeActor) {
								removeActor(group, actor);
								return false;
							} else {
								return true;
							}
						}
					}));
		}
	}

	/**
	 * Fade Out (FO).
	 *
	 * @param actor the actor
	 * @param duration the duration
	 * @param delay the delay
	 * @param group the group
	 * @param removeActor the remove actor
	 */
	public static void create_FO(Actor actor, float duration, float delay,
			final Group group, final boolean removeActor) {
		if (actor != null) {
			actor.addAction(Actions.sequence(Actions.delay(delay),
					Actions.fadeOut(duration), new Action() {
						@Override
						public boolean act(float delta) {
							if (removeActor) {
								removeActor(group, actor);
								return false;
							} else {
								return true;
							}
						}
					}));
		}
	}

	/**
	 * Fade In (FI).
	 *
	 * @param actor the actor
	 * @param duration the duration
	 * @param delay the delay
	 * @param group the group
	 * @param removeActor the remove actor
	 */
	public static void create_FI(Actor actor, float duration, float delay,
			final Group group, final boolean removeActor) {
		if (actor != null) {
			actor.addAction(Actions.sequence(Actions.delay(delay),
					Actions.fadeIn(duration), new Action() {
						@Override
						public boolean act(float delta) {
							if (removeActor) {
								removeActor(group, actor);
								return false;
							} else {
								return true;
							}
						}
					}));
		}
	}

	/**
	 * Move to a position.
	 *
	 * @param actor the actor
	 * @param duration the duration
	 * @param delayBefore the delay before
	 * @param posX the pos x
	 * @param posY the pos y
	 * @param group the group
	 * @param removeActor the remove actor
	 */
	public static void create_MT(Actor actor, float duration,
			float delayBefore, float posX, float posY, final Group group,
			final boolean removeActor) {
		if (actor != null) {
			actor.addAction(Actions.sequence(Actions.delay(delayBefore),
					Actions.moveTo(posX, posY, duration), new Action() {
						@Override
						public boolean act(float delta) {
							if (removeActor) {
								removeActor(group, actor);
								return false;
							} else {
								return true;
							}
						}
					}));
		}
	}

	/**
	 * Shake effect (SHK).
	 *
	 * @param actor the actor
	 * @param shakeAngle the shake angle
	 * @param originalAngle the original angle
	 * @param duration the duration
	 * @param group the group
	 * @param removeActor the remove actor
	 */
	public static void create_SHK(Actor actor, float shakeAngle,
			float originalAngle, float duration, final Group group,
			final boolean removeActor) {
		if (actor != null) {
			actor.addAction(Actions.sequence(
					Actions.rotateTo(shakeAngle, duration),
					Actions.rotateTo(-shakeAngle, duration),
					Actions.rotateTo(originalAngle, duration), new Action() {
						@Override
						public boolean act(float delta) {
							if (removeActor) {
								removeActor(group, actor);
								return false;
							} else {
								return true;
							}
						}
					}));
		}
	}

	//
	// DOUBLE EFFECTS (Sequence - Chain reaction)
	// ################################################################
	/**
	 * Scale effect and Back to previous scale (SC, BTN).
	 *
	 * @param actor the actor
	 * @param scaleRatioX the scale ratio x
	 * @param scaleRatioY the scale ratio y
	 * @param duration the duration
	 * @param group the group
	 * @param removeActor the remove actor
	 */
	public static void create_SC_BTN(Actor actor, float scaleRatioX,
			float scaleRatioY, float duration, final Group group,
			final boolean removeActor) {
		if (actor != null) {
			float originalScaleX = actor.getScaleX();
			float originalScaleY = actor.getScaleY();
			actor.addAction(Actions.sequence(
					Actions.scaleTo(scaleRatioX, scaleRatioY, duration),
					Actions.scaleTo(originalScaleX, originalScaleY, duration),
					new Action() {
						@Override
						public boolean act(float delta) {
							if (removeActor) {
								removeActor(group, actor);
								return false;
							} else {
								return true;
							}
						}
					}));
		}
	}

	/**
	 * Scale effect and Back to original (1.0f)
	 *
	 * @param actor the actor
	 * @param scaleRatioX the scale ratio x
	 * @param scaleRatioY the scale ratio y
	 * @param duration the duration
	 * @param group the group
	 * @param removeActor the remove actor
	 */
	public static void create_SC_BTO(Actor actor, float scaleRatioX,
			float scaleRatioY, float duration, final Group group,
			final boolean removeActor) {
		if (actor != null) {
			actor.addAction(Actions.sequence(
					Actions.scaleTo(scaleRatioX, scaleRatioY, duration),
					Actions.scaleTo(1.0f, 1.0f, duration), new Action() {
						@Override
						public boolean act(float delta) {
							if (removeActor) {
								removeActor(group, actor);
								return false;
							} else {
								return true;
							}
						}
					}));
		}
	}

	/**
	 * Scale effect, Fade Out (SC, FO).
	 *
	 * @param actor the actor
	 * @param scaleRatioX the scale ratio x
	 * @param scaleRatioY the scale ratio y
	 * @param duration the duration
	 * @param delayBeforeFadeOut the delay before fade out
	 * @param group the group
	 * @param removeActor the remove actor
	 */
	public static void create_SC_FO(Actor actor, float scaleRatioX,
			float scaleRatioY, float duration, float delayBeforeFadeOut,
			final Group group, final boolean removeActor) {
		if (actor != null) {
			actor.addAction(Actions.sequence(
					Actions.scaleTo(scaleRatioX, scaleRatioY, duration),
					Actions.delay(delayBeforeFadeOut),
					Actions.fadeOut(duration), new Action() {
						@Override
						public boolean act(float delta) {
							if (removeActor) {
								removeActor(group, actor);
								return false;
							} else {
								return true;
							}
						}
					}));
		}
	}

	/**
	 * Scale effect, Shake effect (SC, SHK).
	 *
	 * @param actor the actor
	 * @param scaleRatioX the scale ratio x
	 * @param scaleRatioY the scale ratio y
	 * @param shakeAngle the shake angle
	 * @param originalAngle the original angle
	 * @param duration the duration
	 * @param group the group
	 * @param removeActor the remove actor
	 */
	public static void create_SC_SHK(Actor actor, float scaleRatioX,
			float scaleRatioY, float shakeAngle, float originalAngle,
			float duration, final Group group, final boolean removeActor) {
		if (actor != null) {
			actor.addAction(Actions.sequence(
					Actions.scaleTo(scaleRatioX, scaleRatioY, duration),
					Actions.rotateTo(shakeAngle, duration),
					Actions.rotateTo(-shakeAngle, duration),
					Actions.rotateTo(originalAngle, duration), new Action() {
						@Override
						public boolean act(float delta) {
							if (removeActor) {
								removeActor(group, actor);
								return false;
							} else {
								return true;
							}
						}
					}));
		}
	}

	//
	// TRIPLE EFFECTS (Sequence - Chain reaction)
	// ################################################################
	/**
	 * Scale effect, Back To Normal, Fade Out (SC, BTN, FO).
	 *
	 * @param actor the actor
	 * @param scaleRatioX the scale ratio x
	 * @param scaleRatioY the scale ratio y
	 * @param duration the duration
	 * @param delayBeforeFadeOut the delay before fade out
	 * @param group the group
	 * @param removeActor the remove actor
	 */
	public static void create_SC_BTN_FO(Actor actor, float scaleRatioX,
			float scaleRatioY, float duration, float delayBeforeFadeOut,
			final Group group, final boolean removeActor) {
		if (actor != null) {
			actor.addAction(Actions.sequence(
					Actions.scaleTo(scaleRatioX, scaleRatioY, duration),
					Actions.scaleTo(1, 1, duration),
					Actions.delay(delayBeforeFadeOut),
					Actions.fadeOut(duration), new Action() {
						@Override
						public boolean act(float delta) {
							if (removeActor) {
								removeActor(group, actor);
								return false;
							} else {
								return true;
							}
						}
					}));
		}
	}

	/**
	 * Scale effect, Shake effect, Back To Normal (SC, SHK, BTN).
	 *
	 * @param actor the actor
	 * @param scaleRatioX the scale ratio x
	 * @param scaleRatioY the scale ratio y
	 * @param shakeAngle the shake angle
	 * @param originalAngle the original angle
	 * @param duration the duration
	 * @param group the group
	 * @param removeActor the remove actor
	 */
	public static void create_SC_SHK_BTN(Actor actor, float scaleRatioX,
			float scaleRatioY, float shakeAngle, float originalAngle,
			float duration, final Group group, final boolean removeActor) {
		if (actor != null) {
			actor.addAction(Actions.sequence(
					Actions.scaleTo(scaleRatioX, scaleRatioY, duration),
					Actions.rotateTo(shakeAngle, duration),
					Actions.rotateTo(-shakeAngle, duration),
					Actions.rotateTo(originalAngle, duration),
					Actions.scaleTo(1, 1, duration), new Action() {
						@Override
						public boolean act(float delta) {
							if (removeActor) {
								removeActor(group, actor);
								return false;
							} else {
								return true;
							}
						}
					}));
		}
	}

	/**
	 * Removes the actor.
	 *
	 * @param group the group
	 * @param actor the actor
	 */
	private static void removeActor(Group group, Actor actor) {
		if (group != null && actor != null) {
			actor.clearActions();
			String actorName = actor.getName();
			if (group.removeActor(actor)) {
				MtxLogger.log(logActive, true, logTag, "Actor removed! (Name: "
						+ actorName + ")");
			} else {
				MtxLogger.log(logActive, true, logTag,
						"Actor not removed! (Name: " + actorName + ")");
			}
		}
	}
}
