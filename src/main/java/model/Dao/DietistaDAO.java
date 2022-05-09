package model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import interfacesDAO.IDietistaDAO;
import javafx.fxml.FXML;
import model.DataObject.Dietista;
import utils.Connect;

public class DietistaDAO implements IDietistaDAO{
	
	private Connection miConexion;
	
	public DietistaDAO() {
		
		miConexion=Connect.getConnect();
		
	}

	@Override
	public boolean createDietista(Dietista d) {

		boolean valid=false;
		
		String sql="INSERT INTO dietista(usuario, contrasena, correoElectronico) VALUES(?,?,?)";
		
		try {
			PreparedStatement sentencia=miConexion.prepareStatement(sql);
			sentencia.setString(1, d.getUsuario());
			sentencia.setString(2, d.getContrasena());
			sentencia.setString(3, d.getCorreo());
			sentencia.executeUpdate();
			valid=true;
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
			
		}
		
		return valid;
	}

	@Override
	public boolean updatePassDietista(Dietista d) {
		
		boolean valid=false;
		
		String sql="Update Dietista SET usuario=?, contrasena=?, correo=? WHERE usuario=?";
		
		 try{
			 
			 PreparedStatement ps=miConexion.prepareStatement(sql);
			 ps.setString (1, d.getUsuario());
			 ps.setString (2, d.getContrasena());
			 ps.setString (3, d.getCorreo());
		
			 ps.executeUpdate ();
			 valid=true;
		 } catch (SQLException e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
				
			}
		 
		return valid;
	}

	@Override
	public boolean deleteDietista(Dietista d) {
		
		boolean valid=false;
		
		String sql="DELETE FROM Dietista WHERE usuario=?";
		
		 try{
			 
			 PreparedStatement ps=miConexion.prepareStatement(sql);
			 ps.setString (1, d.getUsuario());
			 ps.executeUpdate ();
			 valid=true;
		 } catch (SQLException e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
				
			}
		
		return valid;
	}

	@Override
	public Dietista showAllDietistas() {
		Dietista d=null;
		
		String sql="SELECT usuario, contrasena, correo FROM dietista WHERE usuario=?";
		
		try {
			
			PreparedStatement sentencia=miConexion.prepareStatement(sql);
			sentencia.setString(1, d.getUsuario());
			ResultSet miRs=sentencia.executeQuery();
			d=new Dietista();
			miRs.next();
			d.setUsuario(miRs.getString("usuario"));
			d.setContrasena(miRs.getString("contrasena"));
			d.setCorreo(miRs.getString("correo"));
			
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		
		return d;
		
	}

	@Override
	public boolean validDietista(String user, String pass) {
		
		boolean valid=false;
		
		String sql="SELECT usuario, contrasena FROM dietista WHERE usuario=? and contrasena=?";
		
		try {
			
			PreparedStatement sentencia=miConexion.prepareStatement(sql);
			sentencia.setString(1, user);
			sentencia.setString(2, pass);
			ResultSet miRs=sentencia.executeQuery();
			Dietista d=new Dietista();
			miRs.next();
			d.setUsuario(miRs.getString("usuario"));
			d.setContrasena(miRs.getString("contrasena"));
			
			if(d.getUsuario()!=null && d.getContrasena()!=null) {
				
				valid=true;
				
			}
			
			
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		
		return valid;
	}



}
