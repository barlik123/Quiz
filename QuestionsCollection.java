import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Class for the collection of questions read from the questionFile file.
// The questionFile file is designed in a format of question and 4 answers
// line after line when the first answer line is the correct answer.
public class QuestionsCollection {
	
	private ArrayList<Question> qstsCollection = new ArrayList<Question>();
	
	final private String questionsFile = "questions.txt"; // The file to read the questions from
	final private int numPossAnswers = 4; //number of answer options to a question
	
	public QuestionsCollection() {
		qstsCollection = questionsFromFile(questionsFile);
	}
	//ArrayList<Question>
	private ArrayList<Question> questionsFromFile(String filePath) {
		ArrayList<Question> questions = new ArrayList<Question>();
        Scanner scanner = null;
        int counter = 0;
        String q = "";
        ArrayList<String> answers = new ArrayList<String>();
        
        try {
            File file = new File(filePath);
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (counter % (numPossAnswers+1) == 0) {
                	if(counter >= (numPossAnswers+1)) { //finished scanning a question
                    	Question qst = new Question(q, new ArrayList<>(answers), numPossAnswers);
                    	questions.add(qst);
                    	answers.clear();
                	}
                	q = line;
                }
                else {
                	answers.add(line);
                }
                counter++;
            }
            //adds the last question to the collection if exists
            if (answers.size() == numPossAnswers) { 
                questions.add(new Question(q, new ArrayList<>(answers), numPossAnswers));
            }
        } 
        catch (FileNotFoundException e) {
        	System.out.println("The questions file " + questionsFile + " was not found.");
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        finally {
            if (scanner != null) {
                scanner.close(); 
            }
        }
        
        return questions;
    }
	
	public ArrayList<Question> getQuestions() {
	    ArrayList<Question> deepCopy = new ArrayList<>();
	    for (Question q : qstsCollection) {
	        deepCopy.add(new Question(q)); 
	    }
	    return deepCopy;
	}
	
	
}
