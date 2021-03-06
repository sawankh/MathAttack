/**
 * File name:	Addition.java
 * Version:		1.0
 * Date:		26/3/2015 8:59:19
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


// TODO: Auto-generated Javadoc
/**
 * The Class Addition.
 *
 * @author Itop1
 */
public class Addition implements IQuestion {

	/** The first_number. */
	private int first_number;
	
	/** The second_number. */
	private int second_number;

	/** The question. */
	private String question;
	
	/** The correct_answer. */
	private int correct_answer;
	
	/** The answers. */
	private int [] answers;
	
	/**
	 * Instantiates a new addition.
	 *
	 * @param first_number the first_number
	 * @param second_number the second_number
	 */
	public Addition(int first_number, int second_number) {
		this.first_number = first_number;
		this.second_number = second_number;
		question = setQuestion(first_number, second_number);
		correct_answer = getAnswer();
		answers = new int [QuestionsSettings.NUM_ANSWER];
		setRandomAnswers(correct_answer);
	}

	/* (non-Javadoc)
	 * @see com.sawan.mathattack.math.IQuestion#setQuestion(int, int)
	 */
	@Override
	public String setQuestion(int first_number, int second_number) {
		String question = Integer.toString(first_number) + " " + QuestionsSettings.OPERATION_SYMBOL_ADDITION + " " + Integer.toString(second_number) + " = ?";
		return question; 
	}

	/* (non-Javadoc)
	 * @see com.sawan.mathattack.math.IQuestion#getAnswer()
	 */
	@Override
	public int getAnswer() {
		int result = first_number + second_number;
		return result;
	}

	/* (non-Javadoc)
	 * @see com.sawan.mathattack.math.IQuestion#setRandomAnswers(int)
	 */
	@Override
	public void setRandomAnswers(int correct_answer) {
		int lower_bound = (correct_answer / 10) * 10;
		int higher_bound = lower_bound + 10;
		
		for (int i = 0; i < answers.length; i++) {
			if (i == 0) {
				answers[i] = correct_answer;
			} else {
				int random_answer = 0;
				
				// Loop to do not generate correct answer twice
				do {
					random_answer = QuestionsUtils.randomNumber(lower_bound, higher_bound);
				} while (random_answer == correct_answer);
				
				answers[i] = random_answer;
			}			
			
		}
		
		// Shuffle the answers
		QuestionsUtils.shuffleArray(answers);
	}

	/**
	 * Gets the question.
	 *
	 * @return the question
	 */
	@Override
	public String getQuestion() {
		return question;
	}

	/**
	 * Sets the question.
	 *
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * Gets the correct_answer.
	 *
	 * @return the correct_answer
	 */
	@Override
	public int getCorrect_answer() {
		return correct_answer;
	}

	/**
	 * Sets the correct_answer.
	 *
	 * @param correct_answer the correct_answer to set
	 */
	public void setCorrect_answer(int correct_answer) {
		this.correct_answer = correct_answer;
	}

	/**
	 * Gets the answers.
	 *
	 * @return the answers
	 */
	@Override
	public int[] getAnswers() {
		return answers;
	}

	/**
	 * Sets the answers.
	 *
	 * @param answers the answers to set
	 */
	public void setAnswers(int[] answers) {
		this.answers = answers;
	}

	
	
}
