package model.DataObject;

public class Clientes {
	
	private String dni;
	private String nombre;
	private String apellidos;
	private int edad;
	private int altura;
	private double peso;
	private String genero;
	private String motivoDieta;
	private String alergiaAlimentaria;
	private int idDieta;
	private String dietista;
	
	public Clientes(String dni, String nombre, String apellidos, int edad, int altura, double peso, String genero,
			String motivoDieta, String alergiaAlimentaria, int idDieta,String dietista) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.altura = altura;
		this.peso = peso;
		this.genero = genero;
		this.motivoDieta = motivoDieta;
		this.alergiaAlimentaria = alergiaAlimentaria;
		this.idDieta = idDieta;
		this.dietista=dietista;
	}

	public Clientes() {
		super();
	}



	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getMotivoDieta() {
		return motivoDieta;
	}

	public void setMotivoDieta(String motivoDieta) {
		this.motivoDieta = motivoDieta;
	}

	public String getAlergiaAlimentaria() {
		return alergiaAlimentaria;
	}

	public void setAlergiaAlimentaria(String alergiaAlimentaria) {
		this.alergiaAlimentaria = alergiaAlimentaria;
	}

	public int getIdDieta() {
		return idDieta;
	}

	public void setIdDieta(int idDieta) {
		this.idDieta = idDieta;
	}
	
	

	public String getDietista() {
		return dietista;
	}

	public void setDietista(String dietista) {
		this.dietista = dietista;
	}

	@Override
	public String toString() {
		return "clientes [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad
				+ ", altura=" + altura + ", peso=" + peso + ", genero=" + genero + ", motivoDieta=" + motivoDieta
				+ ", alergiaAlimentaria=" + alergiaAlimentaria + ", idDieta=" + idDieta + "]";
	}
	
	
	

}
