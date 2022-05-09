package model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

import interfacesDAO.IClienteDAO;
import model.DataObject.Clientes;
import model.DataObject.Dieta;
import model.DataObject.Dietista;
import utils.Connect;

public class ClienteDAO implements IClienteDAO{


	private Connection miConexion;
	
	public ClienteDAO() {
		
		miConexion=Connect.getConnect();
		
	}
	
	@Override
	public boolean createDietista(Clientes c) {
		
		boolean valid=false;
		
		String sql="INSERT INTO clientes(Dni, nombre, Apellidos, Edad, Altura, peso, genero, MotivoDieta, alergiaAlimentaria, idDieta, Dietista_a_cargo) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps=miConexion.prepareStatement(sql);
			ps.setString(1, c.getDni());
			ps.setString(2, c.getNombre());
			ps.setString(3, c.getApellidos());
			ps.setInt(4, c.getEdad());
			ps.setInt(5, c.getAltura());
			ps.setFloat(6, c.getAltura());
			ps.setString(7, c.getGenero());
			ps.setString(8,c.getMotivoDieta());
			ps.setString(9, c.getAlergiaAlimentaria());
			ps.setInt(10, c.getIdDieta());
			ps.setString(11, c.getDietista());

			ps.executeUpdate();
			valid=true;
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
			
		}
		
		return valid;
	}

	@Override
	public Collection<Clientes> getAllClientes() {
		
		
		
		return null;
	}

	@Override
	public int updateDietista(Clientes c) {
		// TODO Esbozo de método generado automáticamente
		return 0;
	}

	@Override
	public boolean delete(Clientes c) {
		// TODO Esbozo de método generado automáticamente
		return false;
	}

}
