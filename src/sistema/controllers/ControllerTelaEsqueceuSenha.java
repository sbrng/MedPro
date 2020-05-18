package sistema.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerTelaEsqueceuSenha {

	@FXML
	void voltar(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/fxmls/TelaLogin.fxml"));
			Scene start = new Scene(root, 700, 500);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(start);
			window.setTitle("MedPro");
			window.show();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
