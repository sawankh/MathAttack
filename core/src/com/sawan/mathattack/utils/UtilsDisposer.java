/**
 * File name:	UtilsDisposer.java
 * Version:		1.0
 * Date:		@date 13:16:55
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

import java.util.ArrayList;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.sawan.mathattack.game.AbstractGame;
import com.sawan.mathattack.models.EmptyActor;
import com.sawan.mathattack.models.EmptyActorLight;
import com.sawan.mathattack.models.SmartActor;
import com.sawan.mathattack.scene2d.AbstractActor;
import com.sawan.mathattack.scene2d.AbstractActorLight;
import com.sawan.mathattack.screen.AbstractScreen;
import com.sawan.mathattack.settings.MtxLogger;

// TODO: Auto-generated Javadoc
/**
 * The Class UtilsDisposer.
 */
public class UtilsDisposer {
	
	/** The Constant logTag. */
	protected final static String logTag = "MtxUtilsDisposerLog";
	
	/** The log active. */
	public static boolean logActive = true;

	/**
	 * Dispose actor from a group.
	 *
	 * @param group the group
	 * @param actorToBeDisposed the actor to be disposed
	 */
	public static void disposeActor(Group group, Actor actorToBeDisposed) {
		if (group != null && actorToBeDisposed != null) {
			try {
				actorToBeDisposed.clear();
				if (group.removeActor(actorToBeDisposed))
					log("Actor disposed", actorToBeDisposed);
			} catch (Exception e) {
				log("Actor dispose FAIL!", actorToBeDisposed);
			}
		}
	}

	/**
	 * Dispose group from a group.
	 *
	 * @param group the group
	 * @param groupToBeDisposed the group to be disposed
	 */
	public static void disposeGroup(Group group, Group groupToBeDisposed) {
		if (group != null && groupToBeDisposed != null) {
			try {
				groupToBeDisposed.clear();
				if (group.removeActor(groupToBeDisposed))
					log("Actor disposed", groupToBeDisposed);
			} catch (Exception e) {
				log("Actor dispose FAIL!", groupToBeDisposed);
			}
		}
	}

	/**
	 * Dispose empty actor from a group.
	 *
	 * @param group the group
	 * @param emptyActor the empty actor
	 */
	public static void disposeEmptyActor(Group group, EmptyActor emptyActor) {
		if (group != null && emptyActor != null) {
			try {
				emptyActor.clear();
				if (group.removeActor(emptyActor))
					log("Actor disposed", emptyActor);
			} catch (Exception e) {
				log("Actor dispose FAIL!", emptyActor);
			}
		}
	}

	/**
	 * Dispose empty actor light from a group.
	 *
	 * @param group the group
	 * @param emptyActorLight the empty actor light
	 */
	public static void disposeEmptyActorLight(Group group,
			EmptyActorLight emptyActorLight) {
		if (group != null && emptyActorLight != null) {
			try {
				emptyActorLight.clear();
				if (group.removeActor(emptyActorLight))
					log("Group disposed", emptyActorLight);
			} catch (Exception e) {
				log("Group dispose FAIL!", emptyActorLight);
			}
		}
	}

	/**
	 * Dispose abstract actor list from a group.
	 *
	 * @param group the group
	 * @param list the list
	 */
	public static void disposeAbstractActorList(Group group,
			ArrayList<AbstractActor> list) {
		if (group != null && list != null) {
			if (list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					AbstractActor abstractActor = list.get(i);
					try {
						abstractActor.clear();
						if (group.removeActor(abstractActor))
							log("Actor disposed", abstractActor);
					} catch (Exception e) {
						log("Actor dispose FAIL!", abstractActor);
					}
				}
			}
		}
	}

	/**
	 * Dispose abstract actor light list from a group.
	 *
	 * @param group the group
	 * @param list the list
	 */
	public static void disposeAbstractActorLightList(Group group,
			ArrayList<AbstractActorLight> list) {
		if (group != null && list != null) {
			if (list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					AbstractActorLight abstractActorLight = list.get(i);
					try {
						abstractActorLight.clear();
						if (group.removeActor(abstractActorLight))
							log("Actor disposed", abstractActorLight);
					} catch (Exception e) {
						log("Actor dispose FAIL!", abstractActorLight);
					}
				}
			}
		}
	}

	/**
	 * Dispose smart model list from a group.
	 *
	 * @param group the group
	 * @param list the list
	 */
	public static void disposeSmartModelList(Group group,
			ArrayList<SmartActor> list) {
		if (group != null && list != null) {
			if (list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					SmartActor sm = list.get(i);
					try {
						sm.clear();
						if (group.removeActor(sm))
							log("Smart Model disposed", sm);
					} catch (Exception e) {
						log("Smart Model dispose FAIL!", sm);
					}
				}
			}
		}
	}

	/**
	 * Dispose screen, at the end sets screen as "null"
	 * <p>
	 * - Disposing stage<br>.
	 *
	 * @param screen the screen
	 */
	public static void disposeScreen(AbstractScreen screen) {
		if (screen.getStage() != null) {
			screen.getStage().dispose();
			MtxLogger.log(logActive, true, logTag,
					"Disposed Stage: " + screen.getScreenName());
			screen = null;
		}
	}

	/**
	 * Dispose game
	 * <p>
	 * - Disposing asset manager<br>
	 * - Disposing skin<br>.
	 *
	 * @param game the game
	 */
	public static void disposeGame(AbstractGame game) {
		if (game.getAssets().getAssetManager() != null) {
			game.getAssets().getAssetManager().dispose();
			MtxLogger.log(logActive, true, logTag, "Disposed AssetManager");
		}

		if (game.getAssets().getSkin() != null) {
			game.getAssets().getSkin().dispose();
			MtxLogger.log(logActive, true, logTag, "Disposed Skin");
		}
	}

	/**
	 *  Easy logger.
	 *
	 * @param msj the msj
	 * @param actor the actor
	 */
	private static void log(String msj, Actor actor) {
		MtxLogger.log(logActive, true, logTag,
				msj + " (Actor Name: " + actor.getName() + ")");
	}
}
