package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import application.*;

public class ControllerFS {

	@FXML
	private Button botaoLogIn;

	@FXML
	private Button botaoLogOn;

	@FXML
	void goToLogIn(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/fxmls/LogInScene.fxml"));
			Scene start = new Scene(root, 800, 600);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setTitle("LogIn Screen");
			window.setScene(start);
			window.show();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@FXML
	void goToLogOn(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/fxmls/LogOnScene.fxml"));
			Scene start = new Scene(root, 800, 600);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setTitle("LogOn Screen");
			window.setScene(start);
			window.show();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
