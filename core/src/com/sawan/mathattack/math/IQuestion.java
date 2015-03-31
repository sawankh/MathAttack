/**
 * File name:	IQuestion.java
 * Version:		1.0
 * Date:		26/3/2015 8:54:45
 * Author:		Itop1
 * Copyright:	Copyright 200X Itop1
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
package com.sawan.mathattack.math;

/**
 * @author Itop1
 *
 */
public interface IQuestion {
	public String setQuestion(int first_number, int second_number);
	
	public int getAnswer();
	
	public void setRandomAnswers(int correct_answer);
	
	public String getQuestion();

	int getCorrect_answer();

	int[] getAnswers();
}
