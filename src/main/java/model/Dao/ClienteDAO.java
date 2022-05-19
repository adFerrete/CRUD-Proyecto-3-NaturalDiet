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
	public boolean createCliente(Clientes c) {
		
		boolean valid=false;
		
		String sql="INSERT INTO clientes(Dni, nombre, Apellidos, Edad, Altura, peso, genero, MotivoDieta, alergiaAlimentaria, idDieta, Dietista_a_cargo) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps=miConexion.prepareStatement(sql);
			ps.setString(1, c.getDni());
			ps.setString(2, c.getNombre());
			ps.setString(3, c.getApellidos());
			ps.setInt(4, c.getEdad());
			ps.setInt(5, c.getAltura());
			ps.setDouble(6, c.getPeso());
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
				clientes.setApellidos(res.getString("Apellidos"));
				clientes.setEdad(res.getInt("Edad"));
				clientes.setAltura(res.getInt("Altura"));
				clientes.setPeso(res.getDouble("peso"));
				clientes.setGenero(res.getString("genero"));
				clientes.setMotivoDieta(res.getString("MotivoDieta"));
				clientes.setAlergiaAlimentaria(res.getString("alergiaAlimentaria"));
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
	public boolean updateAll(Clientes c) {
		
	boolean valid=false;
		
		String sql="Update clientes set nombre=?, Apellidos=?, Edad=?, Altura=?, peso=?, genero=?, MotivoDieta=?, alergiaAlimentaria=?, idDieta=?, Dietista_a_cargo=? Where Dni=?";		
		
		try {
			PreparedStatement ps=miConexion.prepareStatement(sql);
			ps.setString(1, c.getNombre());
			ps.setString(2, c.getApellidos());
			ps.setInt(3, c.getEdad());
			ps.setInt(4, c.getAltura());
			ps.setDouble(5, c.getPeso());
			ps.setString(6, c.getGenero());
			ps.setString(7, c.getMotivoDieta());
			ps.setString(8, c.getAlergiaAlimentaria());
			ps.setInt(9, c.getIdDieta());
			ps.setString(10, c.getDietista());
			ps.setString(11, c.getDni());
			
			ps.executeUpdate();
			
			valid=true;
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
			
		}
		
		return valid;
	
	}

	@Override
	public boolean updateName(Clientes c) {
		
		boolean valid=false;
		
		String sql="Update clientes set nombre=? where Dni=?";
		
		try {
			PreparedStatement ps=miConexion.prepareStatement(sql);
			
			ps.setString(1, c.getNombre());
			ps.setString(2, c.getDni());
			
			ps.executeUpdate();
			System.out.println(ps.toString());
			valid=true;
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
			
		}
		
		return valid;
	}

	@Override
	public boolean updateApellidos(Clientes c) {
		
		boolean valid = false;

		String sql = "Update clientes set Apellidos=? where Dni=?";

		try {
			PreparedStatement ps = miConexion.prepareStatement(sql);

			ps.setString(1, c.getApellidos());
			ps.setString(2, c.getDni());

			ps.executeUpdate();
			System.out.println(ps.toString());
			valid = true;
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();

		}

		return valid;
		
	}

	@Override
	public boolean updateEdad(Clientes c) {
		
		boolean valid = false;

		String sql = "Update clientes set Edad=? where Dni=?";

		try {
			PreparedStatement ps = miConexion.prepareStatement(sql);

			ps.setInt(1, c.getEdad());
			ps.setString(2, c.getDni());

			ps.executeUpdate();
			
			valid = true;
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();

		}

		return valid;
		
	}

	@Override
	public boolean updateAltura(Clientes c) {
		
		boolean valid = false;

		String sql = "Update clientes set Altura=? where Dni=?";

		try {
			PreparedStatement ps = miConexion.prepareStatement(sql);

			ps.setInt(1, c.getAltura());
			ps.setString(2, c.getDni());

			ps.executeUpdate();
			System.out.println(ps.toString());
			valid = true;
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();

		}

		return valid;
	}

	@Override
	public boolean updatePeso(Clientes c) {
		
		boolean valid = false;

		String sql = "Update clientes set peso=? where Dni=?";

		try {
			PreparedStatement ps = miConexion.prepareStatement(sql);

			ps.setDouble(1, c.getPeso());
			ps.setString(2, c.getDni());

			ps.executeUpdate();
			System.out.println(ps.toString());
			valid = true;
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();

		}

		return valid;
	}

	@Override
	public boolean updateGenero(Clientes c) {
		
		boolean valid = false;

		String sql = "Update clientes set genero=? where Dni=?";

		try {
			PreparedStatement ps = miConexion.prepareStatement(sql);

			ps.setString(1, c.getGenero());
			ps.setString(2, c.getDni());

			ps.executeUpdate();
			
			valid = true;
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();

		}

		return valid;
	}

	@Override
	public boolean updateMotivoDieta(Clientes c) {
		
		boolean valid = false;

		String sql = "Update clientes set MotivoDieta=? where Dni=?";

		try {
			PreparedStatement ps = miConexion.prepareStatement(sql);

			ps.setString(1, c.getMotivoDieta());
			ps.setString(2, c.getDni());

			ps.executeUpdate();
			
			valid = true;
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();

		}

		return valid;
	}

	@Override
	public boolean updateAlergia(Clientes c) {
		
		boolean valid = false;

		String sql = "Update clientes set AlergiaAlimentaria=? where Dni=?";

		try {
			PreparedStatement ps = miConexion.prepareStatement(sql);

			ps.setString(1, c.getAlergiaAlimentaria());
			ps.setString(2, c.getDni());

			ps.executeUpdate();
			
			valid = true;
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();

		}

		return valid;
	}

	@Override
	public boolean updateDieta(Clientes c) {
		
		boolean valid = false;

		String sql = "Update clientes set idDieta=? where Dni=?";

		try {
			PreparedStatement ps = miConexion.prepareStatement(sql);

			ps.setInt(1, c.getIdDieta());
			ps.setString(2, c.getDni());

			ps.executeUpdate();
			
			valid = true;
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();

		}

		return valid;
	}

	@Override
	public boolean updateDietista(Clientes c) {
		
		boolean valid = false;

		String sql = "Update clientes set Dietista_a_cargo=? where Dni=?";

		try {
			PreparedStatement ps = miConexion.prepareStatement(sql);

			ps.setString(1, c.getDietista());
			ps.setString(2, c.getDni());

			ps.executeUpdate();
			
			valid = true;
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();

		}

		return valid;
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
