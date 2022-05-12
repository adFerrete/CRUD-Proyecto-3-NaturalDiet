package com.IESFranciscodelosrios.DavidFerrete.NaturalDiet;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Dao.DietaDAO;
import model.Dao.DietistaDAO;
import model.DataObject.Dieta;
import model.DataObject.Dietista;

public class creacionDietaController {
	
	@FXML
	TextField idDieta;

	@FXML
	TextField nombreDieta;

	@FXML
	TextField tipoDieta;

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
