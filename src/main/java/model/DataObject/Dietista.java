package model.DataObject;

public class Dietista {

	private String usuario;
	private String contrasena;
	private String correo;
	
	public Dietista(String usuario, String contrasena, String correo) {
		super();
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.correo = correo;
	}

	public Dietista() {
		
		
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "Dietista [usuario=" + usuario + ", contraseña=" + contrasena + ", correo=" + correo + "]";
	}
	
	
	
}
