/*
 * *
 *  * ${PROJECT_NAME}
 *  * Copyright (c) ${YEAR} Dennis Suchomsky <dennis.suchomsky@gmail.com>
 *  *
 *  *  This program is free software: you can redistribute it and/or modify
 *  *  it under the terms of the GNU General Public License as published by
 *  *  the Free Software Foundation, either version 3 of the License, or
 *  *  (at your option) any later version.
 *  *
 *  *  This program is distributed in the hope that it will be useful,
 *  *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  *  GNU General Public License for more details.
 *  *
 *  *  You should have received a copy of the GNU General Public License
 *  *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 *
 * *
 *  @todo Keep it simple!
 * /
 */

package xyz.bitnaesser.multiplechoice.model;

import java.util.LinkedList;

public class Question {
	private LinkedList<Answer> answerList;
	private String questionString;

	Question(String _question){
		questionString = _question;
		answerList = new LinkedList<>();
	}

	public String getQuestionString(){
		return questionString;
	}

	public LinkedList<Answer> getAnswers(){
		return answerList;
	}

	public void addWrongAnswer(String answer){
		answerList.add(new WrongAnswer(answer));
	}

	public void addRightAnswer(String answer){
		answerList.add(new RightAnswer(answer));
	}

	abstract class Answer {
		private String answerString;

		Answer(String _answerString){
			answerString = _answerString;
		}

		public String getAnswerString() {
			return answerString;
		}
	}

	private class RightAnswer extends Answer {
		RightAnswer(String _answerString) {
			super(_answerString);
		}
	}
	private class WrongAnswer extends Answer {
		WrongAnswer(String _answerString) {
			super(_answerString);
		}
	}

}
