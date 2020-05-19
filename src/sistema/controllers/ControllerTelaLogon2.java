package sistema.controllers;

import java.io.IOException;
import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sistema.beans.EspecialidadeEnum;
import sistema.beans.LocalTrabEnum;
import sistema.beans.Medico;
import sistema.controlador.TelaRegistro;
import sistema.dao.MedicoDAO;

public class ControllerTelaLogon2 {
	
	private TelaRegistro con = TelaRegistro.getInstance();
	LocalTrabEnum local = LocalTrabEnum.HOPE;
	EspecialidadeEnum esp = EspecialidadeEnum.Acupuntura;
	
	@FXML
	private JFXButton proximo;
	 
	@FXML
    private JFXButton voltar;
	
	@FXML
    private JFXTextField CRMbox;

    @FXML
    private JFXComboBox<String> cbLocal;
    private ArrayList<String> localTrab = new ArrayList();
    private ObservableList<String> obsLocalTrab;

    @FXML
    private JFXComboBox<String> cbEspecialidade;
    private ArrayList<String> especialidade = new ArrayList();
    private ObservableList<String> obsEspecialidade;

    @FXML
    void carregarLocalTrab() {
    	local.setMap();
    	localTrab.addAll(local.getMap().keySet());
    	
    	obsLocalTrab = FXCollections.observableArrayList(localTrab);
    	
    	cbLocal.setItems(obsLocalTrab);
    }
    
    @FXML
    void carregarEspecialidade() {
    	
    	esp.setMap();
    	especialidade.addAll(esp.getMap().keySet());
    	
    	obsEspecialidade = FXCollections.observableArrayList(especialidade);
    	
    	cbEspecialidade.setItems(obsEspecialidade);
    }
    
    @FXML
    void initialize() {
    	carregarLocalTrab();
    	carregarEspecialidade();
    }
	
	@FXML
    void voltar(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/fxmls/TelaLogon.fxml"));
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
	void proximo(ActionEvent event) throws IOException {
		MedicoDAO medDAO = new MedicoDAO();
		
		Medico medico = con.getMedico();
		medico.setCrm(CRMbox.getText());
		
		String cbEsp = cbEspecialidade.getSelectionModel().getSelectedItem();
		medico.setEspecialidade(esp.getMap().get(cbEsp));
		
		String cbLoc = cbLocal.getSelectionModel().getSelectedItem();
		medico.setLocalTrab(local.getMap().get(cbLoc));
		
		try{
			medDAO.create(medico);
			System.out.println("medico criado com sucesso!");
		}catch (Exception e) {
			System.out.println("erro ao criar medico no banco");
		}
		
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
