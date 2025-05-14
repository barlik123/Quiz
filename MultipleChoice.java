import javafx.application.Application; 
import javafx.fxml.FXMLLoader; 
import javafx.scene.Parent; 
import javafx.scene.Scene; 
import javafx.stage.Stage; 

// class that displays the application
public class MultipleChoice extends Application{  

	public void start(Stage stage) throws Exception{  
		Parent root = (Parent) 
		FXMLLoader.load(getClass().getResource("MultipleChoice.fxml"));  
		Scene scene = new Scene(root);  
		stage.setTitle("Test");  
		stage.setScene(scene);  
		stage.show();  
	}  
	
	public static void main(String[] args) {  
		launch(args);  
		System.out.println(); 
	}  
} 