package com.IESFranciscodelosrios.DavidFerrete.NaturalDiet;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Dao.ClienteDAO;
import model.DataObject.Clientes;

public class DietistaController implements Initializable{
	
	@FXML
	private TableView<Clientes> tablaClientes= new TableView<>();
	
	@FXML
	private TableColumn<Clientes, String> DNI_t=new TableColumn<>();
	
	@FXML
	private TableColumn<Clientes, String> nombre_t=new TableColumn<>();
	
	@FXML
	private TableColumn<Clientes, String> apellidos_t=new TableColumn<>();	

	@FXML
	private TableColumn<Clientes, String> alergia_t=new TableColumn<>();

	@FXML
	private TableColumn<Clientes, Integer> edad_t=new TableColumn<>();
	
	@FXML
	private TableColumn<Clientes, Integer> altura_t=new TableColumn<>();
	
	@FXML
	private TableColumn<Clientes, Double> peso_t=new TableColumn<>();
	
	@FXML
	private TableColumn<Clientes, String> genero_t=new TableColumn<>();

	@FXML
	private TableColumn<Clientes, String> motivoDieta_t=new TableColumn<>();
	
	@FXML
	private TableColumn<Clientes, String> dietista_t=new TableColumn<>();
	
	@FXML
	private TableColumn<Clientes, Integer> dieta_t=new TableColumn<>();
	
	
	
	ClienteDAO cDAO=new ClienteDAO();
	@FXML
	TextField eliminacion;
	
	@FXML
	TextField dni_mod;
	
	@FXML
	TextField nombre_mod;
	
	@FXML
	TextField apellidos_mod;
	
	@FXML
	TextField edad_mod;
	
	@FXML
	TextField altura_mod;
	
	@FXML
	TextField peso_mod;
	
	@FXML
	TextArea motivo_mod;
	
	@FXML
	TextField genero_mod;
	
	@FXML
	TextField alergia_mod;
	
	@FXML
	TextField dieta_mod;
	
	@FXML
	TextField dietista_mod;
	
	private ObservableList<Clientes> list;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		
		list=FXCollections.observableArrayList();
		
		for(Clientes c: cDAO.getAllClientes()) {
			
			list.add(c);
			
		}
		
		tablaClientes.setItems(list);
		
		DNI_t.setCellValueFactory(new PropertyValueFactory<Clientes, String>("dni"));
		nombre_t.setCellValueFactory(new PropertyValueFactory<Clientes, String>("nombre"));
		apellidos_t.setCellValueFactory(new PropertyValueFactory<Clientes, String>("apellidos"));
		alergia_t.setCellValueFactory(new PropertyValueFactory<Clientes, String>("alergiaAlimentaria"));
		edad_t.setCellValueFactory(new PropertyValueFactory<Clientes, Integer>("edad"));
		altura_t.setCellValueFactory(new PropertyValueFactory<Clientes, Integer>("altura"));
		peso_t.setCellValueFactory(new PropertyValueFactory<Clientes, Double>("peso"));
		genero_t.setCellValueFactory(new PropertyValueFactory<Clientes, String>("genero"));
		motivoDieta_t.setCellValueFactory(new PropertyValueFactory<Clientes, String>("motivoDieta"));
		dietista_t.setCellValueFactory(new PropertyValueFactory<Clientes, String>("dietista"));
		dieta_t.setCellValueFactory(new PropertyValueFactory<Clientes, Integer>("idDieta"));
		
		
		
	}
	
	
	public void eliminacionCliente() throws IOException {
		
		if(eliminacion!=null) {
			
			String dni=eliminacion.getText();
			
			cDAO.delete(new Clientes(dni));
			
			App.setRoot("dietista");

		}
	
	}
	
	public void updateAll() throws IOException {
		
		if(dni_mod!=null && nombre_mod!=null && apellidos_mod!=null && edad_mod!=null && altura_mod!=null && peso_mod!=null 
				&& genero_mod!=null && motivo_mod!=null && alergia_mod!=null && dieta_mod!=null && dietista_mod!=null ) {
		
			String dni = dni_mod.getText();
			String nombre = nombre_mod.getText();
			String apellidos = apellidos_mod.getText();
			String edad = edad_mod.getText();
			String altura = altura_mod.getText();
			String peso = peso_mod.getText();
			String genero=genero_mod.getText();
			String motivoDieta = motivo_mod.getText();
			String alergia = alergia_mod.getText();
			String dieta = dieta_mod.getText();
			String dietista = dietista_mod.getText();
			
			int ConverEdad=Integer.parseInt(edad);
			int ConverAltura=Integer.parseInt(altura);
			double ConverPeso=Double.parseDouble(peso);
			int ConverDieta=Integer.parseInt(dieta);
			
			cDAO.updateAll(new Clientes(dni,nombre, apellidos, ConverEdad, ConverAltura, ConverPeso, genero, motivoDieta,alergia, ConverDieta, dietista));
		
			App.setRoot("dietista");
			
		}
		
	}
	
	
	@FXML
	public void updateName() throws IOException {
		
		Clientes c=new Clientes();
		
		if(dni_mod!=null && nombre_mod!=null) {
			
			String dni = dni_mod.getText();
			String nombre = nombre_mod.getText();
			
			c.setDni(dni);
			c.setNombre(nombre);
			
			cDAO.updateName(c);
			
			App.setRoot("dietista");
			
		}
		
	}
	
	@FXML
	public void updateApellidos() throws IOException {
		
		Clientes c=new Clientes();
		
		if(dni_mod!=null && apellidos_mod!=null) {
			
			String dni = dni_mod.getText();
			String apellidos = apellidos_mod.getText();
			
			c.setDni(dni);
			c.setApellidos(apellidos);
			
			cDAO.updateApellidos(c);
			
			App.setRoot("dietista");
			
		}
		
	}
	
	@FXML
	public void updateEdad() throws IOException {
		
		Clientes c=new Clientes();
		
		if(dni_mod!=null && edad_mod!=null) {
			
			String dni = dni_mod.getText();
			String edad = edad_mod.getText();
			int ConverEdad=Integer.parseInt(edad);
			
			c.setDni(dni);
			c.setEdad(ConverEdad);
			
			cDAO.updateEdad(c);
			
			App.setRoot("dietista");
			
		}
		
	}
	
	@FXML
	public void updateAltura() throws IOException {
		
		Clientes c=new Clientes();
		
		if(dni_mod!=null && altura_mod!=null) {
			
			String dni = dni_mod.getText();
			String altura = altura_mod.getText();
			int ConverAltura=Integer.parseInt(altura);
			
			c.setDni(dni);
			c.setAltura(ConverAltura);
			
			cDAO.updateAltura(c);
			
			App.setRoot("dietista");
			
		}
		
	}
	
	@FXML
	public void updatePeso() throws IOException {
		
		Clientes c=new Clientes();
		
		if(dni_mod!=null && peso_mod!=null) {
			
			String dni = dni_mod.getText();
			String peso = peso_mod.getText();
			double ConverPeso=Double.parseDouble(peso);
			
			c.setDni(dni);
			c.setPeso(ConverPeso);
			
			cDAO.updatePeso(c);
			
			App.setRoot("dietista");
			
		}
		
	}
	
	@FXML
	public void updategenero() throws IOException {
		
		Clientes c=new Clientes();
		
		if(dni_mod!=null && genero_mod!=null) {
			
			String dni = dni_mod.getText();
			String genero = genero_mod.getText();
			
			c.setDni(dni);
			c.setGenero(genero);
			
			cDAO.updateGenero(c);
			
			App.setRoot("dietista");
			
		}
		
	}
	
	@FXML
	public void updateMotivoDieta() throws IOException {
		
		Clientes c=new Clientes();
		
		if(dni_mod!=null && motivo_mod!=null) {
			
			String dni = dni_mod.getText();
			String motivoDieta = motivo_mod.getText();
			
			c.setDni(dni);
			c.setMotivoDieta(motivoDieta);
			
			cDAO.updateMotivoDieta(c);
			
			App.setRoot("dietista");
			
		}
		
	}
	
	@FXML
	public void updateAlergia() throws IOException {
		
		Clientes c=new Clientes();
		
		if(dni_mod!=null && alergia_mod!=null) {
			
			String dni = dni_mod.getText();
			String alergia= alergia_mod.getText();
			
			c.setDni(dni);
			c.setAlergiaAlimentaria(alergia);
			
			cDAO.updateAlergia(c);
			
			App.setRoot("dietista");
			
		}
		
	}
	
	@FXML
	public void updateIdDieta() throws IOException {
		
		Clientes c=new Clientes();
		
		if(dni_mod!=null && dieta_mod!=null) {
			
			String dni = dni_mod.getText();
			String dieta= dieta_mod.getText();
			int ConverDieta=Integer.parseInt(dieta);
			
			c.setDni(dni);
			c.setIdDieta(ConverDieta);
			
			cDAO.updateDieta(c);
			
			App.setRoot("dietista");
			
		}
		
	}
	
	@FXML
	 private void switchToCreacionCliente() throws IOException {
	   App.setRoot("creacionCliente");
	 }

	 @FXML
	    private void switchToCreacionDieta() throws IOException {
		   App.setRoot("creacionDieta");
	    }

	

}
