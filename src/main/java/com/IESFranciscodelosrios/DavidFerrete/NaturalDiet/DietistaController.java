package com.IESFranciscodelosrios.DavidFerrete.NaturalDiet;

import java.io.IOException;

import javafx.fxml.FXML;

public class DietistaController {
	
	 @FXML
	    private void switchToCreacionCliente() throws IOException {
		   App.setRoot("creacionCliente");
	    }

	 @FXML
	    private void switchToCreacionDieta() throws IOException {
		   App.setRoot("creacionDieta");
	    }

}
