/**
 * File name:	MathAttackMainMenuScreen.java
 * Version:		1.0
 * Date:		01/03/2015 19:28:24
 * Author:		Sawan
 * Copyright:	Copyright 200X Sawan
 *
 *				This file is part of Foobar.
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
package com.sawan.mathattack.game_screens.main;

import com.sawan.mathattack.buttons.MathAttackButton;
import com.sawan.mathattack.game.AbstractGame;
import com.sawan.mathattack.interfaces.IScreen;
import com.sawan.mathattack.models.EmptyActor;
import com.sawan.mathattack.models.EmptyActorLight;
import com.sawan.mathattack.scene2d.ui.TableModel;
import com.sawan.mathattack.screen.AbstractScreen;

/**
 * @author Sawan
 *
 */
public class MathAttackMainMenuScreen extends AbstractScreen implements IScreen {

	
	
	public TableModel menu_table;
	public EmptyActorLight title;
	public MathAttackButton button_play;
	public MathAttackButton button_settings;
	public MathAttackButton button_credits;
	
	public MathAttackMainMenuScreen(AbstractGame game, String screenName) {
		super(game, screenName);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void setUpScreenElements() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setUpMenu() {
		// TODO Auto-generated method stub
		
	}
}
