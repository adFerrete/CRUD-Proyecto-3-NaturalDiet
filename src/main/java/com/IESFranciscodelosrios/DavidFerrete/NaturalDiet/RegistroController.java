package com.IESFranciscodelosrios.DavidFerrete.NaturalDiet;

import java.io.IOException;
import java.sql.Connection;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Dao.DietistaDAO;
import model.DataObject.Dietista;
import utils.Connect;

public class RegistroController {

	DietistaDAO dietista;
	
	@FXML
	TextField user;
	@FXML
	TextField contraseña;
	@FXML
	TextField correo;
	
	Dietista d;
	
	@FXML
	public void RegistroUser() throws IOException{
		
		if(user!=null && contraseña!=null && correo!=null) {
			
			String usuario=user.getText();
			String pass=contraseña.getText();
			String email=correo.getText();
			
			dietista=new DietistaDAO();
			
			dietista.createDietista(new Dietista(usuario,pass,email));
			
			App.setRoot("dietista");
			
			
		}
		
	}
	
	  
    @FXML
    private void switchToPrimaryController() throws IOException {
        App.setRoot("primary");
    }

}
