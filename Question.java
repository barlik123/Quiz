import java.util.ArrayList;
import java.util.Collections;
/*
	Class for a single Question.
	Includes the question itself and four answers 
   	when the first answer is the right one 
 */
public class Question {
	private String question = "";
	private ArrayList<String> answers = new ArrayList<String>();
	private String rightAnswer = "";
	private int numPossAnswers = 0;
	
	public Question(String question, ArrayList<String> answers, int numPossAnswers) throws Exception {
		this.question = question;
		this.numPossAnswers = numPossAnswers;
		if (answers.size() == this.numPossAnswers) {
			this.answers = answers;
			this.rightAnswer = answers.get(0);
		}
		else {
			throw new Exception("Invalid number of answers for the question: " + this.question);
		}
	}
	
	// Copy constructor
    public Question(Question original) {
        this.question = original.getQuestion();
        this.answers = new ArrayList<>(original.getAnswers()); // Deep copy of answers
        this.rightAnswer = original.getRightAnswer();
    }
	
	public String getRightAnswer() {
		return rightAnswer;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public ArrayList<String> getAnswers() {
		//deep copy of the answers arraylist
		ArrayList<String> shuffled = new ArrayList<>(answers); 
		Collections.shuffle(shuffled);
		return shuffled;
	}
	
	public boolean isRightAnswer(String answer) {
		return answer.equals(rightAnswer);
	}
	
}
