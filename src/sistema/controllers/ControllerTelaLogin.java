package sistema.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import application.*;

public class ControllerTelaLogin {

    @FXML
    void irParaTelaEsqueciSenha(MouseEvent event) {
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("/fxmls/TelaEsqueceuSenha.fxml"));
			Scene start = new Scene(root, 700, 500);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setTitle("MedPro");
			window.setScene(start);
			window.show();
		} catch (Exception e) {
			// TODO: handle exception
		}
    }

    @FXML
    void irParaTelaLogon(MouseEvent event) {
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("/fxmls/TelaLogon.fxml"));
			Scene start = new Scene(root, 700, 500);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setTitle("MedPro");
			window.setScene(start);
			window.show();
		} catch (Exception e) {
			// TODO: handle exception
		}
    }

}


