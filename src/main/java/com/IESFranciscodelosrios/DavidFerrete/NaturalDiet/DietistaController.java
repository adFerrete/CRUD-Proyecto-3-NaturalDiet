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
	
	private ObservableList<Clientes> list;
	
	ClienteDAO cDAO=new ClienteDAO();
	@FXML
	TextField eliminacion;
	
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
	
	@FXML
	 private void switchToCreacionCliente() throws IOException {
	   App.setRoot("creacionCliente");
	 }

	 @FXML
	    private void switchToCreacionDieta() throws IOException {
		   App.setRoot("creacionDieta");
	    }

	

}
