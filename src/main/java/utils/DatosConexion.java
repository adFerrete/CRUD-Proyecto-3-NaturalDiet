package utils;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//esta es la clase que escribe y/o leer en el xml

@XmlRootElement(name="conexion")
@XmlAccessorType(XmlAccessType.FIELD)
public class DatosConexion implements Serializable{

	@XmlElement(name="server")
	protected String server;
	@XmlElement(name="database")
	protected String database;
	@XmlElement(name="username")
	protected String username;
	@XmlElement(name="password")
	protected String password;
	
	public DatosConexion() {
		super();
		
		server="";
		database="";
		username="";
		password="";
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "DatosConexion [server=" + server + ", database=" + database + ", username=" + username + ", password="
				+ password + "]";
	}
	
	
	
}
