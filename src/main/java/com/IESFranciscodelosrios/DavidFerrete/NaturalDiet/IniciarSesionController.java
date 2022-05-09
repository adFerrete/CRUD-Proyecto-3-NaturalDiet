package com.IESFranciscodelosrios.DavidFerrete.NaturalDiet;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Dao.DietistaDAO;
import model.DataObject.Dietista;


public class IniciarSesionController {
	
	
	@FXML
	TextField user;
	
	@FXML
	PasswordField pass;
	
    @FXML
    private void switchToPrimaryController() throws IOException {
        App.setRoot("primary");
    }
    
    @FXML
    private void inicioSesion()  throws IOException{
    	    	
    	DietistaDAO dDAO=new DietistaDAO();
    	
    	if(dDAO.validDietista(user.getText(), pass.getText())==true) {
    		
    		App.setRoot("dietista");  
    		
    	}
    	
    	
    	
    }

}
