/**
 * File name:	SettingsManager.java
 * Version:		1.0
 * Date:		@date 13:11:50
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

package com.sawan.mathattack.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.sawan.mathattack.settings.MtxLogger;

// TODO: Auto-generated Javadoc
/**
 * The Class SettingsManager.
 */
public class SettingsManager {
	//
	/** The Constant logTag. */
	private static final String logTag = "MtxSettingsManagerLog";
	
	/** The log active. */
	public static boolean logActive = true;

	// Public values
	/** The Constant PREFS_FILE_NAME. */
	public static final String PREFS_FILE_NAME = "MyPreferences";
	
	/** The Constant prefs. */
	public static final Preferences prefs = Gdx.app
			.getPreferences(PREFS_FILE_NAME);

	// Sound, Music, Vibration
	/** The is sound on. */
	private static boolean isSoundOn = false;
	
	/** The is music on. */
	private static boolean isMusicOn = false;
	
	/** The is vibration on. */
	private static boolean isVibrationOn = false;

	// First Launch
	/** The Constant KEY_FIRST_LAUNCH_DONE. */
	private static final String KEY_FIRST_LAUNCH_DONE = "firstLaunch";

	// General Settings
	/** The Constant KEY_MUSIC. */
	private static final String KEY_MUSIC = "musicSetting";
	
	/** The Constant KEY_SOUND. */
	private static final String KEY_SOUND = "soundEffectSetting";
	
	/** The Constant KEY_VIBRATION. */
	private static final String KEY_VIBRATION = "vibrationSetting";

	/**
	 * Set music on/off, it sets to android preferences and isMusicOn in
	 * SettingManager.
	 *
	 * @param isMusicActive the new music
	 */
	public static void setMusic(boolean isMusicActive) {
		if (isMusicActive) {
			setBooleanPrefValue(KEY_MUSIC, true);
			setSettings();
		} else {
			setBooleanPrefValue(KEY_MUSIC, false);
			setSettings();
		}
	}

	/**
	 * Get music if on/off.
	 *
	 * @return true, if is music on
	 */
	public static boolean isMusicOn() {
		return isMusicOn;
	}

	/**
	 * Get music if on/off from preferences, do not use this in game, you would
	 * not want to access android preferences many times during the game.
	 *
	 * @return true, if is music on from preferences
	 */
	public static boolean isMusicOnFromPreferences() {
		return getBooleanPrefValue(KEY_MUSIC, false);
	}

	/**
	 * Set sound on/off, it sets to android preferences and isSoundOn in
	 * SettingManager.
	 *
	 * @param isSoundActive the new sound
	 */
	public static void setSound(boolean isSoundActive) {
		if (isSoundActive) {
			setBooleanPrefValue(KEY_SOUND, true);
			setSettings();
		} else {
			setBooleanPrefValue(KEY_SOUND, false);
			setSettings();
		}
	}

	/**
	 * Get sound if on/off.
	 *
	 * @return true, if is sound on
	 */
	public static boolean isSoundOn() {
		return isSoundOn;
	}

	/**
	 * Get sound if on/off from preferences, do not use this in game, you would
	 * not want to access android preferences many times during the game.
	 *
	 * @return true, if is sound on from preferences
	 */
	public static boolean isSoundOnFromPreferences() {
		return getBooleanPrefValue(KEY_SOUND, false);
	}

	/**
	 * Set vibration on/off, it sets to android preferences and isVibrationOn in
	 * SettingManager.
	 *
	 * @param isVibrationActive the new vibration
	 */
	public static void setVibration(boolean isVibrationActive) {
		if (isVibrationActive) {
			setBooleanPrefValue(KEY_VIBRATION, true);
			setSettings();
		} else {
			setBooleanPrefValue(KEY_VIBRATION, false);
			setSettings();
		}
	}

	/**
	 * Get vibration if on/off.
	 *
	 * @return true, if is vibration on
	 */
	public static boolean isVibrationOn() {
		return isVibrationOn;
	}

	/**
	 * Get vibration if on/off from preferences, do not use this in game, you
	 * would not want to access android preferences many times during the game.
	 *
	 * @return true, if is vibration on from preferences
	 */
	public static boolean isVibrationOnFromPreferences() {
		return getBooleanPrefValue(KEY_VIBRATION, false);
	}

	/**
	 * Set static variables due to android preferences (isSoundOn, isMusicOn,
	 * isVibrationOn) This method also called in resume() of "AbstractGame" for
	 * %100 guarantee of static variables are set correctly after pause/resume
	 * of the game.
	 */
	public static void setSettings() {
		if (isMusicOnFromPreferences()) {
			isMusicOn = true;
		} else {
			isMusicOn = false;
		}
		//
		if (isSoundOnFromPreferences()) {
			isSoundOn = true;
		} else {
			isSoundOn = false;
		}
		//
		if (isVibrationOnFromPreferences()) {
			isVibrationOn = true;
		} else {
			isVibrationOn = false;
		}
	}

	/**
	 * Set as first launch for the app. It saves to Android Preferences.
	 * 
	 * @param isFirstLaunchDone
	 *            value to set as first launch
	 * */
	public static void setFirstLaunchDone(boolean isFirstLaunchDone) {
		if (isFirstLaunchDone) {
			setBooleanPrefValue(KEY_FIRST_LAUNCH_DONE, true);
			MtxLogger.log(logActive, true, logTag, "SETTED AS FIRST LAUNCH");
		} else {
			setBooleanPrefValue(KEY_FIRST_LAUNCH_DONE, false);
			MtxLogger
					.log(logActive, true, logTag,
							"REMOVED FIRST LAUNCH (Probably overridden the previous first launch)");
		}
	}

	/**
	 * Check the game if it is first launch or not, it is helpful to create
	 * first launch files which should be created once. It can be checked in
	 * every game launch. To set as first launch use the "setFirstLaunchDone"
	 * method
	 *
	 * @return true, if is first launch done
	 * @see setFirstLaunchDone(boolean isFirstLaunchDone);
	 */
	public static boolean isFirstLaunchDone() {
		boolean isFirstLaunchDone = getBooleanPrefValue(KEY_FIRST_LAUNCH_DONE,
				false);
		if (isFirstLaunchDone) {
			MtxLogger.log(logActive, true, logTag,
					"NOT FIRST LAUNCH OF THE APP (First launch set before)");
			return true;
		} else {
			MtxLogger.log(logActive, true, logTag, "FIRST LAUNCH OF THE APP");
			return false;
		}
	}

	/**
	 * Get a android preferences, if it is not set it returns def value.
	 *
	 * @param key the key
	 * @param defValue the def value
	 * @return the string pref value
	 */
	public static String getStringPrefValue(String key, String defValue) {
		String value = prefs.getString(key, defValue);
		MtxLogger.log(logActive, true, logTag, "Pref (Key: " + key + "): "
				+ value);
		return value;

	}

	/**
	 * Get a android preferences, if it is not set it returns def value.
	 *
	 * @param key the key
	 * @param defValue the def value
	 * @return the boolean pref value
	 */
	public static Boolean getBooleanPrefValue(String key, boolean defValue) {
		boolean value = prefs.getBoolean(key, defValue);
		MtxLogger.log(logActive, true, logTag, "Pref (Key: " + key + "): "
				+ value);
		return value;
	}

	/**
	 * Get a android preferences, if it is not set it returns def value.
	 *
	 * @param key the key
	 * @param defValue the def value
	 * @return the integer pref value
	 */
	public static int getIntegerPrefValue(String key, int defValue) {
		int value = prefs.getInteger(key, defValue);
		MtxLogger.log(logActive, true, logTag, "Pref (Key: " + key + "): "
				+ value);
		return value;
	}

	/**
	 * Set an android preference (boolean).
	 *
	 * @param key the key
	 * @param value the value
	 */
	public static void setBooleanPrefValue(String key, boolean value) {
		prefs.putBoolean(key, value);
		prefs.flush();
	}

	/**
	 * Set an android preference (String).
	 *
	 * @param key the key
	 * @param value the value
	 */
	public static void setStringPrefValue(String key, String value) {
		prefs.putString(key, value);
		prefs.flush();
	}

	/**
	 * Set an android preference (Integer).
	 *
	 * @param key the key
	 * @param value the value
	 */
	public static void setIntegerPrefValue(String key, int value) {
		prefs.putInteger(key, value);
		prefs.flush();
	}
}
