import javafx.fxml.FXML;
//import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import java.util.ArrayList;
import java.util.List;


// Class that displays the Multiple Choice Test
public class MultipleChoiceController {
	@FXML
    private VBox questionsContainer;

    @FXML
    private Label testResultsDisplay;
    
    @FXML 
    private Button finishTestButton;
    
    //Display colors:
    final private String rightColor = "-fx-background-color: lightgreen;";
    final private String wrongColor = "-fx-background-color: red;";
    
    private boolean isTestFinished = false;
    
    private List<Question> questions = new ArrayList<>(); //list of Question objects
    private List<ToggleGroup> toggleGroups = new ArrayList<>();
    
    public void initialize() {
        QuestionsCollection qc = new QuestionsCollection();
        questions = qc.getQuestions();
        for(Question question : questions) {
            VBox questionBox = new VBox(10); // container (box) for each question and answers component
            Label questionLabel = new Label(question.getQuestion());
            questionLabel.setWrapText(true);
            
            questionBox.getChildren().add(questionLabel); //adds the question to the question container
            
            ToggleGroup group = new ToggleGroup();
            toggleGroups.add(group); // Store toggle group
            
            for(String answer : question.getAnswers()) {
                RadioButton rb = new RadioButton(answer);
                rb.setToggleGroup(group);
                rb.setWrapText(true);
                questionBox.getChildren().add(rb); //adds the possible answers to the container
            }
            //adds singular question container to the questions container
            questionsContainer.getChildren().add(questionBox); 
        }
    }
    
    // Button to finish tests and reset test
    @FXML
    private void onFinishTest() {
    	if (questions.size() == 0) { //Deals with a case of zero questions
    		testResultsDisplay.setText("No questions in this exam!");
    	}
    	else if (isTestFinished == false) { //displays test results
    		int correctAnswers = 0;
            
            for (int i = 0; i < toggleGroups.size(); i++) {
                ToggleGroup group = toggleGroups.get(i);
                Question currentQuestion = questions.get(i);
                
                RadioButton selected = (RadioButton) group.getSelectedToggle();
                if (selected != null) {
                    String userAnswer = selected.getText();
                    if (currentQuestion.isRightAnswer(userAnswer)) {
                    	selected.setStyle(rightColor);
                        correctAnswers++;
                    }
                    else {
                    	selected.setStyle(wrongColor);
                    }
                }
            }
            testResultsDisplay.setText("Grade: " + ((correctAnswers*100) / questions.size()) + "%");
            isTestFinished = true;
            finishTestButton.setText("Reset Test");
    	}
    	else {// Reset Test
            for (ToggleGroup group : toggleGroups) {
                group.selectToggle(null); //clears previous choices
                for (Toggle toggle : group.getToggles()) {
                    RadioButton rb = (RadioButton) toggle;
                    rb.setStyle(""); //clears choices colors
                }
            }
            testResultsDisplay.setText("Test reset. Try again!");
            isTestFinished = false;
            finishTestButton.setText("Finish Test");
        }
    }

}


