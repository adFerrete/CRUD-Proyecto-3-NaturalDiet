package com.IESFranciscodelosrios.DavidFerrete.NaturalDiet;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Dao.ClienteDAO;
import model.DataObject.Clientes;

/*
 * este controlador es el más importante ya que pertenece a lo que es el panel de control general de la aplicación donde 
 * se añaden, eliminan, muestran y actualizan registros mediante el CRUD.
 */

public class DietistaController implements Initializable{
	
	//todas estas variables pertenecen al tableView y a los tableColumns de Scene Builder donde se mostrarán todos los registros de clientes.
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
	
	//Creo el objeto cDAO para poder llamar a los métodos que trabajan con la base de datos
	ClienteDAO cDAO=new ClienteDAO();
	
	
	@FXML
	TextField eliminacion;
	
	//estos textField se usan para modificar un registro o un campo de la tabla clientes
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
	
	//aquí creo una lista observable para poder mostrar todos los clientes
	private ObservableList<Clientes> list;
	
    /*
     * este metodo se usa para configurar los elementos de Scene builder, aquí yo lo uso para configurar el table view.
     */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		// para crear un table view funcional primero hay que llamar al metodo observableArrayList de la clase FXCollections .

		list=FXCollections.observableArrayList();

		
		//2.después hay que hacer un for-each en el que se añadan todos los clientes que se van creando a la lista
		for(Clientes c: cDAO.getAllClientes()) {
			
			list.add(c);
			
		}
		
		
		//se setea la lista en la tabla
		tablaClientes.setItems(list);
		
		//por último por cada columna del tableView hay que bindearlo a cada atributo de la clase clientes.
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
	
	/*
	 *Este método elimina un cliente por el dni que se introduzca 
	 *llamando al metodo delete de la clase dao.
	 * @throws IOException
	 */
	public void eliminacionCliente() throws IOException {
		
		if(eliminacion!=null) {
			
			String dni=eliminacion.getText();
			
			cDAO.delete(new Clientes(dni));
			
			App.setRoot("dietista");

		}
	
	}
	
	/*
	 *este método actualiza todos los campos de la tabla cliente introduciendo los datos en los textField de debajo del tableView 
	 * @throws IOException
	 */
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
	
	/*
	 *Este método actuliza sólo el nombre de un cliente  
	 */
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
	
	/*
	 *Este método actuliza sólo el apellido de un cliente  
	 */
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
	
	/*
	 *Este método actuliza sólo la edad de un cliente  
	 */
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
	
	/*
	 *Este método actuliza sólo la altura de un cliente  
	 */
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
	
	/*
	 *Este método actuliza sólo el peso de un cliente  
	 */
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
	
	/*
	 *Este método actuliza sólo el género de un cliente  
	 */
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
	
	/*
	 *Este método actuliza sólo el motivo de la dieta de un cliente  
	 */
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
	
	
	/*
	 *Este método actuliza sólo la alergia alimentaria de un cliente  
	 */
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
	
	/*
	 *Este método actuliza sólo el id de dieta asociada al cliente de un cliente  
	 */
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
	
	
	/*
	 *Este método actuliza sólo el dietista que atiende al cliente  
	 */
	@FXML
	public void updateDietista() throws IOException {
		
		Clientes c=new Clientes();
		
		if(dni_mod!=null && dietista_mod!=null) {
			
			String dni = dni_mod.getText();
			String dietista= dietista_mod.getText();
			
			c.setDni(dni);
			c.setDietista(dietista);
			
			cDAO.updateDietista(c);
			
			App.setRoot("dietista");
			
		}
		
	}
	
	/*
	 * cambia a la ventana de creación de un cliente y se usa en el botón llamado crear cliente
	 */
	@FXML
	 private void switchToCreacionCliente() throws IOException {
	   App.setRoot("creacionCliente");
	 }

	/*
	 *  cambia a la ventana de creación de una dieta y se usa en el botón llamado crear dieta
	 */
	 @FXML
	    private void switchToCreacionDieta() throws IOException {
		   App.setRoot("creacionDieta");
	    }
	 
	 /*
	  * cabia a la ventana donde se inicia sesión y se usa en el botón de volver.
	  */
	 @FXML
	    private void switchToInicioSesion() throws IOException {
		   App.setRoot("InicioSesion");
	    }
	

}
