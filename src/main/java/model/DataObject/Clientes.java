package model.DataObject;

public class Clientes extends Persona{

	public Clientes(String dni, String nombre, String apellidos, int edad, int altura, double peso, String genero,
			String motivoDieta, String alergiaAlimentaria, int idDieta, String dietista) {
		super(dni, nombre, apellidos, edad, altura, peso, genero, motivoDieta, alergiaAlimentaria, idDieta, dietista);
		
		
	}

	public Clientes(String dni) {
		
		super(dni);
		
	}
	
	public Clientes() {
		
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

	public void setPeso(double peso) {
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
