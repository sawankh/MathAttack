/**
 * File name:	MusicManager.java
 * Version:		1.0
 * Date:		@date 13:11:43
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

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.audio.Music;

// TODO: Auto-generated Javadoc
/**
 * The Class MusicManager.
 */
public class MusicManager {
	//
	/** The rnd. */
	private Random rnd;
	
	/** The music shuffle list. */
	private ArrayList<Music> musicShuffleList;
	
	/** The current music. */
	private Music currentMusic;
	
	/** The audio manager. */
	private AudioManager audioManager;
	
	/** The is shuffling. */
	private boolean isShuffling = false;
	
	/** The shuffle volume. */
	private float shuffleVolume = 0.5f;

	/**
	 * Instantiates a new music manager.
	 */
	public MusicManager() {
		audioManager = new AudioManager();
		rnd = new Random();
		musicShuffleList = new ArrayList<Music>();
		currentMusic = null;
	}

	/**
	 * Adds the music to shuffle list.
	 *
	 * @param music the music
	 */
	public void addMusicToShuffleList(Music music) {
		musicShuffleList.add(music);
	}

	/**
	 * Play shuffle.
	 *
	 * @param volume the volume
	 */
	public void playShuffle(float volume) {
		clearCurrentMusic();
		clearLoops();
		isShuffling = true;
		startShuffling(volume);
	}

	/**
	 * Play music.
	 *
	 * @param music the music
	 * @param isLooping the is looping
	 * @param volume the volume
	 */
	public void playMusic(Music music, boolean isLooping, float volume) {
		clearCurrentMusic();
		isShuffling = false;
		currentMusic = music;
		shuffleVolume = volume;
		audioManager.playMusic(currentMusic, isLooping, shuffleVolume);
	}

	/**
	 * Stop music.
	 */
	public void stopMusic() {
		if (currentMusic != null) {
			currentMusic.stop();
		}
	}

	/**
	 * Pause music.
	 */
	public void pauseMusic() {
		if (currentMusic != null) {
			currentMusic.pause();
		}
	}

	/**
	 * Clear loops.
	 */
	private void clearLoops() {
		for (int i = 0; i < musicShuffleList.size(); i++) {
			Music m = musicShuffleList.get(i);
			m.setLooping(false);
		}
	}

	/**
	 * Clear current music.
	 */
	private void clearCurrentMusic() {
		if (currentMusic != null) {
			currentMusic.stop();
			currentMusic = null;
		}
	}

	/**
	 * Start shuffling.
	 *
	 * @param volume the volume
	 */
	private void startShuffling(float volume) {
		if (musicShuffleList.size() > 0) {
			int rndNumber = rnd.nextInt(musicShuffleList.size());
			currentMusic = musicShuffleList.get(rndNumber);
			audioManager.playMusic(currentMusic, false, volume);
		}
	}

	/**
	 * This method must be checked in render() or similar all the time, for
	 * shuffle list.
	 */
	public void checkShuffleMusicFinished() {
		if (isShuffling) {
			if (currentMusic != null) {
				if (!currentMusic.isPlaying()) {
					startShuffling(shuffleVolume);
				}
			}
		}
	}

	/**
	 * Gets the music shuffle list.
	 *
	 * @return the music shuffle list
	 */
	public ArrayList<Music> getMusicShuffleList() {
		return musicShuffleList;
	}

	/**
	 * Gets the audio manager.
	 *
	 * @return the audio manager
	 */
	public AudioManager getAudioManager() {
		return audioManager;
	}

	/**
	 * Gets the current music.
	 *
	 * @return the current music
	 */
	public Music getCurrentMusic() {
		return currentMusic;
	}
}
