/**
 * File name:	AudioManager.java
 * Version:		1.0
 * Date:		@date 13:11:29
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

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class AudioManager {

	public AudioManager() {
	}

	/**
	 * Play sound effect, it only plays if SettingsManager.isSoundOn() is true
	 * 
	 * @param sound
	 *            to play
	 * @param volume
	 *            is the volume setting (Range [0.0 - 1.0])
	 * @see SettingsManager.isSoundOn
	 * 
	 * */
	public void playSound(Sound sound, float volume) {
		if (SettingsManager.isSoundOn()) {
			sound.play(volume);
		}
	}

	/**
	 * Play music, it only plays if SettingsManager.isMusicOn() is true
	 * 
	 * @param music
	 *            to play
	 * @param isLooping
	 *            to loop or not
	 * @param volume
	 *            is the volume setting (Range [0.0 - 1.0])
	 * @see SettingsManager.isMusicOn
	 * 
	 * */
	public void playMusic(Music music, boolean isLooping, float volume) {
		if (SettingsManager.isMusicOn()) {
			music.setLooping(isLooping);
			music.setVolume(volume);
			music.play();
		}
	}
}
