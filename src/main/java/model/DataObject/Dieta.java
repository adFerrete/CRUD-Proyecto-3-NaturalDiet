package model.DataObject;

public class Dieta {

	private int idDieta;
	private String nombre;
	private String tipoDieta;
	
	public Dieta(int idDieta,String nombre, String tipoDieta) {
		super();
		this.idDieta = idDieta;
		this.nombre=nombre;
		this.tipoDieta = tipoDieta;
	}

	public Dieta() {
		super();
	}

	public int getIdDieta() {
		return idDieta;
	}

	public void setIdDieta(int idDieta) {
		this.idDieta = idDieta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoDieta() {
		return tipoDieta;
	}

	public void setTipoDieta(String tipoDieta) {
		this.tipoDieta = tipoDieta;
	}

	@Override
	public String toString() {
		return "Dieta [idDieta=" + idDieta + ", tipoDieta=" + tipoDieta + "]";
	}
	
	
	
}
