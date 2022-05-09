package model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import interfacesDAO.IDietaDAO;
import model.DataObject.Dieta;
import model.DataObject.Dietista;
import utils.Connect;

public class DietaDAO implements IDietaDAO{

	private Connection miConexion;
	
		public DietaDAO() {
		
		miConexion=Connect.getConnect();
		
	}
	
	@Override
	public boolean createDieta(Dieta d) {
		
		boolean valid=false;
		
		String sql="INSERT INTO dieta(idDieta, nombre, TipoDieta) VALUES(?,?,?)";
		
		try {
			PreparedStatement sentencia=miConexion.prepareStatement(sql);
			sentencia.setInt(1, d.getIdDieta());
			sentencia.setString(2, d.getNombre());
			sentencia.setString(3, d.getTipoDieta());
			sentencia.executeUpdate();
			valid=true;
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
			
		}
		
		return valid;
		
	}

	@Override
	public Collection<Dieta> get() {
		// TODO Esbozo de método generado automáticamente
		return null;
	}

	public Dieta getAll() {
		
		Dieta d=null;
		
		String sql="SELECT idDieta, PlanSemanal, TipoDieta FROM dietista WHERE usuario=?";
		
		try {
			
			PreparedStatement sentencia=miConexion.prepareStatement(sql);
			sentencia.setInt(1, d.getIdDieta());
			ResultSet miRs=sentencia.executeQuery();
			d=new Dieta();
			miRs.next();
			d.setIdDieta(miRs.getInt("idDieta"));
			d.setTipoDieta(miRs.getString("TipoDieta"));
			
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		
		return d;
	}
	
	@Override
	public int updateDieta(Dieta d) {
		// TODO Esbozo de método generado automáticamente
		return 0;
	}

	@Override
	public boolean delete(Dieta d) {
		// TODO Esbozo de método generado automáticamente
		return false;
	}

}
