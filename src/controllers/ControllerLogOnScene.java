package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerLogOnScene {

    @FXML
    private TextField usernameInput;

    @FXML
    private PasswordField passwordInput;

    @FXML
    private Button submitButton;

    @FXML
    private Button goBack;

    @FXML
    private PasswordField confirmPasswordInput;

    @FXML
    private ChoiceBox<?> specialityEnum;

    @FXML
    private ChoiceBox<?> workplaceEnum;

    @FXML
    void goToLastScene(ActionEvent event) {
    	try {
    		Parent root = FXMLLoader.load(getClass().getResource("/fxmls/FirstScene.fxml"));
    		Scene start = new Scene(root,800,600);
    		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    		window.setScene(start);
    		window.setTitle("Alpha Test");
    		window.show();
      	}catch (Exception e) {
    	  // TODO: handle exception
      }

    }

}
