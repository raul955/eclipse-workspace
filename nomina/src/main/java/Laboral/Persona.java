package Laboral;

public class Persona {

	String nombre;
	String dni;
	char sexo;
	
	
	public Persona(String nombre, String dni, char sexo) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.sexo = sexo;
	}

	public Persona(String nombre, char sexo) {
		super();
		this.nombre = nombre;
		this.sexo = sexo;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	
	public String imprime() {
		return "Persona [nombre=" + nombre + ", dni=" + dni + "]";
	}
	
	
	
	
	
	
	
	
	
}
