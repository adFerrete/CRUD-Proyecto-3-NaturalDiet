package com.IESFranciscodelosrios.DavidFerrete.NaturalDiet;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import model.Dao.ClienteDAO;
import model.DataObject.Clientes;

/*
 * Esta clase es el controlador para crear un cliente.
 */
public class CreacionClienteController {

	//cada una de estas variables pertenecen a los textField que se usan para poder setear el registro 
	
	@FXML
	TextField Genero;
	
	@FXML
	TextField Dni;
	
	@FXML
	TextField Nombre;
	
	@FXML
	TextField Apellidos;
	
	@FXML
	TextField Edad;
	
	@FXML
	TextField Altura;
	
	@FXML
	TextField Peso;
	
	@FXML
	TextArea MotivoDieta;
	
	@FXML
	TextField Alergia;
	
	@FXML
	TextField Dieta;
	
	@FXML
	TextField Dietista;
	
	
/*
 * En este método se recogen los datos del cliente introducido por el usuario obteniendo lo que hay 
 * en los textField y seteándolo al objeto.
 * @throws IOException
 */
	@FXML
	public void CreacionCliente() throws IOException {

		if (Dni != null && Nombre != null && Apellidos != null && Edad != null && Altura != null && Peso != null
				&& MotivoDieta != null && Alergia != null && Dieta != null && Dietista != null && Genero != null) {

			String dni = Dni.getText();
			String nombre = Nombre.getText();
			String apellidos = Apellidos.getText();
			String edad = Edad.getText();
			String altura = Altura.getText();
			String peso = Peso.getText();
			String genero=Genero.getText();
			String motivoDieta = MotivoDieta.getText();
			String alergia = Alergia.getText();
			String dieta = Dieta.getText();
			String dietista = Dietista.getText();
			
			int ConverEdad=Integer.parseInt(edad);
			int ConverAltura=Integer.parseInt(altura);
			double ConverPeso=Double.parseDouble(peso);
			int ConverDieta=Integer.parseInt(dieta);
			

			ClienteDAO cDAO = new ClienteDAO();

			cDAO.createCliente(new Clientes(dni, nombre, apellidos, ConverEdad, ConverAltura, ConverPeso, genero, motivoDieta,
						alergia, ConverDieta, dietista));
			
			App.setRoot("dietista");
			
		}

	}
	
	
	//este metodo es para cambiar de escena. el botón de volver hace uso de este método.
	@FXML
    private void switchToDietista() throws IOException {
	   App.setRoot("dietista");
    }

}

