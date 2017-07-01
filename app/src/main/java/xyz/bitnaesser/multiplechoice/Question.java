package xyz.bitnaesser.multiplechoice;

import java.util.LinkedList;

public class Question {
	private LinkedList<Answer> answerList;
	private String questionString;

	public Question(String _question){
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
