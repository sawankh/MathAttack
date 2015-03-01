package com.sawan.jungle.buttons;

import java.util.Random;

import com.sawan.mathattack.models.SmartActor;



public class JungleGameButton extends SmartActor {

	//
	// Simple button extends SmartModel
	// ###############################################
	//
	// Normally I use ready buttons that I've created, but thanks to Scene2D,
	// every actor is a possible button, so I will make buttons out of our
	// SmartModel, this may be handy in future for effects/animations
	//
	public JungleGameButton(float width, float height, Random rnd,
			boolean DIPActive) {
		super(width, height, rnd, DIPActive);
	}
}
