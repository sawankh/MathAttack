/**
 * File name:	BenchmarkManager.java
 * Version:		1.0
 * Date:		@date 13:11:33
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
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class BenchmarkManager.
 */
public class BenchmarkManager {

	// Stage and font
	/** The stage. */
	private Stage stage;
	
	/** The font. */
	private BitmapFont font;

	// Run time
	/** The start time. */
	private long startTime = System.nanoTime();
	
	/** The seconds time. */
	private long secondsTime = 0L;

	// Table and labels
	/** The table. */
	private Table table;
	
	/** The label run time. */
	private Label labelRunTime;
	
	/** The label resolution. */
	private Label labelResolution;
	
	/** The label fps. */
	private Label labelFps;

	// Helpers
	/** The is benchmark manager active. */
	private boolean isBenchmarkManagerActive = true;
	
	/** The is first data taken. */
	private boolean isFirstDataTaken = false;
	
	/** The fps best. */
	private int fpsBest = 0;
	
	/** The fps worst. */
	private int fpsWorst = 0;

	// Label strings
	/** The Constant LABEL_RUNTIME. */
	private static final String LABEL_RUNTIME = "Run Time: ";
	
	/** The Constant LABEL_RESOLUTION. */
	private static final String LABEL_RESOLUTION = "Resolution: ";
	
	/** The Constant LABEL_FPS. */
	private static final String LABEL_FPS = "Fps: ";
	
	/** The Constant LABEL_FPS_BEST. */
	private static final String LABEL_FPS_BEST = "Best: ";
	
	/** The Constant LABEL_FPS_WORST. */
	private static final String LABEL_FPS_WORST = "Worst: ";

	// Benchmark Table positioner
	/**
	 * The Enum BenchmarkPosition.
	 */
	public enum BenchmarkPosition {
		
		/** The center. */
		CENTER, 
 /** The top left. */
 TOP_LEFT, 
 /** The top right. */
 TOP_RIGHT, 
 /** The bottom left. */
 BOTTOM_LEFT, 
 /** The bottom right. */
 BOTTOM_RIGHT;
	}

	/**
	 * Instantiates a new benchmark manager.
	 *
	 * @param stage the stage
	 * @param font the font
	 * @param benchmarkPosition the benchmark position
	 */
	public BenchmarkManager(Stage stage, BitmapFont font,
			BenchmarkPosition benchmarkPosition) {
		//
		this.stage = stage;
		this.font = font;
		//
		setUp(benchmarkPosition);
	}

	/**
	 * Set up benchmark table and the rest.
	 *
	 * @param benchmarkPosition the new up
	 */
	private void setUp(BenchmarkPosition benchmarkPosition) {
		table = new Table();
		table.setFillParent(true);
		table.setTouchable(Touchable.disabled);
		stage.addActor(table);
		//
		setUpBencmarks();
		setUpPosition(benchmarkPosition);
	}

	/**
	 * Set up benchmark labels.
	 */
	private void setUpBencmarks() {
		LabelStyle style = new LabelStyle(font, null);
		//
		labelResolution = new Label(getResolution(), style);
		labelRunTime = new Label(getRunTime(), style);
		labelFps = new Label(getFPS(), style);
		//
		table.add().row().left();
		table.add(labelResolution).row().left();
		table.add(labelRunTime).row().left();
		table.add(labelFps).row().left();
		table.add().left();
	}

	/**
	 * Update benchmarking. Must be used in render (or act or draw etc...)
	 * */
	public void update() {
		if (isBenchmarkManagerActive) {

			if (System.nanoTime() - startTime >= 1000000000) {
				secondsTime++;
				startTime = System.nanoTime();
			}

			if (!isFirstDataTaken) {
				if (secondsTime > 4f) {
					fpsBest = Gdx.graphics.getFramesPerSecond();
					fpsWorst = Gdx.graphics.getFramesPerSecond();
					isFirstDataTaken = true;
				}
			} else {
				if (Gdx.graphics.getFramesPerSecond() > fpsBest)
					fpsBest = Gdx.graphics.getFramesPerSecond();
				if (Gdx.graphics.getFramesPerSecond() < fpsWorst)
					fpsWorst = Gdx.graphics.getFramesPerSecond();
			}

			//
			labelRunTime.setText(getRunTime());
			labelFps.setText(getFPS());
		}
	}

	/**
	 * Get run time since BenchmarkManager constructed.
	 *
	 * @return the run time
	 */
	public String getRunTime() {
		int seconds = (int) (secondsTime % 60);
		int minutes = (int) ((secondsTime / 60) % 60);
		int hours = (int) ((secondsTime / 3600) % 24);
		String secondsStr = (seconds < 10 ? "0" : "") + seconds;
		String minutesStr = (minutes < 10 ? "0" : "") + minutes;
		String hoursStr = (hours < 10 ? "0" : "") + hours;
		return LABEL_RUNTIME + hoursStr + ":" + minutesStr + ":" + secondsStr;
	}

	/**
	 * Get resolution.
	 *
	 * @return the resolution
	 */
	public String getResolution() {
		return LABEL_RESOLUTION + Gdx.graphics.getWidth() + "x"
				+ Gdx.graphics.getHeight();
	}

	/**
	 * Get current FPS (frame per seconds) and Best/Worst FPS. (Best/Worst fps
	 * starts after 5 seconds to achieve best accuracy). LibGDX renders at 60
	 * FPS
	 *
	 * @return the fps
	 */
	public String getFPS() {
		return LABEL_FPS + Gdx.graphics.getFramesPerSecond()
				+ getFPSBestWorst();
	}

	/**
	 * Get Best/Worst FPS. (Best/Worst fps starts after 5 seconds to achieve
	 * best accuracy)
	 *
	 * @return the FPS best worst
	 */
	public String getFPSBestWorst() {
		return "   (" + LABEL_FPS_BEST + fpsBest + " - " + LABEL_FPS_WORST
				+ fpsWorst + ")";
	}

	/**
	 * Sets the benchmark manager active.
	 *
	 * @param isActive the new benchmark manager active
	 */
	public void setBenchmarkManagerActive(boolean isActive) {
		if (isActive) {
			isBenchmarkManagerActive = true;
			table.setVisible(true);
		} else {
			isBenchmarkManagerActive = false;
			table.setVisible(false);
		}
	}

	/**
	 * Set benchmark table position.
	 *
	 * @param benchmarkPosition the new up position
	 */
	public void setUpPosition(BenchmarkPosition benchmarkPosition) {
		switch (benchmarkPosition) {
		case CENTER:
			table.center();
			break;
		case TOP_LEFT:
			table.top().left();
			break;
		case TOP_RIGHT:
			table.top().right();
			break;
		case BOTTOM_LEFT:
			table.bottom().left();
			break;
		case BOTTOM_RIGHT:
			table.bottom().right();
			break;
		default:
			table.top().left();
			break;
		}
	}
}
