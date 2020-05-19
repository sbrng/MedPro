package sistema.controllers;

import java.time.format.DateTimeFormatter;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import sistema.beans.Medico;
import sistema.controlador.TelaRegistro;

public class ControllerTelaLogon {
	
	private TelaRegistro con = TelaRegistro.getInstance();
	private char genero;
	
	@FXML
    private JFXTextField email;
	
	@FXML
	private JFXTextField login;

    @FXML
    private JFXPasswordField senha;

    @FXML
    private JFXPasswordField confSenha;

    @FXML
    private JFXTextField nome;

    @FXML
    private JFXDatePicker dataNascimento;

    @FXML
    private JFXRadioButton homem;

    @FXML
    private JFXRadioButton mulher;
    
    @FXML
    private ToggleGroup sexo;
    
    @FXML
    void inicialize() {
    	
    }
    
    @FXML
    void setToggle(){
    	RadioButton selectedRadioButton = (RadioButton) sexo.getSelectedToggle();
    	String temp = selectedRadioButton.getText();
    	
    	if(temp.equals("Homem")) {
    		genero = 'M';
    	}else {
    		genero = 'F';
    	}
    	
    	System.out.println(genero);
    	
    }
	
	@FXML
    void irParaTelaLogon2(ActionEvent event) {
		
		//dataNascimento.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString();
		
		setToggle();
		
		Medico medico = new Medico();
		
		medico.setNome(nome.getText());
		medico.setLogin(login.getText());
		medico.setDataNascimento(dataNascimento.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
		medico.setEmail(email.getText());
		medico.setSenha(senha.getText());
		medico.setSexo(genero);
		
		con.setMedico(medico);
		System.out.println("Criado: " + con.getMedico());
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/fxmls/TelaLogon2.fxml"));
			Scene start = new Scene(root, 700, 500);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(start);
			window.setTitle("MedPro");
			window.show();
		} catch (Exception e) {
			// TODO: handle exception
		}
    }

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
