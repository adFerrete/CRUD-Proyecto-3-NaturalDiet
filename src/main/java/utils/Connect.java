package utils;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@XmlRootElement(name="conexion")
@XmlAccessorType(XmlAccessType.FIELD)
public class Connect {
	
	//1 para conectar java con mysql se necesita objeto tipo connection
	protected String server;
	protected String database;
	protected String username;
	protected String password;
	
	@XmlTransient
	private static Connection con;
	@XmlTransient
	private String file="conexion.xml";
	@XmlTransient
	private static Connect _instance;
	
	private Connect() {
		//generar conexion con la base de datos

		DatosConexion dc=loadFile();
		//establecemos la conexion
		try {
			loadFile();
			con=DriverManager.getConnection(dc.getServer()+"/"+dc.getDatabase(),dc.getUsername(),dc.getPassword());
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
			
			con=null;
		}
		
	}
	
	public static Connection getConnect() {
		
		if(_instance==null) {
			
			_instance=new Connect();
			
		}
		
		return con;
	}
	
	public DatosConexion loadFile() {
		JAXBContext contexto;
		DatosConexion datosCon=new DatosConexion();
		try {
			contexto = JAXBContext.newInstance(DatosConexion.class);
		    Unmarshaller um = contexto.createUnmarshaller();
		    //We had written this file in marshalling example
		    DatosConexion newR= (DatosConexion) um.unmarshal( new File("conexion.xml"));
		    datosCon=newR;
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datosCon;
	}

}
