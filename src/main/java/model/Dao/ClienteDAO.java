package model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
	public ArrayList<Clientes> getAllClientes() {
		
		ResultSet res;
		
		ArrayList<Clientes> lista=new ArrayList<>();
		
		String sql="select * from clientes";
		
		try {
			PreparedStatement ps=miConexion.prepareCall(sql);
			
			 res=ps.executeQuery();
			
			while(res.next()) {
				
				Clientes clientes=new Clientes();
				clientes.setDni(res.getString("Dni"));
				clientes.setNombre(res.getString("nombre"));
				clientes.setApellidos("Apellidos");
				clientes.setEdad(res.getInt("Edad"));
				clientes.setAltura(res.getInt("Altura"));
				clientes.setPeso(res.getFloat("peso"));
				clientes.setGenero(res.getString("genero"));
				clientes.setMotivoDieta(res.getString("MotivoDieta"));
				clientes.setAlergiaAlimentaria("alergiaAlimentaria");
				clientes.setIdDieta(res.getInt("idDieta"));
				clientes.setDietista(res.getString("Dietista_a_cargo"));
				
				lista.add(clientes);
			}
			
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public int updateDietista(Clientes c) {
		// TODO Esbozo de método generado automáticamente
		return 0;
	}

	@Override
	public boolean delete(Clientes c) {
		

		boolean valid=false;
		
		String sql="delete from clientes where Dni=?";
		
		try {
			PreparedStatement ps=miConexion.prepareStatement(sql);
			ps.setString(1, c.getDni());

			ps.executeUpdate();
			valid=true;
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
			
		}
		
		
		return false;
	}

}
