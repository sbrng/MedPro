package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import controllers.*;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			System.out.println("Tudo culpa de giulia");
			//Giulia va a merda
			Parent root = FXMLLoader.load(getClass().getResource("/fxmls/FirstScene.fxml"));
			Scene start = new Scene(root,800,600);
			primaryStage.setScene(start);
			primaryStage.setTitle("AlphaTest");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
