# Quiz

## Purpose:
An application that converts a textfile of quiz questions and answers to a app with answering and feedback capabilities.

## How does it work?
1. The questionsFromFile function in the QuestionsCollection file reads questions from a predefined file (in our case "questions.txt") and stores them.
2. Then the questions are converted to a gui with question on top and 4 possible answers below (with one right answer), and the questions are stacked vertically.
3. The student is than able to select is answers and submit the quiz with the "Finish Test" button. 
4. The results will then be displayed on the questions themselves and a grade in the buttom left corner will be displayed too.
5. The student will then be able to retake the test if desired to try and improve his score.

### Text file format:
The text file that initially contains the questions is in the format:

Question

Right Answer

Wrong Answer

Wrong Answer

Wrong Answer

## Necessary libraries:
To run the gui, JavaFX is needed. You can download the library from this link:
https://openjfx.io/openjfx-docs/
