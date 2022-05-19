package com.IESFranciscodelosrios.DavidFerrete.NaturalDiet;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Dao.DietaDAO;
import model.Dao.DietistaDAO;
import model.DataObject.Dieta;
import model.DataObject.Dietista;

/*
 * Esta clase es el controlador para crear una dieta.
 */
public class creacionDietaController {
	
	//cada una de estas variables pertenecen a los textField que se usan para poder setear el registro 
	
	@FXML
	TextField idDieta;

	@FXML
	TextField nombreDieta;

	@FXML
	TextField tipoDieta;

	/*
	 * En este método se recogen los datos de la dieta introducida por el usuario obteniendo lo que hay 
	 * en los textField y seteándolo al objeto.
	 * @throws IOException
	 */
	@FXML 
	public void creacionDieta() throws IOException{
	  
	  if(idDieta!=null && nombreDieta!=null && tipoDieta!=null) {
	  
		  String IdDieta=idDieta.getText();
		  int IDdieta=Integer.parseInt(IdDieta);
		  String NombreDieta=nombreDieta.getText();
		  String TipoDieta=tipoDieta.getText();
	  
		  DietaDAO dDAO=new DietaDAO();
	  
		  dDAO.createDieta(new Dieta(IDdieta,NombreDieta,TipoDieta));
	  
		  App.setRoot("dietista");
	  
	  
	  }
	 		
	}
}
